// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RepeatCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;


import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private static final Drivetrain drivetrain = new Drivetrain();
  private static final Suckythingmbob suckythingmbob = new Suckythingmbob();

  private static final Elevator elevator = new Elevator();
  private static final Drawer drawer = new Drawer();
 private static final Slider slider = new Slider();
  private static final Claw claw = new Claw();
  private static final Limelight limelight = new Limelight();


 private static final Joystick operateStick = new Joystick(0);
  //private static final Joystick driverStick = new Joystick(Constants.Controls.JoystickIDs.DRIVER_ID);
  private static final XboxController driverStick = new XboxController(Constants.Controls.JoystickIDs.OP_ID);
  public Trigger intakeTrigger, drawerInTrigger, drawerOutTrigger, shootTrigger, slideInTrigger, sliderOuTrigger,
      clawGrabTrigger, clawReleaseTrigger, elevateUpTrigger, elevateDownTrigger;

  // The robot's subsystems and commands are defined here...

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    drivetrain.setDefaultCommand(new Drive(
        drivetrain, () -> driverStick.getRawAxis(1),
        () -> driverStick.getRawAxis(4),
        () -> driverStick.getRawAxis(3)));

   //
    elevator.setDefaultCommand(new Elevate(elevator, () -> operateStick.getRawAxis(1))); // ()->operateStick.getRawAxis(1);

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    elevateDownTrigger = new JoystickButton(operateStick, Constants.Controls.ButtonID.ELEVATOR_DOWN_BUTTON_ID);
    elevateUpTrigger = new JoystickButton(operateStick, Constants.Controls.ButtonID.ELEVATOR_UP_BUTTON_ID);

    


    intakeTrigger = new JoystickButton(operateStick, Constants.Controls.ButtonID.INTAKE_BUTTON_ID)
        .whileTrue(new Intake(suckythingmbob));
    shootTrigger = new JoystickButton(operateStick, Constants.Controls.ButtonID.SHOOT_BUTTON_ID)
        .whileTrue(new Shoot(suckythingmbob));
    drawerInTrigger = new JoystickButton(operateStick, Constants.Controls.ButtonID.DRAWER_IN_BUTTON_ID)
        .whileTrue(new DrawOut(drawer));
    drawerOutTrigger = new JoystickButton(operateStick, Constants.Controls.ButtonID.DRAWER_OUT_BUTTON_ID)
        .whileTrue(new DrawIn(drawer));

    slideInTrigger = new JoystickButton(operateStick, Constants.Controls.ButtonID.SLIDE_IN_BUTTON_ID)
     .whileTrue(new SlideIn(slider));
     sliderOuTrigger = new JoystickButton(operateStick, Constants.Controls.ButtonID.SLIDE_OUT_BUTTON_ID)
        .whileTrue(new SlideOut(slider));
   clawGrabTrigger = new JoystickButton(operateStick, Constants.Controls.ButtonID.CLAW_GRAB_BUTTON_ID)
       .whileTrue(new ClawGrab(claw));
   clawReleaseTrigger = new JoystickButton(operateStick, Constants.Controls.ButtonID.CLAW_RELEASE_BUTTON_ID)
        .whileTrue(new ClawRelease(claw));

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
     
     }
     public Command getAutonomousCommand() {
       SequentialCommandGroup auto = new SequentialCommandGroup(
     // new AutoDriveForeward(drivetrain), 
     //new AutoDrawerOut(drawer),
      new AutoShoot(suckythingmbob),

      //  new AutoClawRelease(Suckythingmbob),
     new AutoDriveBackward(drivetrain)

      );
     return auto;
     
 }
}
