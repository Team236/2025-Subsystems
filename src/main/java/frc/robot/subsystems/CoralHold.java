// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class CoralHold extends SubsystemBase {
  /** Creates a new CoralHold. */

  // // TALON SRX
  // private TalonSRX coralMotor;
  // private TalonSRXConfiguration coralConfig;
  // private TalonSRXControlMode controlMode = TalonSRXControlMode.PercentOutput;

  private SparkMax coralMotor;
  private SparkMaxConfig coralConfig;
  public Counter counter;
  public boolean isCounterUnplugged = false;

 
  public CoralHold() {
    // // TALON SRX
    // coralMotor = new TalonSRX(Constants.MotorControllers.ID_CORALMOTOR);
    // coralMotor.setInverted(true);

    // // 3 lines below may not be necessary
    // coralConfig = new TalonSRXConfiguration();
    // coralConfig.peakCurrentLimit = Constants.MotorControllers.SMART_CURRENT_LIMIT;
    // coralMotor.configAllSettings(coralConfig);
    

    // SPARK MAX
    coralMotor = new SparkMax(Constants.MotorControllers.ID_CORALMOTOR , MotorType.kBrushless);

    coralConfig = new SparkMaxConfig();
    coralConfig.inverted(true);

    coralConfig.smartCurrentLimit(Constants.MotorControllers.SMART_CURRENT_LIMIT);

    coralMotor.configure(coralConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);

    try {
      counter = new Counter();
      counter.setUpSource(Constants.CoralHoldCon.DIO_COUNTER);
      counter.reset();
    }

    catch (Exception e) {
      isCounterUnplugged = true;
    }

    SmartDashboard.putBoolean("is counter unplugged:", isCounterUnplugged);
    counter.reset(); //sets counter to zero
  }

  public void resetCount() {
    // automaticaly sets counter to 0 at start 
    counter.reset();
  }

  public void setCoralSpeed(double speed) {
    // coralMotor.set(speed);
  }

  public void coralStop () {
    // // TALON SRX
    // coralMotor.set(controlMode, 0);

    // SPARK MAX
    coralMotor.set(0);
  }

  public int getCoralCount() {
    int count;
    if (isCounterUnplugged) {
      count = 0;
      SmartDashboard.putBoolean("Intake counter unplugged:", isCounterUnplugged);
    } else {
      count =  counter.get();
    }
    return count;
  }

  public boolean isCoralSpinning() {
    boolean  spin;
    
    // // TALON SRX
    // if (Math.abs(coralMotor.getMotorOutputPercent()) > 0.1) {
    //   spin = true;
    // }
    // else {
    //   spin = false;
    // }
    // return spin;

    // SPARK MAX
    if (Math.abs(coralMotor.get()) >0.1) {
      spin = true;
    }
    else {
      spin = false;
    }
    return spin;
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Intake periodic count is:", getCoralCount());
   SmartDashboard.putBoolean("HasNote: ", counter.get()>0);
  }
}
