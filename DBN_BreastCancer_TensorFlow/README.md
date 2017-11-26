# mDBN_TCGA_BRCA
Multimodal Deep Belief Network for TCGA BRCA genomic, transcriptomic and clinical data

TCGA BRCA is a catalogue of genetic mutations responsible for breast cancer. The TCGA BRCA project in the [GDC Data Portal](https://portal.gdc.cancer.gov/repository?filters=~%28op~%27and~content~%28~%28op~%27in~content~%28field~%27cases.project.project_id~value~%28~%27TCGA-BRCA%29%29%29%29%29) consists of more than 27,000 files from 1,098 cases (patients). These files are categorized into 13 different data types, 9 of those can be accessed publicly, while the remaining 4 are controlled. This project will only used public-access files.

This project will create a prediction of breast cancer patient status with multimodal Deep Belief Network (mDBN) using their genetic and clinical data. To be specific, there are three predictions that can be done, which are
1.   Breast cancer type classification
2.   Survival rate regression

This project is created on Python. First, a preprocessing step is done to create the dataset for the Neural Network. Then, we try to implement the multimodal Deep Belief Network (mDBN) on [Tensorflow](https://www.tensorflow.org/) and [Theano](http://deeplearning.net/software/theano/).

Steps:
1. Make sure you have Python 2.7 installed on your computer. Make sure you have Tensorflow modules installed on your Python 2.7.
2. Change "dataset_location_hackathon.py" in folder "Tensorflow". Change variable "MAIN_MDBN_TCGA_BRCA" to the folder of your data.
3. Implement the prediction by run main_run.py "python main_run.py".
	- Pick the type of prediction you want to do.
	- Pick the features you want to use.
	- Design your neural networks (layers, hyperparameters, and etc) 