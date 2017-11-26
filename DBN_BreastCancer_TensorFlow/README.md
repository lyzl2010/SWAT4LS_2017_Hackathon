# Deep Belief Network for TCGA BRCA genomic, transcriptomic and clinical data
TCGA BRCA is a catalogue of genetic mutations responsible for breast cancer. The TCGA BRCA project in the [GDC Data Portal](https://portal.gdc.cancer.gov/repository?filters=~%28op~%27and~content~%28~%28op~%27in~content~%28field~%27cases.project.project_id~value~%28~%27TCGA-BRCA%29%29%29%29%29) consists of more than 27,000 files from 1,098 cases (patients). These files are categorized into 13 different data types, 9 of those can be accessed publicly, while the remaining 4 are controlled. This project will only used public-access files.

This project will create a prediction of breast cancer patient status with multimodal Deep Belief Network (mDBN) using their genetic and clinical data. To be specific, there are three predictions that can be done, which are
1.   Breast cancer type classification
2.   Survival rate regression

This project is created on Python. First, a preprocessing step is done to create the dataset for the Neural Network. Then, we try to implement the DBN on [TensorFlow](https://www.tensorflow.org/).

# Installing
To install this tutorial, you need to have TensorFlow installed on your system. This tutorial requires TensorFlow Nightly. To install TensorFlow, follow the installation instructions here. Once TensorFlow is installed, you can download the source code of this tutorial by running:

git clone https://github.com/tensorflow/nmt/

# Steps to be followed:
1. Make sure you have Python 2.7 installed on your computer. Make sure you have Tensorflow modules installed on your Python 2.7.
2. Change "dataset_location_hackathon.py" in folder "Tensorflow". Change variable "MAIN_MDBN_TCGA_BRCA" to the folder of your data.
3. Implement the prediction by running main_run.py "python main_run.py".
	- Pick the type of prediction you want to do.
	- Pick the features you want to use.
	- Design your neural networks (layers, hyperparameters, and etc) 

# A sample execution	
asif@ubuntu:~/Downloads/hakathon/mdbn_tcga_brca_tensorflow$ pwd
/home/asif/Downloads/hakathon/mdbn_tcga_brca_tensorflow
asif@ubuntu:~/Downloads/hakathon/mdbn_tcga_brca_tensorflow$ ls
main_run.py  main_run.pyc  README.md  Tensorflow
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
2017-11-24 13:55:12.751886: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use SSE4.1 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-24 13:55:12.752029: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use SSE4.2 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-24 13:55:12.752063: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use AVX instructions, but these are available on your machine and could speed up CPU computations.
2017-11-24 13:55:12.752093: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use AVX2 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-24 13:55:12.752122: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use FMA instructions, but these are available on your machine and could speed up CPU computations.

Cancer Type Classification with DNA Methylation (Tensorflow)

/usr/local/lib/python2.7/dist-packages/sklearn/utils/validation.py:475: DataConversionWarning: Data with input dtype |S21 was converted to float64 by MinMaxScaler.
  warnings.warn(msg, DataConversionWarning)

ER Status Prediction Training Process

Traceback (most recent call last):
  File "main_run.py", line 144, in <module>
    main()
  File "main_run.py", line 130, in main
    layers=LAYERS)
  File "/home/asif/Downloads/hakathon/mdbn_tcga_brca_tensorflow/Tensorflow/DBN_classification.py", line 109, in test_DBN
    X_train, X_test, Y_train, Y_test = train_test_split(datasets[i*2], datasets[(i*2)+1], test_size=0.25, random_state=100)
  File "/usr/local/lib/python2.7/dist-packages/sklearn/model_selection/_split.py", line 2031, in train_test_split
    arrays = indexable(*arrays)
  File "/usr/local/lib/python2.7/dist-packages/sklearn/utils/validation.py", line 229, in indexable
    check_consistent_length(*result)
  File "/usr/local/lib/python2.7/dist-packages/sklearn/utils/validation.py", line 204, in check_consistent_length
    " samples: %r" % [int(l) for l in lengths])
ValueError: Found input variables with inconsistent numbers of samples: [1046, 1022]
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
2017-11-24 14:02:08.512719: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use SSE4.1 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-24 14:02:08.512827: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use SSE4.2 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-24 14:02:08.512863: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use AVX instructions, but these are available on your machine and could speed up CPU computations.
2017-11-24 14:02:08.512893: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use AVX2 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-24 14:02:08.512922: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use FMA instructions, but these are available on your machine and could speed up CPU computations.

Cancer Type Classification with DNA Methylation (Tensorflow)

/usr/local/lib/python2.7/dist-packages/sklearn/utils/validation.py:475: DataConversionWarning: Data with input dtype |S21 was converted to float64 by MinMaxScaler.
  warnings.warn(msg, DataConversionWarning)

ER Status Prediction Training Process

[START] Pre-training step:
>> Epoch 1 finished 	RBM Reconstruction error 610.572404
>> Epoch 2 finished 	RBM Reconstruction error 467.756593
>> Epoch 3 finished 	RBM Reconstruction error 659.194650
>> Epoch 4 finished 	RBM Reconstruction error 691.450521
>> Epoch 5 finished 	RBM Reconstruction error 671.588420
>> Epoch 6 finished 	RBM Reconstruction error 708.072636
>> Epoch 7 finished 	RBM Reconstruction error 747.762251
>> Epoch 8 finished 	RBM Reconstruction error 830.075720
>> Epoch 9 finished 	RBM Reconstruction error 797.394041
>> Epoch 10 finished 	RBM Reconstruction error 986.151830
>> Epoch 11 finished 	RBM Reconstruction error 1108.930749
>> Epoch 12 finished 	RBM Reconstruction error 909.330048
>> Epoch 13 finished 	RBM Reconstruction error 819.489193
>> Epoch 14 finished 	RBM Reconstruction error 962.894567
>> Epoch 15 finished 	RBM Reconstruction error 1099.593522
>> Epoch 16 finished 	RBM Reconstruction error 1079.408164
>> Epoch 17 finished 	RBM Reconstruction error 1071.494944
>> Epoch 18 finished 	RBM Reconstruction error 876.653366
>> Epoch 19 finished 	RBM Reconstruction error 1132.431671
>> Epoch 20 finished 	RBM Reconstruction error 1125.099585
>> Epoch 21 finished 	RBM Reconstruction error 1076.410053
>> Epoch 22 finished 	RBM Reconstruction error 1020.130136
>> Epoch 23 finished 	RBM Reconstruction error 1285.196662
>> Epoch 24 finished 	RBM Reconstruction error 1131.793469
>> Epoch 25 finished 	RBM Reconstruction error 1140.726405
>> Epoch 26 finished 	RBM Reconstruction error 1257.163917
>> Epoch 27 finished 	RBM Reconstruction error 818.264176
>> Epoch 28 finished 	RBM Reconstruction error 849.890078
>> Epoch 29 finished 	RBM Reconstruction error 1059.120104
>> Epoch 30 finished 	RBM Reconstruction error 1070.391271
>> Epoch 31 finished 	RBM Reconstruction error 1331.430560
>> Epoch 32 finished 	RBM Reconstruction error 1105.297439
>> Epoch 33 finished 	RBM Reconstruction error 1076.815768
>> Epoch 34 finished 	RBM Reconstruction error 958.837789
>> Epoch 35 finished 	RBM Reconstruction error 1130.586956
>> Epoch 36 finished 	RBM Reconstruction error 1495.893071
>> Epoch 37 finished 	RBM Reconstruction error 902.512685
>> Epoch 38 finished 	RBM Reconstruction error 958.974024
>> Epoch 39 finished 	RBM Reconstruction error 1131.840848
>> Epoch 40 finished 	RBM Reconstruction error 1046.920154
>> Epoch 41 finished 	RBM Reconstruction error 1069.684272
>> Epoch 42 finished 	RBM Reconstruction error 1178.309549
>> Epoch 43 finished 	RBM Reconstruction error 1169.543905
>> Epoch 44 finished 	RBM Reconstruction error 976.787493
>> Epoch 45 finished 	RBM Reconstruction error 1611.200933
>> Epoch 46 finished 	RBM Reconstruction error 1082.482036
>> Epoch 47 finished 	RBM Reconstruction error 1132.196374
>> Epoch 48 finished 	RBM Reconstruction error 1389.551484
>> Epoch 49 finished 	RBM Reconstruction error 1462.378253
>> Epoch 50 finished 	RBM Reconstruction error 1069.351884
>> Epoch 51 finished 	RBM Reconstruction error 955.484607
>> Epoch 52 finished 	RBM Reconstruction error 1218.440059
>> Epoch 53 finished 	RBM Reconstruction error 1140.185590
>> Epoch 54 finished 	RBM Reconstruction error 1253.853479
>> Epoch 55 finished 	RBM Reconstruction error 1002.712085
>> Epoch 56 finished 	RBM Reconstruction error 1470.787701
>> Epoch 57 finished 	RBM Reconstruction error 1331.686704
>> Epoch 58 finished 	RBM Reconstruction error 1353.252449
>> Epoch 59 finished 	RBM Reconstruction error 1493.172349
>> Epoch 60 finished 	RBM Reconstruction error 1485.552498
>> Epoch 61 finished 	RBM Reconstruction error 1754.184464
>> Epoch 62 finished 	RBM Reconstruction error 1431.877485
>> Epoch 63 finished 	RBM Reconstruction error 1677.701346
>> Epoch 64 finished 	RBM Reconstruction error 1948.843289
>> Epoch 65 finished 	RBM Reconstruction error 2109.130872
>> Epoch 66 finished 	RBM Reconstruction error 2336.879204
>> Epoch 67 finished 	RBM Reconstruction error 2767.603602
>> Epoch 68 finished 	RBM Reconstruction error 2687.787972
>> Epoch 69 finished 	RBM Reconstruction error 2507.645741
>> Epoch 70 finished 	RBM Reconstruction error 3361.317994
>> Epoch 71 finished 	RBM Reconstruction error 3699.607883
>> Epoch 72 finished 	RBM Reconstruction error 3510.790014
>> Epoch 73 finished 	RBM Reconstruction error 4317.300426
>> Epoch 74 finished 	RBM Reconstruction error 4194.172783
>> Epoch 75 finished 	RBM Reconstruction error 4765.169600
>> Epoch 76 finished 	RBM Reconstruction error 4509.294532
>> Epoch 77 finished 	RBM Reconstruction error 4632.958193
>> Epoch 78 finished 	RBM Reconstruction error 4983.913445
>> Epoch 79 finished 	RBM Reconstruction error 5374.373626
>> Epoch 80 finished 	RBM Reconstruction error 5972.467535
>> Epoch 81 finished 	RBM Reconstruction error 5446.616557
>> Epoch 82 finished 	RBM Reconstruction error 5443.998987
>> Epoch 83 finished 	RBM Reconstruction error 5826.945629
>> Epoch 84 finished 	RBM Reconstruction error 6606.518841
>> Epoch 85 finished 	RBM Reconstruction error 5496.122464
>> Epoch 86 finished 	RBM Reconstruction error 5933.298468
>> Epoch 87 finished 	RBM Reconstruction error 6786.524938
>> Epoch 88 finished 	RBM Reconstruction error 7033.951678
>> Epoch 89 finished 	RBM Reconstruction error 6933.047630
>> Epoch 90 finished 	RBM Reconstruction error 7181.147089
>> Epoch 91 finished 	RBM Reconstruction error 7435.066260
>> Epoch 92 finished 	RBM Reconstruction error 7738.777885
>> Epoch 93 finished 	RBM Reconstruction error 8100.478365
>> Epoch 94 finished 	RBM Reconstruction error 7326.581355
>> Epoch 95 finished 	RBM Reconstruction error 7431.325380
>> Epoch 96 finished 	RBM Reconstruction error 7166.038565
>> Epoch 97 finished 	RBM Reconstruction error 7834.990370
>> Epoch 98 finished 	RBM Reconstruction error 7959.086165
>> Epoch 99 finished 	RBM Reconstruction error 7370.807770
>> Epoch 100 finished 	RBM Reconstruction error 8005.998625
>> Epoch 1 finished 	RBM Reconstruction error 280376.968750
>> Epoch 2 finished 	RBM Reconstruction error 304802.906250
>> Epoch 3 finished 	RBM Reconstruction error 428111.375000
>> Epoch 4 finished 	RBM Reconstruction error 479022.718750
>> Epoch 5 finished 	RBM Reconstruction error 392566.312500
>> Epoch 6 finished 	RBM Reconstruction error 389721.968750
>> Epoch 7 finished 	RBM Reconstruction error 515493.500000
>> Epoch 8 finished 	RBM Reconstruction error 595875.312500
>> Epoch 9 finished 	RBM Reconstruction error 535640.187500
>> Epoch 10 finished 	RBM Reconstruction error 594747.500000
>> Epoch 11 finished 	RBM Reconstruction error 585409.937500
>> Epoch 12 finished 	RBM Reconstruction error 655577.625000
>> Epoch 13 finished 	RBM Reconstruction error 676284.687500
>> Epoch 14 finished 	RBM Reconstruction error 721981.812500
>> Epoch 15 finished 	RBM Reconstruction error 791994.562500
>> Epoch 16 finished 	RBM Reconstruction error 832575.062500
>> Epoch 17 finished 	RBM Reconstruction error 745671.000000
>> Epoch 18 finished 	RBM Reconstruction error 764578.250000
>> Epoch 19 finished 	RBM Reconstruction error 708601.125000
>> Epoch 20 finished 	RBM Reconstruction error 783969.687500
>> Epoch 21 finished 	RBM Reconstruction error 787759.187500
>> Epoch 22 finished 	RBM Reconstruction error 820046.875000
>> Epoch 23 finished 	RBM Reconstruction error 860475.312500
>> Epoch 24 finished 	RBM Reconstruction error 869154.687500
>> Epoch 25 finished 	RBM Reconstruction error 939081.687500
>> Epoch 26 finished 	RBM Reconstruction error 925940.812500
>> Epoch 27 finished 	RBM Reconstruction error 903787.437500
>> Epoch 28 finished 	RBM Reconstruction error 919789.625000
>> Epoch 29 finished 	RBM Reconstruction error 1015776.437500
>> Epoch 30 finished 	RBM Reconstruction error 933296.125000
>> Epoch 31 finished 	RBM Reconstruction error 1011239.875000
>> Epoch 32 finished 	RBM Reconstruction error 1052726.125000
>> Epoch 33 finished 	RBM Reconstruction error 1167743.625000
>> Epoch 34 finished 	RBM Reconstruction error 1145434.625000
>> Epoch 35 finished 	RBM Reconstruction error 1164733.375000
>> Epoch 36 finished 	RBM Reconstruction error 1077665.000000
>> Epoch 37 finished 	RBM Reconstruction error 1109824.875000
>> Epoch 38 finished 	RBM Reconstruction error 1189749.625000
>> Epoch 39 finished 	RBM Reconstruction error 1241229.375000
>> Epoch 40 finished 	RBM Reconstruction error 1190909.000000
>> Epoch 41 finished 	RBM Reconstruction error 1259808.125000
>> Epoch 42 finished 	RBM Reconstruction error 1266168.500000
>> Epoch 43 finished 	RBM Reconstruction error 1292855.125000
>> Epoch 44 finished 	RBM Reconstruction error 1344600.625000
>> Epoch 45 finished 	RBM Reconstruction error 1356746.250000
>> Epoch 46 finished 	RBM Reconstruction error 1273274.875000
>> Epoch 47 finished 	RBM Reconstruction error 1454146.875000
>> Epoch 48 finished 	RBM Reconstruction error 1473018.625000
>> Epoch 49 finished 	RBM Reconstruction error 1470408.875000
>> Epoch 50 finished 	RBM Reconstruction error 1481193.000000
>> Epoch 51 finished 	RBM Reconstruction error 1507015.125000
>> Epoch 52 finished 	RBM Reconstruction error 1494720.125000
>> Epoch 53 finished 	RBM Reconstruction error 1499530.000000
>> Epoch 54 finished 	RBM Reconstruction error 1544917.000000
>> Epoch 55 finished 	RBM Reconstruction error 1598764.000000
>> Epoch 56 finished 	RBM Reconstruction error 1537954.125000
>> Epoch 57 finished 	RBM Reconstruction error 1564224.375000
>> Epoch 58 finished 	RBM Reconstruction error 1484961.875000
>> Epoch 59 finished 	RBM Reconstruction error 1581871.250000
>> Epoch 60 finished 	RBM Reconstruction error 1515713.000000
>> Epoch 61 finished 	RBM Reconstruction error 1585247.125000
>> Epoch 62 finished 	RBM Reconstruction error 1632987.625000
>> Epoch 63 finished 	RBM Reconstruction error 1599817.875000
>> Epoch 64 finished 	RBM Reconstruction error 1668880.875000
>> Epoch 65 finished 	RBM Reconstruction error 1767116.875000
>> Epoch 66 finished 	RBM Reconstruction error 1795716.000000
>> Epoch 67 finished 	RBM Reconstruction error 1747218.750000
>> Epoch 68 finished 	RBM Reconstruction error 1986948.375000
>> Epoch 69 finished 	RBM Reconstruction error 1990073.875000
>> Epoch 70 finished 	RBM Reconstruction error 1908146.125000
>> Epoch 71 finished 	RBM Reconstruction error 1965694.000000
>> Epoch 72 finished 	RBM Reconstruction error 1965392.000000
>> Epoch 73 finished 	RBM Reconstruction error 2003914.875000
>> Epoch 74 finished 	RBM Reconstruction error 1913735.625000
>> Epoch 75 finished 	RBM Reconstruction error 2069095.375000
>> Epoch 76 finished 	RBM Reconstruction error 2068713.625000
>> Epoch 77 finished 	RBM Reconstruction error 1898653.250000
>> Epoch 78 finished 	RBM Reconstruction error 2197237.750000
>> Epoch 79 finished 	RBM Reconstruction error 2095857.250000
>> Epoch 80 finished 	RBM Reconstruction error 2110329.750000
>> Epoch 81 finished 	RBM Reconstruction error 2304881.250000
>> Epoch 82 finished 	RBM Reconstruction error 2329758.000000
>> Epoch 83 finished 	RBM Reconstruction error 2728304.250000
>> Epoch 84 finished 	RBM Reconstruction error 2642528.500000
>> Epoch 85 finished 	RBM Reconstruction error 2576678.750000
>> Epoch 86 finished 	RBM Reconstruction error 2682606.750000
>> Epoch 87 finished 	RBM Reconstruction error 2745505.500000
>> Epoch 88 finished 	RBM Reconstruction error 2891557.000000
>> Epoch 89 finished 	RBM Reconstruction error 2900145.500000
>> Epoch 90 finished 	RBM Reconstruction error 2940702.750000
>> Epoch 91 finished 	RBM Reconstruction error 3016356.750000
>> Epoch 92 finished 	RBM Reconstruction error 3162379.000000
>> Epoch 93 finished 	RBM Reconstruction error 3300189.000000
>> Epoch 94 finished 	RBM Reconstruction error 3393247.500000
>> Epoch 95 finished 	RBM Reconstruction error 3351159.750000
>> Epoch 96 finished 	RBM Reconstruction error 3435915.750000
>> Epoch 97 finished 	RBM Reconstruction error 3472574.750000
>> Epoch 98 finished 	RBM Reconstruction error 3542066.250000
>> Epoch 99 finished 	RBM Reconstruction error 3762126.250000
>> Epoch 100 finished 	RBM Reconstruction error 3717065.250000
>> Epoch 1 finished 	RBM Reconstruction error 13283574784.000000
>> Epoch 2 finished 	RBM Reconstruction error 16570219520.000000
>> Epoch 3 finished 	RBM Reconstruction error 18348275712.000000
>> Epoch 4 finished 	RBM Reconstruction error 14218039296.000000
>> Epoch 5 finished 	RBM Reconstruction error 20733218816.000000
>> Epoch 6 finished 	RBM Reconstruction error 17924548608.000000
>> Epoch 7 finished 	RBM Reconstruction error 18096367616.000000
>> Epoch 8 finished 	RBM Reconstruction error 20084000768.000000
>> Epoch 9 finished 	RBM Reconstruction error 19849537536.000000
>> Epoch 10 finished 	RBM Reconstruction error 19356246016.000000
>> Epoch 11 finished 	RBM Reconstruction error 23347877888.000000
>> Epoch 12 finished 	RBM Reconstruction error 23328907264.000000
>> Epoch 13 finished 	RBM Reconstruction error 19493066752.000000
>> Epoch 14 finished 	RBM Reconstruction error 21143910400.000000
>> Epoch 15 finished 	RBM Reconstruction error 26313818112.000000
>> Epoch 16 finished 	RBM Reconstruction error 23726925824.000000
>> Epoch 17 finished 	RBM Reconstruction error 23714961408.000000
>> Epoch 18 finished 	RBM Reconstruction error 24838383616.000000
>> Epoch 19 finished 	RBM Reconstruction error 23563640832.000000
>> Epoch 20 finished 	RBM Reconstruction error 27253694464.000000
>> Epoch 21 finished 	RBM Reconstruction error 19226388480.000000
>> Epoch 22 finished 	RBM Reconstruction error 26374215680.000000
>> Epoch 23 finished 	RBM Reconstruction error 26536898560.000000
>> Epoch 24 finished 	RBM Reconstruction error 24611823616.000000
>> Epoch 25 finished 	RBM Reconstruction error 29229828096.000000
>> Epoch 26 finished 	RBM Reconstruction error 28758685696.000000
>> Epoch 27 finished 	RBM Reconstruction error 26910152704.000000
>> Epoch 28 finished 	RBM Reconstruction error 24946165760.000000
>> Epoch 29 finished 	RBM Reconstruction error 29060818944.000000
>> Epoch 30 finished 	RBM Reconstruction error 33488488448.000000
>> Epoch 31 finished 	RBM Reconstruction error 28021170176.000000
>> Epoch 32 finished 	RBM Reconstruction error 27842373632.000000
>> Epoch 33 finished 	RBM Reconstruction error 40832536576.000000
>> Epoch 34 finished 	RBM Reconstruction error 40625082368.000000
>> Epoch 35 finished 	RBM Reconstruction error 40728965120.000000
>> Epoch 36 finished 	RBM Reconstruction error 36631101440.000000
>> Epoch 37 finished 	RBM Reconstruction error 36613124096.000000
>> Epoch 38 finished 	RBM Reconstruction error 42792071168.000000
>> Epoch 39 finished 	RBM Reconstruction error 41067782144.000000
>> Epoch 40 finished 	RBM Reconstruction error 41107591168.000000
>> Epoch 41 finished 	RBM Reconstruction error 33475819520.000000
>> Epoch 42 finished 	RBM Reconstruction error 40774758400.000000
>> Epoch 43 finished 	RBM Reconstruction error 40529580032.000000
>> Epoch 44 finished 	RBM Reconstruction error 50174443520.000000
>> Epoch 45 finished 	RBM Reconstruction error 44892577792.000000
>> Epoch 46 finished 	RBM Reconstruction error 38239670272.000000
>> Epoch 47 finished 	RBM Reconstruction error 38770782208.000000
>> Epoch 48 finished 	RBM Reconstruction error 46634594304.000000
>> Epoch 49 finished 	RBM Reconstruction error 46209359872.000000
>> Epoch 50 finished 	RBM Reconstruction error 40401682432.000000
>> Epoch 51 finished 	RBM Reconstruction error 40825778176.000000
>> Epoch 52 finished 	RBM Reconstruction error 38604304384.000000
>> Epoch 53 finished 	RBM Reconstruction error 37625163776.000000
>> Epoch 54 finished 	RBM Reconstruction error 44436144128.000000
>> Epoch 55 finished 	RBM Reconstruction error 38937247744.000000
>> Epoch 56 finished 	RBM Reconstruction error 40536756224.000000
>> Epoch 57 finished 	RBM Reconstruction error 39751725056.000000
>> Epoch 58 finished 	RBM Reconstruction error 52256952320.000000
>> Epoch 59 finished 	RBM Reconstruction error 57495465984.000000
>> Epoch 60 finished 	RBM Reconstruction error 56957894656.000000
>> Epoch 61 finished 	RBM Reconstruction error 58382684160.000000
>> Epoch 62 finished 	RBM Reconstruction error 50779287552.000000
>> Epoch 63 finished 	RBM Reconstruction error 59234447360.000000
>> Epoch 64 finished 	RBM Reconstruction error 52889505792.000000
>> Epoch 65 finished 	RBM Reconstruction error 60213182464.000000
>> Epoch 66 finished 	RBM Reconstruction error 65159016448.000000
>> Epoch 67 finished 	RBM Reconstruction error 62281379840.000000
>> Epoch 68 finished 	RBM Reconstruction error 66177368064.000000
>> Epoch 69 finished 	RBM Reconstruction error 65642803200.000000
>> Epoch 70 finished 	RBM Reconstruction error 69111447552.000000
>> Epoch 71 finished 	RBM Reconstruction error 61576093696.000000
>> Epoch 72 finished 	RBM Reconstruction error 71202930688.000000
>> Epoch 73 finished 	RBM Reconstruction error 63279624192.000000
>> Epoch 74 finished 	RBM Reconstruction error 66988888064.000000
>> Epoch 75 finished 	RBM Reconstruction error 70689513472.000000
>> Epoch 76 finished 	RBM Reconstruction error 72574124032.000000
>> Epoch 77 finished 	RBM Reconstruction error 74691297280.000000
>> Epoch 78 finished 	RBM Reconstruction error 66709880832.000000
>> Epoch 79 finished 	RBM Reconstruction error 64844103680.000000
>> Epoch 80 finished 	RBM Reconstruction error 67979440128.000000
>> Epoch 81 finished 	RBM Reconstruction error 71974846464.000000
>> Epoch 82 finished 	RBM Reconstruction error 79648235520.000000
>> Epoch 83 finished 	RBM Reconstruction error 72388820992.000000
>> Epoch 84 finished 	RBM Reconstruction error 80381083648.000000
>> Epoch 85 finished 	RBM Reconstruction error 72121745408.000000
>> Epoch 86 finished 	RBM Reconstruction error 75766497280.000000
>> Epoch 87 finished 	RBM Reconstruction error 79029035008.000000
>> Epoch 88 finished 	RBM Reconstruction error 69417213952.000000
>> Epoch 89 finished 	RBM Reconstruction error 71237271552.000000
>> Epoch 90 finished 	RBM Reconstruction error 72601477120.000000
>> Epoch 91 finished 	RBM Reconstruction error 78535245824.000000
>> Epoch 92 finished 	RBM Reconstruction error 82141454336.000000
>> Epoch 93 finished 	RBM Reconstruction error 72070782976.000000
>> Epoch 94 finished 	RBM Reconstruction error 68573011968.000000
>> Epoch 95 finished 	RBM Reconstruction error 72378589184.000000
>> Epoch 96 finished 	RBM Reconstruction error 81602494464.000000
>> Epoch 97 finished 	RBM Reconstruction error 72823226368.000000
>> Epoch 98 finished 	RBM Reconstruction error 85543018496.000000
>> Epoch 99 finished 	RBM Reconstruction error 85463572480.000000
>> Epoch 100 finished 	RBM Reconstruction error 71709433856.000000
[END] Pre-training step
[START] Fine tuning step:
>> Epoch 0 finished 	ANN training loss nan
>> Epoch 1 finished 	ANN training loss nan
>> Epoch 2 finished 	ANN training loss nan
>> Epoch 3 finished 	ANN training loss nan
>> Epoch 4 finished 	ANN training loss nan
>> Epoch 5 finished 	ANN training loss nan
>> Epoch 6 finished 	ANN training loss nan
>> Epoch 7 finished 	ANN training loss nan
>> Epoch 8 finished 	ANN training loss nan
>> Epoch 9 finished 	ANN training loss nan
>> Epoch 10 finished 	ANN training loss nan
>> Epoch 11 finished 	ANN training loss nan
>> Epoch 12 finished 	ANN training loss nan
>> Epoch 13 finished 	ANN training loss nan
>> Epoch 14 finished 	ANN training loss nan
>> Epoch 15 finished 	ANN training loss nan
>> Epoch 16 finished 	ANN training loss nan
>> Epoch 17 finished 	ANN training loss nan
>> Epoch 18 finished 	ANN training loss nan
>> Epoch 19 finished 	ANN training loss nan
>> Epoch 20 finished 	ANN training loss nan
>> Epoch 21 finished 	ANN training loss nan
>> Epoch 22 finished 	ANN training loss nan
>> Epoch 23 finished 	ANN training loss nan
>> Epoch 24 finished 	ANN training loss nan
>> Epoch 25 finished 	ANN training loss nan
>> Epoch 26 finished 	ANN training loss nan
>> Epoch 27 finished 	ANN training loss nan
>> Epoch 28 finished 	ANN training loss nan
>> Epoch 29 finished 	ANN training loss nan
>> Epoch 30 finished 	ANN training loss nan
>> Epoch 31 finished 	ANN training loss nan
>> Epoch 32 finished 	ANN training loss nan
>> Epoch 33 finished 	ANN training loss nan
>> Epoch 34 finished 	ANN training loss nan
>> Epoch 35 finished 	ANN training loss nan
>> Epoch 36 finished 	ANN training loss nan
>> Epoch 37 finished 	ANN training loss nan
>> Epoch 38 finished 	ANN training loss nan
>> Epoch 39 finished 	ANN training loss nan
>> Epoch 40 finished 	ANN training loss nan
>> Epoch 41 finished 	ANN training loss nan
>> Epoch 42 finished 	ANN training loss nan
>> Epoch 43 finished 	ANN training loss nan
>> Epoch 44 finished 	ANN training loss nan
>> Epoch 45 finished 	ANN training loss nan
>> Epoch 46 finished 	ANN training loss nan
>> Epoch 47 finished 	ANN training loss nan
>> Epoch 48 finished 	ANN training loss nan
>> Epoch 49 finished 	ANN training loss nan
>> Epoch 50 finished 	ANN training loss nan
>> Epoch 51 finished 	ANN training loss nan
>> Epoch 52 finished 	ANN training loss nan
>> Epoch 53 finished 	ANN training loss nan
>> Epoch 54 finished 	ANN training loss nan
>> Epoch 55 finished 	ANN training loss nan
>> Epoch 56 finished 	ANN training loss nan
>> Epoch 57 finished 	ANN training loss nan
>> Epoch 58 finished 	ANN training loss nan
>> Epoch 59 finished 	ANN training loss nan
>> Epoch 60 finished 	ANN training loss nan
>> Epoch 61 finished 	ANN training loss nan
>> Epoch 62 finished 	ANN training loss nan
>> Epoch 63 finished 	ANN training loss nan
>> Epoch 64 finished 	ANN training loss nan
>> Epoch 65 finished 	ANN training loss nan
>> Epoch 66 finished 	ANN training loss nan
>> Epoch 67 finished 	ANN training loss nan
>> Epoch 68 finished 	ANN training loss nan
>> Epoch 69 finished 	ANN training loss nan
>> Epoch 70 finished 	ANN training loss nan
>> Epoch 71 finished 	ANN training loss nan
>> Epoch 72 finished 	ANN training loss nan
>> Epoch 73 finished 	ANN training loss nan
>> Epoch 74 finished 	ANN training loss nan
>> Epoch 75 finished 	ANN training loss nan
>> Epoch 76 finished 	ANN training loss nan
>> Epoch 77 finished 	ANN training loss nan
>> Epoch 78 finished 	ANN training loss nan
>> Epoch 79 finished 	ANN training loss nan
>> Epoch 80 finished 	ANN training loss nan
>> Epoch 81 finished 	ANN training loss nan
>> Epoch 82 finished 	ANN training loss nan
>> Epoch 83 finished 	ANN training loss nan
>> Epoch 84 finished 	ANN training loss nan
>> Epoch 85 finished 	ANN training loss nan
>> Epoch 86 finished 	ANN training loss nan
>> Epoch 87 finished 	ANN training loss nan
>> Epoch 88 finished 	ANN training loss nan
>> Epoch 89 finished 	ANN training loss nan
>> Epoch 90 finished 	ANN training loss nan
>> Epoch 91 finished 	ANN training loss nan
>> Epoch 92 finished 	ANN training loss nan
>> Epoch 93 finished 	ANN training loss nan
>> Epoch 94 finished 	ANN training loss nan
>> Epoch 95 finished 	ANN training loss nan
>> Epoch 96 finished 	ANN training loss nan
>> Epoch 97 finished 	ANN training loss nan
>> Epoch 98 finished 	ANN training loss nan
>> Epoch 99 finished 	ANN training loss nan
[END] Fine tuning step
Accuracy: 0.765625
/usr/local/lib/python2.7/dist-packages/sklearn/metrics/classification.py:1135: UndefinedMetricWarning: Precision and F-score are ill-defined and being set to 0.0 in labels with no predicted samples.
  'precision', 'predicted', average, warn_for)
