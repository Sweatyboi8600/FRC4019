// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Suckythingmbob extends SubsystemBase {
  TalonSRX rightIntake;
  TalonSRX leftIntake;

  /** Creates a new intake. */
  public Suckythingmbob() {
    rightIntake = new TalonSRX(Constants.Talons.IDs.RI_TALON_ID);
    leftIntake = new TalonSRX(Constants.Talons.IDs.LI_TALON_ID);

    rightIntake.setInverted(Constants.Talons.Inversions.RI_TALON_INVERT);
    leftIntake.setInverted(Constants.Talons.Inversions.LI_TALON_INVERT);

    leftIntake.follow(rightIntake);

  }

  public void intakeSet(double speed) {
    rightIntake.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
