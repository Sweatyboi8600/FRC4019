// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.Suckythingmbob;

public class AutoShoot extends CommandBase {
  /** Creates a new AutoClawRelease. */
  Suckythingmbob suckythingmbob;
  long startTime;
  public AutoShoot(Suckythingmbob suckythingmbob) {
    this.suckythingmbob = suckythingmbob;
    addRequirements(suckythingmbob);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = System.currentTimeMillis();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    suckythingmbob.intakeSet(-1);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    suckythingmbob.intakeSet(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return System.currentTimeMillis()-startTime>= Constants.Times.SHOOT_AUTO;
  }
}
