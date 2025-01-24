// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class AlgaePivot extends SubsystemBase {
  
  private SparkMax algaePivotMotor;
  private SparkMaxConfig algaePivotConfig;

  private DigitalInput algaeExtLimit, algaeRetLimit;

  private RelativeEncoder algaePivotEncoder;

  private SparkClosedLoopController algaeClosedLoopController;

  public AlgaePivot() {
    algaePivotMotor = new SparkMax(Constants.MotorControllers.ID_ALGAE_PIVOT, MotorType.kBrushless);

    algaePivotEncoder = algaePivotMotor.getEncoder();
    algaeClosedLoopController = algaePivotMotor.getClosedLoopController();

    algaePivotConfig = new SparkMaxConfig();
    algaePivotConfig.closedLoop.pidf(Constants.AlgaePivot.KP, Constants.AlgaePivot.KI, Constants.AlgaePivot.KD, Constants.AlgaePivot.KFF);
    algaePivotConfig.encoder.positionConversionFactor(Constants.AlgaePivot.ENC_CONVERSION_FACTOR);

    SmartDashboard.setDefaultBoolean("Algae Exterior Digital Input threw an exception", false);
    SmartDashboard.setDefaultBoolean("Algae Retracted Digital Input threw an exception", false);

    try {
      algaeExtLimit = new DigitalInput(Constants.AlgaePivot.DIO_EXT_LIMIT);
    } catch (Exception e)
    {
      SmartDashboard.putBoolean("Algae Exterior Digital Input threw an exception", true);
    }
    try {
      algaeRetLimit = new DigitalInput(Constants.AlgaePivot.DIO_RET_LIMIT);
    } catch (Exception e)
    {
      SmartDashboard.putBoolean("Algae Retracted Digital Input threw an exception", true);
    }
  }

  public void setPosition(double revs)
  {
    algaeClosedLoopController.setReference(revs, ControlType.kPosition);
  }

  public void setAlgaePivotSpeed(double speed)
  {
    if (isRetLimit() || isExtLimit())
    {
      stopAlgaePivot();
    } else
    {
      algaePivotMotor.set(speed);
    }
  }

  public void stopAlgaePivot()
  {
    algaePivotMotor.set(0);
  }

  public boolean isRetLimit()
  {
    return algaeRetLimit.get();
  }

  public boolean isExtLimit()
  {
    return algaeExtLimit.get();
  }

  public void resetPivotEncoder()
  {
    algaePivotEncoder.setPosition(0);
  }

  public double getPivotEncoder()
  {
    return algaePivotEncoder.getPosition();
  }

  public boolean isFullyExtended()
  {
    return getPivotEncoder() <= Constants.AlgaePivot.ENC_REVS_MAX;
  }

  public double getPivotSpeed()
  {
    return algaePivotMotor.get();
  }

  @Override
  public void periodic() {
    SmartDashboard.putBoolean("Algae Pivot hit exterior limit", isExtLimit());
    SmartDashboard.putBoolean("Algae Pivot hit retract limit", isRetLimit());
    SmartDashboard.putBoolean("Algae Pivot is fully extended", isFullyExtended());
    SmartDashboard.putNumber("Algae Pivot encoder revolution units", getPivotEncoder());
  }
}
