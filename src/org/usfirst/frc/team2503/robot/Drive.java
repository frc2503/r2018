package org.usfirst.frc.team2503.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;

/*
 * Troubleshooting:
 * 1. Make sure "Drive.init()" is called on robotInit()
 * 		and "Drive.teleopPeriodic()" is called on teleopPeriodic();
 * 2. Check physical connections for the Talons
 * 3. Check physical connections for the joysticks
 * 4. Check that the Talons are connected to the correct PWM
 * 		ports (check Constants.java)
 */

/**
 * This class contains all methods relating to controlling the four speed
 * controllers used for driving
 * 
 * @author warri
 *
 */
public class Drive {

	// Direction modifier
	public static boolean direction;

	// Speed controllers
	private static Talon talonLeft;
	private static Talon talonRight;
	
	public static void init() {
		talonLeft = new Talon(Constants.TALON_DRIVE_LEFT);
		talonRight = new Talon(Constants.TALON_DRIVE_RIGHT);
		direction = true;
		
		System.out.println("Drive initialized");
	}

	public static void teleopPeriodic() {
		// Get raw y axis values from joysticks
		Joystick joyLeft = Input.getLeft();
		double leftVal = joyLeft.getRawAxis(1);
		double rightVal = Input.getRight().getRawAxis(1);

		// Look in Drive.java in "2018 Tutorial" to see why we square inputs
		// TLDR it increases precision
		leftVal *= Math.abs(leftVal);
		rightVal *= Math.abs(rightVal);

		// Switch between forward and reverse with button
		if (joyLeft.getRawButtonPressed(3))
			direction = !direction;

		// Speed multiplier is from the lever on the left controller
		double speedMultiplier = (Input.getLeft().getRawAxis(2) - 1) / -2;

		leftVal *= speedMultiplier;
		rightVal *= speedMultiplier;

		set(leftVal, rightVal);
	}

	public static void set(double left, double right) {

		if (direction) {
			// Drive normally
			talonLeft.set(left);
			talonRight.set(right);
		} else {
			// Drive backwards
			talonLeft.set(-right);
			talonRight.set(-left);
		}
		
	}

}
