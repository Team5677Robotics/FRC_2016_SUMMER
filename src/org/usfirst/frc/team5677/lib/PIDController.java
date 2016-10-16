package org.usfirst.frc.team5677.lib;

public class PIDController {

  double kP;
  double kI;
  double kD;
  double prevError;
  double errorSum;

  public PIDController(double kP, double kI, double kD) {
    this.kP = kP;
    this.kI = kI;
    this.kD = kD;
    this.prevError = 0;
    this.errorSum = 0;
  }

  public double getOutput(double setpoint, double current) {
    double error = setpoint - current;
    double P = this.kP * error;
    this.errorSum += error;
    double I = this.kI * errorSum;
    double D = this.kD * (prevError - error);
    this.prevError = error;
    return P + I + D;
  }

  public void resetError() {
    this.prevError = 0.0;
    this.errorSum = 0.0;
  }
}
