package org.usfirst.frc.team5677.robot.subsystems;


import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import org.usfirst.frc.team5677.robot.Constants;

/**
 * This subsystem includes methods to operate the DriveTrain.
 *
 * @author Rishi Desai
 * @author Vedaad Shakib
 * @version 7/30/16
 */
public class DriveTrain {
  // motors
  public Spark leftMotor1, leftMotor2, rightMotor1, rightMotor2;
  public Encoder leftEncoder, rightEncoder;

  // speed scales
  private static double LEFT_SCALE = 1;
  private static double RIGHT_SCALE = 1;

  // singleton instance of DriveTrain
  private static DriveTrain drive;

  /** Initializes the Sparks. */
  public DriveTrain() {
    this.leftMotor1 = new Spark(Constants.DriveTrain.LEFT_SPARK_PORT_1);
    this.leftMotor2 = new Spark(Constants.DriveTrain.LEFT_SPARK_PORT_2);
    this.rightMotor1 = new Spark(Constants.DriveTrain.RIGHT_SPARK_PORT_1);
    this.rightMotor2 = new Spark(Constants.DriveTrain.RIGHT_SPARK_PORT_2);
    this.leftEncoder =
        new Encoder(
            Constants.DriveTrain.LEFT_ENCODER_PORT_A,
            Constants.DriveTrain.LEFT_ENCODER_PORT_B,
            false,
            Encoder.EncodingType.k4X);
    this.rightEncoder =
        new Encoder(
            Constants.DriveTrain.RIGHT_ENCODER_PORT_A,
            Constants.DriveTrain.RIGHT_ENCODER_PORT_B,
            false,
            Encoder.EncodingType.k4X);
    this.leftEncoder.reset();
    this.rightEncoder.reset();
    this.leftEncoder.setDistancePerPulse(
        (Constants.DriveTrain.WHEEL_DIAM * Math.PI) / Constants.DriveTrain.ENCODER_CYCLES_PER_REV);
    this.rightEncoder.setDistancePerPulse(
        (Constants.DriveTrain.WHEEL_DIAM * Math.PI) / Constants.DriveTrain.ENCODER_CYCLES_PER_REV);
  }

  public static void initialize() {
    if (drive == null) {
      drive = new DriveTrain();
    }
  }

  public static DriveTrain getInstance() {
    initialize();
    return drive;
  }

  public void setLeftSpeed(double speed) {
    leftMotor1.set(speed * LEFT_SCALE);
    leftMotor2.set(speed * LEFT_SCALE);
  }

  public void setRightSpeed(double speed) {
    // motor is inverted
    rightMotor1.set(-speed * RIGHT_SCALE);
    rightMotor2.set(-speed * RIGHT_SCALE);
  }

  public void resetEncoders() {
    this.leftEncoder.reset();
    this.rightEncoder.reset();
  }

  public int getLeftEncoderRawCount() {
    return this.leftEncoder.getRaw();
  }

  public int getRightEncoderRawCount() {
    return this.rightEncoder.getRaw();
  }

  public double getLeftEncoderRate() {
    return this.leftEncoder.getRate();
  }

  public double getRightEncoderRate() {
    return this.rightEncoder.getRate();
  }
}
