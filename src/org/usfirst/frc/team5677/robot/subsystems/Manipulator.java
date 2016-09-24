package org.usfirst.frc.team5677.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.Spark;
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
    
    public double getShooter() {
	return this.shooter.get();
    }

    public void setShooter(double speed) {
	shooter.set(speed);
    }
}
