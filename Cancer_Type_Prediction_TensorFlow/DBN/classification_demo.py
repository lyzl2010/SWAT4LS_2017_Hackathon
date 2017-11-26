import tensorflow as tf
import pandas as pd
import numpy as np
import random
import os
import warnings
from tensorflow.python.framework import ops
np.random.seed(123456789)  # for reproducibility
from sklearn.datasets import load_digits
from sklearn.model_selection import train_test_split
from sklearn.metrics.classification import accuracy_score
from sklearn.metrics import precision_recall_fscore_support
from sklearn.metrics import confusion_matrix
import itertools

from tf_models import SupervisedDBNClassification
import matplotlib.pyplot as plt

warnings.filterwarnings("ignore")
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '3'

# subtype_classification = True
subtype_classification = False

# Loading dataset
filepath = '../input/CNV_data_reduced.csv'
raw_data = pd.read_csv(filepath, sep='\t')
if subtype_classification:
    raw_data = raw_data[raw_data['ctype'] != 15]
    for val in range(1, np.unique(raw_data['ctype']).size+1):
        raw_data.ix[raw_data['ctype'] == val, 'ctype'] = val-1 #labels needs to start from 0
else:
    raw_data.ix[raw_data['ctype'] != 15, 'ctype'] = 0
    raw_data.ix[raw_data['ctype'] == 15, 'ctype'] = 1

column_headers = raw_data.columns.values.tolist()
column_headers.remove('sample_id')
raw_data = raw_data[column_headers]
column_headers.remove('ctype')

# y data
Y_LABEL = 'ctype'                                			    
KEYS = [i for i in raw_data.keys().tolist() if i != Y_LABEL]	        # Name of predictors
X = raw_data[KEYS].get_values()                  			# X data
Y = raw_data[Y_LABEL].get_values()   
class_names = list(raw_data.columns.values)
print(class_names)

# Splitting data
X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size=0.25, random_state=100)

# Training
classifier = SupervisedDBNClassification(hidden_layers_structure=[64, 64],
                                         learning_rate_rbm=0.05,
                                         learning_rate=0.01,
                                         n_epochs_rbm=10,
                                         n_iter_backprop=100,
                                         batch_size=32,
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

def print_and_plot_confusion_matrix(cm, classes, normalize=False, title='Confusion matrix', cmap=plt.cm.Blues):
    """
    This function prints and plots the confusion matrix.
    Normalization can be applied by setting `normalize=True`.
    """
    plt.imshow(cm, interpolation='nearest', cmap=cmap)
    plt.title(title)
    plt.colorbar()
    tick_marks = np.arange(len(classes))
    plt.xticks(tick_marks, classes, rotation=45)
    plt.yticks(tick_marks, classes)

    if normalize:
        cm = cm.astype('float') / cm.sum(axis=1)[:, np.newaxis]
        print("Normalized confusion matrix")
    else:
        print('Confusion matrix, without normalization')

    thresh = cm.max() / 2.
    for i, j in itertools.product(range(cm.shape[0]), range(cm.shape[1])):
        plt.text(j, i, cm[i, j], horizontalalignment="center", color="white" if cm[i, j] > thresh else "black")

    plt.tight_layout()
    plt.ylabel('True label')
    plt.xlabel('Predicted label')
    return cm

# Plot non-normalized confusion matrix
plt.figure()
print_and_plot_confusion_matrix(cnf_matrix, classes=class_names, normalize=False, title='Confusion matrix, without normalization')
plt.show()
