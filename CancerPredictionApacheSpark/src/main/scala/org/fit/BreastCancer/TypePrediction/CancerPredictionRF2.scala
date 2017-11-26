package org.fit.BreastCancer.TypePrediction

import org.apache.spark._
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql._
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.{RandomForestClassifier, RandomForestClassificationModel}
import org.apache.spark.mllib.evaluation.BinaryClassificationMetrics
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.tuning.{ParamGridBuilder, CrossValidator}
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{Normalizer, VectorAssembler}

object CancerPredictionRF2 {
  def main(args: Array[String]) {
    val port = args(0)
    val spark = SparkSession
      .builder
      .master("local[64]")
      .config("spark.sql.warehouse.dir", "/home/miselico/rezaul/")
      .config("spark.driver.port", port)
      .appName("Cancer prediction")
      .getOrCreate()

    import spark.implicits._

    val input = args(1)
    
    val inputDF = spark.read.
      option("inferSchema", "true")
      .format("com.databricks.spark.csv")
      .option("delimiter", "\t")
      .option("header", "true")
      .load(input)

    inputDF.printSchema()
    val filteredDF = inputDF.filter("ctype != 15")

    val dFwithoutSampleID = filteredDF.withColumnRenamed("ctype", "label").drop("sample_id").cache()
    dFwithoutSampleID.printSchema()

    val featureCols = dFwithoutSampleID.columns.drop(1)

    val assembler = new VectorAssembler()
      .setInputCols(featureCols)
      .setOutputCol("features")

    // Normalize each Vector using $L^1$ norm.
    val normalizer = new Normalizer()
      .setInputCol("features")
      .setOutputCol("normFeatures")
      .setP(1.0)

    //dFwithoutSampleID.show(10)

    val Array(trainingDF, testDF) = dFwithoutSampleID.randomSplit(Array(0.75, 0.25), 12345L)

    val rf = new RandomForestClassifier()
      .setLabelCol("label")
      .setFeaturesCol("normFeatures")
      .setSeed(1234567L)

    // Chain indexers and tree in a Pipeline.
    val pipeline = new Pipeline()
      .setStages(Array(assembler, normalizer, rf))

    // Search through decision tree's maxDepth parameter for best model
    /*
    val paramGrid = new ParamGridBuilder()
      .addGrid(rf.maxDepth, 3 :: 5 :: 10 :: 15 :: Nil)
      .addGrid(rf.featureSubsetStrategy, "auto" :: "all" :: Nil)
      .addGrid(rf.impurity, "gini" :: "entropy" :: Nil)
      .addGrid(rf.maxBins, 3 :: 5 :: 10 :: 15 :: Nil)
      .addGrid(rf.numTrees, 3 :: 5 :: 10 :: 15 :: Nil)
      .build()
      */

    // Search through decision tree's maxDepth parameter for best model
    val paramGrid = new ParamGridBuilder()
      .addGrid(rf.maxDepth, 5 :: 10 :: 15 :: 20 :: 25 :: 30 :: Nil)
      .addGrid(rf.featureSubsetStrategy, "auto" :: "all" :: Nil)
      .addGrid(rf.impurity, "gini" :: "entropy" :: Nil)
      .addGrid(rf.maxBins, 5 :: 10 :: 15 :: 20 :: 25 :: 30 :: Nil)
      .addGrid(rf.numTrees, 5 :: 10 :: 15 :: 20 :: 25 :: 30 :: Nil)
      .build()

    val evaluator = new MulticlassClassificationEvaluator()
      .setLabelCol("label")
      .setPredictionCol("prediction")

    // Set up 10-fold cross validation
    val numFolds = 10
    val crossval = new CrossValidator()
      .setEstimator(pipeline)
      .setEvaluator(evaluator)
      .setEstimatorParamMaps(paramGrid)
      .setNumFolds(numFolds)

    val cvModel = crossval.fit(trainingDF)
    val predictions = cvModel.transform(testDF)

    val evaluator1 = evaluator.setMetricName("accuracy")
    val evaluator2 = evaluator.setMetricName("weightedPrecision")
    val evaluator3 = evaluator.setMetricName("weightedRecall")
    val evaluator4 = evaluator.setMetricName("f1")

    // compute the classification accuracy, precision, recall, f1 measure and error on test data.
    val accuracy = evaluator1.evaluate(predictions)
    val precision = evaluator2.evaluate(predictions)
    val recall = evaluator3.evaluate(predictions)
    val f1 = evaluator4.evaluate(predictions)

    // Print the performance metrics
    println("Accuracy = " + accuracy);
    println("Precision = " + precision)
    println("Recall = " + recall)
    println("F1 = " + f1)
    println(s"Test Error = ${1 - accuracy}")
  }
}