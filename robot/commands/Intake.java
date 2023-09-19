// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Suckythingmbob;
import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class Intake extends CommandBase {

  private final Suckythingmbob suckythingmbob;

  /** Creates a new Intake. */
  public Intake(Suckythingmbob suckythingmbob) {
    this.suckythingmbob = suckythingmbob;

    // addRequirements(suckythingmbob);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    suckythingmbob.intakeSet(Constants.Talons.Speed.INTAKE_TALON_SPEED);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    suckythingmbob.intakeSet(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