('Precision:', 0.586181640625)
('Recall:', 0.765625)
('F1-score:', 0.66399336283185839)

PGR Status Prediction Training Process

Traceback (most recent call last):
  File "main_run.py", line 144, in <module>
    main()
  File "main_run.py", line 130, in main
    layers=LAYERS)
  File "/home/asif/Downloads/hakathon/mdbn_tcga_brca_tensorflow/Tensorflow/DBN_classification.py", line 109, in test_DBN
    X_train, X_test, Y_train, Y_test = train_test_split(datasets[i*2], datasets[(i*2)+1], test_size=0.25, random_state=100)
  File "/usr/local/lib/python2.7/dist-packages/sklearn/model_selection/_split.py", line 2031, in train_test_split
    arrays = indexable(*arrays)
  File "/usr/local/lib/python2.7/dist-packages/sklearn/utils/validation.py", line 229, in indexable
    check_consistent_length(*result)
  File "/usr/local/lib/python2.7/dist-packages/sklearn/utils/validation.py", line 204, in check_consistent_length
    " samples: %r" % [int(l) for l in lengths])
ValueError: Found input variables with inconsistent numbers of samples: [1021, 895]
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
/usr/local/lib/python2.7/dist-packages/sklearn/cross_validation.py:41: DeprecationWarning: This module was deprecated in version 0.18 in favor of the model_selection module into which all the refactored classes and functions are moved. Also note that the interface of the new CV iterators are different from that of this module. This module will be removed in 0.20.
  "This module will be removed in 0.20.", DeprecationWarning)
2017-11-24 17:02:45.831885: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use SSE4.1 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-24 17:02:45.831987: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use SSE4.2 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-24 17:02:45.832022: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use AVX instructions, but these are available on your machine and could speed up CPU computations.
2017-11-24 17:02:45.832055: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use AVX2 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-24 17:02:45.832087: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use FMA instructions, but these are available on your machine and could speed up CPU computations.

Survival Rate Regression with DNA Methylation (Tensorflow)

/usr/local/lib/python2.7/dist-packages/sklearn/utils/validation.py:475: DataConversionWarning: Data with input dtype |S21 was converted to float64 by MinMaxScaler.
  warnings.warn(msg, DataConversionWarning)
[START] Pre-training step:
>> Epoch 1 finished 	RBM Reconstruction error 404.256883
>> Epoch 2 finished 	RBM Reconstruction error 422.670373
>> Epoch 3 finished 	RBM Reconstruction error 267.935869
>> Epoch 4 finished 	RBM Reconstruction error 496.527393
>> Epoch 5 finished 	RBM Reconstruction error 446.367457
>> Epoch 6 finished 	RBM Reconstruction error 441.310318
>> Epoch 7 finished 	RBM Reconstruction error 396.025506
>> Epoch 8 finished 	RBM Reconstruction error 512.360273
>> Epoch 9 finished 	RBM Reconstruction error 370.141066
>> Epoch 10 finished 	RBM Reconstruction error 503.043449
>> Epoch 11 finished 	RBM Reconstruction error 543.662357
>> Epoch 12 finished 	RBM Reconstruction error 578.223869
>> Epoch 13 finished 	RBM Reconstruction error 528.714841
>> Epoch 14 finished 	RBM Reconstruction error 791.413737
>> Epoch 15 finished 	RBM Reconstruction error 722.393465
>> Epoch 16 finished 	RBM Reconstruction error 478.740561
>> Epoch 17 finished 	RBM Reconstruction error 585.547636
>> Epoch 18 finished 	RBM Reconstruction error 551.548707
>> Epoch 19 finished 	RBM Reconstruction error 611.929313
>> Epoch 20 finished 	RBM Reconstruction error 641.117232
>> Epoch 21 finished 	RBM Reconstruction error 712.127931
>> Epoch 22 finished 	RBM Reconstruction error 733.507468
>> Epoch 23 finished 	RBM Reconstruction error 807.319134
>> Epoch 24 finished 	RBM Reconstruction error 537.145173
>> Epoch 25 finished 	RBM Reconstruction error 671.892140
>> Epoch 26 finished 	RBM Reconstruction error 756.548391
>> Epoch 27 finished 	RBM Reconstruction error 645.168194
>> Epoch 28 finished 	RBM Reconstruction error 824.050942
>> Epoch 29 finished 	RBM Reconstruction error 996.201899
>> Epoch 30 finished 	RBM Reconstruction error 873.333528
>> Epoch 31 finished 	RBM Reconstruction error 967.633559
>> Epoch 32 finished 	RBM Reconstruction error 921.456846
>> Epoch 33 finished 	RBM Reconstruction error 729.640524
>> Epoch 34 finished 	RBM Reconstruction error 1053.163092
>> Epoch 35 finished 	RBM Reconstruction error 946.508505
>> Epoch 36 finished 	RBM Reconstruction error 856.257920
>> Epoch 37 finished 	RBM Reconstruction error 633.188536
>> Epoch 38 finished 	RBM Reconstruction error 911.774241
>> Epoch 39 finished 	RBM Reconstruction error 669.039110
>> Epoch 40 finished 	RBM Reconstruction error 945.968125
>> Epoch 41 finished 	RBM Reconstruction error 892.905405
>> Epoch 42 finished 	RBM Reconstruction error 961.767737
>> Epoch 43 finished 	RBM Reconstruction error 884.567063
>> Epoch 44 finished 	RBM Reconstruction error 874.121108
>> Epoch 45 finished 	RBM Reconstruction error 1031.688148
>> Epoch 46 finished 	RBM Reconstruction error 1513.166196
>> Epoch 47 finished 	RBM Reconstruction error 1252.944974
>> Epoch 48 finished 	RBM Reconstruction error 1327.403486
>> Epoch 49 finished 	RBM Reconstruction error 1379.243176
>> Epoch 50 finished 	RBM Reconstruction error 1352.222662
>> Epoch 51 finished 	RBM Reconstruction error 1162.778172
>> Epoch 52 finished 	RBM Reconstruction error 1804.138766
>> Epoch 53 finished 	RBM Reconstruction error 1704.083131
>> Epoch 54 finished 	RBM Reconstruction error 1548.834586
>> Epoch 55 finished 	RBM Reconstruction error 1361.608845
>> Epoch 56 finished 	RBM Reconstruction error 1747.467677
>> Epoch 57 finished 	RBM Reconstruction error 2099.967515
>> Epoch 58 finished 	RBM Reconstruction error 1796.061120
>> Epoch 59 finished 	RBM Reconstruction error 1923.029300
>> Epoch 60 finished 	RBM Reconstruction error 2165.928480
>> Epoch 61 finished 	RBM Reconstruction error 2002.013464
>> Epoch 62 finished 	RBM Reconstruction error 2022.116048
>> Epoch 63 finished 	RBM Reconstruction error 1873.728994
>> Epoch 64 finished 	RBM Reconstruction error 1922.505526
>> Epoch 65 finished 	RBM Reconstruction error 2150.281940
>> Epoch 66 finished 	RBM Reconstruction error 2026.661017
>> Epoch 67 finished 	RBM Reconstruction error 2066.419886
>> Epoch 68 finished 	RBM Reconstruction error 2248.359021
>> Epoch 69 finished 	RBM Reconstruction error 2461.600763
>> Epoch 70 finished 	RBM Reconstruction error 2291.195204
>> Epoch 71 finished 	RBM Reconstruction error 2816.258735
>> Epoch 72 finished 	RBM Reconstruction error 2361.787058
>> Epoch 73 finished 	RBM Reconstruction error 2806.031540
>> Epoch 74 finished 	RBM Reconstruction error 3369.639055
>> Epoch 75 finished 	RBM Reconstruction error 3265.149633
>> Epoch 76 finished 	RBM Reconstruction error 2813.633888
>> Epoch 77 finished 	RBM Reconstruction error 3149.821459
>> Epoch 78 finished 	RBM Reconstruction error 3400.864772
>> Epoch 79 finished 	RBM Reconstruction error 3680.211714
>> Epoch 80 finished 	RBM Reconstruction error 3844.760652
>> Epoch 81 finished 	RBM Reconstruction error 4293.718083
>> Epoch 82 finished 	RBM Reconstruction error 4004.304292
>> Epoch 83 finished 	RBM Reconstruction error 4360.495396
>> Epoch 84 finished 	RBM Reconstruction error 4732.068986
>> Epoch 85 finished 	RBM Reconstruction error 5029.261771
>> Epoch 86 finished 	RBM Reconstruction error 5222.556121
>> Epoch 87 finished 	RBM Reconstruction error 4894.760706
>> Epoch 88 finished 	RBM Reconstruction error 4862.523926
>> Epoch 89 finished 	RBM Reconstruction error 5558.850164
>> Epoch 90 finished 	RBM Reconstruction error 5080.749182
>> Epoch 91 finished 	RBM Reconstruction error 5506.685460
>> Epoch 92 finished 	RBM Reconstruction error 6568.150444
>> Epoch 93 finished 	RBM Reconstruction error 5856.586574
>> Epoch 94 finished 	RBM Reconstruction error 6272.420231
>> Epoch 95 finished 	RBM Reconstruction error 6296.242733
>> Epoch 96 finished 	RBM Reconstruction error 7170.775565
>> Epoch 97 finished 	RBM Reconstruction error 6550.278349
>> Epoch 98 finished 	RBM Reconstruction error 7049.386763
>> Epoch 99 finished 	RBM Reconstruction error 6911.445694
>> Epoch 100 finished 	RBM Reconstruction error 6991.285548
>> Epoch 1 finished 	RBM Reconstruction error 241202.750000
>> Epoch 2 finished 	RBM Reconstruction error 223497.656250
>> Epoch 3 finished 	RBM Reconstruction error 275686.906250
>> Epoch 4 finished 	RBM Reconstruction error 296623.531250
>> Epoch 5 finished 	RBM Reconstruction error 377168.406250
>> Epoch 6 finished 	RBM Reconstruction error 339795.156250
>> Epoch 7 finished 	RBM Reconstruction error 384141.562500
>> Epoch 8 finished 	RBM Reconstruction error 354310.625000
>> Epoch 9 finished 	RBM Reconstruction error 378645.468750
>> Epoch 10 finished 	RBM Reconstruction error 359432.031250
>> Epoch 11 finished 	RBM Reconstruction error 373702.000000
>> Epoch 12 finished 	RBM Reconstruction error 336853.750000
>> Epoch 13 finished 	RBM Reconstruction error 356787.062500
>> Epoch 14 finished 	RBM Reconstruction error 385021.281250
>> Epoch 15 finished 	RBM Reconstruction error 368560.375000
>> Epoch 16 finished 	RBM Reconstruction error 424443.156250
>> Epoch 17 finished 	RBM Reconstruction error 440735.843750
>> Epoch 18 finished 	RBM Reconstruction error 476096.750000
>> Epoch 19 finished 	RBM Reconstruction error 387119.468750
>> Epoch 20 finished 	RBM Reconstruction error 386029.937500
>> Epoch 21 finished 	RBM Reconstruction error 397512.218750
>> Epoch 22 finished 	RBM Reconstruction error 429964.687500
>> Epoch 23 finished 	RBM Reconstruction error 456299.375000
>> Epoch 24 finished 	RBM Reconstruction error 437870.562500
>> Epoch 25 finished 	RBM Reconstruction error 437784.562500
>> Epoch 26 finished 	RBM Reconstruction error 417946.593750
>> Epoch 27 finished 	RBM Reconstruction error 462614.031250
>> Epoch 28 finished 	RBM Reconstruction error 429893.000000
>> Epoch 29 finished 	RBM Reconstruction error 488668.812500
>> Epoch 30 finished 	RBM Reconstruction error 559618.250000
>> Epoch 31 finished 	RBM Reconstruction error 503320.906250
>> Epoch 32 finished 	RBM Reconstruction error 506126.968750
>> Epoch 33 finished 	RBM Reconstruction error 552543.312500
>> Epoch 34 finished 	RBM Reconstruction error 571848.187500
>> Epoch 35 finished 	RBM Reconstruction error 578910.125000
>> Epoch 36 finished 	RBM Reconstruction error 571105.250000
>> Epoch 37 finished 	RBM Reconstruction error 522353.031250
>> Epoch 38 finished 	RBM Reconstruction error 561537.312500
>> Epoch 39 finished 	RBM Reconstruction error 529010.125000
>> Epoch 40 finished 	RBM Reconstruction error 617894.687500
>> Epoch 41 finished 	RBM Reconstruction error 595502.000000
>> Epoch 42 finished 	RBM Reconstruction error 760199.687500
>> Epoch 43 finished 	RBM Reconstruction error 607855.187500
>> Epoch 44 finished 	RBM Reconstruction error 693497.000000
>> Epoch 45 finished 	RBM Reconstruction error 689167.750000
>> Epoch 46 finished 	RBM Reconstruction error 737216.625000
>> Epoch 47 finished 	RBM Reconstruction error 665819.437500
>> Epoch 48 finished 	RBM Reconstruction error 708002.437500
>> Epoch 49 finished 	RBM Reconstruction error 764185.937500
>> Epoch 50 finished 	RBM Reconstruction error 749313.187500
>> Epoch 51 finished 	RBM Reconstruction error 753397.812500
>> Epoch 52 finished 	RBM Reconstruction error 822575.500000
>> Epoch 53 finished 	RBM Reconstruction error 814036.375000
>> Epoch 54 finished 	RBM Reconstruction error 916716.500000
>> Epoch 55 finished 	RBM Reconstruction error 855678.000000
>> Epoch 56 finished 	RBM Reconstruction error 1012891.000000
>> Epoch 57 finished 	RBM Reconstruction error 879903.187500
>> Epoch 58 finished 	RBM Reconstruction error 848373.937500
>> Epoch 59 finished 	RBM Reconstruction error 896042.750000
>> Epoch 60 finished 	RBM Reconstruction error 895078.062500
>> Epoch 61 finished 	RBM Reconstruction error 929889.687500
>> Epoch 62 finished 	RBM Reconstruction error 940191.312500
>> Epoch 63 finished 	RBM Reconstruction error 959017.250000
>> Epoch 64 finished 	RBM Reconstruction error 939761.562500
>> Epoch 65 finished 	RBM Reconstruction error 979691.750000
>> Epoch 66 finished 	RBM Reconstruction error 1076481.875000
>> Epoch 67 finished 	RBM Reconstruction error 1142633.750000
>> Epoch 68 finished 	RBM Reconstruction error 1108343.500000
>> Epoch 69 finished 	RBM Reconstruction error 1177313.250000
>> Epoch 70 finished 	RBM Reconstruction error 1238086.500000
>> Epoch 71 finished 	RBM Reconstruction error 1212511.875000
>> Epoch 72 finished 	RBM Reconstruction error 1262283.125000
>> Epoch 73 finished 	RBM Reconstruction error 1274024.625000
>> Epoch 74 finished 	RBM Reconstruction error 1382000.875000
>> Epoch 75 finished 	RBM Reconstruction error 1392950.875000
>> Epoch 76 finished 	RBM Reconstruction error 1431812.875000
>> Epoch 77 finished 	RBM Reconstruction error 1413259.250000
>> Epoch 78 finished 	RBM Reconstruction error 1530790.250000
>> Epoch 79 finished 	RBM Reconstruction error 1403865.625000
>> Epoch 80 finished 	RBM Reconstruction error 1562274.875000
>> Epoch 81 finished 	RBM Reconstruction error 1681284.500000
>> Epoch 82 finished 	RBM Reconstruction error 1630996.375000
>> Epoch 83 finished 	RBM Reconstruction error 1615757.625000
>> Epoch 84 finished 	RBM Reconstruction error 1794518.250000
>> Epoch 85 finished 	RBM Reconstruction error 1654652.000000
>> Epoch 86 finished 	RBM Reconstruction error 1649796.000000
>> Epoch 87 finished 	RBM Reconstruction error 1894492.250000
>> Epoch 88 finished 	RBM Reconstruction error 1860196.750000
>> Epoch 89 finished 	RBM Reconstruction error 1807061.375000
>> Epoch 90 finished 	RBM Reconstruction error 1853938.750000
>> Epoch 91 finished 	RBM Reconstruction error 1904733.750000
>> Epoch 92 finished 	RBM Reconstruction error 1917775.000000
>> Epoch 93 finished 	RBM Reconstruction error 1981295.500000
>> Epoch 94 finished 	RBM Reconstruction error 1924581.625000
>> Epoch 95 finished 	RBM Reconstruction error 1992819.250000
>> Epoch 96 finished 	RBM Reconstruction error 1994816.125000
>> Epoch 97 finished 	RBM Reconstruction error 2091781.750000
>> Epoch 98 finished 	RBM Reconstruction error 2234545.500000
>> Epoch 99 finished 	RBM Reconstruction error 2309686.000000
>> Epoch 100 finished 	RBM Reconstruction error 2398294.500000
>> Epoch 1 finished 	RBM Reconstruction error 1054266624.000000
>> Epoch 2 finished 	RBM Reconstruction error 1609914880.000000
>> Epoch 3 finished 	RBM Reconstruction error 2212510976.000000
>> Epoch 4 finished 	RBM Reconstruction error 2317020416.000000
>> Epoch 5 finished 	RBM Reconstruction error 2430010112.000000
>> Epoch 6 finished 	RBM Reconstruction error 5657021440.000000
>> Epoch 7 finished 	RBM Reconstruction error 7947460608.000000
>> Epoch 8 finished 	RBM Reconstruction error 11461676032.000000
>> Epoch 9 finished 	RBM Reconstruction error 17646080000.000000
>> Epoch 10 finished 	RBM Reconstruction error 25202100224.000000
>> Epoch 11 finished 	RBM Reconstruction error 31784980480.000000
>> Epoch 12 finished 	RBM Reconstruction error 47617953792.000000
>> Epoch 13 finished 	RBM Reconstruction error 57487728640.000000
>> Epoch 14 finished 	RBM Reconstruction error 75968528384.000000
>> Epoch 15 finished 	RBM Reconstruction error 87233150976.000000
>> Epoch 16 finished 	RBM Reconstruction error 97694842880.000000
>> Epoch 17 finished 	RBM Reconstruction error 109390331904.000000
>> Epoch 18 finished 	RBM Reconstruction error 130695225344.000000
>> Epoch 19 finished 	RBM Reconstruction error 143663775744.000000
>> Epoch 20 finished 	RBM Reconstruction error 156053258240.000000
>> Epoch 21 finished 	RBM Reconstruction error 163998023680.000000
>> Epoch 22 finished 	RBM Reconstruction error 193316667392.000000
>> Epoch 23 finished 	RBM Reconstruction error 203647516672.000000
>> Epoch 24 finished 	RBM Reconstruction error 225366458368.000000
>> Epoch 25 finished 	RBM Reconstruction error 251853225984.000000
>> Epoch 26 finished 	RBM Reconstruction error 254479548416.000000
>> Epoch 27 finished 	RBM Reconstruction error 266882973696.000000
>> Epoch 28 finished 	RBM Reconstruction error 288170377216.000000
>> Epoch 29 finished 	RBM Reconstruction error 305553604608.000000
>> Epoch 30 finished 	RBM Reconstruction error 317651189760.000000
>> Epoch 31 finished 	RBM Reconstruction error 318642749440.000000
>> Epoch 32 finished 	RBM Reconstruction error 329628745728.000000
>> Epoch 33 finished 	RBM Reconstruction error 339228098560.000000
>> Epoch 34 finished 	RBM Reconstruction error 351814680576.000000
>> Epoch 35 finished 	RBM Reconstruction error 358313459712.000000
>> Epoch 36 finished 	RBM Reconstruction error 363853217792.000000
>> Epoch 37 finished 	RBM Reconstruction error 375516954624.000000
>> Epoch 38 finished 	RBM Reconstruction error 382087921664.000000
>> Epoch 39 finished 	RBM Reconstruction error 405230485504.000000
>> Epoch 40 finished 	RBM Reconstruction error 402828918784.000000
>> Epoch 41 finished 	RBM Reconstruction error 391168262144.000000
>> Epoch 42 finished 	RBM Reconstruction error 367797010432.000000
>> Epoch 43 finished 	RBM Reconstruction error 349244719104.000000
>> Epoch 44 finished 	RBM Reconstruction error 358138707968.000000
>> Epoch 45 finished 	RBM Reconstruction error 339851378688.000000
>> Epoch 46 finished 	RBM Reconstruction error 344655396864.000000
>> Epoch 47 finished 	RBM Reconstruction error 341847015424.000000
>> Epoch 48 finished 	RBM Reconstruction error 342152839168.000000
>> Epoch 49 finished 	RBM Reconstruction error 339829784576.000000
>> Epoch 50 finished 	RBM Reconstruction error 343553081344.000000
>> Epoch 51 finished 	RBM Reconstruction error 345926008832.000000
>> Epoch 52 finished 	RBM Reconstruction error 345932562432.000000
>> Epoch 53 finished 	RBM Reconstruction error 337136287744.000000
>> Epoch 54 finished 	RBM Reconstruction error 357208915968.000000
>> Epoch 55 finished 	RBM Reconstruction error 369168875520.000000
>> Epoch 56 finished 	RBM Reconstruction error 386969436160.000000
>> Epoch 57 finished 	RBM Reconstruction error 437862825984.000000
>> Epoch 58 finished 	RBM Reconstruction error 449393426432.000000
>> Epoch 59 finished 	RBM Reconstruction error 452532928512.000000
>> Epoch 60 finished 	RBM Reconstruction error 489480060928.000000
>> Epoch 61 finished 	RBM Reconstruction error 502739730432.000000
>> Epoch 62 finished 	RBM Reconstruction error 538851115008.000000
>> Epoch 63 finished 	RBM Reconstruction error 523926372352.000000
>> Epoch 64 finished 	RBM Reconstruction error 540435087360.000000
>> Epoch 65 finished 	RBM Reconstruction error 541920919552.000000
>> Epoch 66 finished 	RBM Reconstruction error 569343475712.000000
>> Epoch 67 finished 	RBM Reconstruction error 572607561728.000000
>> Epoch 68 finished 	RBM Reconstruction error 579148054528.000000
>> Epoch 69 finished 	RBM Reconstruction error 581396398080.000000
>> Epoch 70 finished 	RBM Reconstruction error 590796554240.000000
>> Epoch 71 finished 	RBM Reconstruction error 579289874432.000000
>> Epoch 72 finished 	RBM Reconstruction error 568835309568.000000
>> Epoch 73 finished 	RBM Reconstruction error 533759819776.000000
>> Epoch 74 finished 	RBM Reconstruction error 521112748032.000000
>> Epoch 75 finished 	RBM Reconstruction error 504871845888.000000
>> Epoch 76 finished 	RBM Reconstruction error 517871468544.000000
>> Epoch 77 finished 	RBM Reconstruction error 525948911616.000000
>> Epoch 78 finished 	RBM Reconstruction error 559598206976.000000
>> Epoch 79 finished 	RBM Reconstruction error 572335194112.000000
>> Epoch 80 finished 	RBM Reconstruction error 612247994368.000000
>> Epoch 81 finished 	RBM Reconstruction error 631073800192.000000
>> Epoch 82 finished 	RBM Reconstruction error 684356796416.000000
>> Epoch 83 finished 	RBM Reconstruction error 714470785024.000000
>> Epoch 84 finished 	RBM Reconstruction error 725355986944.000000
>> Epoch 85 finished 	RBM Reconstruction error 770170683392.000000
>> Epoch 86 finished 	RBM Reconstruction error 791763419136.000000
>> Epoch 87 finished 	RBM Reconstruction error 833395228672.000000
>> Epoch 88 finished 	RBM Reconstruction error 837633769472.000000
>> Epoch 89 finished 	RBM Reconstruction error 872986116096.000000
>> Epoch 90 finished 	RBM Reconstruction error 883497041920.000000
>> Epoch 91 finished 	RBM Reconstruction error 903291011072.000000
>> Epoch 92 finished 	RBM Reconstruction error 943986769920.000000
>> Epoch 93 finished 	RBM Reconstruction error 944717496320.000000
>> Epoch 94 finished 	RBM Reconstruction error 936231567360.000000
>> Epoch 95 finished 	RBM Reconstruction error 945726750720.000000
>> Epoch 96 finished 	RBM Reconstruction error 935999635456.000000
>> Epoch 97 finished 	RBM Reconstruction error 913832673280.000000
>> Epoch 98 finished 	RBM Reconstruction error 848463855616.000000
>> Epoch 99 finished 	RBM Reconstruction error 852183678976.000000
>> Epoch 100 finished 	RBM Reconstruction error 882746195968.000000
[END] Pre-training step
[START] Fine tuning step:
>> Epoch 0 finished 	ANN training loss nan
>> Epoch 1 finished 	ANN training loss nan
>> Epoch 2 finished 	ANN training loss nan
>> Epoch 3 finished 	ANN training loss nan
>> Epoch 4 finished 	ANN training loss nan
>> Epoch 5 finished 	ANN training loss nan
>> Epoch 6 finished 	ANN training loss nan
>> Epoch 7 finished 	ANN training loss nan
>> Epoch 8 finished 	ANN training loss nan
>> Epoch 9 finished 	ANN training loss nan
>> Epoch 10 finished 	ANN training loss nan
>> Epoch 11 finished 	ANN training loss nan
>> Epoch 12 finished 	ANN training loss nan
>> Epoch 13 finished 	ANN training loss nan
>> Epoch 14 finished 	ANN training loss nan
>> Epoch 15 finished 	ANN training loss nan
>> Epoch 16 finished 	ANN training loss nan
>> Epoch 17 finished 	ANN training loss nan
>> Epoch 18 finished 	ANN training loss nan
>> Epoch 19 finished 	ANN training loss nan
>> Epoch 20 finished 	ANN training loss nan
>> Epoch 21 finished 	ANN training loss nan
>> Epoch 22 finished 	ANN training loss nan
>> Epoch 23 finished 	ANN training loss nan
>> Epoch 24 finished 	ANN training loss nan
>> Epoch 25 finished 	ANN training loss nan
>> Epoch 26 finished 	ANN training loss nan
>> Epoch 27 finished 	ANN training loss nan
>> Epoch 28 finished 	ANN training loss nan
>> Epoch 29 finished 	ANN training loss nan
>> Epoch 30 finished 	ANN training loss nan
>> Epoch 31 finished 	ANN training loss nan
>> Epoch 32 finished 	ANN training loss nan
>> Epoch 33 finished 	ANN training loss nan
>> Epoch 34 finished 	ANN training loss nan
>> Epoch 35 finished 	ANN training loss nan
>> Epoch 36 finished 	ANN training loss nan
>> Epoch 37 finished 	ANN training loss nan
>> Epoch 38 finished 	ANN training loss nan
>> Epoch 39 finished 	ANN training loss nan
>> Epoch 40 finished 	ANN training loss nan
>> Epoch 41 finished 	ANN training loss nan
>> Epoch 42 finished 	ANN training loss nan
>> Epoch 43 finished 	ANN training loss nan
>> Epoch 44 finished 	ANN training loss nan
>> Epoch 45 finished 	ANN training loss nan
>> Epoch 46 finished 	ANN training loss nan
>> Epoch 47 finished 	ANN training loss nan
>> Epoch 48 finished 	ANN training loss nan
>> Epoch 49 finished 	ANN training loss nan
>> Epoch 50 finished 	ANN training loss nan
>> Epoch 51 finished 	ANN training loss nan
>> Epoch 52 finished 	ANN training loss nan
>> Epoch 53 finished 	ANN training loss nan
>> Epoch 54 finished 	ANN training loss nan
>> Epoch 55 finished 	ANN training loss nan
>> Epoch 56 finished 	ANN training loss nan
>> Epoch 57 finished 	ANN training loss nan
>> Epoch 58 finished 	ANN training loss nan
>> Epoch 59 finished 	ANN training loss nan
>> Epoch 60 finished 	ANN training loss nan
>> Epoch 61 finished 	ANN training loss nan
>> Epoch 62 finished 	ANN training loss nan
>> Epoch 63 finished 	ANN training loss nan
>> Epoch 64 finished 	ANN training loss nan
>> Epoch 65 finished 	ANN training loss nan
>> Epoch 66 finished 	ANN training loss nan
>> Epoch 67 finished 	ANN training loss nan
>> Epoch 68 finished 	ANN training loss nan
>> Epoch 69 finished 	ANN training loss nan
>> Epoch 70 finished 	ANN training loss nan
>> Epoch 71 finished 	ANN training loss nan
>> Epoch 72 finished 	ANN training loss nan
>> Epoch 73 finished 	ANN training loss nan
>> Epoch 74 finished 	ANN training loss nan
>> Epoch 75 finished 	ANN training loss nan
>> Epoch 76 finished 	ANN training loss nan
>> Epoch 77 finished 	ANN training loss nan
>> Epoch 78 finished 	ANN training loss nan
>> Epoch 79 finished 	ANN training loss nan
>> Epoch 80 finished 	ANN training loss nan
>> Epoch 81 finished 	ANN training loss nan
>> Epoch 82 finished 	ANN training loss nan
>> Epoch 83 finished 	ANN training loss nan
>> Epoch 84 finished 	ANN training loss nan
>> Epoch 85 finished 	ANN training loss nan
>> Epoch 86 finished 	ANN training loss nan
>> Epoch 87 finished 	ANN training loss nan
>> Epoch 88 finished 	ANN training loss nan
>> Epoch 89 finished 	ANN training loss nan
>> Epoch 90 finished 	ANN training loss nan
>> Epoch 91 finished 	ANN training loss nan
>> Epoch 92 finished 	ANN training loss nan
>> Epoch 93 finished 	ANN training loss nan
>> Epoch 94 finished 	ANN training loss nan
>> Epoch 95 finished 	ANN training loss nan
>> Epoch 96 finished 	ANN training loss nan
>> Epoch 97 finished 	ANN training loss nan
>> Epoch 98 finished 	ANN training loss nan
>> Epoch 99 finished 	ANN training loss nan
[END] Fine tuning step
Traceback (most recent call last):
  File "main_run.py", line 144, in <module>
    main()
  File "main_run.py", line 140, in main
    layers=LAYERS)
  File "/home/asif/Downloads/hakathon/mdbn_tcga_brca_tensorflow/Tensorflow/DBN_regression.py", line 77, in test_DBN
    print('Done.\nR-squared: %f\nMSE: %f' % (r2_score(Y_test, Y_pred), mean_squared_error(Y_test, Y_pred)))
  File "/usr/local/lib/python2.7/dist-packages/sklearn/metrics/regression.py", line 530, in r2_score
    y_true, y_pred, multioutput)
  File "/usr/local/lib/python2.7/dist-packages/sklearn/metrics/regression.py", line 77, in _check_reg_targets
    y_pred = check_array(y_pred, ensure_2d=False)
  File "/usr/local/lib/python2.7/dist-packages/sklearn/utils/validation.py", line 453, in check_array
    _assert_all_finite(array)
  File "/usr/local/lib/python2.7/dist-packages/sklearn/utils/validation.py", line 44, in _assert_all_finite
    " or a value too large for %r." % X.dtype)
