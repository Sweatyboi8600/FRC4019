// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;
import frc.robot.Constants;

public class AutoElevateDown extends CommandBase {
  /** Creates a new AutoElevateUp. */
  Elevator elevator;
  long startTime;


  public AutoElevateDown(Elevator elevator) {
    this.elevator = elevator;
 addRequirements(elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = System.nanoTime();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    elevator.Set(Constants.Talons.Speed.ELEVATOR_TALON_SPEED);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    elevator.Set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return System.nanoTime() - startTime >= Constants.Times.ELEVATOR_UP_AUTO  ;
  }
}
