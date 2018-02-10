package org.usfirst.frc.team2503.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;

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
	private static Talon talonFrontLeft;
	private static Talon talonFrontRight;
	private static Talon talonBackLeft;
	private static Talon talonBackRight;
	
	public static void init() {
		talonFrontLeft = new Talon(Constants.TALON_FRONT_LEFT);
		talonFrontRight = new Talon(Constants.TALON_FRONT_RIGHT);
		talonBackLeft = new Talon(Constants.TALON_BACK_LEFT);
		talonBackRight = new Talon(Constants.TALON_BACK_RIGHT);
		direction = true;
		
		System.out.println("Drive.init() done");
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
		if (joyLeft.getRawButtonPressed(0))
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
			talonFrontLeft.set(left);
			talonFrontRight.set(right);
			talonBackLeft.set(left);
			talonBackRight.set(right);
		} else {
			// Drive backwards
			talonFrontLeft.set(-right);
			talonFrontRight.set(-left);
			talonBackLeft.set(-right);
			talonBackRight.set(-left);
		}
	}

}
