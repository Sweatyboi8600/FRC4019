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
    RFTalon = new TalonSRX(0);
    LFTalon = new TalonSRX(1);
    LBTalon = new TalonSRX(2);
    RBTalon = new TalonSRX(3);

    RFTalon.setInverted(false);
    LFTalon.setInverted(true);
    RBTalon.setInverted(false);
    LBTalon.setInverted(true);

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
    set((forward - rotation) * throttle * 0.5,
        (forward + rotation) * throttle * 0.5);
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