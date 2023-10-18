# Real-time object detection and image saving procedure
# Capture video frames from smart trolley camera using YOLOv8 model
# and perform real time object detection on the video frames.
# Images with detection labels are saved and the program also records the start and end times.

# Main functions:
# 1. initialise the YOLOv8 model and load the pre-trained weights file.
# 2. Connect the cart camera via Wi-Fi and acquire the video stream.
# 3. Run YOLOv8 object detection on each frame.
# 4. If an object is detected, save the image with the detection label to a specified directory.
# 5. Record the start and end time of the programme to a text file.

# Input:
# - No additional input is required, the program captures video frames directly from the camera.

# Output:
# - Real-time display of the video stream window with object detection labels.
# - If an object is detected, saves the image file with the detected label in the "detected_images" directory.
# - Record the program start and end time to the text files "start_time.txt" and "end_time.txt".

# Example of use:
# - After running the programme and monitoring the video stream from the camera in real time
# - press the 'q' key to exit the programme.
# - If an object is detected, the associated image will be
# - saved in the "detected_images" directory with an incremental file name.
# - The start and end times will be recorded in the "start_time.txt" and "end_time.txt" files.

# Note:
# - Start and end times will be recorded in the "start_time.txt" and "end_time.txt" files:
# - Make sure that the dependency libraries 'ultralytics', 'opencv-python' and 'torch' are installed.
# - To change the path to the weights file for the YOLOv8 model as appropriate.

from ultralytics import YOLO
import cv2
import time
import os
import torch

# Function to write time to a text file in the specified format
def write_time_to_file(filename, time_str):
    with open(filename, "w") as file:
        file.write(time_str)

# Load a model
model = YOLO("/Users/cui_yutao/Desktop/Design_and_Build/best.pt")  # load a pretrained model (recommended for training)

cap = cv2.VideoCapture("http://192.168.8.1:8083/?action=stream")

output_image_id = 0 # output image_id
output_directory = "detected_images"  # Specify the directory in which to save the image

# Make sure the output directory exists
if not os.path.exists(output_directory):
    os.makedirs(output_directory)

frame_interval = 1  # Store one image per second (make sure frame_interval is defined)
start_time = 0  # Initialize start_time to 0

# Record the time_file as initial value at the beginning
start_time_str = time.strftime("%Y-%m-%d %H:%M:%S", time.localtime(0))
end_time_str = time.strftime("%Y-%m-%d %H:%M:%S", time.localtime(0))
write_time_to_file("start_time.txt", f"Start Time: {start_time_str}")
write_time_to_file("end_time.txt", f"Start Time: {end_time_str}")

# Loop through the video frames
while cap.isOpened():
    # Read a frame from the video
    success, frame = cap.read()

    if success:
        # Run YOLOv8 inference on the frame
        results = model(frame)

        # Visualize the results on the frame
        annotated_frame = results[0].plot()

        # Display the annotated frame
        cv2.imshow("YOLOv8 Real-time Detection Video Window", annotated_frame)

        # Record the start time
        current_time = time.time()
        if start_time == 0:
            # Update start_time if it's still 0
            start_time = current_time
            start_time_str = time.strftime("%Y-%m-%d %H:%M:%S", time.localtime(current_time))
            write_time_to_file("start_time.txt", f"Start Time: {start_time_str}")

        # Storing TestImages with detection labels

        # frame tmp is a copy of frame with the same data values
        frame_tmp = torch.tensor(frame, dtype=torch.float64, requires_grad=False)

        # anno frame tmp is a copy of anno frame with consistent data values
        annotated_frame_tmp = torch.tensor(annotated_frame, dtype=torch.float64,requires_grad=False)

        if False in (frame_tmp == annotated_frame_tmp):
            cv2.imwrite(output_directory + '/detected_pic_%d.png' % output_image_id, annotated_frame)
            output_image_id += 1

        del frame_tmp, annotated_frame_tmp

        # Break the loop if 'q' is pressed
        if cv2.waitKey(1) & 0xFF == ord("q"):
            break
    else:
        # Break the loop if the end of the video is reached
        break

# Record the end time
end_time = time.time()
end_time_str = time.strftime("%Y-%m-%d %H:%M:%S", time.localtime(end_time))
write_time_to_file("end_time.txt", f"End Time: {end_time_str}")

# Release the video capture object and close the display window
cap.release()
cv2.destroyAllWindows()
