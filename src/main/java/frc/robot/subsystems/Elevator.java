// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
  /** Creates a new Elevator. */
  private SparkMax leftElevatorMotor, rightElevatorMotor;
  private SparkMaxConfig leftConfig, rightConfig;

  public RelativeEncoder leftElevEncoder, rightElevEncoder;

  private DigitalInput topLimitSwitch, bottomLimitSwitch;
  private DoubleSolenoid elevatorBrake;
  private boolean isTException, isBException;

  public Elevator() {
    leftElevatorMotor = new SparkMax(Constants.MotorControllers.ID_ELEVATOR_LEFT, MotorType.kBrushless);
    rightElevatorMotor = new SparkMax(Constants.MotorControllers.ID_ELEVATOR_RIGHT, MotorType.kBrushless);

    leftConfig = new SparkMaxConfig();
    leftConfig.inverted(true);
    rightConfig = new SparkMaxConfig();
    rightConfig.inverted(false);

    leftElevatorMotor.configure(leftConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
    rightElevatorMotor.configure(rightConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);

    try {
      topLimitSwitch = new DigitalInput(Constants.Elevator.DIO_ELEV_TOP);
    } catch (Exception e) {
      isTException = true;
      SmartDashboard.putBoolean("exception thrown for elev bottom limit: ", isTException);
    }

    try {
      bottomLimitSwitch = new DigitalInput(Constants.Elevator.DIO_ELEV_BOTTOM);
    } catch (Exception e) {
      isBException = true;
      SmartDashboard.putBoolean("exception thrown for elev bottom limit: ", isBException);
    }

    elevatorBrake = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.Elevator.SOL_BRAKE_ON, Constants.Elevator.SOL_BRAKE_OFF);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
