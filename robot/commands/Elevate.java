// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Elevator;
import java.util.function.DoubleSupplier;

public class Elevate extends CommandBase {
  /** Creates a new elevate. */
  Elevator elevator;

  DoubleSupplier forward;

  public Elevate(Elevator elevator, DoubleSupplier forward) {
    this.elevator = elevator;
    this.forward = forward;
    addRequirements(elevator);// here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //SmartDashboard.getNumber("elelelevator", elevator.getEncoder());

    elevator.Set(Constants.Talons.Speed.ELEVATOR_TALON_SPEED * forward.getAsDouble());
  }

 

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
