package org.usfirst.frc.team5677.robot.commands;

import org.usfirst.frc.team5677.robot.OI;
import org.usfirst.frc.team5677.robot.subsystems.Manipulator;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Turns on the motor for the intake to suck in the boulder.
 * 
 * @author Vedaad Shakib
 */
public class ShooterManualSpeedCommand extends Command {
    Manipulator manipulator;
    OI oi;
    Joystick joystickLeft;
	
    public ShooterManualSpeedCommand() {
        manipulator = Manipulator.getInstance();
	oi = OI.getInstance();
	joystickLeft = OI.getLeftJoystick();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
	manipulator.setShooterRot(0.3*joystickLeft.getRawAxis(0));
	manipulator.setShooter(0.3*joystickLeft.getRawAxis(1));
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
