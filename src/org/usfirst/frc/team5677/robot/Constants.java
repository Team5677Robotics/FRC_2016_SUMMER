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
      public static final int LEFT_SPARK_PORT_1 = 2;
      public static final int LEFT_SPARK_PORT_2 = 3;
      public static final int RIGHT_SPARK_PORT_1 = 0;
      public static final int RIGHT_SPARK_PORT_2 = 1;
      
      public static final int RIGHT_ENCODER_PORT_A = 10;
      public static final int RIGHT_ENCODER_PORT_B = 11;
      public static final int LEFT_ENCODER_PORT_A = 12;
      public static final int LEFT_ENCODER_PORT_B = 13;
      
      public static final int ENCODER_CYCLES_PER_REV = 256;
      public static final double WHEEL_DIAM = 7.6;
  }
    
  public class Manipulator {
      public static final int INTAKE_MOTOR_PORT = 4;
      public static final int CONVEYOR_MOTOR_PORT = 6;
      
      public static final int INTAKE_SOLENOID_PORT = 7;
  }
}
