// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.AlgaeHold.ManualAlgaeHold;
import frc.robot.commands.CoralHold.CoralHoldWithCounter;
import frc.robot.commands.CoralHold.CoralManualHold;
import frc.robot.commands.CoralHold.CoralRelease;
import frc.robot.commands.CoralPivot.CoralManualPivot;
import frc.robot.subsystems.AlgaeHold;
import frc.robot.commands.Elevator.ManualUpDown;
import frc.robot.commands.Elevator.PIDToHeight;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.CoralHold;
import frc.robot.subsystems.CoralPivot;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  //CONTROLLERS
  XboxController driverController = new XboxController(Constants.Controller.USB_DRIVECONTROLLER);
  XboxController auxController = new XboxController(Constants.Controller.USB_AUXCONTROLLER);
  
  //SUBSYSTEMS
  private final AlgaeHold algaeHold = new AlgaeHold();
  private final Elevator elevator = new Elevator();
  private final CoralHold coralHold = new CoralHold();
  private final CoralPivot coralPivot = new CoralPivot();
  
  //COMMANDS
  // algae hold
  private final ManualAlgaeHold manualAlgaeHold = new ManualAlgaeHold(algaeHold, Constants.AlgaeHold.HOLD_SPEED);
  private final ManualAlgaeHold manualAlgaeRelease = new ManualAlgaeHold(algaeHold, Constants.AlgaeHold.RELEASE_SPEED);
  
  // elevator
  private final ManualUpDown manualUp = new ManualUpDown(elevator, Constants.Elevator.ELEV_UP_SPEED);
  private final ManualUpDown manualDown = new ManualUpDown(elevator, Constants.Elevator.ELEV_DOWN_SPEED);

  private final PIDToHeight PIDtoL1 = new PIDToHeight(elevator, Constants.Elevator.L1_HEIGHT);
  private final PIDToHeight PIDtoL2 = new PIDToHeight(elevator, Constants.Elevator.L2_HEIGHT);
  private final PIDToHeight PIDtoL3 = new PIDToHeight(elevator, Constants.Elevator.L3_HEIGHT);

// coral pivot
  private final CoralManualPivot manualCoralPivotUp = new CoralManualPivot(coralPivot, Constants.CoralPivot.CORAL_PIVOT_UP_SPEED);
  private final CoralManualPivot manualCoralPivotDown = new CoralManualPivot(coralPivot, Constants.CoralPivot.CORAL_PIVOT_DOWN_SPEED);

  // coral hold
  private final CoralManualHold manualCoralHold = new CoralManualHold(coralHold, Constants.CoralHoldCon.HOLD_SPEED);
  private final CoralRelease coralRelease = new CoralRelease(coralHold, Constants.CoralHoldCon.RELEASE_SPEED);

  private final CoralHoldWithCounter counterCoralHold = new CoralHoldWithCounter(coralHold, Constants.CoralHoldCon.HOLD_SPEED);

    //level 4 release has a positive speed, not negative. the motor will spin in the same direction as if it is Hold
  private final CoralRelease coralReleaseL4 = new CoralRelease(coralHold, Constants.CoralHoldCon.L4_RELEASE_SPEED);
  

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
    // CREATE BUTTONS
    // XBOXCONTROLLER - DRIVER CONTROLLER
    JoystickButton x = new JoystickButton(driverController, Constants.XboxController.X);
    JoystickButton a = new JoystickButton(driverController, Constants.XboxController.A);
    JoystickButton b = new JoystickButton(driverController, Constants.XboxController.B);
    JoystickButton y = new JoystickButton(driverController, Constants.XboxController.Y);
    JoystickButton lb = new JoystickButton(driverController, Constants.XboxController.LB);
    JoystickButton rb = new JoystickButton(driverController, Constants.XboxController.RB);
    JoystickButton lm = new JoystickButton(driverController, Constants.XboxController.LM);
    JoystickButton rm = new JoystickButton(driverController, Constants.XboxController.RM);
    JoystickButton view = new JoystickButton(driverController, Constants.XboxController.VIEW);
    JoystickButton menu = new JoystickButton(driverController, Constants.XboxController.MENU);
    POVButton upPov = new POVButton(driverController,Constants.XboxController.POVXbox.UP_ANGLE);
    POVButton downPov = new POVButton(driverController,Constants.XboxController.POVXbox.DOWN_ANGLE); 
    POVButton leftPov = new POVButton(driverController,Constants.XboxController.POVXbox.LEFT_ANGLE);
    POVButton rightPov = new POVButton(driverController,Constants.XboxController.POVXbox.RIGHT_ANGLE);
    // XBOX CONTROLLER - AUX CONTROLLER
    JoystickButton x1 = new JoystickButton(auxController, Constants.XboxController.X);
    JoystickButton a1 = new JoystickButton(auxController, Constants.XboxController.A);
    JoystickButton b1 = new JoystickButton(auxController, Constants.XboxController.B);
    JoystickButton y1 = new JoystickButton(auxController, Constants.XboxController.Y);
    JoystickButton lb1 = new JoystickButton(auxController, Constants.XboxController.LB);
    JoystickButton rb1 = new JoystickButton(auxController, Constants.XboxController.RB);
    JoystickButton lm1 = new JoystickButton(auxController, Constants.XboxController.LM);
    JoystickButton rm1 = new JoystickButton(auxController, Constants.XboxController.RM);
    JoystickButton view1 = new JoystickButton(auxController, Constants.XboxController.VIEW);
    JoystickButton menu1 = new JoystickButton(auxController, Constants.XboxController.MENU);
    POVButton upPov1 = new POVButton(auxController,Constants.XboxController.POVXbox.UP_ANGLE);
    POVButton downPov1 = new POVButton(auxController,Constants.XboxController.POVXbox.DOWN_ANGLE);
    POVButton leftPov1 = new POVButton(auxController,Constants.XboxController.POVXbox.LEFT_ANGLE);
    POVButton rightPov1 = new POVButton(auxController,Constants.XboxController.POVXbox.RIGHT_ANGLE);

    // ALL BUTTONS BELOW ARE PLACEHOLDER

    // ELEVATOR - zero manually before PID
    upPov.whileTrue(manualUp);
    downPov.whileTrue(manualDown);

    a.onTrue(PIDtoL1); // 6 in
    b.onTrue(PIDtoL2); // 12 in
    x.onTrue(PIDtoL3); // 18 in

    // ALGAE hold 

    x1.whileTrue(manualAlgaeHold);
    y1.whileTrue(manualAlgaeRelease);
    //CORAL PIVOT

    lb1.whileTrue(manualCoralPivotUp);
    rb1.whileTrue(manualCoralPivotDown);

    // CORAL HOLD
  
    rightPov.whileTrue(manualCoralHold);
    leftPov.whileTrue(coralRelease);
    rb.whileTrue(counterCoralHold);
    lb.whileTrue(coralRelease);
    lm.whileTrue(coralReleaseL4);

  }
   /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return null; // Replace with autonomous command
    //  return new ExampleCommand(m_exampleSubsystem);
  }

}