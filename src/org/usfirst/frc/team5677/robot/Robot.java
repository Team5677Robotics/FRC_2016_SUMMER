package org.usfirst.frc.team5677.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.util.Timer;
import org.usfirst.frc.team5677.lib.trajectory.Segment;
import org.usfirst.frc.team5677.lib.trajectory.TrajectoryGenerator;
import org.usfirst.frc.team5677.robot.commands.RevShooterCommand;
import org.usfirst.frc.team5677.robot.controllers.DriveStraightController;
import org.usfirst.frc.team5677.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5677.robot.subsystems.Manipulator;
import org.usfirst.frc.team5677.robot.subsystems.SmartDrive;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the IterativeRobot documentation. If you change the name of this class
 * or the package after creating this project, you must also update the manifest file in the
 * resource directory.
 */
public class Robot extends IterativeRobot {
  public static OI oi;
  public static DriveTrain drive;
  public static SmartDrive sd;
  public static Manipulator manipulator;
  public static DriveStraightController testDrive;
  public static TrajectoryGenerator leftTrajectoryGen;
  public static TrajectoryGenerator rightTrajectoryGen;
  public Command autonomousCommand;
  public SendableChooser chooser;
  public Segment[] leftTrajectory;
  public Segment[] rightTrajectory;
  public Timer timer = new Timer();
  public Compressor compressor;

  public RevShooterCommand revShooterCommand = new RevShooterCommand();

  public CameraServer cam;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  public void robotInit() {
    chooser = new SendableChooser();
    // chooser.addObject("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", chooser);
    oi = OI.getInstance();
    drive = DriveTrain.getInstance();
    sd = SmartDrive.getInstance();
    leftTrajectoryGen = new TrajectoryGenerator(10, 15, 200);
    rightTrajectoryGen = new TrajectoryGenerator(10, 15, 200);
    leftTrajectory = leftTrajectoryGen.calcTrajectory(0, 0, 15);
    rightTrajectory = rightTrajectoryGen.calcTrajectory(0, 0, 15);
    testDrive = new DriveStraightController(leftTrajectory, rightTrajectory, 10, 10, 200, drive);
    manipulator = Manipulator.getInstance();
    compressor = new Compressor(0);
    compressor.setClosedLoopControl(true);

    // camera
    cam = CameraServer.getInstance();
    cam.startAutomaticCapture("cam0");
  }

  /**
   * This function is called once each time the robot enters Disabled mode. You can use it to reset
   * any subsystem information you want to clear when the robot is disabled.
   */
  public void disabledInit() {
    System.out.println("hello");
    testDrive.stop();
    manipulator.setTurret(0.0);
    //timer.purge();
  }

  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the chooser code above
   * (like the commented example) or additional comparisons to the switch structure below with
   * additional strings & commands.
   */
  public void autonomousInit() {
    autonomousCommand = (Command) chooser.getSelected();

    /* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
    switch(autoSelected) {
    case "My Auto":
    	autonomousCommand = new MyAutoCommand();
    	break;
    case "Default Auto":
    default:
    	autonomousCommand = new ExampleCommand();
    	break;
    } */

    // schedule the autonomous command (example)

    if (autonomousCommand != null) autonomousCommand.start();
    drive.resetEncoders();
    System.out.println("This is a test");
    //timer.schedule(testDrive, 0, 5);
    testDrive.start();
    //Segment[] leftTrajectory = leftTrajectoryGen.calcTrajectory(0,0,5);

  }

  /** This function is called periodically during autonomous */
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
    /*for(int i =0; i<leftTrajectory.length; i++){
    System.out.println(leftTrajectory[i].toString());
    //System.out.println(rightTrajectory);
    }*/
  }

  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (autonomousCommand != null) autonomousCommand.cancel();
    drive.resetEncoders();
    manipulator.resetEncoders();
    revShooterCommand.start();
  }

  /** This function is called periodically during operator control */
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    SmartDashboard.putNumber("Left Rate", drive.getLeftEncoderRate());
    SmartDashboard.putNumber("Right Rate", drive.getRightEncoderRate());

    //manipulator.setTurret(oi.getLeftJoystick().getRawAxis(1));
    //System.out.println("Turret Raw: "+manipulator.getTurretEncoderRawCount()
    //		       + " //////// FlyWheel Raw: "+ manipulator.getFlyWheelEncoderRawCount()
    //		       );
    SmartDashboard.putNumber("Turret Raw Count", manipulator.getTurretEncoderRawCount());
    SmartDashboard.putNumber("FlyWheel RPM", manipulator.getFlywheelRPM());
    SmartDashboard.putNumber("Encoder stuff: ", manipulator.turretEncoder.getEncodingScale());
    //System.out.println(SmartDashboard.getNumber("CameraAngle"));
  }

  /** This function is called periodically during test mode */
  public void testPeriodic() {
    LiveWindow.run();
  }
}
