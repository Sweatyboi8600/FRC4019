// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.Constants;
import frc.robot.subsystems.Drawer;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DrawOut extends CommandBase {
  /** Creates a new DrawOut. */
  Drawer drawer;

  public DrawOut(Drawer drawer) {
    this.drawer = drawer ;
    /// addRequirements(drawer); //here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drawer.Set(Constants.Talons.Speed.DRAWER_TALON_SPEED);


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drawer.Set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

    return !drawer.getOutLimit();
  }
}
