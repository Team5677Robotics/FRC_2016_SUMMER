package org.usfirst.frc.team5677.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

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

    // speed scales
    private static double	LEFT_SCALE  = 1;
    private static double	RIGHT_SCALE = 1;

    // singleton instance of DriveTrain
    private static DriveTrain drive;

    /**
     * Initializes the Sparks.
     */
    public DriveTrain() {
        this.leftMotor1	 = new Spark(Constants.DriveTrain.LEFT_SPARK_PORT_1); 
        this.leftMotor2	 = new Spark(Constants.DriveTrain.LEFT_SPARK_PORT_2);
        this.rightMotor1 = new Spark(Constants.DriveTrain.RIGHT_SPARK_PORT_1);
        this.rightMotor2 = new Spark(Constants.DriveTrain.RIGHT_SPARK_PORT_2);
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
        leftMotor1.set(speed*LEFT_SCALE);
        leftMotor2.set(speed*LEFT_SCALE);
    }
    
    public void setRightSpeed(double speed) {
	// motor is inverted
        rightMotor1.set(-speed*RIGHT_SCALE);
        rightMotor2.set(-speed*RIGHT_SCALE);
    }
}
