package org.usfirst.frc.team5677.robot.controllers;

import java.util.TimerTask;
import org.usfirst.frc.team5677.lib.trajectory.TrajectoryFollower;
import org.usfirst.frc.team5677.lib.trajectory.Segment;
import org.usfirst.frc.team5677.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.Timer;

public class DriveStraightController extends TimerTask {
    TrajectoryFollower rightSide;
    TrajectoryFollower leftSide;
    double leftCurrPosition = 0.0;
    double rightCurrPosition = 0.0;
    DriveTrain drive;
    int sum =0;
    int prevSum = 0;
    double distanceTraveled =0.0;
    //Timer t = new Timer();
    double initialTime;
    public DriveStraightController(
				   Segment[] leftTrajectory,
				   Segment[] rightTrajectory,
				   double leftMaxV,
				   double rightMaxV,
				   double controlLoop,
				   DriveTrain drive) {
	
	double leftkV = 1 / leftMaxV;
	double rightkV = 1 / rightMaxV; 
	double dt = 1 / controlLoop;
	this.drive = drive;
	//Will later set these values as constants in a constants file
	this.leftSide = new TrajectoryFollower(leftTrajectory, leftkV, 0.0, 0.0, 0.0, 0.0, dt);
	this.rightSide = new TrajectoryFollower(rightTrajectory, rightkV, 0.0, 0.0, 0.0, 0.0, dt);
    }
    
    public void setEncoderValue(double leftEncoderVal, double rightEncoderVal) {
	//Later on we need to multiply the encoder value by a ticks per feet/inch value to get the actual position
	this.leftCurrPosition = leftEncoderVal;
	this.rightCurrPosition = rightEncoderVal;
    }
    
    public boolean isDone(){
	return rightSide.isTrajDone() && leftSide.isTrajDone();
    }
    public void run() {
	double deltaT = 0.0;
	if (sum == 0) {
	    initialTime = Timer.getFPGATimestamp();
	    deltaT=0.0;
	} else {
	    double currTime = Timer.getFPGATimestamp();
	    deltaT=currTime-initialTime;
	    initialTime = currTime;
	}
	if (!rightSide.isTrajDone() && !leftSide.isTrajDone()) {
	    double leftMotor = this.leftSide.calcMotorOutput(this.leftCurrPosition);
	    double rightMotor = this.rightSide.calcMotorOutput(this.rightCurrPosition);
	    /*System.out.println("Right Side Motor Val: "
			       + rightMotor
			       + "----- Left Side Motor Val: "
			       + leftMotor
			       + "\n");*/
	    sum++;
	    if (prevSum+1 != sum) {
		System.out.println("rlafsdhawlekfhlkgjhalwgejwhgalwkgjhalwgjkhaleghajwegaweg");
	    }
	    prevSum = sum;
	    System.out.println("Sum///////////"+sum);
	    distanceTraveled += deltaT*(leftMotor/10);
	    System.out.println("Delta T:"+deltaT+" ------ Distance Traveled: "+distanceTraveled);
	    //drive.setLeftSpeed(leftMotor);
	    //drive.setRightSpeed(rightMotor);
	} else {
	    System.out.println("dddddddddddddddd");
	    drive.setLeftSpeed(0.0);
	    drive.setRightSpeed(0.0);
	}
    }
}
