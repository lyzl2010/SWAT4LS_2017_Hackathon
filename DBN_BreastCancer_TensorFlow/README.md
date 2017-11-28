# Simple Implementation of Deep Belief Network (DBN) using Genomic, Transcriptomic and Clinical Data
TCGA BRCA is a catalogue of genetic mutations responsible for breast cancer. The TCGA BRCA project in the [GDC Data Portal](https://portal.gdc.cancer.gov/repository?filters=~%28op~%27and~content~%28~%28op~%27in~content~%28field~%27cases.project.project_id~value~%28~%27TCGA-BRCA%29%29%29%29%29) consists of more than 27,000 files from 1,098 cases (patients). These files are categorized into 13 different data types, 9 of those can be accessed publicly, while the remaining 4 are controlled. This project will only used public-access files.

This project will create a prediction of breast cancer patient status with multimodal Deep Belief Network (mDBN) using their genetic and clinical data. To be specific, there are three predictions that can be done, which are

1.   Breast cancer type classification
2.   Survival rate regression

This project is created on Python. First, a preprocessing step is done to create the dataset for the Neural Network. Then, we try to implement the DBN on [TensorFlow](https://www.tensorflow.org/).

## Installing
To install this tutorial, you need to have TensorFlow installed on your system. This tutorial requires TensorFlow Nightly. To install TensorFlow, follow the installation instructions here at https://www.tensorflow.org/install/. 

## Steps to be followed:
1. Make sure you have Python 2.7 installed on your computer. Make sure you have Tensorflow modules installed on your Python 2.7.
2. Change "dataset_location_hackathon.py" in folder "Tensorflow". Change variable "MAIN_MDBN_TCGA_BRCA" to the folder of your data.
3. Implement the prediction by running main_run.py "python main_run.py".
	- Pick the type of prediction you want to do.
	- Pick the features you want to use.
	- Design your neural networks (layers, hyperparameters, and etc) 

## A sample execution	

    asif@ubuntu:~/Downloads/hakathon/mdbn_tcga_brca_tensorflow$ python main_run.py
    Welcome to mDBN breast cancer status prediction!
    All training data by TCGA BRCA
    What prediction do you want to make?
    [1] Breast cancer type classification
    [2] Survival rate regression
    Insert here [default = 1]: 1
    You will classify the type of the breast cancer

    What type of features do you want to use?
    [1] DNA Methylation
    [2] Gene Expression
    [3] miRNA Expression
    Insert here [default = 3]: 1
    You will use DNA Methylation data to create the prediction

    Neural Network Layers
    Number of hidden layers [default = 3]: 
    Layer 0 size [default = 1000]: 
    Layer 1 size [default = 1000]: 
    Layer 2 size [default = 1000]: 

    Neural Network Parameters
    Pre-training iteration [default = 100]: 
    Training iteration [default = 100]: 
    Batch size [default = 10]: 
    Pre-training learning rate [default = 0.01]: 
    Training learning rate [default = 0.1]: 
    Cancer Type Classification with DNA Methylation (Tensorflow)
    ER Status Prediction Training Process

    [START] Pre-training step:
    >> Epoch 1 finished 	RBM Reconstruction error 610.572404
    >> Epoch 2 finished 	RBM Reconstruction error 467.756593
    >> Epoch 3 finished 	RBM Reconstruction error 659.194650
    ....
    >> Epoch 99 finished 	RBM Reconstruction error 3762126.250000
    >> Epoch 100 finished 	RBM Reconstruction error 3717065.250000
    >> Epoch 1 finished 	RBM Reconstruction error 13283574784.000000
    >> Epoch 2 finished 	RBM Reconstruction error 16570219520.000000
    ....
    >> Epoch 100 finished 	RBM Reconstruction error 71709433856.000000
    [END] Pre-training step
    [START] Fine tuning step:
    >> Epoch 0 finished 	ANN training loss nan
    >> Epoch 1 finished 	ANN training loss nan
    ....
    >> Epoch 98 finished 	ANN training loss nan
    >> Epoch 99 finished 	ANN training loss nan
    [END] Fine tuning step
    Accuracy: 0.765625
      'precision', 'predicted', average, warn_for)
    ('Precision:', 0.586181640625)
    ('Recall:', 0.765625)
    ('F1-score:', 0.66399336283185839)