ValueError: Input contains NaN, infinity or a value too large for dtype('float32').
asif@ubuntu:~/Downloads/hakathon/mdbn_tcga_brca_tensorflow$ git clone https://brian_ie@bitbucket.org/galihgilang/mdbn_tcga_brca_tensorflow.git
Cloning into 'mdbn_tcga_brca_tensorflow'...
Password for 'https://brian_ie@bitbucket.org': 
remote: Counting objects: 48, done.
remote: Compressing objects: 100% (48/48), done.
remote: Total 48 (delta 16), reused 0 (delta 0)
Unpacking objects: 100% (48/48), done.
Checking connectivity... done.
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
Insert here [default = 3]: 
You will use miRNA Expression data to create the prediction


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
2017-11-25 05:12:02.821573: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use SSE4.1 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 05:12:02.821651: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use SSE4.2 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 05:12:02.821682: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use AVX instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 05:12:02.821711: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use AVX2 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 05:12:02.821740: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use FMA instructions, but these are available on your machine and could speed up CPU computations.

Cancer Type Classification with miRNA Expression (Tensorflow)

Traceback (most recent call last):
  File "main_run.py", line 146, in <module>
    main()
  File "main_run.py", line 132, in main
    layers=LAYERS)
  File "/home/asif/Downloads/hakathon/mdbn_tcga_brca_tensorflow/Tensorflow/DBN_classification.py", line 61, in test_DBN
    datasets = load_data(dataset)
  File "/home/asif/Downloads/hakathon/mdbn_tcga_brca_tensorflow/Tensorflow/DBN_classification.py", line 37, in load_data
    input_set = np.genfromtxt(temp_input[i], dtype=str, delimiter=',')
  File "/usr/lib/python2.7/dist-packages/numpy/lib/npyio.py", line 1451, in genfromtxt
    fhd = iter(np.lib._datasource.open(fname, 'rbU'))
  File "/usr/lib/python2.7/dist-packages/numpy/lib/_datasource.py", line 151, in open
    return ds.open(path, mode)
  File "/usr/lib/python2.7/dist-packages/numpy/lib/_datasource.py", line 501, in open
    raise IOError("%s not found." % path)
IOError: /home/asif/Downloads/hakathon/Preprocessed_Data_Short_version/input_csv/type/miRNA_Expression/input_mir_type_er.csv not found.
asif@ubuntu:~/Downloads/hakathon/mdbn_tcga_brca_tensorflow$ python main_run.py
Welcome to mDBN breast cancer status prediction!
All training data by TCGA BRCA



What prediction do you want to make?
[1] Breast cancer type classification
[2] Survival rate regression
Insert here [default = 1]: 
You will classify the type of the breast cancer


What type of features do you want to use?
[1] DNA Methylation
[2] Gene Expression
[3] miRNA Expression
Insert here [default = 3]: 
You will use miRNA Expression data to create the prediction


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
2017-11-25 05:13:08.626019: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use SSE4.1 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 05:13:08.626135: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use SSE4.2 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 05:13:08.626168: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use AVX instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 05:13:08.626198: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use AVX2 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 05:13:08.626226: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use FMA instructions, but these are available on your machine and could speed up CPU computations.

Cancer Type Classification with miRNA Expression (Tensorflow)

Traceback (most recent call last):
  File "main_run.py", line 146, in <module>
    main()
  File "main_run.py", line 132, in main
    layers=LAYERS)
  File "/home/asif/Downloads/hakathon/mdbn_tcga_brca_tensorflow/Tensorflow/DBN_classification.py", line 61, in test_DBN
    datasets = load_data(dataset)
  File "/home/asif/Downloads/hakathon/mdbn_tcga_brca_tensorflow/Tensorflow/DBN_classification.py", line 37, in load_data
    input_set = np.genfromtxt(temp_input[i], dtype=str, delimiter=',')
  File "/usr/lib/python2.7/dist-packages/numpy/lib/npyio.py", line 1451, in genfromtxt
    fhd = iter(np.lib._datasource.open(fname, 'rbU'))
  File "/usr/lib/python2.7/dist-packages/numpy/lib/_datasource.py", line 151, in open
    return ds.open(path, mode)
  File "/usr/lib/python2.7/dist-packages/numpy/lib/_datasource.py", line 501, in open
    raise IOError("%s not found." % path)
IOError: /home/asif/Downloads/hakathon/Preprocessed_Data_Short_version/input_csv/type/miRNA_Expression/input_mir_type_er.csv not found.
asif@ubuntu:~/Downloads/hakathon/mdbn_tcga_brca_tensorflow$ 
asif@ubuntu:~/Downloads/hakathon/mdbn_tcga_brca_tensorflow$ python main_run.py
Welcome to mDBN breast cancer status prediction!
All training data by TCGA BRCA



What prediction do you want to make?
[1] Breast cancer type classification
[2] Survival rate regression
Insert here [default = 1]: 
You will classify the type of the breast cancer


What type of features do you want to use?
[1] DNA Methylation
[2] Gene Expression
[3] miRNA Expression
Insert here [default = 3]: 
You will use miRNA Expression data to create the prediction


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
2017-11-25 05:14:04.671859: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use SSE4.1 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 05:14:04.671957: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use SSE4.2 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 05:14:04.671989: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use AVX instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 05:14:04.672019: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use AVX2 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 05:14:04.672048: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use FMA instructions, but these are available on your machine and could speed up CPU computations.

Cancer Type Classification with miRNA Expression (Tensorflow)

Traceback (most recent call last):
  File "main_run.py", line 146, in <module>
    main()
  File "main_run.py", line 132, in main
    layers=LAYERS)
  File "/home/asif/Downloads/hakathon/mdbn_tcga_brca_tensorflow/Tensorflow/DBN_classification.py", line 61, in test_DBN
    datasets = load_data(dataset)
  File "/home/asif/Downloads/hakathon/mdbn_tcga_brca_tensorflow/Tensorflow/DBN_classification.py", line 37, in load_data
    input_set = np.genfromtxt(temp_input[i], dtype=str, delimiter=',')
  File "/usr/lib/python2.7/dist-packages/numpy/lib/npyio.py", line 1451, in genfromtxt
    fhd = iter(np.lib._datasource.open(fname, 'rbU'))
  File "/usr/lib/python2.7/dist-packages/numpy/lib/_datasource.py", line 151, in open
    return ds.open(path, mode)
  File "/usr/lib/python2.7/dist-packages/numpy/lib/_datasource.py", line 501, in open
    raise IOError("%s not found." % path)
IOError: /home/asif/Downloads/hakathon/Preprocessed_Data_Short_version/input_csv/type/miRNA_Expression/input_mir_type_er.csv not found.
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
/usr/local/lib/python2.7/dist-packages/sklearn/cross_validation.py:41: DeprecationWarning: This module was deprecated in version 0.18 in favor of the model_selection module into which all the refactored classes and functions are moved. Also note that the interface of the new CV iterators are different from that of this module. This module will be removed in 0.20.
  "This module will be removed in 0.20.", DeprecationWarning)
2017-11-25 05:36:55.816230: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use SSE4.1 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 05:36:55.816326: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use SSE4.2 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 05:36:55.816359: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use AVX instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 05:36:55.816390: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use AVX2 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 05:36:55.816420: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use FMA instructions, but these are available on your machine and could speed up CPU computations.

Survival Rate Regression with miRNA Expression (Tensorflow)

/usr/local/lib/python2.7/dist-packages/sklearn/utils/validation.py:475: DataConversionWarning: Data with input dtype |S9 was converted to float64 by MinMaxScaler.
  warnings.warn(msg, DataConversionWarning)
[START] Pre-training step:
>> Epoch 1 finished 	RBM Reconstruction error 11.906680
>> Epoch 2 finished 	RBM Reconstruction error 11.256721
>> Epoch 3 finished 	RBM Reconstruction error 11.128585
>> Epoch 4 finished 	RBM Reconstruction error 11.006778
>> Epoch 5 finished 	RBM Reconstruction error 10.930740
>> Epoch 6 finished 	RBM Reconstruction error 10.885211
>> Epoch 7 finished 	RBM Reconstruction error 10.857136
>> Epoch 8 finished 	RBM Reconstruction error 10.852243
>> Epoch 9 finished 	RBM Reconstruction error 10.811701
>> Epoch 10 finished 	RBM Reconstruction error 10.768891
>> Epoch 1 finished 	RBM Reconstruction error 0.575726
>> Epoch 2 finished 	RBM Reconstruction error 0.227707
>> Epoch 3 finished 	RBM Reconstruction error 0.122561
>> Epoch 4 finished 	RBM Reconstruction error 0.086293
>> Epoch 5 finished 	RBM Reconstruction error 0.078426
>> Epoch 6 finished 	RBM Reconstruction error 0.101393
>> Epoch 7 finished 	RBM Reconstruction error 0.074452
>> Epoch 8 finished 	RBM Reconstruction error 0.085510
>> Epoch 9 finished 	RBM Reconstruction error 0.076165
>> Epoch 10 finished 	RBM Reconstruction error 0.096517
>> Epoch 1 finished 	RBM Reconstruction error 0.656585
>> Epoch 2 finished 	RBM Reconstruction error 0.112761
>> Epoch 3 finished 	RBM Reconstruction error 0.036473
>> Epoch 4 finished 	RBM Reconstruction error 0.024593
>> Epoch 5 finished 	RBM Reconstruction error 0.031734
>> Epoch 6 finished 	RBM Reconstruction error 0.049166
>> Epoch 7 finished 	RBM Reconstruction error 0.044483
>> Epoch 8 finished 	RBM Reconstruction error 0.024642
>> Epoch 9 finished 	RBM Reconstruction error 0.065513
>> Epoch 10 finished 	RBM Reconstruction error 0.024890
[END] Pre-training step
[START] Fine tuning step:
>> Epoch 0 finished 	ANN training loss 0.018815
>> Epoch 1 finished 	ANN training loss 0.019657
>> Epoch 2 finished 	ANN training loss 0.018776
>> Epoch 3 finished 	ANN training loss 0.019712
>> Epoch 4 finished 	ANN training loss 0.018800
>> Epoch 5 finished 	ANN training loss 0.023371
>> Epoch 6 finished 	ANN training loss 0.019427
>> Epoch 7 finished 	ANN training loss 0.018827
>> Epoch 8 finished 	ANN training loss 0.018621
>> Epoch 9 finished 	ANN training loss 0.018822
[END] Fine tuning step
Traceback (most recent call last):
  File "main_run.py", line 146, in <module>
    main()
  File "main_run.py", line 142, in main
    layers=LAYERS)
  File "/home/asif/Downloads/hakathon/mdbn_tcga_brca_tensorflow/Tensorflow/DBN_regression.py", line 77, in test_DBN
    print('Done.\nR-squared: %f\nMSE: %f' % (r2_score(Y_test, Y_pred), mean_squared_error(Y_test, Y_pred)))
  File "/usr/local/lib/python2.7/dist-packages/sklearn/metrics/regression.py", line 538, in r2_score
    numerator = (weight * (y_true - y_pred) ** 2).sum(axis=0,
TypeError: ufunc 'subtract' did not contain a loop with signature matching types dtype('S32') dtype('S32') dtype('S32')
asif@ubuntu:~/Downloads/hakathon/mdbn_tcga_brca_tensorflow$ python main_run.py
Welcome to mDBN breast cancer status prediction!
All training data by TCGA BRCA



What prediction do you want to make?
[1] Breast cancer type classification
[2] Survival rate regression
Insert here [default = 1]: 
You will classify the type of the breast cancer


What type of features do you want to use?
[1] DNA Methylation
[2] Gene Expression
[3] miRNA Expression
Insert here [default = 3]: 2
You will use Gene Expression data to create the prediction


Neural Network Layers
Number of hidden layers [default = 3]: 
Layer 0 size [default = 1000]: 10
Layer 1 size [default = 1000]: 10
Layer 2 size [default = 1000]: 10


Neural Network Parameters
Pre-training iteration [default = 100]: 10
Training iteration [default = 100]: 10
Batch size [default = 10]: 10
Pre-training learning rate [default = 0.01]: 
Training learning rate [default = 0.1]: 
2017-11-25 06:08:47.567636: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use SSE4.1 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 06:08:47.567766: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use SSE4.2 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 06:08:47.567821: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use AVX instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 06:08:47.567876: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use AVX2 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 06:08:47.567907: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use FMA instructions, but these are available on your machine and could speed up CPU computations.

Cancer Type Classification with Gene Expression (Tensorflow)

/usr/local/lib/python2.7/dist-packages/sklearn/utils/validation.py:475: DataConversionWarning: Data with input dtype |S9 was converted to float64 by MinMaxScaler.
  warnings.warn(msg, DataConversionWarning)

ER Status Prediction Training Process

[START] Pre-training step:
>> Epoch 1 finished 	RBM Reconstruction error 1408.141115
>> Epoch 2 finished 	RBM Reconstruction error 1604.461294
>> Epoch 3 finished 	RBM Reconstruction error 1471.694151
>> Epoch 4 finished 	RBM Reconstruction error 1458.559540
>> Epoch 5 finished 	RBM Reconstruction error 1589.674793
>> Epoch 6 finished 	RBM Reconstruction error 1546.613200
>> Epoch 7 finished 	RBM Reconstruction error 1389.715980
>> Epoch 8 finished 	RBM Reconstruction error 1403.061456
>> Epoch 9 finished 	RBM Reconstruction error 1345.558181
>> Epoch 10 finished 	RBM Reconstruction error 1507.714372
>> Epoch 1 finished 	RBM Reconstruction error 483523.937500
>> Epoch 2 finished 	RBM Reconstruction error 459986.843750
>> Epoch 3 finished 	RBM Reconstruction error 567019.625000
>> Epoch 4 finished 	RBM Reconstruction error 472891.156250
>> Epoch 5 finished 	RBM Reconstruction error 510116.937500
>> Epoch 6 finished 	RBM Reconstruction error 512056.812500
>> Epoch 7 finished 	RBM Reconstruction error 480685.031250
>> Epoch 8 finished 	RBM Reconstruction error 513701.718750
>> Epoch 9 finished 	RBM Reconstruction error 481029.312500
>> Epoch 10 finished 	RBM Reconstruction error 531820.187500
>> Epoch 1 finished 	RBM Reconstruction error 28904065024.000000
>> Epoch 2 finished 	RBM Reconstruction error 29186940928.000000
>> Epoch 3 finished 	RBM Reconstruction error 28450461696.000000
>> Epoch 4 finished 	RBM Reconstruction error 28850300928.000000
>> Epoch 5 finished 	RBM Reconstruction error 27815260160.000000
>> Epoch 6 finished 	RBM Reconstruction error 29671172096.000000
>> Epoch 7 finished 	RBM Reconstruction error 26997010432.000000
>> Epoch 8 finished 	RBM Reconstruction error 29136707584.000000
>> Epoch 9 finished 	RBM Reconstruction error 28973635584.000000
>> Epoch 10 finished 	RBM Reconstruction error 28999098368.000000
[END] Pre-training step
[START] Fine tuning step:
>> Epoch 0 finished 	ANN training loss 0.614042
>> Epoch 1 finished 	ANN training loss 0.580177
>> Epoch 2 finished 	ANN training loss 0.567696
>> Epoch 3 finished 	ANN training loss 0.560976
>> Epoch 4 finished 	ANN training loss 0.557720
>> Epoch 5 finished 	ANN training loss 0.555907
>> Epoch 6 finished 	ANN training loss 0.556082
>> Epoch 7 finished 	ANN training loss 0.553274
>> Epoch 8 finished 	ANN training loss 0.556931
>> Epoch 9 finished 	ANN training loss 0.552000
[END] Fine tuning step
Accuracy: 0.765625
/usr/local/lib/python2.7/dist-packages/sklearn/metrics/classification.py:1135: UndefinedMetricWarning: Precision and F-score are ill-defined and being set to 0.0 in labels with no predicted samples.
  'precision', 'predicted', average, warn_for)
('Precision:', 0.586181640625)
('Recall:', 0.765625)
('F1-score:', 0.66399336283185839)

PGR Status Prediction Training Process

[START] Pre-training step:
>> Epoch 1 finished 	RBM Reconstruction error 804.080158
>> Epoch 2 finished 	RBM Reconstruction error 1071.950601
>> Epoch 3 finished 	RBM Reconstruction error 1091.443920
>> Epoch 4 finished 	RBM Reconstruction error 992.722989
>> Epoch 5 finished 	RBM Reconstruction error 1023.488361
>> Epoch 6 finished 	RBM Reconstruction error 1077.058488
>> Epoch 7 finished 	RBM Reconstruction error 1046.205347
>> Epoch 8 finished 	RBM Reconstruction error 985.199433
>> Epoch 9 finished 	RBM Reconstruction error 949.899445
>> Epoch 10 finished 	RBM Reconstruction error 962.004532
>> Epoch 1 finished 	RBM Reconstruction error 328994.437500
>> Epoch 2 finished 	RBM Reconstruction error 368754.062500
>> Epoch 3 finished 	RBM Reconstruction error 345117.031250
>> Epoch 4 finished 	RBM Reconstruction error 314747.937500
>> Epoch 5 finished 	RBM Reconstruction error 368180.375000
>> Epoch 6 finished 	RBM Reconstruction error 343070.625000
>> Epoch 7 finished 	RBM Reconstruction error 360746.843750
>> Epoch 8 finished 	RBM Reconstruction error 364576.968750
>> Epoch 9 finished 	RBM Reconstruction error 367121.562500
>> Epoch 10 finished 	RBM Reconstruction error 378583.562500
>> Epoch 1 finished 	RBM Reconstruction error 10147593216.000000
>> Epoch 2 finished 	RBM Reconstruction error 10408981504.000000
>> Epoch 3 finished 	RBM Reconstruction error 10737626112.000000
>> Epoch 4 finished 	RBM Reconstruction error 10205803520.000000
>> Epoch 5 finished 	RBM Reconstruction error 10092453888.000000
>> Epoch 6 finished 	RBM Reconstruction error 9979645952.000000
>> Epoch 7 finished 	RBM Reconstruction error 10567272448.000000
>> Epoch 8 finished 	RBM Reconstruction error 10628126720.000000
>> Epoch 9 finished 	RBM Reconstruction error 9677258752.000000
>> Epoch 10 finished 	RBM Reconstruction error 10688846848.000000
[END] Pre-training step
[START] Fine tuning step:
>> Epoch 0 finished 	ANN training loss 0.718230
>> Epoch 1 finished 	ANN training loss 0.682040
>> Epoch 2 finished 	ANN training loss 0.669531
>> Epoch 3 finished 	ANN training loss 0.661920
>> Epoch 4 finished 	ANN training loss 0.658299
>> Epoch 5 finished 	ANN training loss 0.656989
>> Epoch 6 finished 	ANN training loss 0.654170
>> Epoch 7 finished 	ANN training loss 0.653366
>> Epoch 8 finished 	ANN training loss 0.652520
>> Epoch 9 finished 	ANN training loss 0.656378
[END] Fine tuning step
Accuracy: 0.667969
('Precision:', 0.4461822509765625)
('Recall:', 0.66796875)
('F1-score:', 0.53500073185011709)

HER2 Status Prediction Training Process

[START] Pre-training step:
>> Epoch 1 finished 	RBM Reconstruction error 1054.487387
>> Epoch 2 finished 	RBM Reconstruction error 1275.551521
>> Epoch 3 finished 	RBM Reconstruction error 1240.391861
>> Epoch 4 finished 	RBM Reconstruction error 1405.459118
>> Epoch 5 finished 	RBM Reconstruction error 1059.917912
>> Epoch 6 finished 	RBM Reconstruction error 1094.340048
>> Epoch 7 finished 	RBM Reconstruction error 1345.075809
>> Epoch 8 finished 	RBM Reconstruction error 1430.935123
>> Epoch 9 finished 	RBM Reconstruction error 1035.108793
>> Epoch 10 finished 	RBM Reconstruction error 1165.806520
>> Epoch 1 finished 	RBM Reconstruction error 527903.000000
>> Epoch 2 finished 	RBM Reconstruction error 697931.375000
>> Epoch 3 finished 	RBM Reconstruction error 731005.687500
>> Epoch 4 finished 	RBM Reconstruction error 688528.937500
>> Epoch 5 finished 	RBM Reconstruction error 737848.500000
>> Epoch 6 finished 	RBM Reconstruction error 701385.750000
>> Epoch 7 finished 	RBM Reconstruction error 736501.062500
>> Epoch 8 finished 	RBM Reconstruction error 701753.250000
>> Epoch 9 finished 	RBM Reconstruction error 732877.625000
>> Epoch 10 finished 	RBM Reconstruction error 706432.375000
>> Epoch 1 finished 	RBM Reconstruction error 31466160128.000000
>> Epoch 2 finished 	RBM Reconstruction error 29864087552.000000
>> Epoch 3 finished 	RBM Reconstruction error 30407936000.000000
>> Epoch 4 finished 	RBM Reconstruction error 31451938816.000000
>> Epoch 5 finished 	RBM Reconstruction error 34233397248.000000
>> Epoch 6 finished 	RBM Reconstruction error 31912714240.000000
>> Epoch 7 finished 	RBM Reconstruction error 29667106816.000000
>> Epoch 8 finished 	RBM Reconstruction error 30937698304.000000
>> Epoch 9 finished 	RBM Reconstruction error 33691912192.000000
>> Epoch 10 finished 	RBM Reconstruction error 30997194752.000000
[END] Pre-training step
[START] Fine tuning step:
>> Epoch 0 finished 	ANN training loss 1.019606
>> Epoch 1 finished 	ANN training loss 0.993586
>> Epoch 2 finished 	ANN training loss 0.987214
>> Epoch 3 finished 	ANN training loss 0.979093
>> Epoch 4 finished 	ANN training loss 0.979533
>> Epoch 5 finished 	ANN training loss 0.976294
>> Epoch 6 finished 	ANN training loss 0.974545
>> Epoch 7 finished 	ANN training loss 0.973542
>> Epoch 8 finished 	ANN training loss 0.973189
>> Epoch 9 finished 	ANN training loss 0.974098
[END] Fine tuning step
Accuracy: 0.580357
('Precision:', 0.3368144132653062)
('Recall:', 0.5803571428571429)
('F1-score:', 0.42625100887812761)
asif@ubuntu:~/Downloads/hakathon/mdbn_tcga_brca_tensorflow$ 
asif@ubuntu:~/Downloads/hakathon/mdbn_tcga_brca_tensorflow$ 
asif@ubuntu:~/Downloads/hakathon/mdbn_tcga_brca_tensorflow$ python main_run.py
Welcome to mDBN breast cancer status prediction!
All training data by TCGA BRCA



What prediction do you want to make?
[1] Breast cancer type classification
[2] Survival rate regression
Insert here [default = 1]: 
You will classify the type of the breast cancer


What type of features do you want to use?
[1] DNA Methylation
[2] Gene Expression
[3] miRNA Expression
Insert here [default = 3]: 1
You will use DNA Methylation data to create the prediction


Neural Network Layers
Number of hidden layers [default = 3]: 
Layer 0 size [default = 1000]: 10
Layer 1 size [default = 1000]: 10
Layer 2 size [default = 1000]: 10


Neural Network Parameters
Pre-training iteration [default = 100]: 10
Training iteration [default = 100]: 10
Batch size [default = 10]: 10
Pre-training learning rate [default = 0.01]: 
Training learning rate [default = 0.1]: 
2017-11-25 07:21:23.095288: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use SSE4.1 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 07:21:23.095404: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use SSE4.2 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 07:21:23.095442: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use AVX instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 07:21:23.095474: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use AVX2 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 07:21:23.095508: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use FMA instructions, but these are available on your machine and could speed up CPU computations.

Cancer Type Classification with DNA Methylation (Tensorflow)

/usr/local/lib/python2.7/dist-packages/sklearn/utils/validation.py:475: DataConversionWarning: Data with input dtype |S21 was converted to float64 by MinMaxScaler.
  warnings.warn(msg, DataConversionWarning)

ER Status Prediction Training Process

[START] Pre-training step:
>> Epoch 1 finished 	RBM Reconstruction error 389233.977307
>> Epoch 2 finished 	RBM Reconstruction error 391247.410533
>> Epoch 3 finished 	RBM Reconstruction error 401253.380918
>> Epoch 4 finished 	RBM Reconstruction error 399541.028924
>> Epoch 5 finished 	RBM Reconstruction error 401736.533878
>> Epoch 6 finished 	RBM Reconstruction error 384624.787575
>> Epoch 7 finished 	RBM Reconstruction error 394524.774481
>> Epoch 8 finished 	RBM Reconstruction error 402006.036562
>> Epoch 9 finished 	RBM Reconstruction error 393956.928180
>> Epoch 10 finished 	RBM Reconstruction error 379087.479408
>> Epoch 1 finished 	RBM Reconstruction error 21047951360.000000
>> Epoch 2 finished 	RBM Reconstruction error 21026770944.000000
>> Epoch 3 finished 	RBM Reconstruction error 20733689856.000000
>> Epoch 4 finished 	RBM Reconstruction error 21280278528.000000
>> Epoch 5 finished 	RBM Reconstruction error 20312854528.000000
>> Epoch 6 finished 	RBM Reconstruction error 20836249600.000000
>> Epoch 7 finished 	RBM Reconstruction error 20204285952.000000
>> Epoch 8 finished 	RBM Reconstruction error 20508121088.000000
>> Epoch 9 finished 	RBM Reconstruction error 20911566848.000000
>> Epoch 10 finished 	RBM Reconstruction error 20519794688.000000
>> Epoch 1 finished 	RBM Reconstruction error 99346162021467947008.000000
>> Epoch 2 finished 	RBM Reconstruction error 119003996162940207104.000000
>> Epoch 3 finished 	RBM Reconstruction error 120432675183793274880.000000
>> Epoch 4 finished 	RBM Reconstruction error 121435623302371475456.000000
>> Epoch 5 finished 	RBM Reconstruction error 120870263219462078464.000000
>> Epoch 6 finished 	RBM Reconstruction error 120054795027559219200.000000
>> Epoch 7 finished 	RBM Reconstruction error 120588198904518934528.000000
>> Epoch 8 finished 	RBM Reconstruction error 120244394812652912640.000000
>> Epoch 9 finished 	RBM Reconstruction error 119107156741904662528.000000
>> Epoch 10 finished 	RBM Reconstruction error 120850172942999355392.000000
[END] Pre-training step
[START] Fine tuning step:
>> Epoch 0 finished 	ANN training loss 0.686660
>> Epoch 1 finished 	ANN training loss 0.580194
>> Epoch 2 finished 	ANN training loss 0.568553
>> Epoch 3 finished 	ANN training loss 0.570955
>> Epoch 4 finished 	ANN training loss 0.569551
>> Epoch 5 finished 	ANN training loss 0.563737
>> Epoch 6 finished 	ANN training loss 0.560529
>> Epoch 7 finished 	ANN training loss 0.557391
>> Epoch 8 finished 	ANN training loss 0.557403
>> Epoch 9 finished 	ANN training loss 0.554515
[END] Fine tuning step
Accuracy: 0.765625
/usr/local/lib/python2.7/dist-packages/sklearn/metrics/classification.py:1135: UndefinedMetricWarning: Precision and F-score are ill-defined and being set to 0.0 in labels with no predicted samples.
  'precision', 'predicted', average, warn_for)
