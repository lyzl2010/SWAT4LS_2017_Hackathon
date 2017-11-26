import numpy as np
import pandas as pd
import sys

np.random.seed(123456789)  # for reproducibility
from sklearn.datasets import load_digits
from sklearn.preprocessing import MinMaxScaler
from sklearn.model_selection import train_test_split
from sklearn.metrics.classification import accuracy_score
from sklearn.metrics import precision_recall_fscore_support
from sklearn.metrics import confusion_matrix
import itertools

from tf_models import SupervisedDBNClassification
import matplotlib.pyplot as plt
from dataset_location_hackathon import *


def load_data(dataset):
    temp_input = []
    temp_label = []

    temp_label.extend((LABELS_TYPE_ER,LABELS_TYPE_PGR,LABELS_TYPE_HER2))

    if dataset == 1:        # Methylation
        temp_input.extend((INPUT_MET_TYPE_ER,INPUT_MET_TYPE_PGR,INPUT_MET_TYPE_HER2))
    elif (dataset == 2):    # Gene
        temp_input.extend((INPUT_GEN_TYPE_ER,INPUT_GEN_TYPE_PGR,INPUT_GEN_TYPE_HER2))
    elif dataset == 3:      # miRNA
        temp_input.extend((INPUT_MIR_TYPE_ER,INPUT_MIR_TYPE_PGR,INPUT_MIR_TYPE_HER2))

    
    min_max_scaler = MinMaxScaler()
    rval = []

    for i in range(3):
        input_set = np.genfromtxt(temp_input[i], delimiter=',')
        label_set = np.genfromtxt(temp_label[i], delimiter=',')

        _, nr_in = input_set.shape
        
        # normalize input
        input_set = min_max_scaler.fit_transform(input_set)

        rval.extend((input_set, label_set))

    return rval


def test_DBN(finetune_lr=0.1,
    pretraining_epochs=100,
    pretrain_lr=0.01, k=1,
    training_epochs=100,
    dataset=3, batch_size=10,
    layers=[1000, 1000, 1000]):
    
    # title
    temp_title = ["DNA Methylation", "Gene Expression", "miRNA Expression"]
    print("\nCancer Type Classification with " + temp_title[dataset-1] + " (Tensorflow)\n")
    
    datasets = load_data(dataset)
    
    temp_str = ["ER", "PGR", "HER2"]
    for i in range(3):
        print("\n" + temp_str[i] + " Status Prediction Training Process\n")

        # Splitting data
        X_train, X_test, Y_train, Y_test = train_test_split(datasets[i*2], datasets[(i*2)+1], test_size=0.25, random_state=100)

        # Training
        classifier = SupervisedDBNClassification(hidden_layers_structure=layers,
                                                 learning_rate_rbm=pretrain_lr,
                                                 learning_rate=finetune_lr,
                                                 n_epochs_rbm=pretraining_epochs,
                                                 n_iter_backprop=training_epochs,
                                                 batch_size=batch_size,
                                                 activation_function='relu',
                                                 dropout_p=0.2)
        classifier.fit(X_train, Y_train)

        # Compute the prediction accuracy 
        Y_pred = classifier.predict(X_test)
        print('Accuracy: %f' % accuracy_score(Y_test, Y_pred))

        # Compute the precision, recall and f1 score of the classification
        p, r, f, s = precision_recall_fscore_support(Y_test, Y_pred, average='weighted')
        print('Precision:', p)
        print('Recall:', r)
        print('F1-score:', f)

        # Compute print and plot confusion matrix
        cnf_matrix = confusion_matrix(Y_test, Y_pred)
        np.set_printoptions(precision=2)

