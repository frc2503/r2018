package org.usfirst.frc.team2503.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;

/**
 * This class contains all methods relating to driving and condtolling the four Talon speed controllers
 * @author warri
 *
 */
public class Drive {
	
	// Direction modifier
	private static boolean forward;
	
	// Speed controllers
	private static Talon talonFrontLeft;
	private static Talon talonFrontRight;
	private static Talon talonBackLeft;
	private static Talon talonBackRight;
	
	/**
	 * static constuctor - probably a meme
	 */
	static 
	{
		talonFrontLeft = new Talon(Constants.TALON_FRONT_LEFT);
		talonFrontRight = new Talon(Constants.TALON_FRONT_RIGHT);
		talonBackLeft = new Talon(Constants.TALON_BACK_LEFT);
		talonBackRight = new Talon(Constants.TALON_BACK_RIGHT);
		forward = true;
	}
	
	public static void teleopPeriodic()
	{		
		// Get raw y axis values from joysticks
		double leftVal = Input.getLeft().getRawAxis(1);
		double rightVal = Input.getRight().getRawAxis(1);
		
		// Look in Drive.java in "2018 Tutorial" to see why we square inputs
		// TLDR it increases precision
		leftVal *= Math.abs(leftVal);
		rightVal *= Math.abs(rightVal);
		
		set(leftVal, rightVal);
	}
	
	public static void set(double left, double right)
	{
		// Speed multiplier is gotten from the lever on the left controller
		double speedMultiplier = (Input.getLeft().getRawAxis(2) - 1) / -2;
		
		left *= speedMultiplier;
		right *= speedMultiplier;
		
		if (forward)
		{
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