('Precision:', 0.586181640625)
('Recall:', 0.765625)
('F1-score:', 0.66399336283185839)

PGR Status Prediction Training Process

[START] Pre-training step:
>> Epoch 1 finished 	RBM Reconstruction error 513110.959564
>> Epoch 2 finished 	RBM Reconstruction error 532144.345490
>> Epoch 3 finished 	RBM Reconstruction error 514480.821482
>> Epoch 4 finished 	RBM Reconstruction error 519213.264003
>> Epoch 5 finished 	RBM Reconstruction error 531737.576604
>> Epoch 6 finished 	RBM Reconstruction error 521055.219946
>> Epoch 7 finished 	RBM Reconstruction error 514391.110842
>> Epoch 8 finished 	RBM Reconstruction error 533529.728360
>> Epoch 9 finished 	RBM Reconstruction error 538042.036766
>> Epoch 10 finished 	RBM Reconstruction error 527762.485304
>> Epoch 1 finished 	RBM Reconstruction error 41259495424.000000
>> Epoch 2 finished 	RBM Reconstruction error 42415448064.000000
>> Epoch 3 finished 	RBM Reconstruction error 43299778560.000000
>> Epoch 4 finished 	RBM Reconstruction error 42808324096.000000
>> Epoch 5 finished 	RBM Reconstruction error 43186753536.000000
>> Epoch 6 finished 	RBM Reconstruction error 42477502464.000000
>> Epoch 7 finished 	RBM Reconstruction error 42865262592.000000
>> Epoch 8 finished 	RBM Reconstruction error 42901102592.000000
>> Epoch 9 finished 	RBM Reconstruction error 43231019008.000000
>> Epoch 10 finished 	RBM Reconstruction error 43680497664.000000
>> Epoch 1 finished 	RBM Reconstruction error 311106867855777333248.000000
>> Epoch 2 finished 	RBM Reconstruction error 334011612610630254592.000000
>> Epoch 3 finished 	RBM Reconstruction error 340389976320382074880.000000
>> Epoch 4 finished 	RBM Reconstruction error 335173963526956908544.000000
>> Epoch 5 finished 	RBM Reconstruction error 347927172509251665920.000000
>> Epoch 6 finished 	RBM Reconstruction error 344478118882127642624.000000
>> Epoch 7 finished 	RBM Reconstruction error 345368670524068069376.000000
>> Epoch 8 finished 	RBM Reconstruction error 341563938079498043392.000000
>> Epoch 9 finished 	RBM Reconstruction error 343269113488411197440.000000
>> Epoch 10 finished 	RBM Reconstruction error 346453439899938848768.000000
[END] Pre-training step
[START] Fine tuning step:
>> Epoch 0 finished 	ANN training loss 0.698405
>> Epoch 1 finished 	ANN training loss 0.673935
>> Epoch 2 finished 	ANN training loss 0.668290
>> Epoch 3 finished 	ANN training loss 0.660895
>> Epoch 4 finished 	ANN training loss 0.657431
>> Epoch 5 finished 	ANN training loss 0.654546
>> Epoch 6 finished 	ANN training loss 0.652501
>> Epoch 7 finished 	ANN training loss 0.655290
>> Epoch 8 finished 	ANN training loss 0.651923
>> Epoch 9 finished 	ANN training loss 0.657978
[END] Fine tuning step
Accuracy: 0.667969
('Precision:', 0.4461822509765625)
('Recall:', 0.66796875)
('F1-score:', 0.53500073185011709)

HER2 Status Prediction Training Process

[START] Pre-training step:
>> Epoch 1 finished 	RBM Reconstruction error 335705.284218
>> Epoch 2 finished 	RBM Reconstruction error 347029.198887
>> Epoch 3 finished 	RBM Reconstruction error 341963.343927
>> Epoch 4 finished 	RBM Reconstruction error 340514.804433
>> Epoch 5 finished 	RBM Reconstruction error 350109.695969
>> Epoch 6 finished 	RBM Reconstruction error 346848.112952
>> Epoch 7 finished 	RBM Reconstruction error 330293.726133
>> Epoch 8 finished 	RBM Reconstruction error 321905.643064
>> Epoch 9 finished 	RBM Reconstruction error 328027.135271
>> Epoch 10 finished 	RBM Reconstruction error 334561.403911
>> Epoch 1 finished 	RBM Reconstruction error 12987568128.000000
>> Epoch 2 finished 	RBM Reconstruction error 12998587392.000000
>> Epoch 3 finished 	RBM Reconstruction error 13233766400.000000
>> Epoch 4 finished 	RBM Reconstruction error 14057575424.000000
>> Epoch 5 finished 	RBM Reconstruction error 13560600576.000000
>> Epoch 6 finished 	RBM Reconstruction error 13336983552.000000
>> Epoch 7 finished 	RBM Reconstruction error 13570543616.000000
>> Epoch 8 finished 	RBM Reconstruction error 13793646592.000000
>> Epoch 9 finished 	RBM Reconstruction error 13300872192.000000
>> Epoch 10 finished 	RBM Reconstruction error 13474008064.000000
>> Epoch 1 finished 	RBM Reconstruction error 30383756987403862016.000000
>> Epoch 2 finished 	RBM Reconstruction error 32300124390756974592.000000
>> Epoch 3 finished 	RBM Reconstruction error 31711045643013193728.000000
>> Epoch 4 finished 	RBM Reconstruction error 31341757070638579712.000000
>> Epoch 5 finished 	RBM Reconstruction error 31930418003963805696.000000
>> Epoch 6 finished 	RBM Reconstruction error 31793326496166182912.000000
>> Epoch 7 finished 	RBM Reconstruction error 32741628886843916288.000000
>> Epoch 8 finished 	RBM Reconstruction error 32011579554279718912.000000
>> Epoch 9 finished 	RBM Reconstruction error 31558374055449985024.000000
>> Epoch 10 finished 	RBM Reconstruction error 31556647822194376704.000000
[END] Pre-training step
[START] Fine tuning step:
>> Epoch 0 finished 	ANN training loss 1.003642
>> Epoch 1 finished 	ANN training loss 0.980878
>> Epoch 2 finished 	ANN training loss 1.003722
>> Epoch 3 finished 	ANN training loss 0.974669
>> Epoch 4 finished 	ANN training loss 0.984697
>> Epoch 5 finished 	ANN training loss 0.977218
>> Epoch 6 finished 	ANN training loss 0.973636
>> Epoch 7 finished 	ANN training loss 0.972540
>> Epoch 8 finished 	ANN training loss 0.972366
>> Epoch 9 finished 	ANN training loss 0.974729
[END] Fine tuning step
Accuracy: 0.580357
('Precision:', 0.3368144132653062)
('Recall:', 0.5803571428571429)
('F1-score:', 0.42625100887812761)
asif@ubuntu:~/Downloads/hakathon/mdbn_tcga_brca_tensorflow$ 
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
Insert here [default = 3]: 3
You will use miRNA Expression data to create the prediction


Neural Network Layers
Number of hidden layers [default = 3]: 
Layer 0 size [default = 1000]: 10
Layer 1 size [default = 1000]: 10
Layer 2 size [default = 1000]: 10


Neural Network Parameters
Pre-training iteration [default = 100]: 10
Training iteration [default = 100]: 10
Batch size [default = 10]: 
Pre-training learning rate [default = 0.01]: 
Training learning rate [default = 0.1]: 
2017-11-25 14:45:17.949992: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use SSE4.1 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 14:45:17.950085: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use SSE4.2 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 14:45:17.950118: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use AVX instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 14:45:17.950148: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use AVX2 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 14:45:17.950178: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use FMA instructions, but these are available on your machine and could speed up CPU computations.

Cancer Type Classification with miRNA Expression (Tensorflow)

Traceback (most recent call last):
  File "main_run.py", line 146, in <module>
    main()
  File "main_run.py", line 132, in main
    layers=LAYERS)
  File "/home/asif/Downloads/hakathon/mdbn_tcga_brca_tensorflow/Tensorflow/DBN_classification.py", line 61, in test_DBN
    datasets = load_data(dataset)
  File "/home/asif/Downloads/hakathon/mdbn_tcga_brca_tensorflow/Tensorflow/DBN_classification.py", line 37, in load_data
    input_set = np.genfromtxt(temp_input[i], dtype=str, delimiter=',')
  File "/usr/lib/python2.7/dist-packages/numpy/lib/npyio.py", line 1451, in genfromtxt
    fhd = iter(np.lib._datasource.open(fname, 'rbU'))
  File "/usr/lib/python2.7/dist-packages/numpy/lib/_datasource.py", line 151, in open
    return ds.open(path, mode)
  File "/usr/lib/python2.7/dist-packages/numpy/lib/_datasource.py", line 501, in open
    raise IOError("%s not found." % path)
IOError: /home/asif/Downloads/hakathon/Preprocessed_Data_Short_version/input_csv/type/miRNA_Expression/input_mir_type_er.csv not found.
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
Insert here [default = 3]: 3
You will use miRNA Expression data to create the prediction


Neural Network Layers
Number of hidden layers [default = 3]: 
Layer 0 size [default = 1000]: 10
Layer 1 size [default = 1000]: 10
Layer 2 size [default = 1000]: 10


Neural Network Parameters
Pre-training iteration [default = 100]: 10
Training iteration [default = 100]: 10
Batch size [default = 10]: 10
Pre-training learning rate [default = 0.01]: 
Training learning rate [default = 0.1]: 
2017-11-25 14:48:29.159591: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use SSE4.1 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 14:48:29.159857: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use SSE4.2 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 14:48:29.159935: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use AVX instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 14:48:29.159964: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use AVX2 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 14:48:29.160037: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use FMA instructions, but these are available on your machine and could speed up CPU computations.

Cancer Type Classification with miRNA Expression (Tensorflow)

/usr/local/lib/python2.7/dist-packages/sklearn/utils/validation.py:475: DataConversionWarning: Data with input dtype |S9 was converted to float64 by MinMaxScaler.
  warnings.warn(msg, DataConversionWarning)

ER Status Prediction Training Process

[START] Pre-training step:
>> Epoch 1 finished 	RBM Reconstruction error 12.505088
>> Epoch 2 finished 	RBM Reconstruction error 10.857123
>> Epoch 3 finished 	RBM Reconstruction error 10.615407
>> Epoch 4 finished 	RBM Reconstruction error 10.448228
>> Epoch 5 finished 	RBM Reconstruction error 10.332605
>> Epoch 6 finished 	RBM Reconstruction error 10.224711
>> Epoch 7 finished 	RBM Reconstruction error 10.161565
>> Epoch 8 finished 	RBM Reconstruction error 10.126219
>> Epoch 9 finished 	RBM Reconstruction error 10.111613
>> Epoch 10 finished 	RBM Reconstruction error 10.094984
>> Epoch 1 finished 	RBM Reconstruction error 0.993175
>> Epoch 2 finished 	RBM Reconstruction error 0.274249
>> Epoch 3 finished 	RBM Reconstruction error 0.113236
>> Epoch 4 finished 	RBM Reconstruction error 0.068320
>> Epoch 5 finished 	RBM Reconstruction error 0.064304
>> Epoch 6 finished 	RBM Reconstruction error 0.082507
>> Epoch 7 finished 	RBM Reconstruction error 0.123485
>> Epoch 8 finished 	RBM Reconstruction error 0.128910
>> Epoch 9 finished 	RBM Reconstruction error 0.158653
>> Epoch 10 finished 	RBM Reconstruction error 0.147492
>> Epoch 1 finished 	RBM Reconstruction error 0.970522
>> Epoch 2 finished 	RBM Reconstruction error 0.167892
>> Epoch 3 finished 	RBM Reconstruction error 0.061694
>> Epoch 4 finished 	RBM Reconstruction error 0.080885
>> Epoch 5 finished 	RBM Reconstruction error 0.144053
>> Epoch 6 finished 	RBM Reconstruction error 0.173671
>> Epoch 7 finished 	RBM Reconstruction error 0.188754
>> Epoch 8 finished 	RBM Reconstruction error 0.293429
>> Epoch 9 finished 	RBM Reconstruction error 0.410314
>> Epoch 10 finished 	RBM Reconstruction error 0.348747
[END] Pre-training step
[START] Fine tuning step:
>> Epoch 0 finished 	ANN training loss 0.694052
>> Epoch 1 finished 	ANN training loss 0.578772
>> Epoch 2 finished 	ANN training loss 0.567988
>> Epoch 3 finished 	ANN training loss 0.556466
>> Epoch 4 finished 	ANN training loss 0.552836
>> Epoch 5 finished 	ANN training loss 0.555996
>> Epoch 6 finished 	ANN training loss 0.551944
>> Epoch 7 finished 	ANN training loss 0.556785
>> Epoch 8 finished 	ANN training loss 0.563808
>> Epoch 9 finished 	ANN training loss 0.549317
[END] Fine tuning step
Accuracy: 0.765625
/usr/local/lib/python2.7/dist-packages/sklearn/metrics/classification.py:1135: UndefinedMetricWarning: Precision and F-score are ill-defined and being set to 0.0 in labels with no predicted samples.
  'precision', 'predicted', average, warn_for)
('Precision:', 0.586181640625)
('Recall:', 0.765625)
('F1-score:', 0.66399336283185839)

PGR Status Prediction Training Process

[START] Pre-training step:
>> Epoch 1 finished 	RBM Reconstruction error 11.051185
>> Epoch 2 finished 	RBM Reconstruction error 10.290334
>> Epoch 3 finished 	RBM Reconstruction error 10.183550
>> Epoch 4 finished 	RBM Reconstruction error 10.061962
>> Epoch 5 finished 	RBM Reconstruction error 9.986511
>> Epoch 6 finished 	RBM Reconstruction error 9.940528
>> Epoch 7 finished 	RBM Reconstruction error 9.927230
>> Epoch 8 finished 	RBM Reconstruction error 9.899111
>> Epoch 9 finished 	RBM Reconstruction error 9.883544
>> Epoch 10 finished 	RBM Reconstruction error 9.871977
>> Epoch 1 finished 	RBM Reconstruction error 1.239948
>> Epoch 2 finished 	RBM Reconstruction error 0.419749
>> Epoch 3 finished 	RBM Reconstruction error 0.189524
>> Epoch 4 finished 	RBM Reconstruction error 0.101521
>> Epoch 5 finished 	RBM Reconstruction error 0.063554
>> Epoch 6 finished 	RBM Reconstruction error 0.067911
>> Epoch 7 finished 	RBM Reconstruction error 0.085699
>> Epoch 8 finished 	RBM Reconstruction error 0.091859
>> Epoch 9 finished 	RBM Reconstruction error 0.096124
>> Epoch 10 finished 	RBM Reconstruction error 0.125161
>> Epoch 1 finished 	RBM Reconstruction error 1.194484
>> Epoch 2 finished 	RBM Reconstruction error 0.290070
>> Epoch 3 finished 	RBM Reconstruction error 0.082686
>> Epoch 4 finished 	RBM Reconstruction error 0.045987
>> Epoch 5 finished 	RBM Reconstruction error 0.084325
>> Epoch 6 finished 	RBM Reconstruction error 0.073577
>> Epoch 7 finished 	RBM Reconstruction error 0.107385
>> Epoch 8 finished 	RBM Reconstruction error 0.166341
>> Epoch 9 finished 	RBM Reconstruction error 0.120096
>> Epoch 10 finished 	RBM Reconstruction error 0.133162
[END] Pre-training step
[START] Fine tuning step:
>> Epoch 0 finished 	ANN training loss 0.810413
>> Epoch 1 finished 	ANN training loss 0.693534
>> Epoch 2 finished 	ANN training loss 0.682245
>> Epoch 3 finished 	ANN training loss 0.655789
>> Epoch 4 finished 	ANN training loss 0.652798
>> Epoch 5 finished 	ANN training loss 0.652060
>> Epoch 6 finished 	ANN training loss 0.649872
>> Epoch 7 finished 	ANN training loss 0.649769
>> Epoch 8 finished 	ANN training loss 0.647976
>> Epoch 9 finished 	ANN training loss 0.650720
[END] Fine tuning step
Accuracy: 0.667969
('Precision:', 0.4461822509765625)
('Recall:', 0.66796875)
('F1-score:', 0.53500073185011709)

HER2 Status Prediction Training Process

[START] Pre-training step:
>> Epoch 1 finished 	RBM Reconstruction error 12.979000
>> Epoch 2 finished 	RBM Reconstruction error 11.535069
>> Epoch 3 finished 	RBM Reconstruction error 11.356975
>> Epoch 4 finished 	RBM Reconstruction error 11.304056
>> Epoch 5 finished 	RBM Reconstruction error 11.153631
>> Epoch 6 finished 	RBM Reconstruction error 11.067563
>> Epoch 7 finished 	RBM Reconstruction error 11.019179
>> Epoch 8 finished 	RBM Reconstruction error 10.988831
>> Epoch 9 finished 	RBM Reconstruction error 10.974186
>> Epoch 10 finished 	RBM Reconstruction error 10.960738
>> Epoch 1 finished 	RBM Reconstruction error 1.026911
>> Epoch 2 finished 	RBM Reconstruction error 0.341261
>> Epoch 3 finished 	RBM Reconstruction error 0.174994
>> Epoch 4 finished 	RBM Reconstruction error 0.106758
>> Epoch 5 finished 	RBM Reconstruction error 0.103072
>> Epoch 6 finished 	RBM Reconstruction error 0.104575
>> Epoch 7 finished 	RBM Reconstruction error 0.116055
>> Epoch 8 finished 	RBM Reconstruction error 0.142814
>> Epoch 9 finished 	RBM Reconstruction error 0.144602
>> Epoch 10 finished 	RBM Reconstruction error 0.232371
>> Epoch 1 finished 	RBM Reconstruction error 1.661650
>> Epoch 2 finished 	RBM Reconstruction error 0.447670
>> Epoch 3 finished 	RBM Reconstruction error 0.150439
>> Epoch 4 finished 	RBM Reconstruction error 0.130965
>> Epoch 5 finished 	RBM Reconstruction error 0.271401
>> Epoch 6 finished 	RBM Reconstruction error 0.447131
>> Epoch 7 finished 	RBM Reconstruction error 0.824295
>> Epoch 8 finished 	RBM Reconstruction error 1.078132
>> Epoch 9 finished 	RBM Reconstruction error 1.242212
>> Epoch 10 finished 	RBM Reconstruction error 1.517368
[END] Pre-training step
[START] Fine tuning step:
>> Epoch 0 finished 	ANN training loss 1.033798
>> Epoch 1 finished 	ANN training loss 0.993720
>> Epoch 2 finished 	ANN training loss 0.985826
>> Epoch 3 finished 	ANN training loss 0.977071
>> Epoch 4 finished 	ANN training loss 0.983638
>> Epoch 5 finished 	ANN training loss 0.972610
>> Epoch 6 finished 	ANN training loss 0.969419
>> Epoch 7 finished 	ANN training loss 0.967929
>> Epoch 8 finished 	ANN training loss 0.966688
>> Epoch 9 finished 	ANN training loss 0.968288
[END] Fine tuning step
Accuracy: 0.580357
('Precision:', 0.3368144132653062)
('Recall:', 0.5803571428571429)
('F1-score:', 0.42625100887812761)
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
Insert here [default = 3]: 2
You will use Gene Expression data to create the prediction


Neural Network Layers
Number of hidden layers [default = 3]: 
Layer 0 size [default = 1000]: 10
Layer 1 size [default = 1000]: 10
Layer 2 size [default = 1000]: 10


Neural Network Parameters
Pre-training iteration [default = 100]: 10
Training iteration [default = 100]: 10
Batch size [default = 10]: 10
Pre-training learning rate [default = 0.01]: 
Training learning rate [default = 0.1]: 
/usr/local/lib/python2.7/dist-packages/sklearn/cross_validation.py:41: DeprecationWarning: This module was deprecated in version 0.18 in favor of the model_selection module into which all the refactored classes and functions are moved. Also note that the interface of the new CV iterators are different from that of this module. This module will be removed in 0.20.
  "This module will be removed in 0.20.", DeprecationWarning)
2017-11-25 15:05:30.235443: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use SSE4.1 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 15:05:30.235538: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use SSE4.2 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 15:05:30.235569: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use AVX instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 15:05:30.235598: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use AVX2 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 15:05:30.235626: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use FMA instructions, but these are available on your machine and could speed up CPU computations.

Survival Rate Regression with Gene Expression HTSeq (Tensorflow)

/usr/local/lib/python2.7/dist-packages/sklearn/utils/validation.py:475: DataConversionWarning: Data with input dtype |S9 was converted to float64 by MinMaxScaler.
  warnings.warn(msg, DataConversionWarning)
[START] Pre-training step:
>> Epoch 1 finished 	RBM Reconstruction error 1027.208539
>> Epoch 2 finished 	RBM Reconstruction error 1036.553197
>> Epoch 3 finished 	RBM Reconstruction error 987.647640
>> Epoch 4 finished 	RBM Reconstruction error 1012.497909
>> Epoch 5 finished 	RBM Reconstruction error 1026.320848
>> Epoch 6 finished 	RBM Reconstruction error 964.226633
>> Epoch 7 finished 	RBM Reconstruction error 851.138246
>> Epoch 8 finished 	RBM Reconstruction error 1081.289234
>> Epoch 9 finished 	RBM Reconstruction error 938.717230
>> Epoch 10 finished 	RBM Reconstruction error 911.855574
>> Epoch 1 finished 	RBM Reconstruction error 257606.765625
>> Epoch 2 finished 	RBM Reconstruction error 243397.250000
>> Epoch 3 finished 	RBM Reconstruction error 216291.109375
>> Epoch 4 finished 	RBM Reconstruction error 205713.968750
>> Epoch 5 finished 	RBM Reconstruction error 229877.218750
>> Epoch 6 finished 	RBM Reconstruction error 223253.781250
>> Epoch 7 finished 	RBM Reconstruction error 230241.406250
>> Epoch 8 finished 	RBM Reconstruction error 190316.656250
>> Epoch 9 finished 	RBM Reconstruction error 210650.687500
>> Epoch 10 finished 	RBM Reconstruction error 234194.500000
>> Epoch 1 finished 	RBM Reconstruction error 6292975616.000000
>> Epoch 2 finished 	RBM Reconstruction error 6096840192.000000
>> Epoch 3 finished 	RBM Reconstruction error 6665447424.000000
>> Epoch 4 finished 	RBM Reconstruction error 7165156864.000000
>> Epoch 5 finished 	RBM Reconstruction error 7901792768.000000
>> Epoch 6 finished 	RBM Reconstruction error 6630606336.000000
>> Epoch 7 finished 	RBM Reconstruction error 7207797248.000000
>> Epoch 8 finished 	RBM Reconstruction error 6949975552.000000
>> Epoch 9 finished 	RBM Reconstruction error 6234645504.000000
>> Epoch 10 finished 	RBM Reconstruction error 7218122752.000000
[END] Pre-training step
[START] Fine tuning step:
>> Epoch 0 finished 	ANN training loss nan
>> Epoch 1 finished 	ANN training loss nan
>> Epoch 2 finished 	ANN training loss nan
>> Epoch 3 finished 	ANN training loss nan
>> Epoch 4 finished 	ANN training loss nan
>> Epoch 5 finished 	ANN training loss nan
>> Epoch 6 finished 	ANN training loss nan
>> Epoch 7 finished 	ANN training loss nan
>> Epoch 8 finished 	ANN training loss nan
>> Epoch 9 finished 	ANN training loss nan
[END] Fine tuning step
Traceback (most recent call last):
  File "main_run.py", line 146, in <module>
    main()
  File "main_run.py", line 142, in main
    layers=LAYERS)
  File "/home/asif/Downloads/hakathon/mdbn_tcga_brca_tensorflow/Tensorflow/DBN_regression.py", line 77, in test_DBN
    print('Done.\nR-squared: %f\nMSE: %f' % (r2_score(Y_test, Y_pred), mean_squared_error(Y_test, Y_pred)))
  File "/usr/local/lib/python2.7/dist-packages/sklearn/metrics/regression.py", line 530, in r2_score
    y_true, y_pred, multioutput)
  File "/usr/local/lib/python2.7/dist-packages/sklearn/metrics/regression.py", line 77, in _check_reg_targets
    y_pred = check_array(y_pred, ensure_2d=False)
  File "/usr/local/lib/python2.7/dist-packages/sklearn/utils/validation.py", line 453, in check_array
    _assert_all_finite(array)
  File "/usr/local/lib/python2.7/dist-packages/sklearn/utils/validation.py", line 44, in _assert_all_finite
    " or a value too large for %r." % X.dtype)
ValueError: Input contains NaN, infinity or a value too large for dtype('float32').
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
Insert here [default = 3]: 2
You will use Gene Expression data to create the prediction


Neural Network Layers
Number of hidden layers [default = 3]: 
Layer 0 size [default = 1000]: 10
Layer 1 size [default = 1000]: 10
Layer 2 size [default = 1000]: 10


Neural Network Parameters
Pre-training iteration [default = 100]: 10
Training iteration [default = 100]: 10
Batch size [default = 10]: 10
Pre-training learning rate [default = 0.01]: 
Training learning rate [default = 0.1]: 
/usr/local/lib/python2.7/dist-packages/sklearn/cross_validation.py:41: DeprecationWarning: This module was deprecated in version 0.18 in favor of the model_selection module into which all the refactored classes and functions are moved. Also note that the interface of the new CV iterators are different from that of this module. This module will be removed in 0.20.
  "This module will be removed in 0.20.", DeprecationWarning)
2017-11-25 15:14:31.259222: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use SSE4.1 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 15:14:31.259320: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use SSE4.2 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 15:14:31.259352: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use AVX instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 15:14:31.259382: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use AVX2 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 15:14:31.259410: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use FMA instructions, but these are available on your machine and could speed up CPU computations.

Survival Rate Regression with Gene Expression HTSeq (Tensorflow)

/usr/local/lib/python2.7/dist-packages/sklearn/utils/validation.py:475: DataConversionWarning: Data with input dtype |S9 was converted to float64 by MinMaxScaler.
  warnings.warn(msg, DataConversionWarning)
[START] Pre-training step:
>> Epoch 1 finished 	RBM Reconstruction error 1806.717013
>> Epoch 2 finished 	RBM Reconstruction error 1647.634447
>> Epoch 3 finished 	RBM Reconstruction error 1879.459528
>> Epoch 4 finished 	RBM Reconstruction error 1941.545335
>> Epoch 5 finished 	RBM Reconstruction error 1737.977381
>> Epoch 6 finished 	RBM Reconstruction error 1696.657592
>> Epoch 7 finished 	RBM Reconstruction error 1821.257664
>> Epoch 8 finished 	RBM Reconstruction error 1784.114197
>> Epoch 9 finished 	RBM Reconstruction error 1676.229714
>> Epoch 10 finished 	RBM Reconstruction error 1633.110661
>> Epoch 1 finished 	RBM Reconstruction error 426003.906250
>> Epoch 2 finished 	RBM Reconstruction error 428316.812500
>> Epoch 3 finished 	RBM Reconstruction error 473272.562500
>> Epoch 4 finished 	RBM Reconstruction error 462626.125000
>> Epoch 5 finished 	RBM Reconstruction error 531487.750000
>> Epoch 6 finished 	RBM Reconstruction error 475684.062500
>> Epoch 7 finished 	RBM Reconstruction error 502573.656250
>> Epoch 8 finished 	RBM Reconstruction error 507278.406250
>> Epoch 9 finished 	RBM Reconstruction error 456969.062500
>> Epoch 10 finished 	RBM Reconstruction error 497246.031250
>> Epoch 1 finished 	RBM Reconstruction error 39930748928.000000
>> Epoch 2 finished 	RBM Reconstruction error 40323973120.000000
>> Epoch 3 finished 	RBM Reconstruction error 37318959104.000000
>> Epoch 4 finished 	RBM Reconstruction error 39535058944.000000
>> Epoch 5 finished 	RBM Reconstruction error 36795277312.000000
>> Epoch 6 finished 	RBM Reconstruction error 37509189632.000000
>> Epoch 7 finished 	RBM Reconstruction error 39460921344.000000
>> Epoch 8 finished 	RBM Reconstruction error 39563354112.000000
>> Epoch 9 finished 	RBM Reconstruction error 38960029696.000000
>> Epoch 10 finished 	RBM Reconstruction error 39007870976.000000
[END] Pre-training step
[START] Fine tuning step:
>> Epoch 0 finished 	ANN training loss 0.018797
>> Epoch 1 finished 	ANN training loss 0.018865
>> Epoch 2 finished 	ANN training loss 0.018815
>> Epoch 3 finished 	ANN training loss 0.018714
>> Epoch 4 finished 	ANN training loss 0.018843
>> Epoch 5 finished 	ANN training loss 0.019022
>> Epoch 6 finished 	ANN training loss 0.019428
>> Epoch 7 finished 	ANN training loss 0.018669
>> Epoch 8 finished 	ANN training loss 0.018649
>> Epoch 9 finished 	ANN training loss 0.019435
[END] Fine tuning step
Traceback (most recent call last):
  File "main_run.py", line 146, in <module>
    main()
  File "main_run.py", line 142, in main
    layers=LAYERS)
  File "/home/asif/Downloads/hakathon/mdbn_tcga_brca_tensorflow/Tensorflow/DBN_regression.py", line 77, in test_DBN
    print('Done.\nR-squared: %f\nMSE: %f' % (r2_score(Y_test, Y_pred), mean_squared_error(Y_test, Y_pred)))
  File "/usr/local/lib/python2.7/dist-packages/sklearn/metrics/regression.py", line 538, in r2_score
    numerator = (weight * (y_true - y_pred) ** 2).sum(axis=0,
TypeError: ufunc 'subtract' did not contain a loop with signature matching types dtype('S32') dtype('S32') dtype('S32')
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
Insert here [default = 3]: 1
You will use DNA Methylation data to create the prediction


Neural Network Layers
Number of hidden layers [default = 3]: 
Layer 0 size [default = 1000]: 10
Layer 1 size [default = 1000]: 10
Layer 2 size [default = 1000]: 10


Neural Network Parameters
Pre-training iteration [default = 100]: 10
Training iteration [default = 100]: 10
Batch size [default = 10]: 10
Pre-training learning rate [default = 0.01]: 
Training learning rate [default = 0.1]: 
/usr/local/lib/python2.7/dist-packages/sklearn/cross_validation.py:41: DeprecationWarning: This module was deprecated in version 0.18 in favor of the model_selection module into which all the refactored classes and functions are moved. Also note that the interface of the new CV iterators are different from that of this module. This module will be removed in 0.20.
  "This module will be removed in 0.20.", DeprecationWarning)
