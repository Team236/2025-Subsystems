// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AlgaeHold;

import edu.wpi.first.wpilibj2.command.Command;

public class AlgaeHold extends Command {
  private AlgaeHold algaeHold;
  private double speed;

  public AlgaeHold(AlgaeHold algaeHold, double speed) {
    this.algaeHold = algaeHold;
    this.speed = speed;
    
    addRequirements(this.algaeHold); //TODO still not sure why it is doing this, may be import related
  }

  @Override
  public void initialize() {}
  
  @Override
  public void execute() {
    this.algaeHold.setAlgaeHoldSpeed(speed);
  }
  
  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
