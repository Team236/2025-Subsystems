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
import frc.robot.commands.AlgaeHold.AlgaeGrab;
import frc.robot.commands.AlgaePivot.ManualAlgaePivot;
import frc.robot.commands.AlgaePivot.PIDAlgaePivot;
import frc.robot.commands.CoralHold.CoralHoldWithCounter;
import frc.robot.commands.CoralHold.CoralManualHold;
import frc.robot.commands.CoralHold.CoralRelease;
import frc.robot.subsystems.AlgaeHold;
import frc.robot.subsystems.AlgaePivot;
import frc.robot.commands.Elevator.ManualUpDown;
import frc.robot.commands.Elevator.PIDToHeight;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.CoralHold;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  //Controllers
  XboxController driverController = new XboxController(Constants.Controller.USB_DRIVECONTROLLER);
  XboxController auxController = new XboxController(Constants.Controller.USB_AUXCONTROLLER);

  //Subsystems
  private final AlgaeHold  algaeHold = new AlgaeHold();
  private final AlgaePivot algaePivot = new AlgaePivot();
  private final Elevator elevator = new Elevator();
  private final CoralHold coralHold = new CoralHold();

  //Commmands - Any pid commands put pid at the beginning, then put the subsystem, then put the action :)

  //AlgaeHold
  private final AlgaeGrab algaeGrabPull = new AlgaeGrab(algaeHold, Constants.AlgaeHold.HOLD_SPEED);
  private final AlgaeGrab algaeGrabRelease = new AlgaeGrab(algaeHold, Constants.AlgaeHold.RELEASE_SPEED);

  //AlgaePivot
  private final ManualAlgaePivot algaePivotDown = new ManualAlgaePivot(algaePivot, Constants.AlgaePivot.MAN_EXT_SPEED);
  private final ManualAlgaePivot algaePivotUp = new ManualAlgaePivot(algaePivot, Constants.AlgaePivot.MAN_RET_SPEED);

  private final PIDAlgaePivot pidAlgaePivot1 = new PIDAlgaePivot(algaePivot, Constants.AlgaePivot.ENC_REVS_TEST1);
  private final PIDAlgaePivot pidAlgaePivot2 = new PIDAlgaePivot(algaePivot, Constants.AlgaePivot.ENC_REVS_TEST2);
  
  //Elevator
  private final ManualUpDown elevatorUp = new ManualUpDown(elevator, Constants.Elevator.ELEV_UP_SPEED);
  private final ManualUpDown elevatorDown = new ManualUpDown(elevator, Constants.Elevator.ELEV_DOWN_SPEED);

  private final PIDToHeight pidElevatorL1 = new PIDToHeight(elevator, Constants.Elevator.L1_HEIGHT);
  private final PIDToHeight pidElevatorL2 = new PIDToHeight(elevator, Constants.Elevator.L2_HEIGHT);
  private final PIDToHeight pidElevatorL3 = new PIDToHeight(elevator, Constants.Elevator.L3_HEIGHT);

  //CoralHold
  private final CoralManualHold coralHoldPull = new CoralManualHold(coralHold, Constants.CoralHoldCon.HOLD_SPEED);
  private final CoralRelease coralHoldRelease = new CoralRelease(coralHold, Constants.CoralHoldCon.RELEASE_SPEED);

  private final CoralHoldWithCounter coralHoldCounter = new CoralHoldWithCounter(coralHold, Constants.CoralHoldCon.HOLD_SPEED);
  private final CoralRelease coralHoldReleaseL4 = new CoralRelease(coralHold, Constants.CoralHoldCon.L4_RELEASE_SPEED);

  //CoralPivot





  

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
    //Buttons

    //Main Xbox Controller
    JoystickButton a = new JoystickButton(driverController, Constants.XboxController.A);
    JoystickButton b = new JoystickButton(driverController, Constants.XboxController.B);
    JoystickButton y = new JoystickButton(driverController, Constants.XboxController.Y);
    JoystickButton x = new JoystickButton(driverController, Constants.XboxController.X);
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
    
    //Secondary Xbox Controller
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

    //Inputs

    lb.whileTrue(elevatorDown);
    lm.whileTrue(elevatorUp);

    rb.whileTrue(algaePivotUp);
    rm.whileTrue(algaePivotDown);

    x.onTrue(pidAlgaePivot1);
    y.onTrue(pidAlgaePivot2);

    downPov.onTrue(pidElevatorL1);
    leftPov.onTrue(pidElevatorL2);
    upPov.onTrue(pidElevatorL3);

    a.whileTrue(coralHoldPull);
    b.whileTrue(coralHoldRelease);

    rightPov.whileTrue(coralHoldReleaseL4);


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