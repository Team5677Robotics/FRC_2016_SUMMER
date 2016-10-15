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
      public static final int LEFT_SPARK_PORT_1 = 0;
      public static final int LEFT_SPARK_PORT_2 = 1;
      public static final int RIGHT_SPARK_PORT_1 = 3;
      public static final int RIGHT_SPARK_PORT_2 = 5;
      
      public static final int RIGHT_ENCODER_PORT_A = 14;
      public static final int RIGHT_ENCODER_PORT_B = 15;
      public static final int LEFT_ENCODER_PORT_A = 16;
      public static final int LEFT_ENCODER_PORT_B = 17;
      
      public static final int ENCODER_CYCLES_PER_REV = 256;
      public static final double WHEEL_DIAM = 7.6;
  }
    
    public class Manipulator{ 
      public static final int INTAKE_MOTOR_PORT = 7;
      public static final int CONVEYOR_MOTOR_PORT = 6;
      public static final int TURRET_MOTOR_PORT = 8;
      public static final int FLYWHEEL_MOTOR_PORT = 9;
      
<<<<<<< HEAD
      public static final int INTAKE_SOLENOID_PORT = 0;
      public static final int SHOOTER_HOOD_SOLENOID_PORT=1;

      public static final int FLYWHEEL_ENCODER_PORT_A = 11;
      public static final int FLYWHEEL_ENCODER_PORT_B = 10;
      public static final int TURRET_ENCODER_PORT_A = 12;
      public static final int TURRET_ENCODER_PORT_B = 13;

      public static final double FLYWHEEL_DIAM = 6.25;
      public static final double FLYWHEEL_KP = 0.001;
      public static final double FLYWHEEL_KI = 0.0;	
      public static final double FLYWHEEL_KD = 0.0;
      public static final double FLYWHEEL_SETPOINT = 20000.0;

      public static final double TURRET_KP = 1.0;
      public static final double TURRET_KI = 0.0;	
      public static final double TURRET_KD = 0.0;
	//public static final int TURRET_TICKS_PER_DEGREE = 95;
	public static final int TURRET_TICKS_PER_DEGREE = 24;
=======
      public static final int INTAKE_SOLENOID_PORT = 7;

      public static final int SHOOTER_PORT = 9;
      public static final int SHOOTER_ROT_PORT = 8;
>>>>>>> 724c41e552c67365f69f40069268a99b14ad2f78
  }
}
