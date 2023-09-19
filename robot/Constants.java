// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public abstract class Talons {
        public abstract class IDs {
            public static final int LF_TALON_ID = 2;
            public static final int RF_TALON_ID = 4;
            public static final int LB_TALON_ID = 3;
            public static final int RB_TALON_ID = 5;
            public static final int RI_TALON_ID = 10;
            public static final int LI_TALON_ID = 11;
            public static final int RE_TALON_ID = 1;
            public static final int LE_TALON_ID = 12;
            public static final int RD_TALON_ID = 6;
            public static final int LD_TALON_ID = 7;
            public static final int S_TALON_ID = 9;
            public static final int C_TALON_ID = 8;

        }

        public abstract class Inversions {
            public static final boolean LF_TALON_INVERT = true;
            public static final boolean LB_TALON_INVERT = true;
            public static final boolean RF_TALON_INVERT = false;
            public static final boolean RB_TALON_INVERT = false;
            public static final boolean RI_TALON_INVERT = false;
            public static final boolean LI_TALON_INVERT = true;
            public static final boolean RE_TALON_INVERT = true;
            public static final boolean LE_TALON_INVERT = false;
            public static final boolean LD_TALON_INVERT = false;
            public static final boolean RD_TALON_INVERT = false;
            public static final boolean S_TALON_INVERT = false;
            public static final boolean C_TALON_INVERT = false;

        }

        public abstract class Speed {
            public static final double DRIVE_TALON_SPEED = 1;
            public static final double INTAKE_TALON_SPEED = 1;
            public static final double ELEVATOR_TALON_SPEED = 0.5;
            public static final double DRAWER_TALON_SPEED = 0.40;
            public static final double SLIDER_TALON_SPEED = 0.4;
            public static final double CLAW_TALON_SPEED = 0.2;
            public static final double AUTO_DRIVE_TALON_SPEED = 0.25;



        }
       
        
    }
    public abstract class Sensor{
        public abstract class LimitSwitch{
            public abstract class IDs{
                public static final int DRAWER_IN_ID= 0;
                public static final int DRAWER_OUT_ID= 1;
                public static final int SLIDER_IN_ID= 2;
                public static final int SLIDER_OUT_ID= 3;



            }
        }
    }


    public final class Controls {
        public final class JoystickIDs {
            public static final int DRIVER_ID = 0 ;
            public static final int OP_ID = 1;

        }
        


        public final class ButtonID {
            public static final int INTAKE_BUTTON_ID = 2;
            public static final int DRAWER_IN_BUTTON_ID = 11;
            public static final int DRAWER_OUT_BUTTON_ID = 12;
            public static final int SHOOT_BUTTON_ID = 1;
            public static final int SLIDE_IN_BUTTON_ID = 9;
            public static final int SLIDE_OUT_BUTTON_ID = 10;
            public static final int CLAW_GRAB_BUTTON_ID = 7;
            public static final int CLAW_RELEASE_BUTTON_ID = 8;
            public static final int ELEVATOR_UP_BUTTON_ID = 3;
            public static final int ELEVATOR_DOWN_BUTTON_ID = 4;


        }
    }
    public abstract class Times{
        public static final double  SHOOT_AUTO = 3000;
        public static final double ELEVATOR_UP_AUTO = 4000000;
        public static final double ELEVATOR_DOWN_AUTO = 4000000;
        public static final double DRIVE_FOREWARD_AUTO = 500000000;
        public static final long DRIVE_BACKWARD_AUTO =9000;






    }
}
