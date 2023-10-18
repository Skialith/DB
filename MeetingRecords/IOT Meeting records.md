## Phase 1
####  26 June, 2023 - 30 June, 2023

- We selected pictures of all these three objects we need to detect, including cubes, keys and books from internet under different environment to boost the accuracy of our model. 
- When operating trains, we met with different problems, and we optimize the training processes by changing the epochs and data the weights of different objects pictures in our data set.
- Then we tried object detection using the video stream of cameras deployed in our personal laptops and refined the datasets and epochs again according to the problems encountered.


## Phase 2 -1
#### 8th September, 2023

Tencent meeting
Participant: IOT group members
- Yutao Cui
- Chongzhen Ma

### Content

- We made our way to extract the video stream from the web-camera from the robot designed by the telecom groups.
	- Problem:
		- How to achieve real time detection using video stream from web camera of robot?
	- Solution:
		- By using the given software controlling the robot, we get the stream address from wifi module.
- We designed frame extraction program and set the number of frames took per second according to the real frame number.
	- Problem:
		- Telecom group needs recording of real time environment of robot.
	- Solution:
		- IOT group extracted frames of video stream at a rate of 5 pics per second, realizing the function of environment recording.


## Phase 2 -2
#### 22nd September, 2023

Teaching building 4-401
Participant: all of the members of IOT group, E-commerce group and Telecom group

### Content

- We had a meeting with e-commerce groups and figured out how to upload the pictures we shot to the website for display.
	- Problem:
		- How to save images and make it possible to be accessed
	- Solution:
		- We choose saving the images in a directory of laptop and let the website access the directory directly using the absolute path. Then data can be uploaded to both website and database.
- We made a simple GUI program in order to compare the pictures before and after object detection, aiming to show the accuracy of our algorithm in an intuitive way.
	- Problem:
		- We want to find a way to display our accuracy and address it.
	- Solutions:
		- We design a simple GUI that displays the images before and after detection side by side, so that viewers can find out the accuracy easily.