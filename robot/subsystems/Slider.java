// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Slider extends SubsystemBase {
  TalonSRX slider;
  DigitalInput inLimitSwitch, outLimitSwitch;

  /** Creates a new Slider. */
  public Slider() {
   slider = new TalonSRX(Constants.Talons.IDs.S_TALON_ID);

   slider.setInverted(Constants.Talons.Inversions.S_TALON_INVERT);
   slider.setNeutralMode(NeutralMode.Brake);
   inLimitSwitch = new DigitalInput(Constants.Sensor.LimitSwitch.IDs.SLIDER_IN_ID);
   outLimitSwitch = new DigitalInput(Constants.Sensor.LimitSwitch.IDs.SLIDER_OUT_ID);

  }

  @Override
  public void periodic() {
    SmartDashboard.putBoolean("outLimit", GetOutLimit());
    SmartDashboard.putBoolean("inLimit", GetInLimit());
    
    // This method will be called once per scheduler run
  }
  public void Set(double speed){
    slider.set(ControlMode.PercentOutput, speed);
  }
  public boolean GetInLimit(){
    return inLimitSwitch.get();
  }
  public boolean GetOutLimit(){
    return outLimitSwitch.get();
  }
}
