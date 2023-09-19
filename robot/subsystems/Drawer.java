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

public class Drawer extends SubsystemBase {
  DigitalInput inLimitSwitch, outLimitSwitch;
  TalonSRX rightDraw, leftDraw;
  /** Creates a new Drawer. */
  public Drawer() {
    inLimitSwitch = new DigitalInput(Constants.Sensor.LimitSwitch.IDs.DRAWER_IN_ID);
    outLimitSwitch = new DigitalInput(Constants.Sensor.LimitSwitch.IDs.DRAWER_OUT_ID);

    rightDraw = new TalonSRX(Constants.Talons.IDs.RD_TALON_ID);
    leftDraw = new TalonSRX(Constants.Talons.IDs.LD_TALON_ID);
    rightDraw.setInverted(Constants.Talons.Inversions.RD_TALON_INVERT);
    rightDraw.setInverted(Constants.Talons.Inversions.LD_TALON_INVERT);
    rightDraw.setNeutralMode(NeutralMode.Brake);
    leftDraw.setNeutralMode(NeutralMode.Brake);

    rightDraw.follow(leftDraw);



  }

  @Override
  public void periodic() {
    SmartDashboard.putBoolean("outLimit", getOutLimit());
    SmartDashboard.putBoolean("InLimit", getInLimit());


    // This method will be called once per scheduler run
  }
  public void Set(double speed){
    leftDraw.set(ControlMode.PercentOutput, speed);


  }
  public boolean getInLimit(){
    return inLimitSwitch.get();
  }
    public boolean getOutLimit(){
    return outLimitSwitch.get();
  }

}
