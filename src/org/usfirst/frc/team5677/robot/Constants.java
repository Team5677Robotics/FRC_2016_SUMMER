package org.usfirst.frc.team5677.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class Constants {
    /**
     * Contains constants used by the DriveTrain subsystem.
     */
    public class DriveTrain {
	public static final int	LEFT_SPARK_PORT_1  = 2;
	public static final int	LEFT_SPARK_PORT_2  = 4;
	public static final int	RIGHT_SPARK_PORT_1 = 1;
	public static final int	RIGHT_SPARK_PORT_2 = 3;
	
	public static final int	ENCODER_RIGHT_PORT = 0;
	public static final int	ENCODER_LEFT_PORT  = 1;
    }
}

