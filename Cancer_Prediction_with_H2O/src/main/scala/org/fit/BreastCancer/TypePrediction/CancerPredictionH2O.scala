package org.fit.BreastCancer.TypePrediction

import org.apache.spark.sql.{ DataFrame, SQLContext, SparkSession }
import water.support.{ H2OFrameSupport, ModelMetricsSupport, SparkContextSupport }
import org.apache.spark.sql._
import org.apache.spark.sql.functions.year
import org.apache.spark.ml.feature.{ StringIndexer, VectorAssembler }
import org.apache.spark.ml.{ Pipeline, PipelineStage }
import scala.xml.persistent.SetStorage
import org.apache.spark.sql.functions._
import org.apache.spark.h2o._
import _root_.hex.FrameSplitter
import _root_.hex.{ModelMetrics, ModelMetricsSupervised, ModelMetricsMultinomial}
import water.Key
import water.fvec.Frame
import _root_.hex.deeplearning.DeepLearning
import _root_.hex.deeplearning.DeepLearningModel
import _root_.hex.deeplearning.DeepLearningModel.DeepLearningParameters
import _root_.hex.deeplearning.DeepLearningModel.DeepLearningParameters.Activation
import java.io.File
import water.support.ModelSerializationSupport
import scala.reflect.api.materializeTypeTag
import org.apache.spark.sql.types._

object CancerPredictionH2O extends SparkContextSupport with ModelMetricsSupport with H2OFrameSupport {
  /** Builds DeepLearning model. */
  def toCategorical(f: Frame, i: Int): Unit = {
    f.replace(i, f.vec(i).toCategoricalVec)
    f.update()
  }
  
  def ConfusionMatrix(model: DeepLearningModel, fr: Frame) = ModelMetrics.getFromDKV(model, fr).asInstanceOf[ModelMetricsMultinomial].cm()

  def buildDLModel(train: Frame, valid: Frame,
    epochs: Int = 1000, l1: Double = 0.001, l2: Double = 0.0,
    hidden: Array[Int] = Array[Int](128, 128, 128))(implicit h2oContext: H2OContext): DeepLearningModel = {
    import h2oContext.implicits._
    // Build a model
    val dlParams = new DeepLearningParameters()
    dlParams._train = train
    dlParams._valid = valid
    dlParams._response_column = "label"
    dlParams._epochs = epochs
    dlParams._nfolds = 10
    dlParams._l1 = l1
    dlParams._hidden = hidden
    dlParams._activation = Activation.RectifierWithDropout
    dlParams._variable_importances = true

    // Create a job
    val dl = new DeepLearning(dlParams, water.Key.make("dlModel.hex"))
    dl.trainModel.get
  }
  def main(args: Array[String]) {
    val spark = SparkSession
      .builder
      .master("local[4]")
      .config("spark.sql.warehouse.dir", "data/")
      .appName("Cancer prediction")
      .getOrCreate()

    import spark.implicits._

    val inputDF = spark.read.
      option("inferSchema", "true")
      .format("com.databricks.spark.csv")
      .option("delimiter", "\t")
      .option("header", "true")
      .load("data/big_data2.csv")

    inputDF.printSchema()
    val filteredDF = inputDF.filter("ctype != 15")
    val dFwithoutSampleID = filteredDF.withColumnRenamed("ctype", "label").drop("sample_id").cache()
    dFwithoutSampleID.show()

    implicit val h2oContext = H2OContext.getOrCreate(spark.sparkContext)
    import h2oContext.implicits._
    implicit val sqlContext = SparkSession.builder().getOrCreate().sqlContext
    import sqlContext.implicits._

    val H2ODF: H2OFrame = dFwithoutSampleID.orderBy(rand())
    H2ODF.types.zipWithIndex.foreach(c => if (c._1.toInt == 2) toCategorical(H2ODF, c._2))
    val sf = new FrameSplitter(H2ODF, Array(0.6, 0.2), Array("train.hex", "valid.hex", "test.hex").map(Key.make[Frame](_)), null)
    water.H2O.submitTask(sf)

    val splits = sf.getResult
    val (train, valid, test) = (splits(0), splits(1), splits(2))

    // Build a model
    toCategorical(train, 0)
    toCategorical(valid, 0)
    toCategorical(test, 0)

    val dlModel = buildDLModel(train, valid)

    val result = dlModel.score(test)('predict)
    val predictionsFromModel = h2oContext.asRDD[DoubleHolder](result).take(10).map(_.result.getOrElse("NaN"))
    println(predictionsFromModel.mkString("\n===> Model predictions: ", ", ", ", ...\n"))
    
    val output = dlModel._output
    
    println("Classfication accuracy: " + (1 - dlModel.classification_error()) * 100 + " %")
    
    println("Confusion matrix on test set: ")
    println(ConfusionMatrix(dlModel, test))

    result.add("actual", test.vec("label"))
    val predict_actualDF = h2oContext.asDataFrame(result)
    predict_actualDF.show()

    predict_actualDF.groupBy("actual", "predict").count.show
  
    // Shutdown Spark cluster and H2O
    h2oContext.stop(stopSparkContext = true)
    spark.stop()
  }
}