2017-11-25 16:33:48.569016: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use SSE4.1 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 16:33:48.569113: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use SSE4.2 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 16:33:48.569144: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use AVX instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 16:33:48.569172: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use AVX2 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 16:33:48.569200: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use FMA instructions, but these are available on your machine and could speed up CPU computations.

Survival Rate Regression with DNA Methylation (Tensorflow)

[START] Pre-training step:
>> Epoch 1 finished 	RBM Reconstruction error 222605.896917
>> Epoch 2 finished 	RBM Reconstruction error 225733.534388
>> Epoch 3 finished 	RBM Reconstruction error 213365.139303
>> Epoch 4 finished 	RBM Reconstruction error 227396.566024
>> Epoch 5 finished 	RBM Reconstruction error 220987.540130
>> Epoch 6 finished 	RBM Reconstruction error 222004.671035
>> Epoch 7 finished 	RBM Reconstruction error 221263.070530
>> Epoch 8 finished 	RBM Reconstruction error 220484.815267
>> Epoch 9 finished 	RBM Reconstruction error 218743.531249
>> Epoch 10 finished 	RBM Reconstruction error 223054.245008
>> Epoch 1 finished 	RBM Reconstruction error 11747658752.000000
>> Epoch 2 finished 	RBM Reconstruction error 12238340096.000000
>> Epoch 3 finished 	RBM Reconstruction error 11690096640.000000
>> Epoch 4 finished 	RBM Reconstruction error 12032613376.000000
>> Epoch 5 finished 	RBM Reconstruction error 11871930368.000000
>> Epoch 6 finished 	RBM Reconstruction error 12112060416.000000
>> Epoch 7 finished 	RBM Reconstruction error 12459831296.000000
>> Epoch 8 finished 	RBM Reconstruction error 12294272000.000000
>> Epoch 9 finished 	RBM Reconstruction error 12309939200.000000
>> Epoch 10 finished 	RBM Reconstruction error 11940917248.000000
>> Epoch 1 finished 	RBM Reconstruction error 11937789168903520256.000000
>> Epoch 2 finished 	RBM Reconstruction error 12146050964855455744.000000
>> Epoch 3 finished 	RBM Reconstruction error 11892401328908926976.000000
>> Epoch 4 finished 	RBM Reconstruction error 11910234307999825920.000000
>> Epoch 5 finished 	RBM Reconstruction error 11943227353414500352.000000
>> Epoch 6 finished 	RBM Reconstruction error 12022946344474771456.000000
>> Epoch 7 finished 	RBM Reconstruction error 11861072944098705408.000000
>> Epoch 8 finished 	RBM Reconstruction error 12167018651597144064.000000
>> Epoch 9 finished 	RBM Reconstruction error 12137163612368142336.000000
>> Epoch 10 finished 	RBM Reconstruction error 12333931113763307520.000000
[END] Pre-training step
[START] Fine tuning step:
>> Epoch 0 finished 	ANN training loss nan
>> Epoch 1 finished 	ANN training loss nan
>> Epoch 2 finished 	ANN training loss nan
>> Epoch 3 finished 	ANN training loss nan
>> Epoch 4 finished 	ANN training loss nan
>> Epoch 5 finished 	ANN training loss nan
>> Epoch 6 finished 	ANN training loss nan
>> Epoch 7 finished 	ANN training loss nan
>> Epoch 8 finished 	ANN training loss nan
>> Epoch 9 finished 	ANN training loss nan
[END] Fine tuning step
Infinity or a value too large for dtype('float32'). Please try different layer settings.
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
Insert here [default = 3]: 1
You will use DNA Methylation data to create the prediction


Neural Network Layers
Number of hidden layers [default = 3]: 3
Layer 0 size [default = 1000]: 100
Layer 1 size [default = 1000]: 100
Layer 2 size [default = 1000]: 100


Neural Network Parameters
Pre-training iteration [default = 100]: 10 
Training iteration [default = 100]: 10
Batch size [default = 10]: 
Pre-training learning rate [default = 0.01]: 
Training learning rate [default = 0.1]: 
/usr/local/lib/python2.7/dist-packages/sklearn/cross_validation.py:41: DeprecationWarning: This module was deprecated in version 0.18 in favor of the model_selection module into which all the refactored classes and functions are moved. Also note that the interface of the new CV iterators are different from that of this module. This module will be removed in 0.20.
  "This module will be removed in 0.20.", DeprecationWarning)
2017-11-25 16:37:46.455873: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use SSE4.1 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 16:37:46.456084: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use SSE4.2 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 16:37:46.456129: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use AVX instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 16:37:46.456169: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use AVX2 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 16:37:46.456208: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use FMA instructions, but these are available on your machine and could speed up CPU computations.

Survival Rate Regression with DNA Methylation (Tensorflow)

[START] Pre-training step:
>> Epoch 1 finished 	RBM Reconstruction error 15837.246032
>> Epoch 2 finished 	RBM Reconstruction error 14448.151664
>> Epoch 3 finished 	RBM Reconstruction error 14265.223884
>> Epoch 4 finished 	RBM Reconstruction error 16097.165323
>> Epoch 5 finished 	RBM Reconstruction error 15221.305506
>> Epoch 6 finished 	RBM Reconstruction error 14892.015529
>> Epoch 7 finished 	RBM Reconstruction error 15844.008275
>> Epoch 8 finished 	RBM Reconstruction error 13475.390264
>> Epoch 9 finished 	RBM Reconstruction error 13774.751380
>> Epoch 10 finished 	RBM Reconstruction error 14520.839372
>> Epoch 1 finished 	RBM Reconstruction error 6290631.000000
>> Epoch 2 finished 	RBM Reconstruction error 5786676.000000
>> Epoch 3 finished 	RBM Reconstruction error 6286840.500000
>> Epoch 4 finished 	RBM Reconstruction error 6755990.500000
>> Epoch 5 finished 	RBM Reconstruction error 6388392.000000
>> Epoch 6 finished 	RBM Reconstruction error 7063510.500000
>> Epoch 7 finished 	RBM Reconstruction error 6513348.500000
>> Epoch 8 finished 	RBM Reconstruction error 6068481.000000
>> Epoch 9 finished 	RBM Reconstruction error 6480918.000000
>> Epoch 10 finished 	RBM Reconstruction error 6368667.500000
>> Epoch 1 finished 	RBM Reconstruction error 964408442880.000000
>> Epoch 2 finished 	RBM Reconstruction error 927154307072.000000
>> Epoch 3 finished 	RBM Reconstruction error 904318484480.000000
>> Epoch 4 finished 	RBM Reconstruction error 954198654976.000000
>> Epoch 5 finished 	RBM Reconstruction error 928858701824.000000
>> Epoch 6 finished 	RBM Reconstruction error 984945524736.000000
>> Epoch 7 finished 	RBM Reconstruction error 1009313447936.000000
>> Epoch 8 finished 	RBM Reconstruction error 1063949828096.000000
>> Epoch 9 finished 	RBM Reconstruction error 963130621952.000000
>> Epoch 10 finished 	RBM Reconstruction error 929858846720.000000
[END] Pre-training step
[START] Fine tuning step:
>> Epoch 0 finished 	ANN training loss nan
>> Epoch 1 finished 	ANN training loss nan
>> Epoch 2 finished 	ANN training loss nan
>> Epoch 3 finished 	ANN training loss nan
>> Epoch 4 finished 	ANN training loss nan
>> Epoch 5 finished 	ANN training loss nan
>> Epoch 6 finished 	ANN training loss nan
>> Epoch 7 finished 	ANN training loss nan
>> Epoch 8 finished 	ANN training loss nan
>> Epoch 9 finished 	ANN training loss nan
[END] Fine tuning step
Infinity or a value too large for dtype('float32'). Please try different layer settings.
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
Insert here [default = 3]: 2
You will use Gene Expression data to create the prediction


Neural Network Layers
Number of hidden layers [default = 3]: 
Layer 0 size [default = 1000]: 100
Layer 1 size [default = 1000]: 100
Layer 2 size [default = 1000]: 100


Neural Network Parameters
Pre-training iteration [default = 100]: 
Training iteration [default = 100]: 
Batch size [default = 10]: 
Pre-training learning rate [default = 0.01]: 
Training learning rate [default = 0.1]: 
/usr/local/lib/python2.7/dist-packages/sklearn/cross_validation.py:41: DeprecationWarning: This module was deprecated in version 0.18 in favor of the model_selection module into which all the refactored classes and functions are moved. Also note that the interface of the new CV iterators are different from that of this module. This module will be removed in 0.20.
  "This module will be removed in 0.20.", DeprecationWarning)
2017-11-25 16:45:31.667078: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use SSE4.1 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 16:45:31.667184: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use SSE4.2 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 16:45:31.667219: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use AVX instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 16:45:31.667250: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use AVX2 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 16:45:31.667280: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use FMA instructions, but these are available on your machine and could speed up CPU computations.

Survival Rate Regression with Gene Expression HTSeq (Tensorflow)

[START] Pre-training step:
>> Epoch 1 finished 	RBM Reconstruction error 84.027716
>> Epoch 2 finished 	RBM Reconstruction error 85.139716
>> Epoch 3 finished 	RBM Reconstruction error 75.133950
>> Epoch 4 finished 	RBM Reconstruction error 54.377330
>> Epoch 5 finished 	RBM Reconstruction error 94.518482
>> Epoch 6 finished 	RBM Reconstruction error 89.207670
>> Epoch 7 finished 	RBM Reconstruction error 81.728604
>> Epoch 8 finished 	RBM Reconstruction error 108.699212
>> Epoch 9 finished 	RBM Reconstruction error 79.804388
>> Epoch 10 finished 	RBM Reconstruction error 67.769631
>> Epoch 11 finished 	RBM Reconstruction error 64.101078
>> Epoch 12 finished 	RBM Reconstruction error 75.809066
>> Epoch 13 finished 	RBM Reconstruction error 80.162620
>> Epoch 14 finished 	RBM Reconstruction error 62.832182
>> Epoch 15 finished 	RBM Reconstruction error 69.269295
>> Epoch 16 finished 	RBM Reconstruction error 73.619655
>> Epoch 17 finished 	RBM Reconstruction error 70.542992
>> Epoch 18 finished 	RBM Reconstruction error 57.519898
>> Epoch 19 finished 	RBM Reconstruction error 54.154931
>> Epoch 20 finished 	RBM Reconstruction error 77.636667
>> Epoch 21 finished 	RBM Reconstruction error 64.936890
>> Epoch 22 finished 	RBM Reconstruction error 62.350412
>> Epoch 23 finished 	RBM Reconstruction error 52.962882
>> Epoch 24 finished 	RBM Reconstruction error 65.174811
>> Epoch 25 finished 	RBM Reconstruction error 64.595304
>> Epoch 26 finished 	RBM Reconstruction error 59.626135
>> Epoch 27 finished 	RBM Reconstruction error 62.667173
>> Epoch 28 finished 	RBM Reconstruction error 52.940214
>> Epoch 29 finished 	RBM Reconstruction error 56.182419
>> Epoch 30 finished 	RBM Reconstruction error 60.070662
>> Epoch 31 finished 	RBM Reconstruction error 71.994946
>> Epoch 32 finished 	RBM Reconstruction error 73.657878
>> Epoch 33 finished 	RBM Reconstruction error 72.448845
>> Epoch 34 finished 	RBM Reconstruction error 73.861212
>> Epoch 35 finished 	RBM Reconstruction error 82.771910
>> Epoch 36 finished 	RBM Reconstruction error 73.059459
>> Epoch 37 finished 	RBM Reconstruction error 81.256477
>> Epoch 38 finished 	RBM Reconstruction error 71.286307
>> Epoch 39 finished 	RBM Reconstruction error 72.605287
>> Epoch 40 finished 	RBM Reconstruction error 67.971232
>> Epoch 41 finished 	RBM Reconstruction error 66.335238
>> Epoch 42 finished 	RBM Reconstruction error 63.705452
>> Epoch 43 finished 	RBM Reconstruction error 80.927179
>> Epoch 44 finished 	RBM Reconstruction error 73.148199
>> Epoch 45 finished 	RBM Reconstruction error 68.747972
>> Epoch 46 finished 	RBM Reconstruction error 84.884246
>> Epoch 47 finished 	RBM Reconstruction error 74.690864
>> Epoch 48 finished 	RBM Reconstruction error 80.391600
>> Epoch 49 finished 	RBM Reconstruction error 72.974810
>> Epoch 50 finished 	RBM Reconstruction error 82.190021
>> Epoch 51 finished 	RBM Reconstruction error 77.992353
>> Epoch 52 finished 	RBM Reconstruction error 84.971664
>> Epoch 53 finished 	RBM Reconstruction error 95.264123
>> Epoch 54 finished 	RBM Reconstruction error 86.743024
>> Epoch 55 finished 	RBM Reconstruction error 88.103642
>> Epoch 56 finished 	RBM Reconstruction error 85.272451
>> Epoch 57 finished 	RBM Reconstruction error 87.133994
>> Epoch 58 finished 	RBM Reconstruction error 88.906744
>> Epoch 59 finished 	RBM Reconstruction error 90.681665
>> Epoch 60 finished 	RBM Reconstruction error 96.202468
>> Epoch 61 finished 	RBM Reconstruction error 90.674403
>> Epoch 62 finished 	RBM Reconstruction error 80.555156
>> Epoch 63 finished 	RBM Reconstruction error 85.916700
>> Epoch 64 finished 	RBM Reconstruction error 88.797488
>> Epoch 65 finished 	RBM Reconstruction error 87.998589
>> Epoch 66 finished 	RBM Reconstruction error 97.797842
>> Epoch 67 finished 	RBM Reconstruction error 95.468497
>> Epoch 68 finished 	RBM Reconstruction error 99.247150
>> Epoch 69 finished 	RBM Reconstruction error 114.831883
>> Epoch 70 finished 	RBM Reconstruction error 112.233807
>> Epoch 71 finished 	RBM Reconstruction error 114.623423
>> Epoch 72 finished 	RBM Reconstruction error 113.623836
>> Epoch 73 finished 	RBM Reconstruction error 115.215745
>> Epoch 74 finished 	RBM Reconstruction error 107.871855
>> Epoch 75 finished 	RBM Reconstruction error 108.675598
>> Epoch 76 finished 	RBM Reconstruction error 108.012239
>> Epoch 77 finished 	RBM Reconstruction error 107.378871
>> Epoch 78 finished 	RBM Reconstruction error 110.855928
>> Epoch 79 finished 	RBM Reconstruction error 111.776406
>> Epoch 80 finished 	RBM Reconstruction error 104.603565
>> Epoch 81 finished 	RBM Reconstruction error 95.943701
>> Epoch 82 finished 	RBM Reconstruction error 103.611479
>> Epoch 83 finished 	RBM Reconstruction error 102.022184
>> Epoch 84 finished 	RBM Reconstruction error 97.442229
>> Epoch 85 finished 	RBM Reconstruction error 97.806298
>> Epoch 86 finished 	RBM Reconstruction error 99.227222
>> Epoch 87 finished 	RBM Reconstruction error 110.925320
>> Epoch 88 finished 	RBM Reconstruction error 97.793791
>> Epoch 89 finished 	RBM Reconstruction error 104.017102
>> Epoch 90 finished 	RBM Reconstruction error 108.221063
>> Epoch 91 finished 	RBM Reconstruction error 113.704416
>> Epoch 92 finished 	RBM Reconstruction error 108.266360
>> Epoch 93 finished 	RBM Reconstruction error 103.090174
>> Epoch 94 finished 	RBM Reconstruction error 106.526931
>> Epoch 95 finished 	RBM Reconstruction error 98.121644
>> Epoch 96 finished 	RBM Reconstruction error 98.948513
>> Epoch 97 finished 	RBM Reconstruction error 104.607305
>> Epoch 98 finished 	RBM Reconstruction error 102.387376
>> Epoch 99 finished 	RBM Reconstruction error 94.960072
>> Epoch 100 finished 	RBM Reconstruction error 96.012785
>> Epoch 1 finished 	RBM Reconstruction error 158.379868
>> Epoch 2 finished 	RBM Reconstruction error 208.241928
>> Epoch 3 finished 	RBM Reconstruction error 220.484116
>> Epoch 4 finished 	RBM Reconstruction error 298.338898
>> Epoch 5 finished 	RBM Reconstruction error 216.513000
>> Epoch 6 finished 	RBM Reconstruction error 303.167480
>> Epoch 7 finished 	RBM Reconstruction error 349.007324
>> Epoch 8 finished 	RBM Reconstruction error 248.124939
>> Epoch 9 finished 	RBM Reconstruction error 224.287521
>> Epoch 10 finished 	RBM Reconstruction error 219.219559
>> Epoch 11 finished 	RBM Reconstruction error 295.711456
>> Epoch 12 finished 	RBM Reconstruction error 216.590179
>> Epoch 13 finished 	RBM Reconstruction error 174.131882
>> Epoch 14 finished 	RBM Reconstruction error 197.381882
>> Epoch 15 finished 	RBM Reconstruction error 164.777939
>> Epoch 16 finished 	RBM Reconstruction error 187.183929
>> Epoch 17 finished 	RBM Reconstruction error 208.748337
>> Epoch 18 finished 	RBM Reconstruction error 184.617294
>> Epoch 19 finished 	RBM Reconstruction error 214.617477
>> Epoch 20 finished 	RBM Reconstruction error 252.415283
>> Epoch 21 finished 	RBM Reconstruction error 238.082642
>> Epoch 22 finished 	RBM Reconstruction error 261.188080
>> Epoch 23 finished 	RBM Reconstruction error 283.645538
>> Epoch 24 finished 	RBM Reconstruction error 241.941498
>> Epoch 25 finished 	RBM Reconstruction error 197.839203
>> Epoch 26 finished 	RBM Reconstruction error 263.400055
>> Epoch 27 finished 	RBM Reconstruction error 238.681427
>> Epoch 28 finished 	RBM Reconstruction error 219.728485
>> Epoch 29 finished 	RBM Reconstruction error 202.288300
>> Epoch 30 finished 	RBM Reconstruction error 267.053833
>> Epoch 31 finished 	RBM Reconstruction error 250.951141
>> Epoch 32 finished 	RBM Reconstruction error 257.908661
>> Epoch 33 finished 	RBM Reconstruction error 251.414307
>> Epoch 34 finished 	RBM Reconstruction error 256.368011
>> Epoch 35 finished 	RBM Reconstruction error 282.899139
>> Epoch 36 finished 	RBM Reconstruction error 283.535980
>> Epoch 37 finished 	RBM Reconstruction error 287.936584
>> Epoch 38 finished 	RBM Reconstruction error 323.073792
>> Epoch 39 finished 	RBM Reconstruction error 323.576599
>> Epoch 40 finished 	RBM Reconstruction error 279.447968
>> Epoch 41 finished 	RBM Reconstruction error 286.326904
>> Epoch 42 finished 	RBM Reconstruction error 316.571228
>> Epoch 43 finished 	RBM Reconstruction error 299.776855
>> Epoch 44 finished 	RBM Reconstruction error 323.003784
>> Epoch 45 finished 	RBM Reconstruction error 330.035706
>> Epoch 46 finished 	RBM Reconstruction error 333.050293
>> Epoch 47 finished 	RBM Reconstruction error 297.589203
>> Epoch 48 finished 	RBM Reconstruction error 329.062805
>> Epoch 49 finished 	RBM Reconstruction error 302.975647
>> Epoch 50 finished 	RBM Reconstruction error 264.317383
>> Epoch 51 finished 	RBM Reconstruction error 259.071838
>> Epoch 52 finished 	RBM Reconstruction error 296.285095
>> Epoch 53 finished 	RBM Reconstruction error 282.509735
>> Epoch 54 finished 	RBM Reconstruction error 279.861359
>> Epoch 55 finished 	RBM Reconstruction error 275.647614
>> Epoch 56 finished 	RBM Reconstruction error 270.664978
>> Epoch 57 finished 	RBM Reconstruction error 299.238892
>> Epoch 58 finished 	RBM Reconstruction error 306.962524
>> Epoch 59 finished 	RBM Reconstruction error 296.059418
>> Epoch 60 finished 	RBM Reconstruction error 307.932037
>> Epoch 61 finished 	RBM Reconstruction error 270.915466
>> Epoch 62 finished 	RBM Reconstruction error 299.218414
>> Epoch 63 finished 	RBM Reconstruction error 271.079742
>> Epoch 64 finished 	RBM Reconstruction error 285.289276
>> Epoch 65 finished 	RBM Reconstruction error 270.931335
>> Epoch 66 finished 	RBM Reconstruction error 248.086960
>> Epoch 67 finished 	RBM Reconstruction error 265.466431
>> Epoch 68 finished 	RBM Reconstruction error 243.434189
>> Epoch 69 finished 	RBM Reconstruction error 272.030090
>> Epoch 70 finished 	RBM Reconstruction error 270.629791
>> Epoch 71 finished 	RBM Reconstruction error 259.532074
>> Epoch 72 finished 	RBM Reconstruction error 233.710526
>> Epoch 73 finished 	RBM Reconstruction error 253.006363
>> Epoch 74 finished 	RBM Reconstruction error 240.321243
>> Epoch 75 finished 	RBM Reconstruction error 264.850983
>> Epoch 76 finished 	RBM Reconstruction error 264.254272
>> Epoch 77 finished 	RBM Reconstruction error 264.479584
>> Epoch 78 finished 	RBM Reconstruction error 249.809830
>> Epoch 79 finished 	RBM Reconstruction error 255.384262
>> Epoch 80 finished 	RBM Reconstruction error 273.657684
>> Epoch 81 finished 	RBM Reconstruction error 258.103119
>> Epoch 82 finished 	RBM Reconstruction error 248.532928
>> Epoch 83 finished 	RBM Reconstruction error 262.291107
>> Epoch 84 finished 	RBM Reconstruction error 254.737320
>> Epoch 85 finished 	RBM Reconstruction error 271.948029
>> Epoch 86 finished 	RBM Reconstruction error 325.420135
>> Epoch 87 finished 	RBM Reconstruction error 278.892517
>> Epoch 88 finished 	RBM Reconstruction error 283.372803
>> Epoch 89 finished 	RBM Reconstruction error 282.567871
>> Epoch 90 finished 	RBM Reconstruction error 302.422119
>> Epoch 91 finished 	RBM Reconstruction error 304.894897
>> Epoch 92 finished 	RBM Reconstruction error 302.439575
>> Epoch 93 finished 	RBM Reconstruction error 312.365753
>> Epoch 94 finished 	RBM Reconstruction error 290.944641
>> Epoch 95 finished 	RBM Reconstruction error 295.653107
>> Epoch 96 finished 	RBM Reconstruction error 317.262665
>> Epoch 97 finished 	RBM Reconstruction error 287.867523
>> Epoch 98 finished 	RBM Reconstruction error 331.921204
>> Epoch 99 finished 	RBM Reconstruction error 312.176666
>> Epoch 100 finished 	RBM Reconstruction error 329.163818
>> Epoch 1 finished 	RBM Reconstruction error 962.985901
>> Epoch 2 finished 	RBM Reconstruction error 1027.782471
>> Epoch 3 finished 	RBM Reconstruction error 443.949677
>> Epoch 4 finished 	RBM Reconstruction error 866.854614
>> Epoch 5 finished 	RBM Reconstruction error 986.213867
>> Epoch 6 finished 	RBM Reconstruction error 1108.912231
>> Epoch 7 finished 	RBM Reconstruction error 1231.227661
>> Epoch 8 finished 	RBM Reconstruction error 1293.531860
>> Epoch 9 finished 	RBM Reconstruction error 1738.364868
>> Epoch 10 finished 	RBM Reconstruction error 1419.683594
>> Epoch 11 finished 	RBM Reconstruction error 1429.986328
>> Epoch 12 finished 	RBM Reconstruction error 1727.308350
>> Epoch 13 finished 	RBM Reconstruction error 1294.930420
>> Epoch 14 finished 	RBM Reconstruction error 1194.923584
>> Epoch 15 finished 	RBM Reconstruction error 1850.290527
>> Epoch 16 finished 	RBM Reconstruction error 1254.279663
>> Epoch 17 finished 	RBM Reconstruction error 1344.911133
>> Epoch 18 finished 	RBM Reconstruction error 1656.404297
>> Epoch 19 finished 	RBM Reconstruction error 1997.113892
>> Epoch 20 finished 	RBM Reconstruction error 1796.064819
>> Epoch 21 finished 	RBM Reconstruction error 2465.488037
>> Epoch 22 finished 	RBM Reconstruction error 2268.477783
>> Epoch 23 finished 	RBM Reconstruction error 1950.298828
>> Epoch 24 finished 	RBM Reconstruction error 2677.682861
>> Epoch 25 finished 	RBM Reconstruction error 2500.044434
>> Epoch 26 finished 	RBM Reconstruction error 3071.655762
>> Epoch 27 finished 	RBM Reconstruction error 2876.874512
>> Epoch 28 finished 	RBM Reconstruction error 2828.249512
>> Epoch 29 finished 	RBM Reconstruction error 2670.505371
>> Epoch 30 finished 	RBM Reconstruction error 3077.585205
>> Epoch 31 finished 	RBM Reconstruction error 2495.708008
>> Epoch 32 finished 	RBM Reconstruction error 2649.238525
>> Epoch 33 finished 	RBM Reconstruction error 2604.848633
>> Epoch 34 finished 	RBM Reconstruction error 2702.526123
>> Epoch 35 finished 	RBM Reconstruction error 2946.058594
>> Epoch 36 finished 	RBM Reconstruction error 3108.145752
>> Epoch 37 finished 	RBM Reconstruction error 2950.851807
>> Epoch 38 finished 	RBM Reconstruction error 2951.137695
>> Epoch 39 finished 	RBM Reconstruction error 2515.415771
>> Epoch 40 finished 	RBM Reconstruction error 2652.804199
>> Epoch 41 finished 	RBM Reconstruction error 2936.397461
>> Epoch 42 finished 	RBM Reconstruction error 2819.163574
>> Epoch 43 finished 	RBM Reconstruction error 2904.155273
>> Epoch 44 finished 	RBM Reconstruction error 3429.860596
>> Epoch 45 finished 	RBM Reconstruction error 3586.364014
>> Epoch 46 finished 	RBM Reconstruction error 3255.774658
>> Epoch 47 finished 	RBM Reconstruction error 2993.612549
>> Epoch 48 finished 	RBM Reconstruction error 2739.750488
>> Epoch 49 finished 	RBM Reconstruction error 2774.241699
>> Epoch 50 finished 	RBM Reconstruction error 3208.812744
>> Epoch 51 finished 	RBM Reconstruction error 3239.482422
>> Epoch 52 finished 	RBM Reconstruction error 3627.970947
>> Epoch 53 finished 	RBM Reconstruction error 3774.093506
>> Epoch 54 finished 	RBM Reconstruction error 3265.398682
>> Epoch 55 finished 	RBM Reconstruction error 3551.278076
>> Epoch 56 finished 	RBM Reconstruction error 3519.461426
>> Epoch 57 finished 	RBM Reconstruction error 3326.224609
>> Epoch 58 finished 	RBM Reconstruction error 3588.417725
>> Epoch 59 finished 	RBM Reconstruction error 3219.469727
>> Epoch 60 finished 	RBM Reconstruction error 3889.774658
>> Epoch 61 finished 	RBM Reconstruction error 3576.361328
>> Epoch 62 finished 	RBM Reconstruction error 3605.211182
>> Epoch 63 finished 	RBM Reconstruction error 3680.573975
>> Epoch 64 finished 	RBM Reconstruction error 3527.705078
>> Epoch 65 finished 	RBM Reconstruction error 3690.697266
>> Epoch 66 finished 	RBM Reconstruction error 3961.612061
>> Epoch 67 finished 	RBM Reconstruction error 3326.117920
>> Epoch 68 finished 	RBM Reconstruction error 3525.181885
>> Epoch 69 finished 	RBM Reconstruction error 3542.193115
>> Epoch 70 finished 	RBM Reconstruction error 3335.571777
>> Epoch 71 finished 	RBM Reconstruction error 3572.744385
>> Epoch 72 finished 	RBM Reconstruction error 3748.452393
>> Epoch 73 finished 	RBM Reconstruction error 3922.780273
>> Epoch 74 finished 	RBM Reconstruction error 3382.211426
>> Epoch 75 finished 	RBM Reconstruction error 3696.716309
>> Epoch 76 finished 	RBM Reconstruction error 3496.065674
>> Epoch 77 finished 	RBM Reconstruction error 3600.362549
>> Epoch 78 finished 	RBM Reconstruction error 3750.746338
>> Epoch 79 finished 	RBM Reconstruction error 3891.174805
>> Epoch 80 finished 	RBM Reconstruction error 3660.755371
>> Epoch 81 finished 	RBM Reconstruction error 3787.811035
>> Epoch 82 finished 	RBM Reconstruction error 3779.478027
>> Epoch 83 finished 	RBM Reconstruction error 3884.006592
>> Epoch 84 finished 	RBM Reconstruction error 4169.356445
>> Epoch 85 finished 	RBM Reconstruction error 3955.723633
>> Epoch 86 finished 	RBM Reconstruction error 3958.858398
>> Epoch 87 finished 	RBM Reconstruction error 4256.222168
>> Epoch 88 finished 	RBM Reconstruction error 4294.205078
>> Epoch 89 finished 	RBM Reconstruction error 3977.723145
>> Epoch 90 finished 	RBM Reconstruction error 4564.448242
>> Epoch 91 finished 	RBM Reconstruction error 4065.675293
>> Epoch 92 finished 	RBM Reconstruction error 4168.559570
>> Epoch 93 finished 	RBM Reconstruction error 4069.854248
>> Epoch 94 finished 	RBM Reconstruction error 4411.064941
>> Epoch 95 finished 	RBM Reconstruction error 4059.101807
>> Epoch 96 finished 	RBM Reconstruction error 4300.855469
>> Epoch 97 finished 	RBM Reconstruction error 3859.466309
>> Epoch 98 finished 	RBM Reconstruction error 4308.016113
>> Epoch 99 finished 	RBM Reconstruction error 4076.148193
>> Epoch 100 finished 	RBM Reconstruction error 4218.145508
[END] Pre-training step
[START] Fine tuning step:
>> Epoch 0 finished 	ANN training loss nan
>> Epoch 1 finished 	ANN training loss nan
>> Epoch 2 finished 	ANN training loss nan
>> Epoch 3 finished 	ANN training loss nan
>> Epoch 4 finished 	ANN training loss nan
>> Epoch 5 finished 	ANN training loss nan
>> Epoch 6 finished 	ANN training loss nan
>> Epoch 7 finished 	ANN training loss nan
>> Epoch 8 finished 	ANN training loss nan
>> Epoch 9 finished 	ANN training loss nan
>> Epoch 10 finished 	ANN training loss nan
>> Epoch 11 finished 	ANN training loss nan
>> Epoch 12 finished 	ANN training loss nan
>> Epoch 13 finished 	ANN training loss nan
>> Epoch 14 finished 	ANN training loss nan
>> Epoch 15 finished 	ANN training loss nan
>> Epoch 16 finished 	ANN training loss nan
>> Epoch 17 finished 	ANN training loss nan
>> Epoch 18 finished 	ANN training loss nan
>> Epoch 19 finished 	ANN training loss nan
>> Epoch 20 finished 	ANN training loss nan
>> Epoch 21 finished 	ANN training loss nan
>> Epoch 22 finished 	ANN training loss nan
>> Epoch 23 finished 	ANN training loss nan
>> Epoch 24 finished 	ANN training loss nan
>> Epoch 25 finished 	ANN training loss nan
>> Epoch 26 finished 	ANN training loss nan
>> Epoch 27 finished 	ANN training loss nan
>> Epoch 28 finished 	ANN training loss nan
>> Epoch 29 finished 	ANN training loss nan
>> Epoch 30 finished 	ANN training loss nan
>> Epoch 31 finished 	ANN training loss nan
>> Epoch 32 finished 	ANN training loss nan
>> Epoch 33 finished 	ANN training loss nan
>> Epoch 34 finished 	ANN training loss nan
>> Epoch 35 finished 	ANN training loss nan
>> Epoch 36 finished 	ANN training loss nan
>> Epoch 37 finished 	ANN training loss nan
>> Epoch 38 finished 	ANN training loss nan
>> Epoch 39 finished 	ANN training loss nan
>> Epoch 40 finished 	ANN training loss nan
>> Epoch 41 finished 	ANN training loss nan
>> Epoch 42 finished 	ANN training loss nan
>> Epoch 43 finished 	ANN training loss nan
>> Epoch 44 finished 	ANN training loss nan
>> Epoch 45 finished 	ANN training loss nan
>> Epoch 46 finished 	ANN training loss nan
>> Epoch 47 finished 	ANN training loss nan
>> Epoch 48 finished 	ANN training loss nan
>> Epoch 49 finished 	ANN training loss nan
>> Epoch 50 finished 	ANN training loss nan
>> Epoch 51 finished 	ANN training loss nan
>> Epoch 52 finished 	ANN training loss nan
>> Epoch 53 finished 	ANN training loss nan
>> Epoch 54 finished 	ANN training loss nan
>> Epoch 55 finished 	ANN training loss nan
>> Epoch 56 finished 	ANN training loss nan
>> Epoch 57 finished 	ANN training loss nan
>> Epoch 58 finished 	ANN training loss nan
>> Epoch 59 finished 	ANN training loss nan
>> Epoch 60 finished 	ANN training loss nan
>> Epoch 61 finished 	ANN training loss nan
>> Epoch 62 finished 	ANN training loss nan
>> Epoch 63 finished 	ANN training loss nan
>> Epoch 64 finished 	ANN training loss nan
>> Epoch 65 finished 	ANN training loss nan
>> Epoch 66 finished 	ANN training loss nan
>> Epoch 67 finished 	ANN training loss nan
>> Epoch 68 finished 	ANN training loss nan
>> Epoch 69 finished 	ANN training loss nan
>> Epoch 70 finished 	ANN training loss nan
>> Epoch 71 finished 	ANN training loss nan
>> Epoch 72 finished 	ANN training loss nan
>> Epoch 73 finished 	ANN training loss nan
>> Epoch 74 finished 	ANN training loss nan
>> Epoch 75 finished 	ANN training loss nan
>> Epoch 76 finished 	ANN training loss nan
>> Epoch 77 finished 	ANN training loss nan
>> Epoch 78 finished 	ANN training loss nan
>> Epoch 79 finished 	ANN training loss nan
>> Epoch 80 finished 	ANN training loss nan
>> Epoch 81 finished 	ANN training loss nan
>> Epoch 82 finished 	ANN training loss nan
>> Epoch 83 finished 	ANN training loss nan
>> Epoch 84 finished 	ANN training loss nan
>> Epoch 85 finished 	ANN training loss nan
>> Epoch 86 finished 	ANN training loss nan
>> Epoch 87 finished 	ANN training loss nan
>> Epoch 88 finished 	ANN training loss nan
>> Epoch 89 finished 	ANN training loss nan
>> Epoch 90 finished 	ANN training loss nan
>> Epoch 91 finished 	ANN training loss nan
>> Epoch 92 finished 	ANN training loss nan
>> Epoch 93 finished 	ANN training loss nan
>> Epoch 94 finished 	ANN training loss nan
>> Epoch 95 finished 	ANN training loss nan
>> Epoch 96 finished 	ANN training loss nan
>> Epoch 97 finished 	ANN training loss nan
>> Epoch 98 finished 	ANN training loss nan
>> Epoch 99 finished 	ANN training loss nan
[END] Fine tuning step
Infinity or a value too large for dtype('float32'). Please try different layer settings.
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
2017-11-25 19:12:19.255762: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use SSE4.1 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 19:12:19.255913: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use SSE4.2 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 19:12:19.255973: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use AVX instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 19:12:19.256003: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use AVX2 instructions, but these are available on your machine and could speed up CPU computations.
2017-11-25 19:12:19.256045: W tensorflow/core/platform/cpu_feature_guard.cc:45] The TensorFlow library wasn't compiled to use FMA instructions, but these are available on your machine and could speed up CPU computations.

