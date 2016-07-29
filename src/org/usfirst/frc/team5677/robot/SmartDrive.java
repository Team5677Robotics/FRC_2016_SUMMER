package org.usfirst.frc.team5677.robot;

import org.usfirst.frc.team5677.robot.subsystems.*;

public class SmartDrive {
	/**
	 * Constructs a TeleopDrive object
	 */ 
	private DriveTrain drive;
	
	public SmartDrive(DriveTrain drive) {
		//super(lf, lr, rf, rr, shifter1, shifter2);
		// TODO Auto-generated constructor stub]
		this.drive = drive;
		
	}
	
	/**
	 * Does some skimming. Takes off excess speed and dishes it off to the other side.
	 * 
	 * @param speed
	 */ 
	private double skim(double speed){
		double gain = 0.3;
		if (speed > 1.0) {
		    return -((speed - 1.0) * gain);
		}else if (speed < -1.0) {
		    return -((speed + 1.0) * gain);
		}else {
			return 0.0;
		}
	}
	
	/**
	 * arcadeDrive.
	 * 
	 * @param throttle, turn
	 */ 
	public void arcadeDrive(double throttle, double turn) {
		//throttle = -throttle;
		if(turn<0.1 && turn>-0.1){
			turn =0.0;
		}
		if(throttle<0.1 && throttle>-0.1){
			throttle=0.0;
		}
		double leftSpeed, rightSpeed, skimmedLeftSpeed, skimmedRightSpeed;
		leftSpeed=throttle + turn;
		rightSpeed=throttle - turn;
		
		skimmedLeftSpeed = leftSpeed + skim(leftSpeed);
		skimmedRightSpeed = rightSpeed + skim(rightSpeed);
		
		//if (getButtonA)
		//System.out.println("left speeed: "+skimmedLeftSpeed);
		//System.out.println("right speeed: "+skimmedRightSpeed);
		drive.setLeftSpeed(skimmedLeftSpeed);
		drive.setRightSpeed(skimmedRightSpeed);
	}
	
	/**
	 * TankDrive.
	 * 
	 * @param leftY, rightY
	 */
	public void tankDrive(double leftY, double rightY ){
		drive.setLeftSpeed(leftY);
		drive.setRightSpeed(rightY);
	}
}
