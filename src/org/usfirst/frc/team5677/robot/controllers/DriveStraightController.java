package org.usfirst.frc.team5677.robot.controllers;

import java.util.Timer;
import java.util.TimerTask;
import org.usfirst.frc.team5677.lib.trajectory.TrajectoryFollower;
import org.usfirst.frc.team5677.lib.trajectory.Segment;
import org.usfirst.frc.team5677.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveStraightController {
    TrajectoryFollower rightSide;
    TrajectoryFollower leftSide;
    double leftCurrPosition = 0.0;
    double rightCurrPosition = 0.0;
    DriveTrain drive;
    int sum =0;
    int prevSum = 0;
    double distanceTraveled =0.0;
    Timer timer = new Timer();
    double initialTime;
    public DriveStraightController(
				   Segment[] leftTrajectory,
				   Segment[] rightTrajectory,
				   double leftMaxV,
				   double rightMaxV,
				   double controlLoop,
				   DriveTrain drive){	
	double leftkV = 1 / 5.0;
	double rightkV = 1 / 5.0; 
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

    public void start(){
	rightSide.reset();
	leftSide.reset();
	timer.schedule(new DriveStraightTask(),0,5);
    }

    public void stop(){
	timer.cancel();
	timer.purge();
	timer = new Timer();
	System.out.println(isDone());
    }
    class DriveStraightTask extends TimerTask{
	
	public void run() {
	    if (!rightSide.isTrajDone() && !leftSide.isTrajDone()) {
		double leftMotor = leftSide.calcMotorOutput(leftCurrPosition);
		double rightMotor = rightSide.calcMotorOutput(rightCurrPosition);
		/*System.out.println("Right Side Motor Val: "
			       + rightMotor
			       + "----- Left Side Motor Val: "
			       + leftMotor
			       + "\n");*/
		if(leftMotor>1.0){
		    leftMotor=1.0;
		}
		if(rightMotor>1.0){
		    rightMotor=1.0;
		}
	    
		SmartDashboard.putNumber("leftMotorTraj", leftMotor);
		SmartDashboard.putNumber("rightMotorTraj", rightMotor);
		drive.setLeftSpeed(leftMotor);
		drive.setRightSpeed(rightMotor);
		SmartDashboard.putNumber("Left Rate", drive.getLeftEncoderRate());
		SmartDashboard.putNumber("Right Rate", drive.getRightEncoderRate());

	    } else {
		System.out.println("dddddddddddddddd");
		drive.setLeftSpeed(0.0);
		drive.setRightSpeed(0.0);
		timer.cancel();
		//timer.purge();
	    }
	}
    }
 }
