// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class AlgaePivot extends SubsystemBase {
  
  private SparkMax algaePivotMotor;
  private SparkMaxConfig algaePivotConfig;

  private DigitalInput algaeExtLimit, algaeRetLimit;

  private RelativeEncoder algaePivotEncoder;

  public AlgaePivot() {
    algaePivotMotor = new SparkMax(Constants.MotorControllers.ID_ALGAE_PIVOT, MotorType.kBrushless);

    algaePivotConfig = new SparkMaxConfig();

    algaePivotEncoder = algaePivotMotor.getEncoder();

    algaeExtLimit = new DigitalInput(Constants.AlgaePivot.DIO_EXT_LIMIT);
    algaeRetLimit = new DigitalInput(Constants.AlgaePivot.DIO_RET_LIMIT);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
