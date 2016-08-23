package org.usfirst.frc.team5677.robot.commands;

import org.usfirst.frc.team5677.robot.OI;
import org.usfirst.frc.team5677.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5677.robot.subsystems.SmartDrive;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Enables the joystick to control the drivetrain via tank drive.
 * 
 * @author Vedaad Shakib
 * @version 02/11/16
 */
public class TankManualDriveCommand extends Command {
    SmartDrive sd;
	
    public TankManualDriveCommand() {
        sd = SmartDrive.getInstance();
	requires(sd);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	
        if(OI.getLeftJoystick().getRawButton(1)){
            sd.tankDrive(1.0, 1.0);
        }else{
            sd.tankDrive(0.0, 0.0);
        }
        //sd.tankDrive(-OI.getLeftJoystick().getRawAxis(1), -OI.getRightJoystick().getRawAxis(1));
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
