// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CoralHold;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class CoralManualWithCounter extends Command {
  /** Creates a new Coral_Manual. */

  private CoralHold coralHold;
  private double speed;

  public CoralManualWithCounter(CoralHold coralHold, double speed) {
    this.speed = speed;
    this.coralHold = coralHold;

    //addRequirements(this.coralHold);
    addRequirements(this.coralHold);
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    CoralHold.resetCount();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (speed > 0) {
      if (CoralHold.getCoralCount() > 0) {
        coralHold.coralStop();
      } else {
        coralHold.setCoralSpeed(speed);
      }
    } else {
      CoralHold.resetCount();
      coralHold.setCoralSpeed(speed);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.coralHold.coralStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
