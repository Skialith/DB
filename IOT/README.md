# Internet of Things

This project focuses on object detection and image processing and  is used for the DB project of IoT Engineering in the junior year of 2021 at the International College of Beijing University of Posts and Telecommunications (BUPT). It utilizes a pre-trained YOLOv8 model for object detection in images and real-time video streams.

## Table of Contents

- [Internet of Things](#internet-of-things)
  - [Table of Contents](#table-of-contents)
  - [General Info](#general-info)
  - [Technologies](#technologies)
  - [Setup](#setup)
  - [Features](#features)
    - [1. Object Detection in Images](#1-object-detection-in-images)
    - [2. Real-time Object Detection](#2-real-time-object-detection)
    - [3. Image Comparison GUI](#3-image-comparison-gui)
    - [4. Video Frame Capture](#4-video-frame-capture)
  - [Status](#status)
  - [Inspiration](#inspiration)
  - [Contact](#contact)

## General Info

The main goal of this project is to facilitate object detection in various contexts. It can be used for detecting objects in still images, real-time video streams, and for comparing images side-by-side through a graphical user interface. The three types of objects that can be detected are books, Rubik's Cubes and keys. The training data includes images captured in various environments to demonstrate the accuracy of our algorithm.

## Technologies

Project is created with:
* Python 3.x
* ultralytics
* opencv-python
* torch
* PIL
* tkinter

## Setup

To run this project, install it locally using git:
```
$ git clone https://github.com/Skialith/Design_and_Build.git
$ cd Design_and_Build
```
## Features

List of features ready and TODOs for future development

### 1. Object Detection in Images

* **Script**: `test_model.py`
* **Description**: This script performs object detection on images using a pre-trained YOLOv8 model. Detected objects are filtered based on confidence thresholds and specific categories.
* **Usage**: 
  ```sh
  python test_model.py
  ```
* **Note**: Make sure the dependency library 'ultralytics' is installed. You need to specify the path to the weights file for the pre-trained model.

### 2. Real-time Object Detection

* **Script**: `final_demo.py`
* **Description**: This script is used for real-time object detection in video streams. It captures video frames, performs object detection, and saves images with detection labels. Also save the start and end times.
* **Usage**: 
  ```sh
  python final_demo.py
  ```
* **Note**: Make sure that the dependency libraries 'ultralytics', 'opencv-python', and 'torch' are installed.

### 3. Image Comparison GUI

* **Script**: `pic_comparison.py`
* **Description**: The script provides a graphical user interface for side-by-side comparisons showing the images before and after the detection was performed.
* **Usage**: 
  ```sh
  python pic_comparison.py
  ```
* **Note**: Make sure that the dependency libraries 'PIL' and 'tkinter' are installed.

### 4. Video Frame Capture

* **Script**: `extraction_of_frame.py`
* **Description**: This script captures video frames and saves them as images to help the Telecom team record photos of the environment during their explorations
* **Usage**: 
  ```sh
  python extraction_of_frame.py

* **Note**: Make sure the dependency library 'opencv-python' is installed.

## Status

Project is: _in progress_

## Inspiration

The genesis of this project lies in the ever-growing necessity for intelligent, real-time environmental monitoring systems. In an era where data is power, the ability to not just capture but also interpret visual data through object detection offers immense possibilities. This project harnesses the power of YOLOv8, a state-of-the-art machine learning model, to turn ordinary camera footage into a rich source of insights.

Primary applications include:
- **Environmental Monitoring**: Automated procedures for checking objects and recording environments are essential for areas of a project that require constant monitoring or event detection.
- **Model Demonstration**: A tangible way to showcase the capabilities of object detection models, providing a bridge between theory and practice.

Envisioning the future, the potential expansions could be:
- **Smart Urban Planning**: Analyzing foot traffic, vehicle movement, or environmental changes in real-time, contributing to more informed urban development decisions.
- **Enhanced Security Systems**: Integration into security systems for more nuanced detection, including unauthorized activities or unattended objects.
- **Wildlife Observation**: Non-intrusive monitoring of natural habitats, aiding in wildlife protection and research without human interference.
- **Disaster Response**: Quick analysis of environments in disaster-stricken areas, assisting in efficient and effective response plans.

This project is not just a testament to technological advancement but a step towards smarter, data-driven decision-making processes in various fields. The adaptability of the system promises continual evolution alongside future advancements in machine learning and data analysis.


## Contact

Created by [@Skialith](https://github.com/Skialith) - feel free to contact me!

