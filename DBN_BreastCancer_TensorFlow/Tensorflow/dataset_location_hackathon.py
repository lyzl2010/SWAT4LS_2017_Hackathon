MAIN_MDBN_TCGA_BRCA = "/home/asif/Downloads/hakathon/Preprocessed_Data_Short_version/"

########################
######### INPUT ########
########################
# The main folder for all the inputs/features of your training set
# You need at least 30GB of free space for this folder
DATASET_INPUT = MAIN_MDBN_TCGA_BRCA + "input_csv/"

INPUT_MET_TYPE_ER = DATASET_INPUT + "type/DNA_Methylation/input_met_type_er.csv"
INPUT_MET_TYPE_PGR = DATASET_INPUT + "type/DNA_Methylation/input_met_type_pgr.csv"
INPUT_MET_TYPE_HER2 = DATASET_INPUT + "type/DNA_Methylation/input_met_type_her2.csv"
INPUT_MET_SURVIVAL = DATASET_INPUT + "survival/DNA_Methylation/input_met_sur.csv"

INPUT_GEN_TYPE_ER = DATASET_INPUT + "type/Gene_Expression/input_gen_type_er.csv"
INPUT_GEN_TYPE_PGR = DATASET_INPUT + "type/Gene_Expression/input_gen_type_pgr.csv"
INPUT_GEN_TYPE_HER2 = DATASET_INPUT + "type/Gene_Expression/input_gen_type_her2.csv"
INPUT_GEN_SURVIVAL = DATASET_INPUT + "survival/Gene_Expression/input_gen_sur.csv"

INPUT_MIR_TYPE_ER = DATASET_INPUT + "type/mirNA_Expression/input_mir_type_er.csv"
INPUT_MIR_TYPE_PGR = DATASET_INPUT + "type/mirNA_Expression/input_mir_type_pgr.csv"
INPUT_MIR_TYPE_HER2 = DATASET_INPUT + "type/mirNA_Expression/input_mir_type_her2.csv"
INPUT_MIR_SURVIVAL = DATASET_INPUT + "survival/mirNA_Expression/input_mir_sur.csv"


########################
######## LABELS ########
########################
# The main folder for all the labels of your training set
# You need at least 30GB of free space for this folder
DATASET_LABELS = MAIN_MDBN_TCGA_BRCA + "labels_csv/"

LABELS_TYPE_ER = DATASET_LABELS + "type/label_type_er.csv"
LABELS_TYPE_PGR = DATASET_LABELS + "type/label_type_pgr.csv"
LABELS_TYPE_HER2 = DATASET_LABELS + "type/label_type_her2.csv"
LABELS_SURVIVAL = DATASET_LABELS + "survival/label_sur.csv"
