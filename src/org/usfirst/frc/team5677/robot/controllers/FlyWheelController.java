package org.usfirst.frc.team5677.robot.controllers;

import org.usfirst.frc.team5677.lib.PIDController;
import org.usfirst.frc.team5677.robot.Constants;

public class FlyWheelController extends PIDController{

    public FlyWheelController(){
	super(Constants.Manipulator.FLYWHEEL_KP,
	      Constants.Manipulator.FLYWHEEL_KI,
	      Constants.Manipulator.FLYWHEEL_KD);
    }

    public double getFlyWheelSpeed(double current){
	double flyWheelSpeed = super.getOutput(Constants.Manipulator.FLYWHEEL_SETPOINT, current);
	
	if(flyWheelSpeed > 1.0){
	    flyWheelSpeed = 1.0;
	}
	return Math.abs(flyWheelSpeed);
    }
};
