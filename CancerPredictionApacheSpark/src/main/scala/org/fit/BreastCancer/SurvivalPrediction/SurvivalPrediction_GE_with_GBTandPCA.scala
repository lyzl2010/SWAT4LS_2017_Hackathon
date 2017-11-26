package org.fit.BreastCancer.SurvivalPrediction

import org.apache.spark._
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql._
import org.apache.spark.ml.feature.{ VectorAssembler, Normalizer }
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.evaluation.RegressionEvaluator
import org.apache.spark.ml.feature.VectorIndexer
import org.apache.spark.ml.tuning.{ ParamGridBuilder, CrossValidator }
import org.apache.spark.ml.regression.{ GBTRegressionModel, GBTRegressor }
import org.apache.spark.ml.feature.PCA
import org.apache.spark.ml.linalg.Vectors

/*
 * 
 * MSE = 0.017521216764709593
 * RMSE = 0.13236773309500163
 * R2 = -4.476344000803323E-6
 * MAE = -4.476344000803323E-6
 * 
 */

object SurvivalPrediction_GE_with_GBTandPCA { 
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
      .load("C:/Users/admin-karim/Google Drive/Hackaton/Reduced_BRC/input_csv/survival/Gene_Expression/input_gen_sur.csv")

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
    
    val Array(trainingDF, testDF) = inputDF.randomSplit(Array(0.75, 0.25), 12345L)
    
     val gbt = new GBTRegressor()
      .setLabelCol("label")
      .setFeaturesCol("features")
      .setMaxIter(10)
      .setSeed(1234567L)
      .setMaxBins(10)
      .setMaxDepth(10)

    val pipelineModel = gbt.fit(inputDF)
    val predictions = pipelineModel.transform(testDF)
    predictions.show()

    val evaluator = new RegressionEvaluator()
      .setLabelCol("label")
      .setPredictionCol("prediction")
      
    val mseEvaluator = evaluator.setMetricName("mse")
    val mse = mseEvaluator.evaluate(predictions)    
    println("MSE = " + mse)
    
    val rmseEvaluator = evaluator.setMetricName("rmse")
    val rmse = mseEvaluator.evaluate(predictions)    
    println("RMSE = " + rmse)
    
    val r2Evaluator = evaluator.setMetricName("r2")
    val r2 = mseEvaluator.evaluate(predictions)    
    println("R2 = " + r2)
    
    val maeEvaluator = evaluator.setMetricName("r2")
    val mae = mseEvaluator.evaluate(predictions)    
    println("MAE = " + mae)
  }
}