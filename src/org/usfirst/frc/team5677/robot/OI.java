package org.usfirst.frc.team5677.robot;

import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team5677.robot.commands.IntakeSolenoidTriggerCommand;
import org.usfirst.frc.team5677.robot.commands.ManipulatorSetSpeedCommand;
import org.usfirst.frc.team5677.robot.commands.ShooterHoodTriggerCommand;
import org.usfirst.frc.team5677.robot.commands.ToggleRevModeCommand;
import org.usfirst.frc.team5677.robot.commands.TurnTurretCommand;
import org.usfirst.frc.team5677.robot.wrappers.GamepadWrapper;
import org.usfirst.frc.team5677.robot.wrappers.JoystickButtonWrapper;
/**
 * This class is the glue that binds the controls on the physical operator interface to the commands
 * and command groups that allow control of the robot.
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

    //spit-out
    JoystickButtonWrapper button4 = new JoystickButtonWrapper(joystickLeft, 5);
    button4.whenPressed(new ManipulatorSetSpeedCommand(0.7));
    button4.whenReleased(new ManipulatorSetSpeedCommand(0));
    //intake
    JoystickButtonWrapper button5 = new JoystickButtonWrapper(joystickLeft, 4);
    button5.whenPressed(new ManipulatorSetSpeedCommand(-0.7));
    button5.whenReleased(new ManipulatorSetSpeedCommand(0));

    JoystickButtonWrapper button2 = new JoystickButtonWrapper(joystickLeft, 2);
    button2.whenPressed(new IntakeSolenoidTriggerCommand());

    JoystickButtonWrapper button3 = new JoystickButtonWrapper(joystickLeft, 3);
    button3.whenPressed(new ShooterHoodTriggerCommand());

    JoystickButtonWrapper button1 = new JoystickButtonWrapper(joystickLeft, 1);
    button1.whenPressed(new ToggleRevModeCommand());

    JoystickButtonWrapper button6 = new JoystickButtonWrapper(joystickLeft, 6);
    button6.whenPressed(new TurnTurretCommand(25.0));
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
