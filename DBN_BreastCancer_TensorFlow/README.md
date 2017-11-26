# Deep Belief Network for TCGA BRCA genomic, transcriptomic and clinical data
TCGA BRCA is a catalogue of genetic mutations responsible for breast cancer. The TCGA BRCA project in the [GDC Data Portal](https://portal.gdc.cancer.gov/repository?filters=~%28op~%27and~content~%28~%28op~%27in~content~%28field~%27cases.project.project_id~value~%28~%27TCGA-BRCA%29%29%29%29%29) consists of more than 27,000 files from 1,098 cases (patients). These files are categorized into 13 different data types, 9 of those can be accessed publicly, while the remaining 4 are controlled. This project will only used public-access files.

This project will create a prediction of breast cancer patient status with multimodal Deep Belief Network (mDBN) using their genetic and clinical data. To be specific, there are three predictions that can be done, which are
1.   Breast cancer type classification
2.   Survival rate regression

This project is created on Python. First, a preprocessing step is done to create the dataset for the Neural Network. Then, we try to implement the DBN on [TensorFlow](https://www.tensorflow.org/).

# Steps to be followed:
1. Make sure you have Python 2.7 installed on your computer. Make sure you have Tensorflow modules installed on your Python 2.7.
2. Change "dataset_location_hackathon.py" in folder "Tensorflow". Change variable "MAIN_MDBN_TCGA_BRCA" to the folder of your data.
3. Implement the prediction by running main_run.py "python main_run.py".
	- Pick the type of prediction you want to do.
	- Pick the features you want to use.
	- Design your neural networks (layers, hyperparameters, and etc) 

# Example of running	
asif@ubuntu:~/Downloads/hakathon/mdbn_tcga_brca_tensorflow$ python main_run.py
Welcome to mDBN breast cancer status prediction!
All training data by TCGA BRCA

What prediction do you want to make?
[1] Breast cancer type classification
[2] Survival rate regression
Insert here [default = 1]: 2
You will predict the survival rate

What type of features do you want to use?
[1] DNA Methylation
[2] Gene Expression
[3] miRNA Expression
Insert here [default = 3]: 3
You will use miRNA Expression data to create the prediction

Neural Network Layers
Number of hidden layers [default = 3]: 3
Layer 0 size [default = 1000]: 20
Layer 1 size [default = 1000]: 20
Layer 2 size [default = 1000]: 20

Neural Network Parameters
Pre-training iteration [default = 100]: 10
Training iteration [default = 100]: 10
Batch size [default = 10]: 10
Pre-training learning rate [default = 0.01]:
Training learning rate [default = 0.1]:
Survival Rate Regression with miRNA Expression (Tensorflow)

[START] Pre-training step:
>> Epoch 1 finished     RBM Reconstruction error 11.906680
>> Epoch 2 finished     RBM Reconstruction error 11.256721
....
>> Epoch 8 finished     RBM Reconstruction error 0.024642
>> Epoch 9 finished     RBM Reconstruction error 0.065513
>> Epoch 10 finished     RBM Reconstruction error 0.024890
[END] Pre-training step
[START] Fine tuning step:
>> Epoch 0 finished     ANN training loss 0.018815
>> Epoch 1 finished     ANN training loss 0.019657
.....
>> Epoch 8 finished     ANN training loss 0.018621
>> Epoch 9 finished     ANN training loss 0.018822
[END] Fine tuning step	
