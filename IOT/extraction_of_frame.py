# Real-time video capture and screenshot saver to help the Telecom team record photos of the environment during their explorations
# Capture video frames from a video source (e.g. webcam) and save a screenshot every second.
# Screenshots are saved in a specified directory.

# Main features:
# 1. Connects to a specified video stream.
# 2. Capture video frames from the video stream. # 3.
# 3. Saves the video frame as a screenshot to the specified directory.
# 4. Performs a screenshot operation every second.

# Input:
# - No additional input is required, the program captures video frames directly from the video source.

# Output:
# - Save the captured video frames as screenshots in the "screenshots" directory.
# - Screenshot filenames are named incrementally.

# Example of usage:
# - After running the programme, it will automatically start capturing video frames from the video source.
# - The programme will save a screenshot every second.
# - Stop the program by pressing Ctrl+C or close the terminal where it is running.
# - Screenshots will be saved in the "screenshots" directory with the name "screenshot_0.png", "screenshot_1.png" etc. # - The program will automatically start capturing video frames from the video source.

# - Note:
# - Make sure the dependency library 'opencv-python' is installed.
# - Modify 'video_stream_url' to the correct video stream URL or path if not capturing video from the default camera.
# - Screenshots are saved in the 'screenshots' directory created, if it does not exist, the program will create it automatically.
# - The program will run indefinitely until the user manually stops it or the video stream ends.

import os
import cv2
import time

# Replace 'video_stream_url' with the URL or path to your video stream
video_stream_url = "http://192.168.8.1:8083/?action=stream"

# Create a directory to store the screenshots if it doesn't exist
output_directory = 'screenshots'
os.makedirs(output_directory, exist_ok=True)

# Create a VideoCapture object to capture the video stream
cap = cv2.VideoCapture(video_stream_url)

# Check if the video stream is opened successfully
if not cap.isOpened():
    print("Error: Could not open video stream.")
    exit()

# Counter for naming the saved screenshots
screenshot_count = 0

while True:
    # Read a frame from the video stream
    ret, frame = cap.read()

    if not ret:
        print("Error: Could not read a frame from the video stream.")
        break

    # Save the frame as a screenshot in the specified directory
    screenshot_filename = os.path.join(output_directory, f'screenshot_{screenshot_count}.png')
    cv2.imwrite(screenshot_filename, frame)
    print(f"Saved {screenshot_filename}")

    # Increment the screenshot count
    screenshot_count += 1

    # Wait for 1 second before capturing the next screenshot
    time.sleep(1)

# Release the VideoCapture and close any open windows
cap.release()
cv2.destroyAllWindows()