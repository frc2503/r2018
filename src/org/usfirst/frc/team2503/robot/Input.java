package org.usfirst.frc.team2503.robot;

import edu.wpi.first.wpilibj.Joystick;

/*
 * Troubleshooting:
 * 1. Check to make sure the joysticks (and controller) are
 * 		actually plugged in. 
 * 2. Make sure "Input.int()" is called on robotInit();
 * 3. If the inputs are backwards, switch 
 * 		USB ports or switch the JOYSTICK_RIGHT and JOYSTICK_LEFT
 * 		constants in Constants.java
 */

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
		
		System.out.println("Input initialized");
	}

	public static Joystick getRight() { 
		return joystickRight; 
	}	
	public static Joystick getLeft() { 
		return joystickLeft; 
	}
	
}
