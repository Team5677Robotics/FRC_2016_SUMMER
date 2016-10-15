package org.usfirst.frc.team5677.robot.commands;

import org.usfirst.frc.team5677.robot.subsystems.Manipulator;
import org.usfirst.frc.team5677.robot.controllers.FlyWheelController;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Toggles the intake motor
 * 
 * @author Rishi Desai
 */
public class RevShooterCommand extends Command {
    Manipulator manipulator;
    FlyWheelController flyWheelController;
	
    public RevShooterCommand() {
        manipulator = Manipulator.getInstance();
	flyWheelController = new FlyWheelController();
	flyWheelController.resetError();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
	//manipulator.setShooterHoodSolenoid(!manipulator.getShooterHoodSolenoid());
	flyWheelController.resetError();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	//System.out.println("execute");
	//System.out.println(manipulator.getIsRevMode());
	if(manipulator.getIsRevMode()){
	    //System.out.println(manipulator.getFlywheelRPM());
	    double output = flyWheelController.getFlyWheelSpeed(manipulator.getFlywheelRPM());
	    //double output = 0.7;
	    System.out.println(output);
	    manipulator.setFlyWheel(output);
	}else{
	    manipulator.setFlyWheel(0.0);
	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
