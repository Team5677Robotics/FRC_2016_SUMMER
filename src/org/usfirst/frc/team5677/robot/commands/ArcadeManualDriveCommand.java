package org.usfirst.frc.team5677.robot.commands;

import org.usfirst.frc.team5677.robot.OI;
import org.usfirst.frc.team5677.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5677.robot.subsystems.SmartDrive;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Enables the joystick to control the drivetrain via arcade drive.
 *
 * @author Vedaad Shakib
 * @version 02/11/16
 */
public class ArcadeManualDriveCommand extends Command {
  SmartDrive sd;

  public ArcadeManualDriveCommand() {
    sd = SmartDrive.getInstance();
    requires(sd);
  }

  // Called just before this Command runs the first time
  protected void initialize() {}

  // Called repeatedly when this Command is scheduled to run
  protected void execute() {
      //Joystick setup if we are usign the logitech joysticks
      //sd.arcadeDrive(-OI.getLeftJoystick().getRawAxis(1), OI.getRightJoystick().getRawAxis(0));
      sd.arcadeDrive(OI.getRobotDriver().getLeftY(), OI.getRobotDriver().getRightX());
  }

  // Make this return true when this Command no longer needs to run execute()
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  protected void end() {}

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  protected void interrupted() {}
}
