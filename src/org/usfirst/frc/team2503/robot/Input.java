package org.usfirst.frc.team2503.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class contains all of our input objects
 * @author warri
 *
 */
public class Input {
	
	private static Joystick joystickRight;
	private static Joystick joystickLeft;
	
	public static void init() {
		joystickRight = new Joystick(Constants.JOYSTICK_RIGHT);
		joystickLeft = new Joystick(Constants.JOYSTICK_LEFT);
		System.out.println("Input.init() done");
	}

	public static Joystick getRight() { return joystickRight; }	
	public static Joystick getLeft() { return joystickLeft; }
	
}
