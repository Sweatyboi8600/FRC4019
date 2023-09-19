// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;
import frc.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class Drive extends CommandBase {
  private final Drivetrain drivetrain;
  private final DoubleSupplier ThrottleSupplier;
  private final DoubleSupplier RotationSupplier;
  private final DoubleSupplier ForewardSupplier;

  /** Creates a new Drive. */
  public Drive(Drivetrain drivetrain,
      DoubleSupplier forwardSupplier,
      DoubleSupplier rotationSupplier,
      DoubleSupplier throttleSupplier) {
    this.drivetrain = drivetrain;
    ForewardSupplier = forwardSupplier;

    RotationSupplier = rotationSupplier;
    ThrottleSupplier = throttleSupplier;

    addRequirements(drivetrain);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double forward = ForewardSupplier.getAsDouble();
    double rotation = RotationSupplier.getAsDouble();
    double throttle = ThrottleSupplier.getAsDouble() / -2 + 0.5;
    drivetrain.arcadeDrive(forward, rotation, throttle);

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
