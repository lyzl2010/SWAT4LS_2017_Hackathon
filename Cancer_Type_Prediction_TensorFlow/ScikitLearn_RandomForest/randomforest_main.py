from sklearn.ensemble import RandomForestClassifier
from sklearn import metrics
import numpy as np
import pandas as pd
import random
from sklearn.model_selection import train_test_split
from sklearn.metrics import confusion_matrix
from sklearn.model_selection import  cross_val_score, cross_val_predict

random.seed(1337)
np.random.seed(1337)  # for reproducibility

# subtype_classification = True
subtype_classification = False

filepath = '../input/CNV_data_reduced.csv'
input_df = pd.read_csv(filepath, sep='\t')
if subtype_classification:
    input_df = input_df[input_df['ctype'] != 15]
else:
    input_df.ix[input_df['ctype'] != 15, 'ctype'] = 1
column_headers = input_df.columns.values.tolist()
column_headers.remove('sample_id')
column_headers.remove('ctype')

X = input_df[column_headers].values
y = input_df['ctype'].values

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.25, random_state=42)

rf = RandomForestClassifier(n_estimators=100, criterion="gini", max_depth=32, max_features="auto")
model = rf.fit(X_train, y_train)
predictionRes = model.predict(X_test)

print(metrics.classification_report(y_test, predictionRes, digits=4))
accuracy = metrics.accuracy_score(y_test, predictionRes)
print("Accuracy: " + str(accuracy))
print("Confusion matrix: ")
print(confusion_matrix(y_test, predictionRes))

#cross validation
cvs = cross_val_score(model, X, y, cv=5)
print("Cross validation scores: " + str(cvs))
cvp = cross_val_predict(model, X, y, cv=5)
print("Cross validation prediction scores: ")
print(metrics.classification_report(y, cvp, digits=4))
cva = metrics.accuracy_score(y, cvp)
print("Cross validation accuracy: " + str(cva))
print("Cross validation confusion matrix: ")
print(confusion_matrix(y, cvp))

