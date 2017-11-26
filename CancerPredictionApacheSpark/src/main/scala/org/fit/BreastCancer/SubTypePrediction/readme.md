# Cancer subtype prediction:  
For three types of predictions, we have provided a deep learning implementation (i.e. Multilyer Perceptron - MLP) for cancer subtype prediction. We have used ER, HER2 and PGR data with their corresponding inputs. 
	
  - **SubTypePrediction_DNAMet_ER_with_MLP.scala**: It takes 2 inputs: i) **input_csv_met_type_er.csv** is the data and ii) **label_type_er.csv** is the corresponding label. There are 3 classes to be predicted -i.e. **multinominal classification problem**. 
 - **SubTypePrediction_DNAMet_HER2_with_MLP.scala**: It takes 2 inputs: i) input_csv_met_type_her2.csv is the data and ii) label_type_her2.csv is the corresponding label. There are 4 classes to be predicted -i.e. **multinominal classification problem**. 
- **SubTypePrediction_DNAMet_PGR_with_MLP.scala**: It takes 2 inputs: i) **input_csv_met_type_pgr.csv** is the data and ii) **label_type_pgr.csv** is the corresponding label. There are 4 classes to be predicted -i.e. **multinominal classification problem**.
  
Every Scala script does necessary feature engineering, modelling and simple evaluation. Finally, **accuracy**, **precision**, **recall** and **F1 measure**. It is to be noted, that none of the hyperparametrs are tuned. You can use these simple implementation and tune your training as well as hyperparametrs.  
