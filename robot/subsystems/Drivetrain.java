// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import  frc.robot.Constants;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class Drivetrain extends SubsystemBase {

  TalonSRX RFTalon;
  TalonSRX RBTalon;
  TalonSRX LFTalon;
  TalonSRX LBTalon;
  //ADXRS450_Gyro gyro;


  /** Creates a new Drivetrain. */
  public Drivetrain() {
    RFTalon = new TalonSRX(Constants.Talons.IDs.RF_TALON_ID);
    LFTalon = new TalonSRX(Constants.Talons.IDs.LF_TALON_ID);
    LBTalon = new TalonSRX(Constants.Talons.IDs.LB_TALON_ID);
    RBTalon = new TalonSRX(Constants.Talons.IDs.RB_TALON_ID);

    RFTalon.setInverted(Constants.Talons.Inversions.RF_TALON_INVERT);
    LFTalon.setInverted(Constants.Talons.Inversions.LF_TALON_INVERT);
    RBTalon.setInverted(Constants.Talons.Inversions.RB_TALON_INVERT);
    LBTalon.setInverted(Constants.Talons.Inversions.LB_TALON_INVERT);

    RFTalon.setNeutralMode(NeutralMode.Coast);
    LFTalon.setNeutralMode(NeutralMode.Coast);
    RBTalon.setNeutralMode(NeutralMode.Coast);
    LBTalon.setNeutralMode(NeutralMode.Coast);
    //gyro = new ADXRS450_Gyro();
   // gyro.reset();




    
  }
  public void set(double leftpower, double rightpower){
    RFTalon.set(ControlMode.PercentOutput, rightpower);
    RBTalon.set(ControlMode.PercentOutput, rightpower);
    LBTalon.set(ControlMode.PercentOutput, leftpower);
    LFTalon.set(ControlMode.PercentOutput, leftpower);





  }
  public void arcadeDrive(double forward, double rotation, double throttle) {
    set((forward - rotation) * throttle * Constants.Talons.Speed.DRIVE_TALON_SPEED,
        (forward + rotation) * throttle * Constants.Talons.Speed.DRIVE_TALON_SPEED);
  }

  @Override
  public void periodic() {
   // SmartDashboard.putNumber("gyro", gyro.getAngle());
    // This method will be called once per scheduler run
  }
  // public double getAngle(){
  //  return gyro.getAngle();
  // }
}
