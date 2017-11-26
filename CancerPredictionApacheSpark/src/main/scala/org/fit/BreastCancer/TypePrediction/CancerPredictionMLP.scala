package org.fit.BreastCancer.TypePrediction

import org.apache.spark._
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql._
import org.apache.spark.ml.classification.{ MultilayerPerceptronClassifier, MultilayerPerceptronClassificationModel }
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{ VectorAssembler, Normalizer }
import org.apache.spark.mllib.util.MLUtils

object CancerPredictionMLP {
  def main(args: Array[String]) {
    val spark = SparkSession
      .builder
      .master("local[4]")
      .config("spark.sql.warehouse.dir", "/data/")
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
    dFwithoutSampleID.printSchema()

    val featureCols = dFwithoutSampleID.columns.drop(1)    
    println(featureCols.length)

    val assembler = new VectorAssembler()
      .setInputCols(featureCols)
      .setOutputCol("features")

    val assembleDF = assembler.transform(dFwithoutSampleID)
    // Normalize each Vector using $L^1$ norm.
    val normalizer = new Normalizer()
      .setInputCol("features")
      .setOutputCol("normFeatures")
      .setP(1.0)

    val normalizedDF = normalizer.transform(assembleDF)
    dFwithoutSampleID.show(10)
    
    val vectorsDF = MLUtils.convertVectorColumnsToML(normalizedDF)
    val numFeatures = vectorsDF.count().toInt
    println(numFeatures)

    val Array(trainingDF, testDF) = normalizedDF.randomSplit(Array(0.75, 0.25), 12345L)

    val layers = Array[Int](569, 64, 128, 256, 512, 15)
    val mlp = new MultilayerPerceptronClassifier()
      .setLayers(layers)
      .setBlockSize(128)
      .setSeed(1234L)
      .setTol(1E-8)
      .setMaxIter(1000)

    val evaluator = new MulticlassClassificationEvaluator()
      .setLabelCol("label")
      .setPredictionCol("prediction")

    val mlpModel = mlp.fit(trainingDF)

    val predictions = mlpModel.transform(testDF)

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