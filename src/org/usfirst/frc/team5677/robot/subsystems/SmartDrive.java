package org.usfirst.frc.team5677.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5677.robot.commands.ArcadeManualDriveCommand;

/**
 * High-level Wrapper for DriveTrain class. Capable of performing both arcade and tank drive.
 *
 * @author Rishi Desai
 * @author Vedaad Shakib
 * @version 07/30/16
 */
public class SmartDrive extends Subsystem {
  // singleton instances of drive and sd
  private static DriveTrain drive;
  private static SmartDrive sd;

  /** Constructs a TeleopDrive object */
  public SmartDrive() {
    drive = DriveTrain.getInstance();
    drive.resetEncoders();
  }

  public static void initialize() {
    if (sd == null) {
      sd = new SmartDrive();
    }
  }

  public static SmartDrive getInstance() {
    initialize();
    return sd;
  }

  /**
   * Sets the default command to be manual drive, which allows the human player to drive the robot
   * using the joysticks.
   */
  public void initDefaultCommand() {
    setDefaultCommand(new ArcadeManualDriveCommand());
    //setDefaultCommand(new TankManualDriveCommand());
  }

  /**
   * arcadeDrive.
   *
   * @param throttle, turn
   */
  public void arcadeDrive(double throttle, double turn) {
    double leftSpeed, rightSpeed, skimmedLeftSpeed, skimmedRightSpeed;

    if (turn < 0.1 && turn > -0.1) {
      turn = 0.0;
    }

    if (throttle < 0.1 && throttle > -0.1) {
      throttle = 0.0;
    }
    //System.out.println("throttle: "+throttle+"  ------  turn: "+turn);
    leftSpeed = throttle + turn;
    rightSpeed = throttle - turn;

    //System.out.println("left speeed: " +  leftSpeed + "  -------  right speeed: " + rightSpeed);
    //System.out.println("Left Skim: "+skim(leftSpeed)+"  -------  Right Skim: "+skim(rightSpeed));
    skimmedLeftSpeed = leftSpeed + skim(rightSpeed);
    skimmedRightSpeed = rightSpeed + skim(leftSpeed);

    //System.out.println(
    //    "left speeed: " + skimmedLeftSpeed + "  -------  right speeed: " + skimmedRightSpeed);

    drive.setLeftSpeed(skimmedLeftSpeed);
    drive.setRightSpeed(skimmedRightSpeed);
  }

  /**
   * Does some skimming. Takes off excess speed and dishes it off to the other side.
   *
   * @param speed
   */
  private double skim(double speed) {
    double gain = 0.7;

    if (speed > 1.0) {
      return -((speed - 1.0) * gain);
    } else if (speed < -1.0) {
      return -((speed + 1.0) * gain);
    } else {
      return 0.0;
    }
  }

  /**
   * TankDrive.
   *
   * @param leftY, rightY
   */
  public void tankDrive(double leftY, double rightY) {
    drive.setLeftSpeed(leftY);
    drive.setRightSpeed(rightY);
    //System.out.println("left speeed: " +  leftY + "  -------  right speeed: " + rightY);
    System.out.println(
        "Left Encoder: "
            + drive.getLeftEncoderRate()
            + "  ------- Right Encoder: "
            + drive.getRightEncoderRate());
  }
}
