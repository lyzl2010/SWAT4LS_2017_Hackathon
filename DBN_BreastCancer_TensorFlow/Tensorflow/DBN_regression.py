from sklearn.cross_validation import train_test_split
from sklearn.metrics.regression import r2_score, mean_squared_error
from sklearn.preprocessing import MinMaxScaler

from tf_models import SupervisedDBNRegression

import sys
import numpy

from dataset_location_hackathon import *
sys.path.insert(0, '/home/asif/Downloads/hakathon/Preprocessed_Data_Short_version/')
from main_run import *


def load_data(dataset):
    temp_label = LABELS_SURVIVAL
    if dataset == 1:                                    # Methylation
        temp_input = INPUT_MET_SURVIVAL
    elif dataset == 2:                                  # Gene
        temp_input = INPUT_GEN_SURVIVAL
    elif dataset == 3:                                  # miRNA
        temp_input = INPUT_MIR_SURVIVAL

    
    try:
        input_set = numpy.genfromtxt(temp_input, delimiter=',')
        label_set = numpy.genfromtxt(temp_label, delimiter=',')
    except Exception as e:
        sys.exit("Change your choice of features because the data is not available")

    _, nr_in = input_set.shape

    # normalize input
    min_max_scaler = MinMaxScaler()
    input_set = min_max_scaler.fit_transform(input_set)

    return input_set, label_set


def test_DBN(finetune_lr=0.1,
    pretraining_epochs=100,
    pretrain_lr=0.01, k=1,
    training_epochs=100,
    dataset=3, batch_size=10,
    layers=[1000, 1000, 1000]):
	
    # title
    temp_title = ["DNA Methylation",
                  "Gene Expression HTSeq",
                  "miRNA Expression"]
    print("\nSurvival Rate Regression with " + temp_title[dataset-1] + " (Tensorflow)\n")
    
    # Loading dataset
    X, Y = load_data(dataset)

    # Splitting data
    X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size=0.2, random_state=1337)

    # Data scaling
    min_max_scaler = MinMaxScaler()
    X_train = min_max_scaler.fit_transform(X_train)

    # Training
    regressor = SupervisedDBNRegression(hidden_layers_structure=layers,
                                    	learning_rate_rbm=pretrain_lr,
                                    	learning_rate=finetune_lr,
                                    	n_epochs_rbm=pretraining_epochs,
                                    	n_iter_backprop=training_epochs,
                                    	batch_size=batch_size,
                                    	activation_function='relu')
    regressor.fit(X_train, Y_train)

    # Test
    X_test = min_max_scaler.transform(X_test)
    Y_pred = regressor.predict(X_test)
    try:
        print('Done.\nR-squared: %f\nMSE: %f' % (r2_score(Y_test, Y_pred), mean_squared_error(Y_test, Y_pred)))
    except Exception as e:
        print("Infinity or a value too large for dtype('float32'). Please try different layer settings.")
    

