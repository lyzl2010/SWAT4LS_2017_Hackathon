import sys
import os
import timeit

DATASET = 3
PRETRAIN_EPOCH = 100
TRAIN_EPOCH = 100
PRETRAIN_LR = 0.1
TRAIN_LR = 0.01
LAYERS = []

def main():
	global DATASET
	global PRETRAIN_EPOCH
	global TRAIN_EPOCH
	global PRETRAIN_LR
	global TRAIN_LR
	global LAYERS

	print("Welcome to mDBN breast cancer status prediction!")
	print("All training data by TCGA BRCA\n")


	######################
	##### PREDICTION #####
	######################
	print("\n\nWhat prediction do you want to make?")
	print("[1] Breast cancer type classification")
	print("[2] Survival rate regression")
	try:
		prediction = input("Insert here [default = 1]: ")
	except Exception as e:
		prediction = 1

	if prediction == 2:	# if survival rate regression is picked
		print("You will predict the survival rate")
	else:
		prediction = 1	# if breast cancer type classification or any other number is picked
		print("You will classify the type of the breast cancer")



	######################
	####### DATASET ######
	######################
	print("\n\nWhat type of features do you want to use?")
	print("[1] DNA Methylation")
	print("[2] Gene Expression")
	print("[3] miRNA Expression")
	try:
		features = input("Insert here [default = 3]: ")
	except Exception as e:
		features = 3

	if features == 1:	# if DNA Methylation is picked
		print("You will use DNA Methylation data to create the prediction")
		DATASET = 1

	elif features == 2:	# if Gene Expression is picked
		print("You will use Gene Expression data to create the prediction")
		DATASET = 2
		
	else:	# if miRNA Expression or any other number is picked
		DATASET = 3
		print("You will use miRNA Expression data to create the prediction")



	######################
	####### LAYERS #######
	######################
	print("\n\nNeural Network Layers")
	try:
		n_layers = int(input("Number of hidden layers [default = 3]: "))
	except Exception as e:
		n_layers = 3

	for i in range(n_layers):
		try:
			temp = int(input("Layer " + str(i) + " size [default = 1000]: "))
		except Exception as e:
			temp = 1000

		LAYERS.append(temp)



	######################
	### HYPERPARAMETER ###
	######################
	print("\n\nNeural Network Parameters")
	try:
		PRETRAIN_EPOCH = int(input("Pre-training iteration [default = 100]: "))
	except Exception as e:
		PRETRAIN_EPOCH = 100

	try:
		TRAIN_EPOCH = int(input("Training iteration [default = 100]: "))
	except Exception as e:
		TRAIN_EPOCH = 100

	try:
		BATCH_SIZE = int(input("Batch size [default = 10]: "))
	except Exception as e:
		BATCH_SIZE = 10

	try:
		PRETRAIN_LR = int(input("Pre-training learning rate [default = 0.01]: "))
	except Exception as e:
		PRETRAIN_LR = 0.01

	try:
		TRAIN_LR = int(input("Training learning rate [default = 0.1]: "))
	except Exception as e:
		TRAIN_LR = 0.1
	
	

	######################
	#### OPEN PROGRAM ####
	######################
	program_path = os.path.dirname(os.path.realpath(__file__))
	sys.path.insert(0, program_path + '/Tensorflow')
	if prediction == 1: 								# classification
		from DBN_classification import test_DBN
		test_DBN(dataset = DATASET,
			pretraining_epochs = PRETRAIN_EPOCH,
			training_epochs = TRAIN_EPOCH,
			pretrain_lr = PRETRAIN_LR,
			finetune_lr = TRAIN_LR,
			batch_size = BATCH_SIZE,
			layers=LAYERS)

	elif prediction == 2:								# regression
		from DBN_regression import test_DBN
		test_DBN(dataset = DATASET,
			pretraining_epochs = PRETRAIN_EPOCH,
			training_epochs = TRAIN_EPOCH,
			pretrain_lr = PRETRAIN_LR,
			finetune_lr = TRAIN_LR,
			batch_size = BATCH_SIZE,
			layers=LAYERS)


if __name__ == '__main__':
    main()
