# Deep Belief Network (DBN), Multilayer Perceptron and Random Forest using CNV Data
Refer to https://github.com/Overholt94/SWAT4LS_2017_Hackathon/blob/master/Dataset_processing.pdf and https://github.com/Overholt94/SWAT4LS_2017_Hackathon details. 

## Installing
To install this tutorial, you need to have TensorFlow installed on your system. This tutorial requires TensorFlow Nightly. To install TensorFlow, follow the installation instructions here at https://www.tensorflow.org/install/. 

## Steps to be followed:
1. Make sure you have Python 2.7 (3.3+) installed on your computer. Make sure you have Tensorflow modules installed on your Python 2.7.
2. Change dataset location: 
    filepath = '../input/CNV_data_reduced.csv' in
	- https://github.com/Overholt94/SWAT4LS_2017_Hackathon/blob/master/Cancer_Type_Prediction_TensorFlow/DBN/classification_demo.py
	- https://github.com/Overholt94/SWAT4LS_2017_Hackathon/blob/master/Cancer_Type_Prediction_TensorFlow/MLP/DMLP.py
	- https://github.com/Overholt94/SWAT4LS_2017_Hackathon/blob/master/Cancer_Type_Prediction_TensorFlow/ScikitLearn_RandomForest/randomforest_main.py

3. Implement the prediction by running the following script:
- python classification_demo.py (or python3 classification_demo.py)
- python DMLP.py (or python3 DMLP.py)
- python randomforest_main.py (or python3 randomforest_main.py)

## A sample execution	

	asif@ubuntu:~/Downloads/hakathon/Cancer_Type_prediction/MLP$ python3 DMLP.py 
	Variables loaded successfully...
	Number of predictors 	569
	Number of classes 	14
	Number of instances 	7895
	Data loaded and splitted successfully...
	Deep MLP networks has been built successfully...
	Starting training...
	Epoch:  0/200, cost:1.827274747
	Training accuracy: 0.790
	Epoch: 10/200, cost:1.212634145
	Training accuracy: 0.860
	Epoch: 20/200, cost:1.162385062
	Training accuracy: 0.920
	Epoch: 30/200, cost:1.129133233
	Training accuracy: 0.920
	Epoch: 40/200, cost:1.125699195
	Training accuracy: 0.880
	Epoch: 50/200, cost:1.118929907
	Training accuracy: 0.950
	Epoch: 60/200, cost:1.128129311
	Training accuracy: 0.950
	Epoch: 70/200, cost:1.116312892
	Training accuracy: 0.940
	Epoch: 80/200, cost:1.113498847
	Training accuracy: 0.940
	Epoch: 90/200, cost:1.106775373
	Training accuracy: 0.950
	Epoch:100/200, cost:1.098091425
	Training accuracy: 0.920
	Epoch:110/200, cost:1.101043162
	Training accuracy: 0.910
	Epoch:120/200, cost:1.101031174
	Training accuracy: 0.930
	Epoch:130/200, cost:1.098224256
	Training accuracy: 0.930
	Epoch:140/200, cost:1.098724014
	Training accuracy: 0.910
	Epoch:150/200, cost:1.105315332
	Training accuracy: 0.950
	Epoch:160/200, cost:1.100867587
	Training accuracy: 0.940
	Epoch:170/200, cost:1.098714927
	Training accuracy: 0.910
	Epoch:180/200, cost:1.102214290
	Training accuracy: 0.930
	Epoch:190/200, cost:1.092969030
	Training accuracy: 0.970

	Your deep MLP model has been trained sucessfully.

	Evaluating deep MLP on the test set...
	Prediction/clasification accuracy: 0.740

