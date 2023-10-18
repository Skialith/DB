 // 定义引脚连接
const int leftMotorPin1 = 2;   // 左侧轮子引脚1向前
const int leftMotorPin2 = 3;   // 左侧轮子引脚2向后
const int rightMotorPin1 = 4;  // 右侧轮子引脚1向前
const int rightMotorPin2 = 5;  // 右侧轮子引脚2向后

const int trigPin1 = A0; //前方
const int echoPin1 = A1; //前方
const int trigPin2 = A2; //左边
const int echoPin2 = A3; //左边
const int trigPin3 = A4; //右边
const int echoPin3 = A5; //右边
const int trigPin4 = A6; //前上边
const int echoPin4 = A7; //前上边

//前方两个超声波的测距误差
const int rangeMin = -25;   // 差值最小值
const int rangeMax = 25;    // 差值最大值

//电机速度，可以根据需要调整
int speed = 55;
int turnspeed = 120;

// 用于存储距离
//long lastDistanceFront = 0;
//long lastDistanceLeft = 0;
//long lastDistanceRight = 0;
                                                                                                                                                                                              
void setup() {
  //设置引脚模式
  pinMode(leftMotorPin1, OUTPUT);
  pinMode(leftMotorPin2, OUTPUT);
  pinMode(rightMotorPin1, OUTPUT);
  pinMode(rightMotorPin2, OUTPUT);
  pinMode(trigPin1, OUTPUT);
  pinMode(echoPin1, INPUT);
  pinMode(trigPin2, OUTPUT);
  pinMode(echoPin2, INPUT);
  pinMode(trigPin3, OUTPUT);
  pinMode(echoPin3, INPUT);
  pinMode(trigPin4, OUTPUT);
  pinMode(echoPin4, INPUT);

  // 停止所有电机
  stop();

  // 延时一段时间让系统稳定
  delay(1000);

  // 开始串口通信
  Serial.begin(9600);
}

void loop() {
 
  long distanceFront = getDistance(trigPin1, echoPin1);
  long distanceLeft = getDistance(trigPin2, echoPin2);
  long distanceRight = getDistance(trigPin3, echoPin3);
  long distanceFrontup = getDistance(trigPin4, echoPin4);
  
  // 打印距离到串口监视器
  Serial.print("Front Distance: ");
  Serial.print(distanceFront);
  Serial.println(" cm");

  Serial.print("Front Distance Up: ");
  Serial.print(distanceFrontup);
  Serial.println(" cm");

  Serial.print("Left Distance: ");
  Serial.print(distanceLeft);
  Serial.println(" cm");

  Serial.print("Right Distance: ");
  Serial.print(distanceRight);
  Serial.println(" cm");
  
  forward();

if(distanceFrontup > 10){
    if (distanceFront < 10){
      // 停止小车
    stop();
    // 延迟一段时间
    delay(3000);
    //后退  
    backward();
    // 延迟一段时间
    delay(300);
    // 右转
    turnRight();
    // 延迟一段时间
    delay(800);  
   }
  }

  // 进行避障操作
  if(distanceFrontup < 10) {
    if(distanceLeft < distanceRight) {
      turnRight();
      delay(505); //调整转弯时间
      forward();
      delay(400);
    } else {
      turnLeft();
      delay(505);
      forward();
      delay(400);
    }
  } else if(distanceLeft < 8) {
    turnRight();
    delay(350); //调整前进时间
    forward();
    delay(150);
    turnLeft(); //回正
    delay(200);
  } else if(distanceRight < 8) {
    turnLeft();
    delay(350); //调整前进时间
    forward();
    delay(150);
    turnRight(); //回正
    delay(200);
  }else {
    forward();
  }

  
}
  // 更新上一次的距离
 // lastDistanceFront = distanceFront;
  //lastDistanceLeft = distanceLeft;
  //lastDistanceRight = distanceRight;


void forward() {
  //前进
  analogWrite(leftMotorPin1, speed);
  analogWrite(rightMotorPin1, speed);
  digitalWrite(leftMotorPin2, LOW);
  digitalWrite(rightMotorPin2, LOW);

}

void backward() {
  //后退
  digitalWrite(leftMotorPin1, LOW);
  digitalWrite(rightMotorPin1, LOW);
  analogWrite(leftMotorPin2, speed);
  analogWrite(rightMotorPin2, speed);

}

void turnLeft() {
  //左转，即左侧电机后退，右侧电机前进
  analogWrite(rightMotorPin1, turnspeed);
  analogWrite(leftMotorPin2, turnspeed);
  digitalWrite(rightMotorPin2, LOW);
  digitalWrite(leftMotorPin1, LOW);

}

void turnRight() {
  //右转，即左侧电机前进，右侧电机后退
  analogWrite(rightMotorPin2, turnspeed);
  analogWrite(leftMotorPin1, turnspeed);
  digitalWrite(rightMotorPin1, LOW);
  digitalWrite(leftMotorPin2, LOW);
  
}

void stop() {
  //停止
  digitalWrite(leftMotorPin2, LOW);
  digitalWrite(leftMotorPin1, LOW);
  digitalWrite(rightMotorPin2, LOW);
  digitalWrite(rightMotorPin1, LOW);
  
}

long getDistance(int trigPin, int echoPin) {
  digitalWrite(trigPin, LOW);
  delayMicroseconds(2);
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);
  long duration = pulseIn(echoPin, HIGH);
  // 将微秒转换为厘米
  long distance = (duration/2) / 29.1;
  return distance;
}
