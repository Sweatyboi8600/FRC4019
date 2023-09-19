// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;
import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardComponent;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Elevator extends SubsystemBase {
  TalonSRX rightelevator;
  TalonSRX leftelevator;

  ShuffleboardTab tab;
  GenericEntry elevatorPos;


  /** Creates a new elevator. */
  public Elevator() {
   
    rightelevator = new TalonSRX(Constants.Talons.IDs.RE_TALON_ID);// Constants.Talons.IDs.RE_TALON_ID);
    leftelevator = new TalonSRX(Constants.Talons.IDs.LE_TALON_ID);// Constants.Talons.IDs.LE_TALON_ID);
    rightelevator.setInverted(Constants.Talons.Inversions.RE_TALON_INVERT);
    leftelevator.setInverted(Constants.Talons.Inversions.LE_TALON_INVERT);
    leftelevator.setNeutralMode(NeutralMode.Brake);
    rightelevator.setNeutralMode(NeutralMode.Brake);
    // leftelevator.follow(rightelevator);
    
    rightelevator.setSelectedSensorPosition(500);

    tab = Shuffleboard.getTab("Elevator");

    elevatorPos = tab.add("Elevator Position", 500).getEntry();


  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // SmartDashboard.putNumber("elevator encoder", rightelevator.getSelectedSensorPosition());
    elevatorPos.setDouble(rightelevator.getSelectedSensorPosition());
   // rightelevator.

  }

  public void Set(double speed) {
    leftelevator.set(ControlMode.PercentOutput, speed);
    rightelevator.set(ControlMode.PercentOutput, speed);

  }

  public void resetEncnoder() {
    rightelevator.setSelectedSensorPosition(0);

  }
  public void getEncoder(){
    rightelevator.getSelectedSensorPosition();
  }

  public double getDistence() {
    return rightelevator.getSelectedSensorPosition() ;
  }
}
