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

    // Algae Pivot (placeholder)
    public static final int ID_ALGAE_PIVOT = 50;
  
  }

  public static class Elevator {
    public static final int DIO_ELEV_TOP = 4;
    public static final int DIO_ELEV_BOTTOM = 5;

    public static final int SOL_BRAKE_ON = 2; 
    public static final int SOL_BRAKE_OFF = 3;
  }

  public static class AlgaeHold {
    public static final double HOLD_SPEED = 0.1;
    public static final double RELEASE_SPEED = -0.1;
  }

  public static class AlgaePivot {
    public static final int DIO_EXT_LIMIT = 8;
    public static final int DIO_RET_LIMIT = 9;
    public static final double ENC_REVS_MAX = -74;
    public static final double ENC_REVS_TEST1 = -30;
    public static final double ENC_REVS_TEST2 = -52;
    public static final double MAN_EXT_SPEED = -0.1;
    public static final double MAN_RET_SPEED = 0.1;
    public static final double KP = 0.029;
    public static final double KI = 0;
    public static final double KD = 0;
    public static final double KFF = 0;
    //public static final double ENC_CONVERSION_FACTOR = 1; //unnecessary for now but may make it easier to change values with real world units
  }

  public static class XboxController {
    public static final int A = 1;
    public static final int B = 2;
    public static final int X = 3;
    public static final int Y = 4;
    public static final int LB = 5;
    public static final int RB = 6;
  } 
}
