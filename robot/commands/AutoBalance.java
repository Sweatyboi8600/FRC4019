// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

public class AutoBalance extends CommandBase {
  /** Creates a new AutoBalance. */
  Drivetrain drivetrain;
  public AutoBalance( Drivetrain drivetrain) {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // if(-Constants.Threshold.GYRO_THRESHOLD < drivetrain.getAngle() && Constants.Threshold.GYRO_THRESHOLD> drivetrain.getAngle()){
    //   drivetrain.set(0, 0);
    // }
    // else {
    //   drivetrain.set(Constants.Talons.Speed.AUTO_DRIVE_TALON_SPEED * drivetrain.getAngle(), 
    //   Constants.Talons.Speed.AUTO_DRIVE_TALON_SPEED * drivetrain.getAngle());
    // }
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
