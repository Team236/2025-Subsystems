// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class CoralHold extends Command {
  /** Creates a new CoralHold. */

  private SparkMax coralMotor;
  private SparkMaxConfig coralConfig;
  public static Counter counter;
  public static boolean isCounterUnplugged = false;

  public CoralHold() {
    // Use addRequirements() here to declare subsystem dependencies.

    coralMotor = new SparkMax(Constants.MotorControllers.ID_CORALMOTOR, MotorType.kBrushless);

    coralConfig = new SparkMaxConfig();
    coralConfig.inverted(true);

    coralMotor.configure(coralConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);

      try {
      counter = new Counter();
      counter.setUpSource(Constants.CoralHold.DIO_COUNTER);
      counter.reset();
    }

    catch (Exception e) {
      isCounterUnplugged = true;
    }

    SmartDashboard.putBoolean("is counter unplugged:", isCounterUnplugged);
    counter.reset(); //sets counter to zero
  }

  @Override
  public void initialize() {
    // automaticaly sets counter to 0 at start 
    counter.reset();
  }

  public void setCoralSpeed(double speed) {
    coralMotor.set(speed);
  }


  public void coralStop () {
    coralMotor.set(0);
  }

  public static int getCoralCount () {
    // grabs number of coral (normaly 0 or 1)
    int count;
    count = counter.get();
    return count;
  }

  public boolean isCoralSpinning() {
    boolean spin;
    if (Math.abs(coralMotor.get()) >0.1) {
      spin = true;
    }
    else {
      spin = false;
    }
    return spin;
  }

  @Override
  public void execute() {
    SmartDashboard.putNumber("Intake periodic count is:", getCoralCount());
   SmartDashboard.putBoolean("HasNote: ", counter.get()>0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