Cancer Type Classification with DNA Methylation (Tensorflow)


ER Status Prediction Training Process

[START] Pre-training step:
>> Epoch 1 finished 	RBM Reconstruction error 469.879839
>> Epoch 2 finished 	RBM Reconstruction error 374.972434
>> Epoch 3 finished 	RBM Reconstruction error 554.588701
>> Epoch 4 finished 	RBM Reconstruction error 546.850071
>> Epoch 5 finished 	RBM Reconstruction error 562.730047
>> Epoch 6 finished 	RBM Reconstruction error 609.488302
>> Epoch 7 finished 	RBM Reconstruction error 600.357009
>> Epoch 8 finished 	RBM Reconstruction error 722.935042
>> Epoch 9 finished 	RBM Reconstruction error 659.239332
>> Epoch 10 finished 	RBM Reconstruction error 787.718454
>> Epoch 11 finished 	RBM Reconstruction error 857.650962
>> Epoch 12 finished 	RBM Reconstruction error 695.009332
>> Epoch 13 finished 	RBM Reconstruction error 661.623581
>> Epoch 14 finished 	RBM Reconstruction error 827.085232
>> Epoch 15 finished 	RBM Reconstruction error 948.363429
>> Epoch 16 finished 	RBM Reconstruction error 944.782833
>> Epoch 17 finished 	RBM Reconstruction error 953.678840
>> Epoch 18 finished 	RBM Reconstruction error 747.660705
>> Epoch 19 finished 	RBM Reconstruction error 985.145041
>> Epoch 20 finished 	RBM Reconstruction error 974.200514
>> Epoch 21 finished 	RBM Reconstruction error 933.669349
>> Epoch 22 finished 	RBM Reconstruction error 848.149624
>> Epoch 23 finished 	RBM Reconstruction error 1071.912258
>> Epoch 24 finished 	RBM Reconstruction error 1014.346601
>> Epoch 25 finished 	RBM Reconstruction error 1072.171997
>> Epoch 26 finished 	RBM Reconstruction error 1197.743701
>> Epoch 27 finished 	RBM Reconstruction error 788.831220
>> Epoch 28 finished 	RBM Reconstruction error 789.157720
>> Epoch 29 finished 	RBM Reconstruction error 958.003908
>> Epoch 30 finished 	RBM Reconstruction error 1015.009994
>> Epoch 31 finished 	RBM Reconstruction error 1290.823473
>> Epoch 32 finished 	RBM Reconstruction error 1107.357405
>> Epoch 33 finished 	RBM Reconstruction error 1156.256639
>> Epoch 34 finished 	RBM Reconstruction error 1106.581700
>> Epoch 35 finished 	RBM Reconstruction error 1331.398902
>> Epoch 36 finished 	RBM Reconstruction error 1767.864438
>> Epoch 37 finished 	RBM Reconstruction error 1288.221255
>> Epoch 38 finished 	RBM Reconstruction error 1352.458010
>> Epoch 39 finished 	RBM Reconstruction error 1745.350977
>> Epoch 40 finished 	RBM Reconstruction error 1814.481974
>> Epoch 41 finished 	RBM Reconstruction error 2008.338960
>> Epoch 42 finished 	RBM Reconstruction error 2132.418695
>> Epoch 43 finished 	RBM Reconstruction error 2302.831849
>> Epoch 44 finished 	RBM Reconstruction error 2513.918629
>> Epoch 45 finished 	RBM Reconstruction error 3370.059581
>> Epoch 46 finished 	RBM Reconstruction error 2833.028398
>> Epoch 47 finished 	RBM Reconstruction error 3124.477104
>> Epoch 48 finished 	RBM Reconstruction error 3338.563447
>> Epoch 49 finished 	RBM Reconstruction error 3525.149087
>> Epoch 50 finished 	RBM Reconstruction error 3073.696217
>> Epoch 51 finished 	RBM Reconstruction error 3469.232894
>> Epoch 52 finished 	RBM Reconstruction error 3501.137544
>> Epoch 53 finished 	RBM Reconstruction error 3554.125260
>> Epoch 54 finished 	RBM Reconstruction error 3556.630593
>> Epoch 55 finished 	RBM Reconstruction error 3614.353743
>> Epoch 56 finished 	RBM Reconstruction error 4026.656512
>> Epoch 57 finished 	RBM Reconstruction error 4012.557960
>> Epoch 58 finished 	RBM Reconstruction error 3967.594347
>> Epoch 59 finished 	RBM Reconstruction error 4060.568102
>> Epoch 60 finished 	RBM Reconstruction error 4893.496329
>> Epoch 61 finished 	RBM Reconstruction error 4894.320124
>> Epoch 62 finished 	RBM Reconstruction error 4340.632774
>> Epoch 63 finished 	RBM Reconstruction error 4923.643368
>> Epoch 64 finished 	RBM Reconstruction error 4649.727150
>> Epoch 65 finished 	RBM Reconstruction error 4336.554990
>> Epoch 66 finished 	RBM Reconstruction error 4762.735347
>> Epoch 67 finished 	RBM Reconstruction error 4964.342194
>> Epoch 68 finished 	RBM Reconstruction error 4590.020619
>> Epoch 69 finished 	RBM Reconstruction error 4172.197621
>> Epoch 70 finished 	RBM Reconstruction error 4709.392939
>> Epoch 71 finished 	RBM Reconstruction error 5024.604323
>> Epoch 72 finished 	RBM Reconstruction error 5128.120278
>> Epoch 73 finished 	RBM Reconstruction error 5495.706751
>> Epoch 74 finished 	RBM Reconstruction error 5454.621166
>> Epoch 75 finished 	RBM Reconstruction error 5081.927977
>> Epoch 76 finished 	RBM Reconstruction error 4779.228654
>> Epoch 77 finished 	RBM Reconstruction error 4594.195734
>> Epoch 78 finished 	RBM Reconstruction error 4972.768652
>> Epoch 79 finished 	RBM Reconstruction error 5407.111904
>> Epoch 80 finished 	RBM Reconstruction error 5927.912836
>> Epoch 81 finished 	RBM Reconstruction error 5031.929440
>> Epoch 82 finished 	RBM Reconstruction error 5433.894786
>> Epoch 83 finished 	RBM Reconstruction error 5608.658231
>> Epoch 84 finished 	RBM Reconstruction error 6003.051286
>> Epoch 85 finished 	RBM Reconstruction error 5257.493371
>> Epoch 86 finished 	RBM Reconstruction error 5688.978465
>> Epoch 87 finished 	RBM Reconstruction error 6209.340218
>> Epoch 88 finished 	RBM Reconstruction error 5670.649579
>> Epoch 89 finished 	RBM Reconstruction error 5972.611809
>> Epoch 90 finished 	RBM Reconstruction error 5812.641327
>> Epoch 91 finished 	RBM Reconstruction error 6147.224255
>> Epoch 92 finished 	RBM Reconstruction error 5794.112667
>> Epoch 93 finished 	RBM Reconstruction error 6102.263482
>> Epoch 94 finished 	RBM Reconstruction error 5703.056267
>> Epoch 95 finished 	RBM Reconstruction error 5857.009645
>> Epoch 96 finished 	RBM Reconstruction error 5835.585732
>> Epoch 97 finished 	RBM Reconstruction error 6301.463867
>> Epoch 98 finished 	RBM Reconstruction error 6115.939311
>> Epoch 99 finished 	RBM Reconstruction error 5836.088549
>> Epoch 100 finished 	RBM Reconstruction error 6152.174322
>> Epoch 1 finished 	RBM Reconstruction error 216071.250000
>> Epoch 2 finished 	RBM Reconstruction error 233136.625000
>> Epoch 3 finished 	RBM Reconstruction error 276159.593750
>> Epoch 4 finished 	RBM Reconstruction error 292002.437500
>> Epoch 5 finished 	RBM Reconstruction error 245160.734375
>> Epoch 6 finished 	RBM Reconstruction error 256852.843750
>> Epoch 7 finished 	RBM Reconstruction error 307854.156250
>> Epoch 8 finished 	RBM Reconstruction error 347137.625000
>> Epoch 9 finished 	RBM Reconstruction error 313630.750000
>> Epoch 10 finished 	RBM Reconstruction error 319294.781250
>> Epoch 11 finished 	RBM Reconstruction error 288240.906250
>> Epoch 12 finished 	RBM Reconstruction error 323404.312500
>> Epoch 13 finished 	RBM Reconstruction error 342991.937500
>> Epoch 14 finished 	RBM Reconstruction error 362301.156250
>> Epoch 15 finished 	RBM Reconstruction error 399847.781250
>> Epoch 16 finished 	RBM Reconstruction error 422061.781250
>> Epoch 17 finished 	RBM Reconstruction error 376624.375000
>> Epoch 18 finished 	RBM Reconstruction error 395513.218750
>> Epoch 19 finished 	RBM Reconstruction error 368315.656250
>> Epoch 20 finished 	RBM Reconstruction error 406613.000000
>> Epoch 21 finished 	RBM Reconstruction error 409698.093750
>> Epoch 22 finished 	RBM Reconstruction error 434278.437500
>> Epoch 23 finished 	RBM Reconstruction error 460523.781250
>> Epoch 24 finished 	RBM Reconstruction error 434219.937500
>> Epoch 25 finished 	RBM Reconstruction error 477039.968750
>> Epoch 26 finished 	RBM Reconstruction error 460005.625000
>> Epoch 27 finished 	RBM Reconstruction error 452062.250000
>> Epoch 28 finished 	RBM Reconstruction error 458912.843750
>> Epoch 29 finished 	RBM Reconstruction error 530397.062500
>> Epoch 30 finished 	RBM Reconstruction error 480371.875000
>> Epoch 31 finished 	RBM Reconstruction error 496699.500000
>> Epoch 32 finished 	RBM Reconstruction error 492114.312500
>> Epoch 33 finished 	RBM Reconstruction error 543264.437500
>> Epoch 34 finished 	RBM Reconstruction error 570144.812500
>> Epoch 35 finished 	RBM Reconstruction error 567130.312500
>> Epoch 36 finished 	RBM Reconstruction error 553238.812500
>> Epoch 37 finished 	RBM Reconstruction error 551505.062500
>> Epoch 38 finished 	RBM Reconstruction error 579395.250000
>> Epoch 39 finished 	RBM Reconstruction error 585870.312500
>> Epoch 40 finished 	RBM Reconstruction error 563484.687500
>> Epoch 41 finished 	RBM Reconstruction error 631604.500000
>> Epoch 42 finished 	RBM Reconstruction error 602059.500000
>> Epoch 43 finished 	RBM Reconstruction error 595713.062500
>> Epoch 44 finished 	RBM Reconstruction error 673642.062500
>> Epoch 45 finished 	RBM Reconstruction error 691851.312500
>> Epoch 46 finished 	RBM Reconstruction error 677480.375000
>> Epoch 47 finished 	RBM Reconstruction error 738064.687500
>> Epoch 48 finished 	RBM Reconstruction error 692644.875000
>> Epoch 49 finished 	RBM Reconstruction error 719677.000000
>> Epoch 50 finished 	RBM Reconstruction error 734413.687500
>> Epoch 51 finished 	RBM Reconstruction error 760263.187500
>> Epoch 52 finished 	RBM Reconstruction error 778269.062500
>> Epoch 53 finished 	RBM Reconstruction error 798044.000000
>> Epoch 54 finished 	RBM Reconstruction error 843802.375000
>> Epoch 55 finished 	RBM Reconstruction error 847358.687500
>> Epoch 56 finished 	RBM Reconstruction error 845973.562500
>> Epoch 57 finished 	RBM Reconstruction error 861581.562500
>> Epoch 58 finished 	RBM Reconstruction error 862300.562500
>> Epoch 59 finished 	RBM Reconstruction error 908211.125000
>> Epoch 60 finished 	RBM Reconstruction error 865894.625000
>> Epoch 61 finished 	RBM Reconstruction error 904914.687500
>> Epoch 62 finished 	RBM Reconstruction error 942608.062500
>> Epoch 63 finished 	RBM Reconstruction error 890814.812500
>> Epoch 64 finished 	RBM Reconstruction error 861050.000000
>> Epoch 65 finished 	RBM Reconstruction error 929670.750000
>> Epoch 66 finished 	RBM Reconstruction error 986893.062500
>> Epoch 67 finished 	RBM Reconstruction error 929717.812500
>> Epoch 68 finished 	RBM Reconstruction error 1045794.437500
>> Epoch 69 finished 	RBM Reconstruction error 1045810.125000
>> Epoch 70 finished 	RBM Reconstruction error 1039579.750000
>> Epoch 71 finished 	RBM Reconstruction error 1113214.500000
>> Epoch 72 finished 	RBM Reconstruction error 1153281.125000
>> Epoch 73 finished 	RBM Reconstruction error 1179314.000000
>> Epoch 74 finished 	RBM Reconstruction error 1148430.500000
>> Epoch 75 finished 	RBM Reconstruction error 1300331.000000
>> Epoch 76 finished 	RBM Reconstruction error 1259416.875000
>> Epoch 77 finished 	RBM Reconstruction error 1195416.875000
>> Epoch 78 finished 	RBM Reconstruction error 1374692.125000
>> Epoch 79 finished 	RBM Reconstruction error 1365519.375000
>> Epoch 80 finished 	RBM Reconstruction error 1395215.500000
>> Epoch 81 finished 	RBM Reconstruction error 1462715.500000
>> Epoch 82 finished 	RBM Reconstruction error 1418552.500000
>> Epoch 83 finished 	RBM Reconstruction error 1599298.375000
>> Epoch 84 finished 	RBM Reconstruction error 1505428.000000
>> Epoch 85 finished 	RBM Reconstruction error 1514062.250000
>> Epoch 86 finished 	RBM Reconstruction error 1581803.125000
>> Epoch 87 finished 	RBM Reconstruction error 1567653.250000
>> Epoch 88 finished 	RBM Reconstruction error 1635389.125000
>> Epoch 89 finished 	RBM Reconstruction error 1612941.875000
>> Epoch 90 finished 	RBM Reconstruction error 1615753.500000
>> Epoch 91 finished 	RBM Reconstruction error 1573483.750000
>> Epoch 92 finished 	RBM Reconstruction error 1422043.250000
>> Epoch 93 finished 	RBM Reconstruction error 1439668.750000
>> Epoch 94 finished 	RBM Reconstruction error 1435441.000000
>> Epoch 95 finished 	RBM Reconstruction error 1491815.750000
>> Epoch 96 finished 	RBM Reconstruction error 1623788.125000
>> Epoch 97 finished 	RBM Reconstruction error 1716552.250000
>> Epoch 98 finished 	RBM Reconstruction error 1722061.875000
>> Epoch 99 finished 	RBM Reconstruction error 1901212.375000
>> Epoch 100 finished 	RBM Reconstruction error 1919428.500000
>> Epoch 1 finished 	RBM Reconstruction error 4680656384.000000
>> Epoch 2 finished 	RBM Reconstruction error 5179925504.000000
>> Epoch 3 finished 	RBM Reconstruction error 5866116608.000000
>> Epoch 4 finished 	RBM Reconstruction error 5189866496.000000
>> Epoch 5 finished 	RBM Reconstruction error 6224684032.000000
>> Epoch 6 finished 	RBM Reconstruction error 6344584192.000000
>> Epoch 7 finished 	RBM Reconstruction error 5948328448.000000
>> Epoch 8 finished 	RBM Reconstruction error 6891956224.000000
>> Epoch 9 finished 	RBM Reconstruction error 6409990144.000000
>> Epoch 10 finished 	RBM Reconstruction error 6278003712.000000
>> Epoch 11 finished 	RBM Reconstruction error 7150904832.000000
>> Epoch 12 finished 	RBM Reconstruction error 7025823232.000000
>> Epoch 13 finished 	RBM Reconstruction error 6299773952.000000
>> Epoch 14 finished 	RBM Reconstruction error 6506806784.000000
>> Epoch 15 finished 	RBM Reconstruction error 7747911168.000000
>> Epoch 16 finished 	RBM Reconstruction error 6405987840.000000
>> Epoch 17 finished 	RBM Reconstruction error 7130568704.000000
>> Epoch 18 finished 	RBM Reconstruction error 8019746304.000000
>> Epoch 19 finished 	RBM Reconstruction error 8013480448.000000
>> Epoch 20 finished 	RBM Reconstruction error 8855066624.000000
>> Epoch 21 finished 	RBM Reconstruction error 7919397376.000000
>> Epoch 22 finished 	RBM Reconstruction error 9327897600.000000
>> Epoch 23 finished 	RBM Reconstruction error 8319172608.000000
>> Epoch 24 finished 	RBM Reconstruction error 9380320256.000000
>> Epoch 25 finished 	RBM Reconstruction error 10649788416.000000
>> Epoch 26 finished 	RBM Reconstruction error 10546477056.000000
>> Epoch 27 finished 	RBM Reconstruction error 12917939200.000000
>> Epoch 28 finished 	RBM Reconstruction error 13459798016.000000
>> Epoch 29 finished 	RBM Reconstruction error 14016495616.000000
>> Epoch 30 finished 	RBM Reconstruction error 17814468608.000000
>> Epoch 31 finished 	RBM Reconstruction error 14324377600.000000
>> Epoch 32 finished 	RBM Reconstruction error 14098856960.000000
>> Epoch 33 finished 	RBM Reconstruction error 16688467968.000000
>> Epoch 34 finished 	RBM Reconstruction error 16550661120.000000
>> Epoch 35 finished 	RBM Reconstruction error 16545865728.000000
>> Epoch 36 finished 	RBM Reconstruction error 17163387904.000000
>> Epoch 37 finished 	RBM Reconstruction error 17899446272.000000
>> Epoch 38 finished 	RBM Reconstruction error 19807449088.000000
>> Epoch 39 finished 	RBM Reconstruction error 20552206336.000000
>> Epoch 40 finished 	RBM Reconstruction error 18901573632.000000
>> Epoch 41 finished 	RBM Reconstruction error 16951534592.000000
>> Epoch 42 finished 	RBM Reconstruction error 19878326272.000000
>> Epoch 43 finished 	RBM Reconstruction error 20364742656.000000
>> Epoch 44 finished 	RBM Reconstruction error 25432721408.000000
>> Epoch 45 finished 	RBM Reconstruction error 22447902720.000000
>> Epoch 46 finished 	RBM Reconstruction error 20590157824.000000
>> Epoch 47 finished 	RBM Reconstruction error 21387888640.000000
>> Epoch 48 finished 	RBM Reconstruction error 24876263424.000000
>> Epoch 49 finished 	RBM Reconstruction error 25567064064.000000
>> Epoch 50 finished 	RBM Reconstruction error 26121605120.000000
>> Epoch 51 finished 	RBM Reconstruction error 25691598848.000000
>> Epoch 52 finished 	RBM Reconstruction error 27130920960.000000
>> Epoch 53 finished 	RBM Reconstruction error 26914557952.000000
>> Epoch 54 finished 	RBM Reconstruction error 29931022336.000000
>> Epoch 55 finished 	RBM Reconstruction error 29538697216.000000
>> Epoch 56 finished 	RBM Reconstruction error 31584165888.000000
>> Epoch 57 finished 	RBM Reconstruction error 28775673856.000000
>> Epoch 58 finished 	RBM Reconstruction error 31071031296.000000
>> Epoch 59 finished 	RBM Reconstruction error 31407493120.000000
>> Epoch 60 finished 	RBM Reconstruction error 31426172928.000000
>> Epoch 61 finished 	RBM Reconstruction error 31189747712.000000
>> Epoch 62 finished 	RBM Reconstruction error 30455973888.000000
>> Epoch 63 finished 	RBM Reconstruction error 32766982144.000000
>> Epoch 64 finished 	RBM Reconstruction error 29462263808.000000
>> Epoch 65 finished 	RBM Reconstruction error 32008091648.000000
>> Epoch 66 finished 	RBM Reconstruction error 32694792192.000000
>> Epoch 67 finished 	RBM Reconstruction error 32112740352.000000
>> Epoch 68 finished 	RBM Reconstruction error 32643354624.000000
>> Epoch 69 finished 	RBM Reconstruction error 33204776960.000000
>> Epoch 70 finished 	RBM Reconstruction error 35013644288.000000
>> Epoch 71 finished 	RBM Reconstruction error 32659687424.000000
>> Epoch 72 finished 	RBM Reconstruction error 36096110592.000000
>> Epoch 73 finished 	RBM Reconstruction error 33262430208.000000
>> Epoch 74 finished 	RBM Reconstruction error 33500798976.000000
>> Epoch 75 finished 	RBM Reconstruction error 35386867712.000000
>> Epoch 76 finished 	RBM Reconstruction error 37326020608.000000
>> Epoch 77 finished 	RBM Reconstruction error 37357867008.000000
>> Epoch 78 finished 	RBM Reconstruction error 35569692672.000000
>> Epoch 79 finished 	RBM Reconstruction error 35357655040.000000
>> Epoch 80 finished 	RBM Reconstruction error 36383891456.000000
>> Epoch 81 finished 	RBM Reconstruction error 36663398400.000000
>> Epoch 82 finished 	RBM Reconstruction error 38677712896.000000
>> Epoch 83 finished 	RBM Reconstruction error 37774921728.000000
>> Epoch 84 finished 	RBM Reconstruction error 37939269632.000000
>> Epoch 85 finished 	RBM Reconstruction error 37528117248.000000
>> Epoch 86 finished 	RBM Reconstruction error 40509825024.000000
>> Epoch 87 finished 	RBM Reconstruction error 39205195776.000000
>> Epoch 88 finished 	RBM Reconstruction error 39209021440.000000
>> Epoch 89 finished 	RBM Reconstruction error 40025640960.000000
>> Epoch 90 finished 	RBM Reconstruction error 40109002752.000000
>> Epoch 91 finished 	RBM Reconstruction error 39665942528.000000
>> Epoch 92 finished 	RBM Reconstruction error 44480188416.000000
>> Epoch 93 finished 	RBM Reconstruction error 39811608576.000000
>> Epoch 94 finished 	RBM Reconstruction error 37722894336.000000
>> Epoch 95 finished 	RBM Reconstruction error 39330033664.000000
>> Epoch 96 finished 	RBM Reconstruction error 40181850112.000000
>> Epoch 97 finished 	RBM Reconstruction error 39665205248.000000
>> Epoch 98 finished 	RBM Reconstruction error 41943519232.000000
>> Epoch 99 finished 	RBM Reconstruction error 40941654016.000000
>> Epoch 100 finished 	RBM Reconstruction error 36606595072.000000
[END] Pre-training step
[START] Fine tuning step:
>> Epoch 0 finished 	ANN training loss nan
>> Epoch 1 finished 	ANN training loss nan
>> Epoch 2 finished 	ANN training loss nan
>> Epoch 3 finished 	ANN training loss nan
>> Epoch 4 finished 	ANN training loss nan
>> Epoch 5 finished 	ANN training loss nan
>> Epoch 6 finished 	ANN training loss nan
>> Epoch 7 finished 	ANN training loss nan
>> Epoch 8 finished 	ANN training loss nan
>> Epoch 9 finished 	ANN training loss nan
>> Epoch 10 finished 	ANN training loss nan
>> Epoch 11 finished 	ANN training loss nan
>> Epoch 12 finished 	ANN training loss nan
>> Epoch 13 finished 	ANN training loss nan
>> Epoch 14 finished 	ANN training loss nan
>> Epoch 15 finished 	ANN training loss nan
>> Epoch 16 finished 	ANN training loss nan
>> Epoch 17 finished 	ANN training loss nan
>> Epoch 18 finished 	ANN training loss nan
>> Epoch 19 finished 	ANN training loss nan
>> Epoch 20 finished 	ANN training loss nan
>> Epoch 21 finished 	ANN training loss nan
>> Epoch 22 finished 	ANN training loss nan
>> Epoch 23 finished 	ANN training loss nan
>> Epoch 24 finished 	ANN training loss nan
>> Epoch 25 finished 	ANN training loss nan
>> Epoch 26 finished 	ANN training loss nan
>> Epoch 27 finished 	ANN training loss nan
>> Epoch 28 finished 	ANN training loss nan
>> Epoch 29 finished 	ANN training loss nan
>> Epoch 30 finished 	ANN training loss nan
>> Epoch 31 finished 	ANN training loss nan
>> Epoch 32 finished 	ANN training loss nan
>> Epoch 33 finished 	ANN training loss nan
>> Epoch 34 finished 	ANN training loss nan
>> Epoch 35 finished 	ANN training loss nan
>> Epoch 36 finished 	ANN training loss nan
>> Epoch 37 finished 	ANN training loss nan
>> Epoch 38 finished 	ANN training loss nan
>> Epoch 39 finished 	ANN training loss nan
>> Epoch 40 finished 	ANN training loss nan
>> Epoch 41 finished 	ANN training loss nan
>> Epoch 42 finished 	ANN training loss nan
>> Epoch 43 finished 	ANN training loss nan
>> Epoch 44 finished 	ANN training loss nan
>> Epoch 45 finished 	ANN training loss nan
>> Epoch 46 finished 	ANN training loss nan
>> Epoch 47 finished 	ANN training loss nan
>> Epoch 48 finished 	ANN training loss nan
>> Epoch 49 finished 	ANN training loss nan
>> Epoch 50 finished 	ANN training loss nan
>> Epoch 51 finished 	ANN training loss nan
>> Epoch 52 finished 	ANN training loss nan
>> Epoch 53 finished 	ANN training loss nan
>> Epoch 54 finished 	ANN training loss nan
>> Epoch 55 finished 	ANN training loss nan
>> Epoch 56 finished 	ANN training loss nan
>> Epoch 57 finished 	ANN training loss nan
>> Epoch 58 finished 	ANN training loss nan
>> Epoch 59 finished 	ANN training loss nan
>> Epoch 60 finished 	ANN training loss nan
>> Epoch 61 finished 	ANN training loss nan
>> Epoch 62 finished 	ANN training loss nan
>> Epoch 63 finished 	ANN training loss nan
>> Epoch 64 finished 	ANN training loss nan
>> Epoch 65 finished 	ANN training loss nan
>> Epoch 66 finished 	ANN training loss nan
>> Epoch 67 finished 	ANN training loss nan
>> Epoch 68 finished 	ANN training loss nan
>> Epoch 69 finished 	ANN training loss nan
>> Epoch 70 finished 	ANN training loss nan
>> Epoch 71 finished 	ANN training loss nan
>> Epoch 72 finished 	ANN training loss nan
>> Epoch 73 finished 	ANN training loss nan
>> Epoch 74 finished 	ANN training loss nan
>> Epoch 75 finished 	ANN training loss nan
>> Epoch 76 finished 	ANN training loss nan
>> Epoch 77 finished 	ANN training loss nan
>> Epoch 78 finished 	ANN training loss nan
>> Epoch 79 finished 	ANN training loss nan
>> Epoch 80 finished 	ANN training loss nan
>> Epoch 81 finished 	ANN training loss nan
>> Epoch 82 finished 	ANN training loss nan
>> Epoch 83 finished 	ANN training loss nan
>> Epoch 84 finished 	ANN training loss nan
>> Epoch 85 finished 	ANN training loss nan
>> Epoch 86 finished 	ANN training loss nan
>> Epoch 87 finished 	ANN training loss nan
>> Epoch 88 finished 	ANN training loss nan
>> Epoch 89 finished 	ANN training loss nan
>> Epoch 90 finished 	ANN training loss nan
>> Epoch 91 finished 	ANN training loss nan
>> Epoch 92 finished 	ANN training loss nan
>> Epoch 93 finished 	ANN training loss nan
>> Epoch 94 finished 	ANN training loss nan
>> Epoch 95 finished 	ANN training loss nan
>> Epoch 96 finished 	ANN training loss nan
>> Epoch 97 finished 	ANN training loss nan
>> Epoch 98 finished 	ANN training loss nan
>> Epoch 99 finished 	ANN training loss nan
[END] Fine tuning step
Accuracy: 0.765625
/usr/local/lib/python2.7/dist-packages/sklearn/metrics/classification.py:1135: UndefinedMetricWarning: Precision and F-score are ill-defined and being set to 0.0 in labels with no predicted samples.
  'precision', 'predicted', average, warn_for)
