// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.CoralPivot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CoralPivot;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class ManualMove extends Command {

  private CoralPivot coralPivot;
  private double coralSpeed;

  /** Creates a new ManualMove. */
  public ManualMove(CoralPivot coralPivot, double coralSpeed) {
    this.coralPivot = coralPivot;
    this.coralSpeed = coralSpeed;

    addRequirements(this.coralPivot);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    //may need to use -speed?
    coralPivot.setCoralPivotSpeed(coralSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    coralPivot.stopCoralPivot();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
