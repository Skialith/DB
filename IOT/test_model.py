# Image object detection procedure,working with GUI to show model results
# Performs object detection on images in a specified directory using a pre-trained YOLOv8 model.
# Detected objects will be filtered based on a confidence threshold and only specific categories will be detected.
# Images with detection labels will be saved.

# Main functions:
# 1. Initialise the YOLOv8 model and load the pre-trained weights file.
# 2. Perform object detection on the images in the specified directory.
# 3. If objects are detected, filter the detection results based on confidence thresholds and categories.
# 4. Save the image with the detection label.

# Input:
# - Images to be detected are stored in the specified directory.

# Output:
# - Images with detection labels are saved in the original directory.
# - The detection result includes the category and confidence level of the detected object.

# Example of usage:
# - After running the program, it will automatically start object detection on the images in the specified directory.
# - The detected objects will be filtered according to the specified categories and confidence thresholds.
# - The images with the detection results will be saved back to the original directory.

# - Make sure that the dependency library is installed:
# - Make sure the dependency library 'ultralytics' is installed.
# - You need to specify the path to the weights file for the pre-trained model.
# - The `classes` parameter is used to specify which classes of objects should be detected.
# - The `conf` parameter is the confidence threshold, which is used to filter the detection results.

from ultralytics import YOLO
# Load a model

model = YOLO("/Users/cui_yutao/Desktop/Design_and_Build/best.pt")  # load a pretrained model (recommended for training)


img_path = "./TestImages/"
# results = model.predict(img_path, save=True,conf=0.5) # device=0 by default, conf:置信度阈值
results = model.predict(img_path,save=True,classes=[0,1,2],conf=0.6) # i.e. classes=0,classes=[0,3,4]

