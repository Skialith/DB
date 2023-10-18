

# Telecom
# Intelligent Photo-Recognition Obstacle-Avoidance Car

## Introduction

The Intelligent Photo-Recognition Obstacle-Avoidance Car is an innovative robot built upon the Arduino platform. This smart vehicle is not just capable of autonomous navigation and obstacle avoidance through sensor detection but also features treasure recognition through photo recognition algorithms. Compact, highly operational, and user-friendly, this car is perfect for applications in tech education and smart home setups.

## Table of Contents
- [Intelligent Photo-Recognition Obstacle-Avoidance Car](#intelligent-photo-recognition-obstacle-avoidance-car)
  - [Introduction](#introduction)
  - [Features](#features)
  - [Components](#components)
  - [Requirements](#requirements)
  - [User Scenarios](#user-scenarios)
  - [Specific Functions](#specific-functions)
  - [Code Overview](#code-overview)
  - [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
  - [Usage](#usage)

## Features

- Autonomous navigation and obstacle avoidance
- Treasure recognition through photo capturing and image recognition
- Stable and reliable sensor-to-board connections
- Quick response time (less than 1 second)
- User-friendly operation

## Components

- 1x Arduino control board
- 1x Ultrasonic sensor
- 2x Infrared sensors
- 1x Camera
- 1x DC motor drive module
- 4x DC motors
- 8x Copper columns
- Several Dupont wires
- 1x Battery box
- 1x Aluminum chassis

## Requirements

- **Obstacle Avoidance**: The car should detect obstacles in its path and navigate accordingly based on the obstacle's distance.
- **Photo Recognition**: The car should capture photos using its camera and identify "treasures" through an image recognition algorithm.
- **Connection Stability**: Ensure stable and reliable connections among sensors, camera, and the Arduino control board, with accurate data transmission.
- **Response Speed**: Sensor detection and obstacle avoidance should have a response time of less than 1 second.
- **Ease of Operation**: The car should feature a simple and intuitive user interface for easy operation and control.

## User Scenarios

- **Educational**: Can be employed in educational scenarios, especially for teaching and learning about intelligent robots, enhancing students' understanding and interest in technology.
- **DIY Hobbyists**: Ideal for enthusiasts who enjoy electronic DIY and programming, allowing them to assemble and program robots using the provided components.
- **Home Entertainment**: Serves as an interactive home entertainment robot, enhancing family interactions and leisure activities.

## Specific Functions

- **Obstacle Avoidance**: Utilizes ultrasonic and infrared sensors to detect obstacles, choosing appropriate avoidance maneuvers based on the data received.
- **Photo Recognition**: Employs a camera to capture images and utilizes image recognition algorithms to identify specific objects or "treasures."

## Code Overview

The provided Arduino script (`main.ino`) controls the car's movement logic. It continuously reads from the ultrasonic sensors and controls the motors based on these readings, allowing the car to move autonomously while avoiding obstacles.

```
cppCopy code// Pin definitions, variable declarations, and initial setup...

void loop() {
  // Retrieve distance measurements from sensors
  long distanceFront = getDistance(trigPin1, echoPin1);
  // ... other distance measurements

  // Print distances to the serial monitor for debugging
  Serial.print("Front Distance: ");
  // ... other print statements

  // Car movement logic based on sensor readings
  // ... includes forward, backward, turnRight, turnLeft, stop functions

  // Obstacle avoidance logic
  // ... conditions and movement commands based on sensor data
}

// Function to calculate the distance based on sensor readings
long getDistance(int trigPin, int echoPin) {
  // ... code to calculate distance
}
```

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Arduino IDE or compatible software
- Complete set of specified components
- Access to a power source (for the battery box)
- Basic knowledge of electronics assembly



## Usage

1. Power on the car by connecting the battery box.
2. Place the car in the start position in your test area or maze.
3. Monitor the car's movements; it should navigate autonomously, avoiding obstacles, and capturing photos of identified "treasures."

