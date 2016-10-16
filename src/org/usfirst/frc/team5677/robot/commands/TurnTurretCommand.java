package org.usfirst.frc.team5677.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5677.robot.controllers.TurretController;
import org.usfirst.frc.team5677.robot.subsystems.Manipulator;

/**
 * Toggles the intake motor
 *
 * @author Rishi Desai
 */
public class TurnTurretCommand extends Command {
  Manipulator manipulator;
  TurretController turretController;

  public TurnTurretCommand(double setpoint) {
    manipulator = Manipulator.getInstance();
    turretController = new TurretController();
    turretController.setSetpoint(manipulator.getTurretDegreesToTicks(setpoint));
    turretController.resetError();
  }

  // Called just before this Command runs the first time
  protected void initialize() {
    manipulator.resetTurretEncoder();
    turretController.resetError();
  }

  // Called repeatedly when this Command is scheduled to run
  protected void execute() {
    //System.out.println("execute");
    //System.out.println(manipulator.getIsRevMode());

    //System.out.println(manipulator.getFlywheelRPM());
    double output = turretController.getTurretSpeed(manipulator.getFlywheelRPM());
    //double output = 0.7;
    System.out.println(output);
    manipulator.setTurret(output);
  }

  // Make this return true when this Command no longer needs to run execute()
  protected boolean isFinished() {
    return turretController.isFinished(manipulator.getTurretEncoderRawCount());
  }

  // Called once after isFinished returns true
  protected void end() {
    manipulator.setTurret(0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  protected void interrupted() {}
}
