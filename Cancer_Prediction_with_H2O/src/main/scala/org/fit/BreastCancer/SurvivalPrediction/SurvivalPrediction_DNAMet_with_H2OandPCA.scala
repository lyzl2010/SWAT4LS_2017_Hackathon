package org.fit.BreastCancer.SurvivalPrediction

import org.apache.spark._
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql._
import org.apache.spark.ml.feature.{VectorAssembler, Normalizer}
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.feature.VectorIndexer
import org.apache.spark.ml.feature.PCA
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.sql.{DataFrame, SQLContext, SparkSession}
import water.support.{H2OFrameSupport, ModelMetricsSupport, SparkContextSupport}
import org.apache.spark.sql.functions.year
import org.apache.spark.ml.feature.{ StringIndexer, VectorAssembler }
import org.apache.spark.ml.{Pipeline, PipelineStage}
import scala.xml.persistent.SetStorage
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

object SurvivalPrediction_DNAMet_with_H2OandPCA { 
    /** Builds DeepLearning model. */ 
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
    dlParams._l1 = l2
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

    spark.conf.set("spark.sql.crossJoin.enabled", "true")
    val inputDataDF = spark.read.
      option("inferSchema", "true")
      .option("delimiter", ",")
      .format("com.databricks.spark.csv")
      .option("header", "false")
      .load("C:/Users/admin-karim/Google Drive/Hackaton/Reduced_BRC/input_csv/survival/DNA_Methylation/input_met_sur.csv")

    inputDataDF.printSchema()

    val inputLabelDF = spark.read.
      option("inferSchema", "true")
      .option("delimiter", "\n")
      .format("com.databricks.spark.csv")
      .option("header", "false")
      .load("data/label_sur.csv")

    val LabelDF = inputLabelDF.withColumnRenamed("_c0", "label")
    inputLabelDF.show()

    val featureCols = inputDataDF.columns

    val assembler = new VectorAssembler()
      .setInputCols(featureCols)
      .setOutputCol("features")

    val assembleDF = assembler.transform(inputDataDF).select("features")
    assembleDF.show()
    
    val pca = new PCA()
      .setInputCol("features")
      .setOutputCol("pcaFeatures")
      .setK(100)
      .fit(assembleDF)

    val pcaDF = pca.transform(assembleDF).select("pcaFeatures").withColumnRenamed("pcaFeatures", "features")
    pcaDF.show()    
    
    import org.apache.spark.sql.functions._
    val inputDF = LabelDF.join(pcaDF)
    inputDF.printSchema()    
    
    implicit val h2oContext = H2OContext.getOrCreate(spark.sparkContext)
    import h2oContext.implicits._
    implicit val sqlContext = SparkSession.builder().getOrCreate().sqlContext
    import sqlContext.implicits._

    val H2ODF: H2OFrame = inputDF.orderBy(rand())
    val sf = new FrameSplitter(H2ODF, Array(0.6, 0.2), Array("train.hex", "valid.hex", "test.hex").map(Key.make[Frame](_)), null)
    water.H2O.submitTask(sf)

    val splits = sf.getResult
    val (train, valid, test) = (splits(0), splits(1), splits(2))

    val dlModel = buildDLModel(train, valid)

    val result = dlModel.score(test)('predict)
    val predictionsFromModel = h2oContext.asRDD[DoubleHolder](result).take(10).map(_.result.getOrElse("NaN"))
    println(predictionsFromModel.mkString("\n===> Model predictions: ", ", ", ", ...\n"))
    
    val output = dlModel._output
    
    val mse = dlModel.mse()
    println("MSE: " + mse)
    
    val rmse = Math.sqrt(mse)
    println("RMSE: " + rmse)
    
    val mae = dlModel.mae()
    println("MAE: " + mae)

    result.add("actual", test.vec("label"))
    val predict_actualDF = h2oContext.asDataFrame(result)
    predict_actualDF.show()

    predict_actualDF.groupBy("actual", "predict").count.show

    h2oContext.stop(stopSparkContext = true)
    spark.stop()
  }
}