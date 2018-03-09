package org.usfirst.frc.team2503.robot;

/*
 * Troubleshooting:
 * Each of these variables corresponds with a port number.
 * This can be a DIO port, PWM port, PCM port, etc. These
 * should only be changed when the port something is
 * physically connected to changes. (AKA talk to someone
 * from electrical)
 */

/**
 * This class contains constant values for port numbers
 * 
 * @author warri
 *
 */
public class Constants {
	
	// Debug
	public static final boolean DEBUG = true;

	// PC Stuff
	public static final int JOYSTICK_LEFT = 1;
	public static final int JOYSTICK_RIGHT = 0;

	// USB
	public static final int CAMERA_FRONT = 0;
	public static final int CAMERA_BACK = 1;

	// PWM
	public static final int TALON_DRIVE_LEFT = 0;
	public static final int TALON_DRIVE_RIGHT = 1;
	public static final int TALON_SHOOT_FRONT_LEFT = 2;
	public static final int TALON_SHOOT_FRONT_RIGHT = 3;
	public static final int TALON_SHOOT_BACK_LEFT = 4;
	public static final int TALON_SHOOT_BACK_RIGHT = 9;
	public static final int TALON_INTAKE_LEFT = 7;
	public static final int TALON_INTAKE_RIGHT = 8;
	public static final int TALON_WINCH = 6;
	public static final int TALON_ARM = 5;

	// Analog
	public static final int RANGEFINDER_LEFT = 0;
	public static final int RANGEFINDER_RIGHT = 1;

	// Digital
	public static final int LIMIT_LEFT = 0;
	public static final int LIMIT_RIGHT = 1;

	// PCM
	// Since double solenoids use two ports, these
	// will use the set port as well as the next port
	// Ex: SOLENOID uses ports 0 and 1 (0 + 1 = 1)
	public static final int SOLENOID = 0;
}
