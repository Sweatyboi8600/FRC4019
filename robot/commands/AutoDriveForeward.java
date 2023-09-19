// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

public class AutoDriveForeward extends CommandBase {
  /** Creates a new AutoDriveForeward. */
  Drivetrain drivetrain;
  long startTime;
  public AutoDriveForeward(Drivetrain drivetrain) {
    this.drivetrain = drivetrain;
  addRequirements(drivetrain); //here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime =  System.nanoTime();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.set(-Constants.Talons.Speed.AUTO_DRIVE_TALON_SPEED, Constants.Talons.Speed.AUTO_DRIVE_TALON_SPEED);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.set(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return      System.nanoTime()-startTime>= Constants.Times.DRIVE_FOREWARD_AUTO;
    
  }
}