('Precision:', 0.586181640625)
('Recall:', 0.765625)
('F1-score:', 0.66399336283185839)

PGR Status Prediction Training Process

[START] Pre-training step:
>> Epoch 1 finished 	RBM Reconstruction error 480.858131
>> Epoch 2 finished 	RBM Reconstruction error 475.990893
>> Epoch 3 finished 	RBM Reconstruction error 595.705168
>> Epoch 4 finished 	RBM Reconstruction error 468.340875
>> Epoch 5 finished 	RBM Reconstruction error 482.946044
>> Epoch 6 finished 	RBM Reconstruction error 593.353986
>> Epoch 7 finished 	RBM Reconstruction error 527.067687
>> Epoch 8 finished 	RBM Reconstruction error 606.197925
>> Epoch 9 finished 	RBM Reconstruction error 667.117175
>> Epoch 10 finished 	RBM Reconstruction error 544.609511
>> Epoch 11 finished 	RBM Reconstruction error 600.284539
>> Epoch 12 finished 	RBM Reconstruction error 687.893722
>> Epoch 13 finished 	RBM Reconstruction error 886.264072
>> Epoch 14 finished 	RBM Reconstruction error 747.757736
>> Epoch 15 finished 	RBM Reconstruction error 784.719060
>> Epoch 16 finished 	RBM Reconstruction error 981.319083
>> Epoch 17 finished 	RBM Reconstruction error 850.585552
>> Epoch 18 finished 	RBM Reconstruction error 745.779298
>> Epoch 19 finished 	RBM Reconstruction error 916.037595
>> Epoch 20 finished 	RBM Reconstruction error 888.130055
>> Epoch 21 finished 	RBM Reconstruction error 1255.190389
>> Epoch 22 finished 	RBM Reconstruction error 1006.169665
>> Epoch 23 finished 	RBM Reconstruction error 1091.857805
>> Epoch 24 finished 	RBM Reconstruction error 756.813254
>> Epoch 25 finished 	RBM Reconstruction error 1166.314528
>> Epoch 26 finished 	RBM Reconstruction error 1020.547562
>> Epoch 27 finished 	RBM Reconstruction error 977.831572
>> Epoch 28 finished 	RBM Reconstruction error 950.377967
>> Epoch 29 finished 	RBM Reconstruction error 943.373753
>> Epoch 30 finished 	RBM Reconstruction error 1101.711830
>> Epoch 31 finished 	RBM Reconstruction error 1042.218775
>> Epoch 32 finished 	RBM Reconstruction error 1023.668757
>> Epoch 33 finished 	RBM Reconstruction error 901.692038
>> Epoch 34 finished 	RBM Reconstruction error 1593.438994
>> Epoch 35 finished 	RBM Reconstruction error 1183.533154
>> Epoch 36 finished 	RBM Reconstruction error 1256.710644
>> Epoch 37 finished 	RBM Reconstruction error 1012.136664
>> Epoch 38 finished 	RBM Reconstruction error 1078.402164
>> Epoch 39 finished 	RBM Reconstruction error 1165.939986
>> Epoch 40 finished 	RBM Reconstruction error 1172.881270
>> Epoch 41 finished 	RBM Reconstruction error 1059.466026
>> Epoch 42 finished 	RBM Reconstruction error 1399.569227
>> Epoch 43 finished 	RBM Reconstruction error 1205.579539
>> Epoch 44 finished 	RBM Reconstruction error 1477.807118
>> Epoch 45 finished 	RBM Reconstruction error 858.022666
>> Epoch 46 finished 	RBM Reconstruction error 1411.084423
>> Epoch 47 finished 	RBM Reconstruction error 939.617801
>> Epoch 48 finished 	RBM Reconstruction error 1077.536078
>> Epoch 49 finished 	RBM Reconstruction error 1099.034317
>> Epoch 50 finished 	RBM Reconstruction error 770.324956
>> Epoch 51 finished 	RBM Reconstruction error 867.845372
>> Epoch 52 finished 	RBM Reconstruction error 1191.629050
>> Epoch 53 finished 	RBM Reconstruction error 1011.691263
>> Epoch 54 finished 	RBM Reconstruction error 1257.586730
>> Epoch 55 finished 	RBM Reconstruction error 1217.107629
>> Epoch 56 finished 	RBM Reconstruction error 1231.468344
>> Epoch 57 finished 	RBM Reconstruction error 1316.430463
>> Epoch 58 finished 	RBM Reconstruction error 1291.317155
>> Epoch 59 finished 	RBM Reconstruction error 1389.073824
>> Epoch 60 finished 	RBM Reconstruction error 1096.421609
>> Epoch 61 finished 	RBM Reconstruction error 1298.091445
>> Epoch 62 finished 	RBM Reconstruction error 1193.963823
>> Epoch 63 finished 	RBM Reconstruction error 942.408176
>> Epoch 64 finished 	RBM Reconstruction error 1095.377483
>> Epoch 65 finished 	RBM Reconstruction error 1094.387578
>> Epoch 66 finished 	RBM Reconstruction error 1090.955944
>> Epoch 67 finished 	RBM Reconstruction error 1347.377660
>> Epoch 68 finished 	RBM Reconstruction error 1206.617770
>> Epoch 69 finished 	RBM Reconstruction error 873.628484
>> Epoch 70 finished 	RBM Reconstruction error 1210.347025
>> Epoch 71 finished 	RBM Reconstruction error 1151.225183
>> Epoch 72 finished 	RBM Reconstruction error 1063.996470
>> Epoch 73 finished 	RBM Reconstruction error 1318.468174
>> Epoch 74 finished 	RBM Reconstruction error 1138.791861
>> Epoch 75 finished 	RBM Reconstruction error 1154.850106
>> Epoch 76 finished 	RBM Reconstruction error 1162.224507
>> Epoch 77 finished 	RBM Reconstruction error 1097.843104
>> Epoch 78 finished 	RBM Reconstruction error 1195.194167
>> Epoch 79 finished 	RBM Reconstruction error 1438.708184
>> Epoch 80 finished 	RBM Reconstruction error 1312.535214
>> Epoch 81 finished 	RBM Reconstruction error 1326.172176
>> Epoch 82 finished 	RBM Reconstruction error 1377.291195
>> Epoch 83 finished 	RBM Reconstruction error 975.380326
>> Epoch 84 finished 	RBM Reconstruction error 1371.607163
>> Epoch 85 finished 	RBM Reconstruction error 1457.953065
>> Epoch 86 finished 	RBM Reconstruction error 1208.067503
>> Epoch 87 finished 	RBM Reconstruction error 1594.483330
>> Epoch 88 finished 	RBM Reconstruction error 847.537081
>> Epoch 89 finished 	RBM Reconstruction error 1632.570294
>> Epoch 90 finished 	RBM Reconstruction error 1497.840640
>> Epoch 91 finished 	RBM Reconstruction error 1186.613664
>> Epoch 92 finished 	RBM Reconstruction error 1159.851176
>> Epoch 93 finished 	RBM Reconstruction error 1046.080265
>> Epoch 94 finished 	RBM Reconstruction error 1361.898310
>> Epoch 95 finished 	RBM Reconstruction error 1414.241634
>> Epoch 96 finished 	RBM Reconstruction error 1528.414610
>> Epoch 97 finished 	RBM Reconstruction error 1562.420152
>> Epoch 98 finished 	RBM Reconstruction error 1690.397854
>> Epoch 99 finished 	RBM Reconstruction error 1610.975093
>> Epoch 100 finished 	RBM Reconstruction error 1530.957585
>> Epoch 1 finished 	RBM Reconstruction error 249526.562500
>> Epoch 2 finished 	RBM Reconstruction error 240320.250000
>> Epoch 3 finished 	RBM Reconstruction error 207100.406250
>> Epoch 4 finished 	RBM Reconstruction error 222910.406250
>> Epoch 5 finished 	RBM Reconstruction error 196395.421875
>> Epoch 6 finished 	RBM Reconstruction error 218051.015625
>> Epoch 7 finished 	RBM Reconstruction error 207800.812500
>> Epoch 8 finished 	RBM Reconstruction error 182354.734375
>> Epoch 9 finished 	RBM Reconstruction error 201236.406250
>> Epoch 10 finished 	RBM Reconstruction error 186062.250000
>> Epoch 11 finished 	RBM Reconstruction error 190762.125000
>> Epoch 12 finished 	RBM Reconstruction error 202331.406250
>> Epoch 13 finished 	RBM Reconstruction error 188536.687500
>> Epoch 14 finished 	RBM Reconstruction error 197615.859375
>> Epoch 15 finished 	RBM Reconstruction error 207029.671875
>> Epoch 16 finished 	RBM Reconstruction error 182048.484375
>> Epoch 17 finished 	RBM Reconstruction error 191253.875000
>> Epoch 18 finished 	RBM Reconstruction error 205742.343750
>> Epoch 19 finished 	RBM Reconstruction error 207465.750000
>> Epoch 20 finished 	RBM Reconstruction error 203465.140625
>> Epoch 21 finished 	RBM Reconstruction error 182445.781250
>> Epoch 22 finished 	RBM Reconstruction error 166738.000000
>> Epoch 23 finished 	RBM Reconstruction error 182635.921875
>> Epoch 24 finished 	RBM Reconstruction error 184042.375000
>> Epoch 25 finished 	RBM Reconstruction error 184912.390625
>> Epoch 26 finished 	RBM Reconstruction error 177330.453125
>> Epoch 27 finished 	RBM Reconstruction error 179517.218750
>> Epoch 28 finished 	RBM Reconstruction error 145260.406250
>> Epoch 29 finished 	RBM Reconstruction error 201661.609375
>> Epoch 30 finished 	RBM Reconstruction error 197133.328125
>> Epoch 31 finished 	RBM Reconstruction error 216942.953125
>> Epoch 32 finished 	RBM Reconstruction error 204235.234375
>> Epoch 33 finished 	RBM Reconstruction error 180118.125000
>> Epoch 34 finished 	RBM Reconstruction error 217432.453125
>> Epoch 35 finished 	RBM Reconstruction error 199735.546875
>> Epoch 36 finished 	RBM Reconstruction error 246886.734375
>> Epoch 37 finished 	RBM Reconstruction error 291135.093750
>> Epoch 38 finished 	RBM Reconstruction error 281562.093750
>> Epoch 39 finished 	RBM Reconstruction error 273962.406250
>> Epoch 40 finished 	RBM Reconstruction error 287981.468750
>> Epoch 41 finished 	RBM Reconstruction error 341358.500000
>> Epoch 42 finished 	RBM Reconstruction error 304329.750000
>> Epoch 43 finished 	RBM Reconstruction error 278753.437500
>> Epoch 44 finished 	RBM Reconstruction error 343492.312500
>> Epoch 45 finished 	RBM Reconstruction error 320119.687500
>> Epoch 46 finished 	RBM Reconstruction error 360834.062500
>> Epoch 47 finished 	RBM Reconstruction error 354773.000000
>> Epoch 48 finished 	RBM Reconstruction error 390527.375000
>> Epoch 49 finished 	RBM Reconstruction error 347504.906250
>> Epoch 50 finished 	RBM Reconstruction error 377043.500000
>> Epoch 51 finished 	RBM Reconstruction error 360885.781250
>> Epoch 52 finished 	RBM Reconstruction error 364035.062500
>> Epoch 53 finished 	RBM Reconstruction error 378037.125000
>> Epoch 54 finished 	RBM Reconstruction error 320314.156250
>> Epoch 55 finished 	RBM Reconstruction error 354400.656250
>> Epoch 56 finished 	RBM Reconstruction error 354674.031250
>> Epoch 57 finished 	RBM Reconstruction error 351352.218750
>> Epoch 58 finished 	RBM Reconstruction error 366973.437500
>> Epoch 59 finished 	RBM Reconstruction error 375607.062500
>> Epoch 60 finished 	RBM Reconstruction error 355228.781250
>> Epoch 61 finished 	RBM Reconstruction error 399711.718750
>> Epoch 62 finished 	RBM Reconstruction error 349557.843750
>> Epoch 63 finished 	RBM Reconstruction error 365616.593750
>> Epoch 64 finished 	RBM Reconstruction error 357812.125000
>> Epoch 65 finished 	RBM Reconstruction error 370533.718750
>> Epoch 66 finished 	RBM Reconstruction error 341548.750000
>> Epoch 67 finished 	RBM Reconstruction error 367891.125000
>> Epoch 68 finished 	RBM Reconstruction error 358111.625000
>> Epoch 69 finished 	RBM Reconstruction error 361827.687500
>> Epoch 70 finished 	RBM Reconstruction error 366877.812500
>> Epoch 71 finished 	RBM Reconstruction error 392195.843750
>> Epoch 72 finished 	RBM Reconstruction error 362237.500000
>> Epoch 73 finished 	RBM Reconstruction error 377756.812500
>> Epoch 74 finished 	RBM Reconstruction error 349686.937500
>> Epoch 75 finished 	RBM Reconstruction error 353342.250000
>> Epoch 76 finished 	RBM Reconstruction error 372264.375000
>> Epoch 77 finished 	RBM Reconstruction error 359989.468750
>> Epoch 78 finished 	RBM Reconstruction error 385276.562500
>> Epoch 79 finished 	RBM Reconstruction error 388413.125000
>> Epoch 80 finished 	RBM Reconstruction error 396971.875000
>> Epoch 81 finished 	RBM Reconstruction error 363194.656250
>> Epoch 82 finished 	RBM Reconstruction error 380213.000000
>> Epoch 83 finished 	RBM Reconstruction error 349629.656250
>> Epoch 84 finished 	RBM Reconstruction error 400064.593750
>> Epoch 85 finished 	RBM Reconstruction error 371977.781250
>> Epoch 86 finished 	RBM Reconstruction error 352727.843750
>> Epoch 87 finished 	RBM Reconstruction error 347626.125000
>> Epoch 88 finished 	RBM Reconstruction error 400631.093750
>> Epoch 89 finished 	RBM Reconstruction error 355661.218750
>> Epoch 90 finished 	RBM Reconstruction error 370180.343750
>> Epoch 91 finished 	RBM Reconstruction error 360666.437500
>> Epoch 92 finished 	RBM Reconstruction error 355535.468750
>> Epoch 93 finished 	RBM Reconstruction error 362121.531250
>> Epoch 94 finished 	RBM Reconstruction error 364895.625000
>> Epoch 95 finished 	RBM Reconstruction error 392525.125000
>> Epoch 96 finished 	RBM Reconstruction error 370766.312500
>> Epoch 97 finished 	RBM Reconstruction error 376343.218750
>> Epoch 98 finished 	RBM Reconstruction error 373554.031250
>> Epoch 99 finished 	RBM Reconstruction error 397630.843750
>> Epoch 100 finished 	RBM Reconstruction error 359594.343750
>> Epoch 1 finished 	RBM Reconstruction error 173175280.000000
>> Epoch 2 finished 	RBM Reconstruction error 186625072.000000
>> Epoch 3 finished 	RBM Reconstruction error 77423168.000000
>> Epoch 4 finished 	RBM Reconstruction error 83752824.000000
>> Epoch 5 finished 	RBM Reconstruction error 75739960.000000
>> Epoch 6 finished 	RBM Reconstruction error 208903408.000000
>> Epoch 7 finished 	RBM Reconstruction error 98418592.000000
>> Epoch 8 finished 	RBM Reconstruction error 131465752.000000
>> Epoch 9 finished 	RBM Reconstruction error 106642816.000000
>> Epoch 10 finished 	RBM Reconstruction error 144229664.000000
>> Epoch 11 finished 	RBM Reconstruction error 129952192.000000
>> Epoch 12 finished 	RBM Reconstruction error 181566400.000000
>> Epoch 13 finished 	RBM Reconstruction error 106183096.000000
>> Epoch 14 finished 	RBM Reconstruction error 138970672.000000
>> Epoch 15 finished 	RBM Reconstruction error 193874928.000000
>> Epoch 16 finished 	RBM Reconstruction error 114838800.000000
>> Epoch 17 finished 	RBM Reconstruction error 140205280.000000
>> Epoch 18 finished 	RBM Reconstruction error 153466736.000000
>> Epoch 19 finished 	RBM Reconstruction error 175540256.000000
>> Epoch 20 finished 	RBM Reconstruction error 271070144.000000
>> Epoch 21 finished 	RBM Reconstruction error 133108240.000000
>> Epoch 22 finished 	RBM Reconstruction error 185119392.000000
>> Epoch 23 finished 	RBM Reconstruction error 180062816.000000
>> Epoch 24 finished 	RBM Reconstruction error 139471856.000000
>> Epoch 25 finished 	RBM Reconstruction error 104258504.000000
>> Epoch 26 finished 	RBM Reconstruction error 149033168.000000
>> Epoch 27 finished 	RBM Reconstruction error 105183736.000000
>> Epoch 28 finished 	RBM Reconstruction error 188354016.000000
>> Epoch 29 finished 	RBM Reconstruction error 138996720.000000
>> Epoch 30 finished 	RBM Reconstruction error 159945616.000000
>> Epoch 31 finished 	RBM Reconstruction error 122006880.000000
>> Epoch 32 finished 	RBM Reconstruction error 126901344.000000
>> Epoch 33 finished 	RBM Reconstruction error 140449088.000000
>> Epoch 34 finished 	RBM Reconstruction error 151331392.000000
>> Epoch 35 finished 	RBM Reconstruction error 137239712.000000
>> Epoch 36 finished 	RBM Reconstruction error 148391280.000000
>> Epoch 37 finished 	RBM Reconstruction error 102749336.000000
>> Epoch 38 finished 	RBM Reconstruction error 60488916.000000
>> Epoch 39 finished 	RBM Reconstruction error 118092272.000000
>> Epoch 40 finished 	RBM Reconstruction error 149853824.000000
>> Epoch 41 finished 	RBM Reconstruction error 165027376.000000
>> Epoch 42 finished 	RBM Reconstruction error 174479552.000000
>> Epoch 43 finished 	RBM Reconstruction error 123439408.000000
>> Epoch 44 finished 	RBM Reconstruction error 187484144.000000
>> Epoch 45 finished 	RBM Reconstruction error 165385312.000000
>> Epoch 46 finished 	RBM Reconstruction error 190782624.000000
>> Epoch 47 finished 	RBM Reconstruction error 190348864.000000
>> Epoch 48 finished 	RBM Reconstruction error 159560496.000000
>> Epoch 49 finished 	RBM Reconstruction error 136270896.000000
>> Epoch 50 finished 	RBM Reconstruction error 240273568.000000
>> Epoch 51 finished 	RBM Reconstruction error 121814304.000000
>> Epoch 52 finished 	RBM Reconstruction error 150963984.000000
>> Epoch 53 finished 	RBM Reconstruction error 116090944.000000
>> Epoch 54 finished 	RBM Reconstruction error 189231648.000000
>> Epoch 55 finished 	RBM Reconstruction error 187812016.000000
>> Epoch 56 finished 	RBM Reconstruction error 163351120.000000
>> Epoch 57 finished 	RBM Reconstruction error 169142048.000000
>> Epoch 58 finished 	RBM Reconstruction error 162192736.000000
>> Epoch 59 finished 	RBM Reconstruction error 181361088.000000
>> Epoch 60 finished 	RBM Reconstruction error 134011944.000000
>> Epoch 61 finished 	RBM Reconstruction error 216614688.000000
>> Epoch 62 finished 	RBM Reconstruction error 140163680.000000
>> Epoch 63 finished 	RBM Reconstruction error 204023296.000000
>> Epoch 64 finished 	RBM Reconstruction error 128965616.000000
>> Epoch 65 finished 	RBM Reconstruction error 117558528.000000
>> Epoch 66 finished 	RBM Reconstruction error 181742208.000000
>> Epoch 67 finished 	RBM Reconstruction error 171155632.000000
>> Epoch 68 finished 	RBM Reconstruction error 98654728.000000
>> Epoch 69 finished 	RBM Reconstruction error 231918224.000000
>> Epoch 70 finished 	RBM Reconstruction error 99281256.000000
>> Epoch 71 finished 	RBM Reconstruction error 183225616.000000
>> Epoch 72 finished 	RBM Reconstruction error 148785744.000000
>> Epoch 73 finished 	RBM Reconstruction error 169414160.000000
>> Epoch 74 finished 	RBM Reconstruction error 129026376.000000
>> Epoch 75 finished 	RBM Reconstruction error 102978216.000000
>> Epoch 76 finished 	RBM Reconstruction error 176341200.000000
>> Epoch 77 finished 	RBM Reconstruction error 143938048.000000
>> Epoch 78 finished 	RBM Reconstruction error 207341600.000000
>> Epoch 79 finished 	RBM Reconstruction error 133614176.000000
>> Epoch 80 finished 	RBM Reconstruction error 121829368.000000
>> Epoch 81 finished 	RBM Reconstruction error 106650032.000000
>> Epoch 82 finished 	RBM Reconstruction error 193545408.000000
>> Epoch 83 finished 	RBM Reconstruction error 144157888.000000
>> Epoch 84 finished 	RBM Reconstruction error 194588096.000000
>> Epoch 85 finished 	RBM Reconstruction error 168043280.000000
>> Epoch 86 finished 	RBM Reconstruction error 136130784.000000
>> Epoch 87 finished 	RBM Reconstruction error 144822432.000000
>> Epoch 88 finished 	RBM Reconstruction error 136828960.000000
>> Epoch 89 finished 	RBM Reconstruction error 168108688.000000
>> Epoch 90 finished 	RBM Reconstruction error 126202416.000000
>> Epoch 91 finished 	RBM Reconstruction error 145947152.000000
>> Epoch 92 finished 	RBM Reconstruction error 186921600.000000
>> Epoch 93 finished 	RBM Reconstruction error 121149784.000000
>> Epoch 94 finished 	RBM Reconstruction error 133704824.000000
>> Epoch 95 finished 	RBM Reconstruction error 147880768.000000
>> Epoch 96 finished 	RBM Reconstruction error 157815728.000000
>> Epoch 97 finished 	RBM Reconstruction error 196504320.000000
>> Epoch 98 finished 	RBM Reconstruction error 134977792.000000
>> Epoch 99 finished 	RBM Reconstruction error 127531640.000000
>> Epoch 100 finished 	RBM Reconstruction error 160958336.000000
[END] Pre-training step
[START] Fine tuning step:
>> Epoch 0 finished 	ANN training loss nan
>> Epoch 1 finished 	ANN training loss nan
>> Epoch 2 finished 	ANN training loss nan
>> Epoch 3 finished 	ANN training loss nan
>> Epoch 4 finished 	ANN training loss nan
>> Epoch 5 finished 	ANN training loss nan
>> Epoch 6 finished 	ANN training loss nan
>> Epoch 7 finished 	ANN training loss nan
>> Epoch 8 finished 	ANN training loss nan
>> Epoch 9 finished 	ANN training loss nan
>> Epoch 10 finished 	ANN training loss nan
>> Epoch 11 finished 	ANN training loss nan
>> Epoch 12 finished 	ANN training loss nan
>> Epoch 13 finished 	ANN training loss nan
>> Epoch 14 finished 	ANN training loss nan
>> Epoch 15 finished 	ANN training loss nan
>> Epoch 16 finished 	ANN training loss nan
>> Epoch 17 finished 	ANN training loss nan
>> Epoch 18 finished 	ANN training loss nan
>> Epoch 19 finished 	ANN training loss nan
>> Epoch 20 finished 	ANN training loss nan
>> Epoch 21 finished 	ANN training loss nan
>> Epoch 22 finished 	ANN training loss nan
>> Epoch 23 finished 	ANN training loss nan
>> Epoch 24 finished 	ANN training loss nan
>> Epoch 25 finished 	ANN training loss nan
>> Epoch 26 finished 	ANN training loss nan
>> Epoch 27 finished 	ANN training loss nan
>> Epoch 28 finished 	ANN training loss nan
>> Epoch 29 finished 	ANN training loss nan
>> Epoch 30 finished 	ANN training loss nan
>> Epoch 31 finished 	ANN training loss nan
>> Epoch 32 finished 	ANN training loss nan
>> Epoch 33 finished 	ANN training loss nan
>> Epoch 34 finished 	ANN training loss nan
>> Epoch 35 finished 	ANN training loss nan
>> Epoch 36 finished 	ANN training loss nan
>> Epoch 37 finished 	ANN training loss nan
>> Epoch 38 finished 	ANN training loss nan
>> Epoch 39 finished 	ANN training loss nan
>> Epoch 40 finished 	ANN training loss nan
>> Epoch 41 finished 	ANN training loss nan
>> Epoch 42 finished 	ANN training loss nan
>> Epoch 43 finished 	ANN training loss nan
>> Epoch 44 finished 	ANN training loss nan
>> Epoch 45 finished 	ANN training loss nan
>> Epoch 46 finished 	ANN training loss nan
>> Epoch 47 finished 	ANN training loss nan
>> Epoch 48 finished 	ANN training loss nan
>> Epoch 49 finished 	ANN training loss nan
>> Epoch 50 finished 	ANN training loss nan
>> Epoch 51 finished 	ANN training loss nan
>> Epoch 52 finished 	ANN training loss nan
>> Epoch 53 finished 	ANN training loss nan
>> Epoch 54 finished 	ANN training loss nan
>> Epoch 55 finished 	ANN training loss nan
>> Epoch 56 finished 	ANN training loss nan
>> Epoch 57 finished 	ANN training loss nan
>> Epoch 58 finished 	ANN training loss nan
>> Epoch 59 finished 	ANN training loss nan
>> Epoch 60 finished 	ANN training loss nan
>> Epoch 61 finished 	ANN training loss nan
>> Epoch 62 finished 	ANN training loss nan
>> Epoch 63 finished 	ANN training loss nan
>> Epoch 64 finished 	ANN training loss nan
>> Epoch 65 finished 	ANN training loss nan
>> Epoch 66 finished 	ANN training loss nan
>> Epoch 67 finished 	ANN training loss nan
>> Epoch 68 finished 	ANN training loss nan
>> Epoch 69 finished 	ANN training loss nan
>> Epoch 70 finished 	ANN training loss nan
>> Epoch 71 finished 	ANN training loss nan
>> Epoch 72 finished 	ANN training loss nan
>> Epoch 73 finished 	ANN training loss nan
>> Epoch 74 finished 	ANN training loss nan
>> Epoch 75 finished 	ANN training loss nan
>> Epoch 76 finished 	ANN training loss nan
>> Epoch 77 finished 	ANN training loss nan
>> Epoch 78 finished 	ANN training loss nan
>> Epoch 79 finished 	ANN training loss nan
>> Epoch 80 finished 	ANN training loss nan
>> Epoch 81 finished 	ANN training loss nan
>> Epoch 82 finished 	ANN training loss nan
>> Epoch 83 finished 	ANN training loss nan
>> Epoch 84 finished 	ANN training loss nan
>> Epoch 85 finished 	ANN training loss nan
>> Epoch 86 finished 	ANN training loss nan
>> Epoch 87 finished 	ANN training loss nan
>> Epoch 88 finished 	ANN training loss nan
>> Epoch 89 finished 	ANN training loss nan
>> Epoch 90 finished 	ANN training loss nan
>> Epoch 91 finished 	ANN training loss nan
>> Epoch 92 finished 	ANN training loss nan
>> Epoch 93 finished 	ANN training loss nan
>> Epoch 94 finished 	ANN training loss nan
>> Epoch 95 finished 	ANN training loss nan
>> Epoch 96 finished 	ANN training loss nan
>> Epoch 97 finished 	ANN training loss nan
>> Epoch 98 finished 	ANN training loss nan
>> Epoch 99 finished 	ANN training loss nan
[END] Fine tuning step
Accuracy: 0.667969
('Precision:', 0.4461822509765625)
('Recall:', 0.66796875)
('F1-score:', 0.53500073185011709)

