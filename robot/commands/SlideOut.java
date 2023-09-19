// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Slider;

public class SlideOut extends CommandBase {
  /** Creates a new SlideOut. */
  Slider slider;

  public SlideOut(Slider slider) {
    this.slider = slider;

    // addRequirements(slider) ;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    slider.Set(-Constants.Talons.Speed.SLIDER_TALON_SPEED);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    slider.Set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false ;//slider.GetOutLimit();
  }
}
