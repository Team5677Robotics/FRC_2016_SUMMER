package org.usfirst.frc.team5677.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5677.robot.wrappers.GamepadWrapper;
import org.usfirst.frc.team5677.robot.wrappers.JoystickButtonWrapper;

import org.usfirst.frc.team5677.robot.commands.IntakeInCommand;
import org.usfirst.frc.team5677.robot.commands.IntakeOutCommand;
import org.usfirst.frc.team5677.robot.commands.ConveyorOutCommand;
import org.usfirst.frc.team5677.robot.commands.ConveyorInCommand;
import org.usfirst.frc.team5677.robot.commands.IntakeSolenoidTriggerCommand;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 *
 * @author Vedaad Shakib
 * @version 07/30/16
 */
public class OI {
  private static OI oi;
  private static Joystick joystickLeft;
  private static Joystick joystickRight;
  private static GamepadWrapper robotDriver;

  /*
   * Creates joystick instances and maps buttons
   */
  public OI() {
    joystickLeft = new Joystick(0);
    joystickRight = new Joystick(1);
    robotDriver = new GamepadWrapper(3);

    robotDriver.getButtonA().whenPressed(new IntakeInCommand());
    robotDriver.getButtonB().whenPressed(new IntakeOutCommand());
    robotDriver.getButtonX().whenPressed(new ConveyorInCommand());
    robotDriver.getButtonY().whenPressed(new ConveyorOutCommand());
    
    robotDriver.getButtonBumperLeft().whenPressed(new IntakeSolenoidTriggerCommand());
  }

  public static void initialize() {
    if (oi == null) {
      oi = new OI();
    }
  }
    
  public static OI getInstance() {
    initialize();
    return oi;
  }

  public static GamepadWrapper getRobotDriver() {
    return robotDriver;
  }

  public static Joystick getRightJoystick() {
    return joystickRight;
  }

  public static Joystick getLeftJoystick() {
    return joystickLeft;
  }
}
