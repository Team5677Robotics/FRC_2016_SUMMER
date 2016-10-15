package org.usfirst.frc.team5677.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;

import org.usfirst.frc.team5677.robot.Constants;

import org.usfirst.frc.team5677.robot.commands.ShooterManualSpeedCommand;

/**
 * This subsystem includes methods to operate the Manipulator.
 *
 * @author Rishi Desai
 * @author Vedaad Shakib
 * @version 7/30/16
 */
<<<<<<< HEAD
public class Manipulator {
  // motors
  public Victor conveyorMotor;
  public Victor intakeMotor;
  public Victor flyWheelMotor;
  public Victor turretMotor;  
  // solenoids
  public Solenoid intakeSolenoid;
  public Solenoid shooterHoodSolenoid;
  //sensors
  public Encoder turretEncoder;
  public Encoder flyWheelEncoder;  
  // singleton instance of Manipulator
  private static Manipulator manipulator;

    public boolean isRevMode = false;
  /**
   * Initializes the Sparks.
   */
  public Manipulator() {
    this.intakeMotor   = new Victor(Constants.Manipulator.INTAKE_MOTOR_PORT);
    this.conveyorMotor = new Victor(Constants.Manipulator.CONVEYOR_MOTOR_PORT);
    this.flyWheelMotor = new Victor(Constants.Manipulator.FLYWHEEL_MOTOR_PORT);
    this.turretMotor = new Victor(Constants.Manipulator.TURRET_MOTOR_PORT);
    
    this.intakeSolenoid = new Solenoid(Constants.Manipulator.INTAKE_SOLENOID_PORT);
    this.shooterHoodSolenoid = new Solenoid(Constants.Manipulator.SHOOTER_HOOD_SOLENOID_PORT);

    this.turretEncoder = new Encoder(Constants.Manipulator.TURRET_ENCODER_PORT_A,
				     Constants.Manipulator.TURRET_ENCODER_PORT_B,
				     false); 
					
    this.flyWheelEncoder = new Encoder(Constants.Manipulator.FLYWHEEL_ENCODER_PORT_A,
				       Constants.Manipulator.FLYWHEEL_ENCODER_PORT_B,
				       false,
				       Encoder.EncodingType.k4X);

    this.turretEncoder.setDistancePerPulse(Constants.DriveTrain.ENCODER_CYCLES_PER_REV);
    this.turretEncoder.reset();
    this.flyWheelEncoder.reset();
  }

  public static void initialize() {
    if (manipulator == null) {
      manipulator = new Manipulator();
    }
  }

    public void resetEncoders(){
	turretEncoder.reset();
	flyWheelEncoder.reset();
    }

    public void resetTurretEncoder(){
	turretEncoder.reset();
    }
  public static Manipulator getInstance() {
    initialize();
    return manipulator;
  }
=======
public class Manipulator extends Subsystem {
    // motors
    public Spark intakeMotor, conveyorMotor;
    public Spark shooter, shooterRot;
  
    // solenoids
    public Solenoid intakeSolenoid;
    
    // singleton instance of Manipulator
    private static Manipulator manipulator;
    
    /**
     * Initializes the Sparks.
     */
    public Manipulator() {
	this.intakeMotor   = new Spark(Constants.Manipulator.INTAKE_MOTOR_PORT);
	this.conveyorMotor = new Spark(Constants.Manipulator.CONVEYOR_MOTOR_PORT);
	this.shooter = new Spark(Constants.Manipulator.SHOOTER_PORT);
	this.shooterRot = new Spark(Constants.Manipulator.SHOOTER_ROT_PORT);
    }
    
    public static void initialize() {
	if (manipulator == null) {
	    manipulator = new Manipulator();
	}
    }
    
    public static Manipulator getInstance() {
	initialize();
	return manipulator;
    }
>>>>>>> 724c41e552c67365f69f40069268a99b14ad2f78

    public void initDefaultCommand() {
	setDefaultCommand(new ShooterManualSpeedCommand());
    }
    
    public void setIntake(double speed) {
	this.intakeMotor.set(speed);
    }
    
    public double getIntake() {
	return this.intakeMotor.get();
    }
    
    public void setConveyor(double speed) {
	this.conveyorMotor.set(speed);  
    }
    
    public double getConveyor() {
	return this.conveyorMotor.get();
    }
    
    public boolean getIntakeSolenoid() {
	return this.intakeSolenoid.get();
    }
    
    public void setIntakeSolenoid(boolean state) {
	this.intakeSolenoid.set(state);
    }

    public double getShooterRot() {
	return this.shooterRot.get();
    }

    public void setShooterRot(double speed) {
	shooterRot.set(speed);
    }
    
<<<<<<< HEAD
 public double getConveyor() {
   return this.conveyorMotor.get();
 }

 public double getFlyWheel(){
   return this.flyWheelMotor.get();
 }

 public double getTurret(){
   return this.turretMotor.get();
 }

 public void setFlyWheel(double speed){
   this.flyWheelMotor.set(speed);
 }

 public void setTurret(double speed){
   this.turretMotor.set(speed);
 }
    
 public boolean getIntakeSolenoid() {
     return this.intakeSolenoid.get();
 }

 public boolean getShooterHoodSolenoid(){
     return this.shooterHoodSolenoid.get();
 }

 public void setIntakeSolenoid(boolean state) {
     this.intakeSolenoid.set(state);
 }

 public void setShooterHoodSolenoid(boolean state){
     this.shooterHoodSolenoid.set(state);
 }

    public int getTurretDegreesToTicks(double degrees){
	double ticks = Constants.Manipulator.TURRET_TICKS_PER_DEGREE * degrees;
	int round_ticks = (int)ticks;
	return round_ticks;
    }
    
    public int getTurretEncoderRawCount(){
	return turretEncoder.get();
    }

    public int getFlyWheelEncoderRawCount(){
	return flyWheelEncoder.getRaw();
    }

    public double getFlywheelRPM(){
	return flyWheelEncoder.getRate();
    }

    public boolean getIsRevMode(){
	return isRevMode;
    }

    public void setIsRevMode(boolean state){
	if(!state){
	    isRevMode = true;
	}else{
	    isRevMode = false;
	}
=======
    public double getShooter() {
	return this.shooter.get();
    }

    public void setShooter(double speed) {
	shooter.set(speed);
>>>>>>> 724c41e552c67365f69f40069268a99b14ad2f78
    }
}
