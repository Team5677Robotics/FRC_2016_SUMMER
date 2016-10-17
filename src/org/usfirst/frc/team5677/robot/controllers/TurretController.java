package org.usfirst.frc.team5677.robot.controllers;

import org.usfirst.frc.team5677.lib.PIDController;
import org.usfirst.frc.team5677.robot.Constants;

public class TurretController extends PIDController {

  double setpoint;

  public TurretController() {
    super(
        Constants.Manipulator.TURRET_KP,
        Constants.Manipulator.TURRET_KI,
        Constants.Manipulator.TURRET_KD);
  }

  public void setSetpoint(double setpoint) {
    this.setpoint = setpoint;
  }

  public boolean isFinished(double current) {
    double poseUpperBound = this.setpoint + (Constants.Manipulator.TURRET_TICKS_PER_DEGREE / 2);
    double poseLowerBound = this.setpoint - (Constants.Manipulator.TURRET_TICKS_PER_DEGREE / 2);
    return (current < poseUpperBound && current > poseLowerBound);
  }

  public double getTurretSpeed(double current) {
    double turretSpeed = super.getOutput(this.setpoint, current);

    if (turretSpeed > 0.2) {
      turretSpeed = 0.2;
    }

    if (turretSpeed < -0.2) {
      turretSpeed = -0.2;
    }
    return turretSpeed;
  }
};