HER2 Status Prediction Training Process

[START] Pre-training step:
>> Epoch 1 finished 	RBM Reconstruction error 391.041799
>> Epoch 2 finished 	RBM Reconstruction error 836.992488
>> Epoch 3 finished 	RBM Reconstruction error 632.966773
>> Epoch 4 finished 	RBM Reconstruction error 572.549347
>> Epoch 5 finished 	RBM Reconstruction error 338.383595
>> Epoch 6 finished 	RBM Reconstruction error 836.357271
>> Epoch 7 finished 	RBM Reconstruction error 795.105415
>> Epoch 8 finished 	RBM Reconstruction error 989.695615
>> Epoch 9 finished 	RBM Reconstruction error 864.829614
>> Epoch 10 finished 	RBM Reconstruction error 872.963478
>> Epoch 11 finished 	RBM Reconstruction error 1198.825164
>> Epoch 12 finished 	RBM Reconstruction error 719.403872
>> Epoch 13 finished 	RBM Reconstruction error 981.983446
>> Epoch 14 finished 	RBM Reconstruction error 1173.332803
>> Epoch 15 finished 	RBM Reconstruction error 764.705328
>> Epoch 16 finished 	RBM Reconstruction error 726.393616
>> Epoch 17 finished 	RBM Reconstruction error 829.274412
>> Epoch 18 finished 	RBM Reconstruction error 1062.964355
>> Epoch 19 finished 	RBM Reconstruction error 1117.590085
>> Epoch 20 finished 	RBM Reconstruction error 1270.774916
>> Epoch 21 finished 	RBM Reconstruction error 1059.570061
>> Epoch 22 finished 	RBM Reconstruction error 1178.382208
>> Epoch 23 finished 	RBM Reconstruction error 1489.696917
>> Epoch 24 finished 	RBM Reconstruction error 1192.876394
>> Epoch 25 finished 	RBM Reconstruction error 1232.788625
>> Epoch 26 finished 	RBM Reconstruction error 1268.417593
>> Epoch 27 finished 	RBM Reconstruction error 1599.620834
>> Epoch 28 finished 	RBM Reconstruction error 1335.013683
>> Epoch 29 finished 	RBM Reconstruction error 1500.666417
>> Epoch 30 finished 	RBM Reconstruction error 1308.927112
>> Epoch 31 finished 	RBM Reconstruction error 1445.243606
>> Epoch 32 finished 	RBM Reconstruction error 1185.648919
>> Epoch 33 finished 	RBM Reconstruction error 1215.791123
>> Epoch 34 finished 	RBM Reconstruction error 1543.124894
>> Epoch 35 finished 	RBM Reconstruction error 1375.660463
>> Epoch 36 finished 	RBM Reconstruction error 1460.727143
>> Epoch 37 finished 	RBM Reconstruction error 1189.873212
>> Epoch 38 finished 	RBM Reconstruction error 1610.197952
>> Epoch 39 finished 	RBM Reconstruction error 1587.009274
>> Epoch 40 finished 	RBM Reconstruction error 1402.253302
>> Epoch 41 finished 	RBM Reconstruction error 1320.404228
>> Epoch 42 finished 	RBM Reconstruction error 1551.072443
>> Epoch 43 finished 	RBM Reconstruction error 1195.289399
>> Epoch 44 finished 	RBM Reconstruction error 1608.566582
>> Epoch 45 finished 	RBM Reconstruction error 1786.748977
>> Epoch 46 finished 	RBM Reconstruction error 1554.621400
>> Epoch 47 finished 	RBM Reconstruction error 1401.916765
>> Epoch 48 finished 	RBM Reconstruction error 1517.436305
>> Epoch 49 finished 	RBM Reconstruction error 1450.122347
>> Epoch 50 finished 	RBM Reconstruction error 1734.190330
>> Epoch 51 finished 	RBM Reconstruction error 1425.148792
>> Epoch 52 finished 	RBM Reconstruction error 1590.987185
>> Epoch 53 finished 	RBM Reconstruction error 1224.109308
>> Epoch 54 finished 	RBM Reconstruction error 1404.310113
>> Epoch 55 finished 	RBM Reconstruction error 1399.283936
>> Epoch 56 finished 	RBM Reconstruction error 1258.599113
>> Epoch 57 finished 	RBM Reconstruction error 1247.421931
>> Epoch 58 finished 	RBM Reconstruction error 1491.717281
>> Epoch 59 finished 	RBM Reconstruction error 1321.978694
>> Epoch 60 finished 	RBM Reconstruction error 1929.157908
>> Epoch 61 finished 	RBM Reconstruction error 1486.515236
>> Epoch 62 finished 	RBM Reconstruction error 1780.200979
>> Epoch 63 finished 	RBM Reconstruction error 1221.426241
>> Epoch 64 finished 	RBM Reconstruction error 1530.065918
>> Epoch 65 finished 	RBM Reconstruction error 1109.547624
>> Epoch 66 finished 	RBM Reconstruction error 1606.467603
>> Epoch 67 finished 	RBM Reconstruction error 1923.635445
>> Epoch 68 finished 	RBM Reconstruction error 1348.333759
>> Epoch 69 finished 	RBM Reconstruction error 1690.230987
>> Epoch 70 finished 	RBM Reconstruction error 1717.222154
>> Epoch 71 finished 	RBM Reconstruction error 1219.883141
>> Epoch 72 finished 	RBM Reconstruction error 1761.149067
>> Epoch 73 finished 	RBM Reconstruction error 1768.113922
>> Epoch 74 finished 	RBM Reconstruction error 1531.803721
>> Epoch 75 finished 	RBM Reconstruction error 1636.294888
>> Epoch 76 finished 	RBM Reconstruction error 1758.676022
>> Epoch 77 finished 	RBM Reconstruction error 1496.939755
>> Epoch 78 finished 	RBM Reconstruction error 1595.798183
>> Epoch 79 finished 	RBM Reconstruction error 1213.483171
>> Epoch 80 finished 	RBM Reconstruction error 1687.227918
>> Epoch 81 finished 	RBM Reconstruction error 1737.733401
>> Epoch 82 finished 	RBM Reconstruction error 1673.097790
>> Epoch 83 finished 	RBM Reconstruction error 1307.442304
>> Epoch 84 finished 	RBM Reconstruction error 1458.769704
>> Epoch 85 finished 	RBM Reconstruction error 1686.048735
>> Epoch 86 finished 	RBM Reconstruction error 1804.750127
>> Epoch 87 finished 	RBM Reconstruction error 1843.344081
>> Epoch 88 finished 	RBM Reconstruction error 1511.631251
>> Epoch 89 finished 	RBM Reconstruction error 1873.424817
>> Epoch 90 finished 	RBM Reconstruction error 2250.137557
>> Epoch 91 finished 	RBM Reconstruction error 1248.868310
>> Epoch 92 finished 	RBM Reconstruction error 1433.828309
>> Epoch 93 finished 	RBM Reconstruction error 1532.235885
>> Epoch 94 finished 	RBM Reconstruction error 1683.603889
>> Epoch 95 finished 	RBM Reconstruction error 1368.538581
>> Epoch 96 finished 	RBM Reconstruction error 1566.628533
>> Epoch 97 finished 	RBM Reconstruction error 1677.755037
>> Epoch 98 finished 	RBM Reconstruction error 2088.580852
>> Epoch 99 finished 	RBM Reconstruction error 1429.825570
>> Epoch 100 finished 	RBM Reconstruction error 1834.596220
>> Epoch 1 finished 	RBM Reconstruction error 457209.718750
>> Epoch 2 finished 	RBM Reconstruction error 475342.875000
>> Epoch 3 finished 	RBM Reconstruction error 462489.375000
>> Epoch 4 finished 	RBM Reconstruction error 436867.437500
>> Epoch 5 finished 	RBM Reconstruction error 449336.375000
>> Epoch 6 finished 	RBM Reconstruction error 440305.937500
>> Epoch 7 finished 	RBM Reconstruction error 439094.000000
>> Epoch 8 finished 	RBM Reconstruction error 440644.625000
>> Epoch 9 finished 	RBM Reconstruction error 448267.500000
>> Epoch 10 finished 	RBM Reconstruction error 450478.843750
>> Epoch 11 finished 	RBM Reconstruction error 447858.375000
>> Epoch 12 finished 	RBM Reconstruction error 418829.531250
>> Epoch 13 finished 	RBM Reconstruction error 457611.718750
>> Epoch 14 finished 	RBM Reconstruction error 406926.843750
>> Epoch 15 finished 	RBM Reconstruction error 382433.000000
>> Epoch 16 finished 	RBM Reconstruction error 395434.250000
>> Epoch 17 finished 	RBM Reconstruction error 449517.250000
>> Epoch 18 finished 	RBM Reconstruction error 412531.500000
>> Epoch 19 finished 	RBM Reconstruction error 395184.968750
>> Epoch 20 finished 	RBM Reconstruction error 404467.312500
>> Epoch 21 finished 	RBM Reconstruction error 432343.562500
>> Epoch 22 finished 	RBM Reconstruction error 384022.218750
>> Epoch 23 finished 	RBM Reconstruction error 406223.312500
>> Epoch 24 finished 	RBM Reconstruction error 379427.250000
>> Epoch 25 finished 	RBM Reconstruction error 446107.187500
>> Epoch 26 finished 	RBM Reconstruction error 423645.468750
>> Epoch 27 finished 	RBM Reconstruction error 441651.875000
>> Epoch 28 finished 	RBM Reconstruction error 375949.312500
>> Epoch 29 finished 	RBM Reconstruction error 347677.031250
>> Epoch 30 finished 	RBM Reconstruction error 370356.000000
>> Epoch 31 finished 	RBM Reconstruction error 375599.406250
>> Epoch 32 finished 	RBM Reconstruction error 384416.343750
>> Epoch 33 finished 	RBM Reconstruction error 396539.031250
>> Epoch 34 finished 	RBM Reconstruction error 334129.781250
>> Epoch 35 finished 	RBM Reconstruction error 417064.187500
>> Epoch 36 finished 	RBM Reconstruction error 324148.312500
>> Epoch 37 finished 	RBM Reconstruction error 354066.468750
>> Epoch 38 finished 	RBM Reconstruction error 368629.843750
>> Epoch 39 finished 	RBM Reconstruction error 331601.875000
>> Epoch 40 finished 	RBM Reconstruction error 410821.906250
>> Epoch 41 finished 	RBM Reconstruction error 372469.906250
>> Epoch 42 finished 	RBM Reconstruction error 371695.625000
>> Epoch 43 finished 	RBM Reconstruction error 364277.531250
>> Epoch 44 finished 	RBM Reconstruction error 393492.125000
>> Epoch 45 finished 	RBM Reconstruction error 363396.281250
>> Epoch 46 finished 	RBM Reconstruction error 365553.031250
>> Epoch 47 finished 	RBM Reconstruction error 363640.750000
>> Epoch 48 finished 	RBM Reconstruction error 381319.156250
>> Epoch 49 finished 	RBM Reconstruction error 408099.781250
>> Epoch 50 finished 	RBM Reconstruction error 401197.125000
>> Epoch 51 finished 	RBM Reconstruction error 358095.625000
>> Epoch 52 finished 	RBM Reconstruction error 352033.687500
>> Epoch 53 finished 	RBM Reconstruction error 372000.750000
>> Epoch 54 finished 	RBM Reconstruction error 367690.062500
>> Epoch 55 finished 	RBM Reconstruction error 351572.593750
>> Epoch 56 finished 	RBM Reconstruction error 359999.906250
>> Epoch 57 finished 	RBM Reconstruction error 322457.843750
>> Epoch 58 finished 	RBM Reconstruction error 352775.000000
>> Epoch 59 finished 	RBM Reconstruction error 345199.781250
>> Epoch 60 finished 	RBM Reconstruction error 350719.000000
>> Epoch 61 finished 	RBM Reconstruction error 363407.000000
>> Epoch 62 finished 	RBM Reconstruction error 332529.500000
>> Epoch 63 finished 	RBM Reconstruction error 360640.000000
>> Epoch 64 finished 	RBM Reconstruction error 375224.656250
>> Epoch 65 finished 	RBM Reconstruction error 345507.437500
>> Epoch 66 finished 	RBM Reconstruction error 368545.718750
>> Epoch 67 finished 	RBM Reconstruction error 395074.593750
>> Epoch 68 finished 	RBM Reconstruction error 354494.843750
>> Epoch 69 finished 	RBM Reconstruction error 378691.718750
>> Epoch 70 finished 	RBM Reconstruction error 350964.906250
>> Epoch 71 finished 	RBM Reconstruction error 367548.625000
>> Epoch 72 finished 	RBM Reconstruction error 369028.062500
>> Epoch 73 finished 	RBM Reconstruction error 322242.187500
>> Epoch 74 finished 	RBM Reconstruction error 319860.843750
>> Epoch 75 finished 	RBM Reconstruction error 329601.781250
>> Epoch 76 finished 	RBM Reconstruction error 344696.281250
>> Epoch 77 finished 	RBM Reconstruction error 337365.375000
>> Epoch 78 finished 	RBM Reconstruction error 361459.218750
>> Epoch 79 finished 	RBM Reconstruction error 308881.875000
>> Epoch 80 finished 	RBM Reconstruction error 375449.718750
>> Epoch 81 finished 	RBM Reconstruction error 367820.156250
>> Epoch 82 finished 	RBM Reconstruction error 399296.843750
>> Epoch 83 finished 	RBM Reconstruction error 404589.218750
>> Epoch 84 finished 	RBM Reconstruction error 349613.750000
>> Epoch 85 finished 	RBM Reconstruction error 319761.843750
>> Epoch 86 finished 	RBM Reconstruction error 344802.718750
>> Epoch 87 finished 	RBM Reconstruction error 341569.843750
>> Epoch 88 finished 	RBM Reconstruction error 353897.937500
>> Epoch 89 finished 	RBM Reconstruction error 337118.000000
>> Epoch 90 finished 	RBM Reconstruction error 337673.031250
>> Epoch 91 finished 	RBM Reconstruction error 337227.218750
>> Epoch 92 finished 	RBM Reconstruction error 333530.312500
>> Epoch 93 finished 	RBM Reconstruction error 302831.656250
>> Epoch 94 finished 	RBM Reconstruction error 342368.625000
>> Epoch 95 finished 	RBM Reconstruction error 376949.687500
>> Epoch 96 finished 	RBM Reconstruction error 364689.656250
>> Epoch 97 finished 	RBM Reconstruction error 329944.843750
>> Epoch 98 finished 	RBM Reconstruction error 353993.812500
>> Epoch 99 finished 	RBM Reconstruction error 359132.875000
>> Epoch 100 finished 	RBM Reconstruction error 328207.781250
>> Epoch 1 finished 	RBM Reconstruction error 400769536.000000
>> Epoch 2 finished 	RBM Reconstruction error 384501472.000000
>> Epoch 3 finished 	RBM Reconstruction error 304003040.000000
>> Epoch 4 finished 	RBM Reconstruction error 419143200.000000
>> Epoch 5 finished 	RBM Reconstruction error 459158400.000000
>> Epoch 6 finished 	RBM Reconstruction error 409628960.000000
>> Epoch 7 finished 	RBM Reconstruction error 398964672.000000
>> Epoch 8 finished 	RBM Reconstruction error 379164448.000000
>> Epoch 9 finished 	RBM Reconstruction error 461463200.000000
>> Epoch 10 finished 	RBM Reconstruction error 296874176.000000
>> Epoch 11 finished 	RBM Reconstruction error 460116640.000000
>> Epoch 12 finished 	RBM Reconstruction error 282294016.000000
>> Epoch 13 finished 	RBM Reconstruction error 394125728.000000
>> Epoch 14 finished 	RBM Reconstruction error 448361376.000000
>> Epoch 15 finished 	RBM Reconstruction error 546913600.000000
>> Epoch 16 finished 	RBM Reconstruction error 490640096.000000
>> Epoch 17 finished 	RBM Reconstruction error 437147296.000000
>> Epoch 18 finished 	RBM Reconstruction error 416528704.000000
>> Epoch 19 finished 	RBM Reconstruction error 465755520.000000
>> Epoch 20 finished 	RBM Reconstruction error 349163168.000000
>> Epoch 21 finished 	RBM Reconstruction error 394048192.000000
>> Epoch 22 finished 	RBM Reconstruction error 307932960.000000
>> Epoch 23 finished 	RBM Reconstruction error 397749984.000000
>> Epoch 24 finished 	RBM Reconstruction error 402156704.000000
>> Epoch 25 finished 	RBM Reconstruction error 392049888.000000
>> Epoch 26 finished 	RBM Reconstruction error 486453792.000000
>> Epoch 27 finished 	RBM Reconstruction error 562074368.000000
>> Epoch 28 finished 	RBM Reconstruction error 426993120.000000
>> Epoch 29 finished 	RBM Reconstruction error 303145248.000000
>> Epoch 30 finished 	RBM Reconstruction error 370345728.000000
>> Epoch 31 finished 	RBM Reconstruction error 421717728.000000
>> Epoch 32 finished 	RBM Reconstruction error 410583520.000000
>> Epoch 33 finished 	RBM Reconstruction error 281443776.000000
>> Epoch 34 finished 	RBM Reconstruction error 343833280.000000
>> Epoch 35 finished 	RBM Reconstruction error 475159008.000000
>> Epoch 36 finished 	RBM Reconstruction error 371574848.000000
>> Epoch 37 finished 	RBM Reconstruction error 401635104.000000
>> Epoch 38 finished 	RBM Reconstruction error 459360288.000000
>> Epoch 39 finished 	RBM Reconstruction error 280228480.000000
>> Epoch 40 finished 	RBM Reconstruction error 423822784.000000
>> Epoch 41 finished 	RBM Reconstruction error 343505664.000000
>> Epoch 42 finished 	RBM Reconstruction error 313878144.000000
>> Epoch 43 finished 	RBM Reconstruction error 383729824.000000
>> Epoch 44 finished 	RBM Reconstruction error 414149952.000000
>> Epoch 45 finished 	RBM Reconstruction error 314567264.000000
>> Epoch 46 finished 	RBM Reconstruction error 348002496.000000
>> Epoch 47 finished 	RBM Reconstruction error 406593152.000000
>> Epoch 48 finished 	RBM Reconstruction error 302710208.000000
>> Epoch 49 finished 	RBM Reconstruction error 463260512.000000
>> Epoch 50 finished 	RBM Reconstruction error 364430560.000000
>> Epoch 51 finished 	RBM Reconstruction error 380163680.000000
>> Epoch 52 finished 	RBM Reconstruction error 353214624.000000
>> Epoch 53 finished 	RBM Reconstruction error 407592800.000000
>> Epoch 54 finished 	RBM Reconstruction error 437139488.000000
>> Epoch 55 finished 	RBM Reconstruction error 441037760.000000
>> Epoch 56 finished 	RBM Reconstruction error 374994688.000000
>> Epoch 57 finished 	RBM Reconstruction error 418045760.000000
>> Epoch 58 finished 	RBM Reconstruction error 441456320.000000
>> Epoch 59 finished 	RBM Reconstruction error 476429824.000000
>> Epoch 60 finished 	RBM Reconstruction error 424827552.000000
>> Epoch 61 finished 	RBM Reconstruction error 398968096.000000
>> Epoch 62 finished 	RBM Reconstruction error 370473056.000000
>> Epoch 63 finished 	RBM Reconstruction error 417999168.000000
>> Epoch 64 finished 	RBM Reconstruction error 357629088.000000
>> Epoch 65 finished 	RBM Reconstruction error 513870400.000000
>> Epoch 66 finished 	RBM Reconstruction error 398774560.000000
>> Epoch 67 finished 	RBM Reconstruction error 400167552.000000
>> Epoch 68 finished 	RBM Reconstruction error 401800352.000000
>> Epoch 69 finished 	RBM Reconstruction error 432906688.000000
>> Epoch 70 finished 	RBM Reconstruction error 463159424.000000
>> Epoch 71 finished 	RBM Reconstruction error 332045088.000000
>> Epoch 72 finished 	RBM Reconstruction error 405844832.000000
>> Epoch 73 finished 	RBM Reconstruction error 404515584.000000
>> Epoch 74 finished 	RBM Reconstruction error 412211296.000000
>> Epoch 75 finished 	RBM Reconstruction error 426515712.000000
>> Epoch 76 finished 	RBM Reconstruction error 319491552.000000
>> Epoch 77 finished 	RBM Reconstruction error 486785088.000000
>> Epoch 78 finished 	RBM Reconstruction error 382348704.000000
>> Epoch 79 finished 	RBM Reconstruction error 393885920.000000
>> Epoch 80 finished 	RBM Reconstruction error 293220032.000000
>> Epoch 81 finished 	RBM Reconstruction error 411667744.000000
>> Epoch 82 finished 	RBM Reconstruction error 438171744.000000
>> Epoch 83 finished 	RBM Reconstruction error 387446528.000000
>> Epoch 84 finished 	RBM Reconstruction error 416017824.000000
>> Epoch 85 finished 	RBM Reconstruction error 334594976.000000
>> Epoch 86 finished 	RBM Reconstruction error 441138336.000000
>> Epoch 87 finished 	RBM Reconstruction error 314486176.000000
>> Epoch 88 finished 	RBM Reconstruction error 343434528.000000
>> Epoch 89 finished 	RBM Reconstruction error 415971456.000000
>> Epoch 90 finished 	RBM Reconstruction error 465823040.000000
>> Epoch 91 finished 	RBM Reconstruction error 257311872.000000
>> Epoch 92 finished 	RBM Reconstruction error 335770656.000000
>> Epoch 93 finished 	RBM Reconstruction error 531259968.000000
>> Epoch 94 finished 	RBM Reconstruction error 452077888.000000
>> Epoch 95 finished 	RBM Reconstruction error 436101152.000000
>> Epoch 96 finished 	RBM Reconstruction error 534076928.000000
>> Epoch 97 finished 	RBM Reconstruction error 462081312.000000
>> Epoch 98 finished 	RBM Reconstruction error 419411840.000000
>> Epoch 99 finished 	RBM Reconstruction error 314816128.000000
>> Epoch 100 finished 	RBM Reconstruction error 401139840.000000
[END] Pre-training step
[START] Fine tuning step:
>> Epoch 0 finished 	ANN training loss 1.100916
>> Epoch 1 finished 	ANN training loss 1.003201
>> Epoch 2 finished 	ANN training loss 0.987071
>> Epoch 3 finished 	ANN training loss 0.975448
>> Epoch 4 finished 	ANN training loss 0.976615
>> Epoch 5 finished 	ANN training loss 0.982543
>> Epoch 6 finished 	ANN training loss 0.973516
>> Epoch 7 finished 	ANN training loss 0.979670
>> Epoch 8 finished 	ANN training loss 0.973199
>> Epoch 9 finished 	ANN training loss 0.977416
>> Epoch 10 finished 	ANN training loss 0.974117
>> Epoch 11 finished 	ANN training loss 0.977245
>> Epoch 12 finished 	ANN training loss 0.972543
>> Epoch 13 finished 	ANN training loss 0.973467
>> Epoch 14 finished 	ANN training loss 0.972551
>> Epoch 15 finished 	ANN training loss 0.985291
>> Epoch 16 finished 	ANN training loss 0.973483
>> Epoch 17 finished 	ANN training loss 1.032754
>> Epoch 18 finished 	ANN training loss 0.975029
>> Epoch 19 finished 	ANN training loss 0.973920
>> Epoch 20 finished 	ANN training loss 0.979619
>> Epoch 21 finished 	ANN training loss 0.973436
>> Epoch 22 finished 	ANN training loss 0.973382
>> Epoch 23 finished 	ANN training loss 0.973673
>> Epoch 24 finished 	ANN training loss 0.972198
>> Epoch 25 finished 	ANN training loss 0.976629
>> Epoch 26 finished 	ANN training loss 0.978149
>> Epoch 27 finished 	ANN training loss 0.972190
>> Epoch 28 finished 	ANN training loss 0.975452
>> Epoch 29 finished 	ANN training loss 0.972537
>> Epoch 30 finished 	ANN training loss 0.973224
>> Epoch 31 finished 	ANN training loss 0.972399
>> Epoch 32 finished 	ANN training loss 0.981313
>> Epoch 33 finished 	ANN training loss 0.972501
>> Epoch 34 finished 	ANN training loss 0.972320
>> Epoch 35 finished 	ANN training loss 0.972333
>> Epoch 36 finished 	ANN training loss 0.972365
>> Epoch 37 finished 	ANN training loss 0.973041
>> Epoch 38 finished 	ANN training loss 0.973402
>> Epoch 39 finished 	ANN training loss 0.973150
>> Epoch 40 finished 	ANN training loss 0.973351
>> Epoch 41 finished 	ANN training loss 0.972491
>> Epoch 42 finished 	ANN training loss 0.973387
>> Epoch 43 finished 	ANN training loss 0.975201
>> Epoch 44 finished 	ANN training loss 0.974669
>> Epoch 45 finished 	ANN training loss 0.973237
>> Epoch 46 finished 	ANN training loss 0.973701
>> Epoch 47 finished 	ANN training loss 0.974115
>> Epoch 48 finished 	ANN training loss 0.973621
>> Epoch 49 finished 	ANN training loss 0.975080
>> Epoch 50 finished 	ANN training loss 0.973482
>> Epoch 51 finished 	ANN training loss 0.973096
>> Epoch 52 finished 	ANN training loss 0.972423
>> Epoch 53 finished 	ANN training loss 0.973715
>> Epoch 54 finished 	ANN training loss 0.972462
>> Epoch 55 finished 	ANN training loss 0.973218
>> Epoch 56 finished 	ANN training loss 0.974274
>> Epoch 57 finished 	ANN training loss 0.972654
>> Epoch 58 finished 	ANN training loss 0.973055
>> Epoch 59 finished 	ANN training loss 0.974541
>> Epoch 60 finished 	ANN training loss 0.972862
>> Epoch 61 finished 	ANN training loss 0.974566
>> Epoch 62 finished 	ANN training loss 0.974633
>> Epoch 63 finished 	ANN training loss 0.972228
>> Epoch 64 finished 	ANN training loss 0.972528
>> Epoch 65 finished 	ANN training loss 0.975309
>> Epoch 66 finished 	ANN training loss 0.972574
>> Epoch 67 finished 	ANN training loss 0.973502
>> Epoch 68 finished 	ANN training loss 0.972238
>> Epoch 69 finished 	ANN training loss 0.972355
>> Epoch 70 finished 	ANN training loss 0.972399
>> Epoch 71 finished 	ANN training loss 0.977468
>> Epoch 72 finished 	ANN training loss 0.972539
>> Epoch 73 finished 	ANN training loss 0.974523
>> Epoch 74 finished 	ANN training loss 0.972638
>> Epoch 75 finished 	ANN training loss 0.972507
>> Epoch 76 finished 	ANN training loss 0.972180
>> Epoch 77 finished 	ANN training loss 0.975650
>> Epoch 78 finished 	ANN training loss 0.976923
>> Epoch 79 finished 	ANN training loss 0.972457
>> Epoch 80 finished 	ANN training loss 0.972530
>> Epoch 81 finished 	ANN training loss 0.974509
>> Epoch 82 finished 	ANN training loss 0.972226
>> Epoch 83 finished 	ANN training loss 0.972228
>> Epoch 84 finished 	ANN training loss 0.979132
>> Epoch 85 finished 	ANN training loss 0.972195
>> Epoch 86 finished 	ANN training loss 0.972707
>> Epoch 87 finished 	ANN training loss 0.972699
>> Epoch 88 finished 	ANN training loss 0.975048
>> Epoch 89 finished 	ANN training loss 0.973130
>> Epoch 90 finished 	ANN training loss 0.972863
>> Epoch 91 finished 	ANN training loss 0.972569
>> Epoch 92 finished 	ANN training loss 0.978470
>> Epoch 93 finished 	ANN training loss 0.972716
>> Epoch 94 finished 	ANN training loss 0.972678
>> Epoch 95 finished 	ANN training loss 0.973266
>> Epoch 96 finished 	ANN training loss 0.972965
>> Epoch 97 finished 	ANN training loss 0.972450
>> Epoch 98 finished 	ANN training loss 0.976090
>> Epoch 99 finished 	ANN training loss 0.972646
[END] Fine tuning step
Accuracy: 0.580357
('Precision:', 0.3368144132653062)
('Recall:', 0.5803571428571429)
('F1-score:', 0.42625100887812761)
asif@ubuntu:~/Downloads/hakathon/mdbn_tcga_brca_tensorflow$ 

