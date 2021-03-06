package org.usfirst.frc.team5677.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5677.robot.subsystems.Manipulator;

/**
 * Toggles the intake motor
 *
 * @author Vedaad Shakib
 */
public class ShooterHoodTriggerCommand extends Command {
  Manipulator manipulator;
  double eps = Math.pow(10, -6);

  public ShooterHoodTriggerCommand() {
    manipulator = Manipulator.getInstance();
  }

  // Called just before this Command runs the first time
  protected void initialize() {
    manipulator.setShooterHoodSolenoid(!manipulator.getShooterHoodSolenoid());
  }

  // Called repeatedly when this Command is scheduled to run
  protected void execute() {}

  // Make this return true when this Command no longer needs to run execute()
  protected boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  protected void end() {}

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  protected void interrupted() {}
}
