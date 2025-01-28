// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.AlgaeHold.AlgaeGrab;
import frc.robot.commands.AlgaePivot.ManualAlgaePivot;
import frc.robot.commands.AlgaePivot.PIDAlgaePivot;
import frc.robot.subsystems.AlgaeHold;
import frc.robot.subsystems.AlgaePivot;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  //CONTROLLERS
  XboxController driverController = new XboxController(Constants.Controller.USB_DRIVECONTROLLER);
  XboxController auxController = new XboxController(Constants.Controller.USB_AUXCONTROLLER);

  //Instance of each SUBSYSTEM
  private final AlgaeHold  algaeHold = new AlgaeHold();
  private final AlgaePivot algaePivot = new AlgaePivot();

  //Instance of each COMMAND
  private final AlgaeGrab holdAlgae = new AlgaeGrab(algaeHold, Constants.AlgaeHold.HOLD_SPEED);
  private final AlgaeGrab releaseAlgae = new AlgaeGrab(algaeHold, Constants.AlgaeHold.RELEASE_SPEED);

  private final ManualAlgaePivot pivotDownAlgae = new ManualAlgaePivot(algaePivot, Constants.AlgaePivot.MAN_EXT_SPEED);
  private final ManualAlgaePivot pivotUpAlgae = new ManualAlgaePivot(algaePivot, Constants.AlgaePivot.MAN_RET_SPEED);

  private final PIDAlgaePivot pidAlgaePivot1 = new PIDAlgaePivot(algaePivot, Constants.AlgaePivot.ENC_REVS_TEST1);
  private final PIDAlgaePivot pidAlgaePivot2 = new PIDAlgaePivot(algaePivot, Constants.AlgaePivot.ENC_REVS_TEST2);
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.

    JoystickButton a = new JoystickButton(driverController, Constants.XboxController.A);
    JoystickButton b = new JoystickButton(driverController, Constants.XboxController.B);
    JoystickButton y = new JoystickButton(driverController, Constants.XboxController.Y);
    JoystickButton x = new JoystickButton(driverController, Constants.XboxController.X);

    a.whileTrue(pivotDownAlgae);
    b.whileTrue(pivotUpAlgae);
    y.onTrue(pidAlgaePivot1);
    x.onTrue(pidAlgaePivot2);
  }

  public Command getAutonomousCommand() {
    return null; // Replace with autonomous command
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  // public Command getAutonomousCommand() {
  //   // An example command will be run in autonomous
  // }
}