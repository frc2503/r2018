package org.usfirst.frc.team2503.robot;

import edu.wpi.first.wpilibj.Talon;

/*
 * Troubleshooting:
 * 1. Make sure "Winch.init()" is called on robotInit() and
 * 		"Winch.teleopPeriodic()" is called teleopPeriodic()
 * 2. Check the physical connections of the winch Talon
 * 3. Check the physical connections of the Joysticks
 */

public class Winch {
	
	private static Talon talonWinch;
	
	public static void init() {
		talonWinch = new Talon(Constants.TALON_WINCH);
	}
	
	public static void teleopPeriodic() {
		if (Input.getLeft().getRawButton(2))
		{
			talonWinch.set(1);
		} else {
			talonWinch.set(0);
		}
	}

}
