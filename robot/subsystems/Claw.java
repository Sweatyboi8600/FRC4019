// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Claw extends SubsystemBase {
  /** Creates a new Claw. */
  TalonSRX claw;

  public Claw() {
    claw = new TalonSRX(Constants.Talons.IDs.C_TALON_ID);
    claw.setInverted(Constants.Talons.Inversions.C_TALON_INVERT);
   
    claw.configFactoryDefault();
    claw.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    claw.setSensorPhase(false);
    claw.setSelectedSensorPosition(0);
    

  }

  @Override
  public void periodic() {
   SmartDashboard.putNumber("claw Encoder",  claw.getSelectedSensorPosition());

    // This method will be called once per scheduler run
  }

  public void Set(double speed) {
    claw.set(ControlMode.PercentOutput, speed);
  }
  // public void resetEncoder(){
  //   claw.setSelectedSensorPosition(0);
  // }

}
