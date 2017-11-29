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

object SurvivalPredictionRF {
  //val settings: CsvParserSettings  = new CsvParserSettings()
  //settings.setMaxColumns(10000)    
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
      .load("data/input_mir_sur.csv") // don't forget to provide the correct path

    inputDataDF.printSchema()

    val inputLabelDF = spark.read.
      option("inferSchema", "true")
      .option("delimiter", "\n")
      .format("com.databricks.spark.csv")
      .option("header", "false")
      .load("data/label_sur.csv") // don't forget to provide the correct path

    val LabelDF = inputLabelDF.withColumnRenamed("_c0", "label")
    inputLabelDF.show()

    import org.apache.spark.sql.functions._
    val inputDF = LabelDF.join(inputDataDF)
    inputDF.printSchema()

    val featureCols = inputDataDF.columns

    val assembler = new VectorAssembler()
      .setInputCols(featureCols)
      .setOutputCol("features")

    // Normalize each Vector using $L^1$ norm.
    val normalizer = new Normalizer()
      .setInputCol("features")
      .setOutputCol("normFeatures")
      .setP(1.0)

    inputDF.show(10)

    val gbt = new GBTRegressor()
      .setLabelCol("label")
      .setFeaturesCol("features")
      .setMaxIter(100)
      .setSeed(1234567L)

    val pca = new PCA()
      .setInputCol("features")
      .setOutputCol("pcaFeatures")
      .setK(100)
    //.fit(trainingDF)

    val pipeline = new Pipeline()
      .setStages(Array(assembler, normalizer, pca, gbt))

    val pipelineModel = pipeline.fit(inputDF)

    val reducedDF = pipelineModel.transform(inputDF).withColumnRenamed("pcaFeatures", "features")
    val finalDF = reducedDF.select("features", "label")
    finalDF.show()

    val Array(trainingDF, testDF) = finalDF.randomSplit(Array(0.75, 0.25), 12345L)

    // Search through decision tree's maxDepth parameter for best model
    val paramGrid = new ParamGridBuilder()
      .addGrid(gbt.maxDepth, 10 :: Nil)
      .addGrid(gbt.maxBins, 10 :: Nil)
      .build()

    val evaluator = new RegressionEvaluator()
      .setLabelCol("label")
      .setPredictionCol("prediction")

    val numFolds = 10
    val crossval = new CrossValidator()
      .setEstimator(pipeline)
      .setEvaluator(evaluator)
      .setEstimatorParamMaps(paramGrid)
      .setNumFolds(numFolds)

    val cvModel = crossval.fit(trainingDF)
    val predictions = cvModel.transform(testDF)

    val regEvaluator = evaluator.setMetricName("rmse")
    val rmse = regEvaluator.evaluate(predictions)
    println("RMSE = " + rmse)
  }
}
