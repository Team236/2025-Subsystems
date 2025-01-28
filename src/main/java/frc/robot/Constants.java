// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final class Controller {
    public static final int USB_DRIVECONTROLLER = 0;
    public static final int USB_AUXCONTROLLER = 1;
  }

  public static class MotorControllers {
    public static final int SMART_CURRENT_LIMIT = 40;
    // Elevator (placeholder)
    public static final int ID_ELEVATOR_LEFT = 46;
    public static final int ID_ELEVATOR_RIGHT = 47;

    // Algae Hold (placeholder)
    public static final int ID_ALGAE_HOLD = 49;
    // CoralHold (placeholder)

    // Talon SRX (testing)
    public static final int ID_CORALMOTORSRX = 14;

    // SparkMax
    public static final int ID_CORALMOTOR = 48;
  }

  public static class CoralHoldCon {
    public static final int DIO_COUNTER = 12;
    public static final double HOLD_SPEED = .1;
    public static final double RELEASE_SPEED = -.1;
    public static final double L4_RELEASE_SPEED = .1;
      
    //placeholder PID values supporting PID for subsystem
    public static final double KP_CORALPIVOT = 0.002;   //TODO tune PID values
    public static final double KI_KP_CORALPIVOT = 0;
    public static final double KD_KP_CORALPIVOT = 0;

    // target position values for PID
    public static final double PIVOT_STOWED_POSITION=0; //TODO find actual encoder rotation values
    public static final double PIVOT_LEVEL1_POSITION=5; //TODO find actual encoder rotation values
    public static final double PIVOT_LEVEL2_POSITION=5; //TODO find actual encoder rotation values
    public static final double PIVOT_LEVEL3_POSITION=5; //TODO find actual encoder rotation values
    public static final double PIVOT_LEVEL4_POSITION=10; //TODO find actual encoder rotation values

  }

  public static class Elevator {
    public static final int DIO_ELEV_TOP = 4;
    public static final int DIO_ELEV_BOTTOM = 5;

    public static final double ELEV_UP_SPEED = 0.15;
    public static final double ELEV_DOWN_SPEED = -0.15;

    //placeholder conversion factors
    public static final double ELEV_REV_TO_IN = 0.32327;
    public static final double ELEV_IN_TO_REV = 1/(0.32327);

    public static final double L1_HEIGHT = 6;
    public static final double L2_HEIGHT = 12;
    public static final double L3_HEIGHT = 18;
    
    public static final double MIN_HEIGHT = 1.5;
    public static final double MAX_HEIGHT = 27;

    //placeholder PID values
    public static final double KP_ELEV = 0.2;
    public static final double KI_ELEV = 0;
    public static final double KD_ELEV = 0;

  }
  
  public static class XboxController {
    public static final int A = 1;
    public static final int B = 2;
    public static final int X = 3;
    public static final int Y = 4;
    public static final int LB = 5;
    public static final int RB = 6;
    public static final int VIEW = 7;
    public static final int MENU = 8;
    public static final int LM = 9;
    public static final int RM = 10;

    public static class AxesXbox {
      public static final int LX = 0;
      public static final int LY = 1;
      public static final int LTrig = 2;
      public static final int RTrig = 3;
      public static final int RX = 4;
      public static final int RY = 5;
    }

    public class POVXbox {
      public static final int UP_ANGLE = 0;
      public static final int RIGHT_ANGLE = 90;
      public static final int DOWN_ANGLE = 180;
      public static final int LEFT_ANGLE = 270;
    }
  }

  public static class AlgaeHold {
    public static final double HOLD_SPEED = 0.1;
    public static final double RELEASE_SPEED = -0.1;
  }
 
}
