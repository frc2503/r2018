package org.usfirst.frc.team2503.robot;

import edu.wpi.first.wpilibj.Talon;

/*
 * Troubleshooting:
 * 1. Make sure "Winch.init()" is called on robotInit() and
 * 		"Winch.teleopPeriodic()" is called teleopPeriodic()
 * 2. Check the physical connections of the arm and winch Talons
 */

public class Arm {

	private static Talon talonWinch;
	private static Talon talonArm;

	private static final double ARM_SPEED = 0.50;

	public static void init() {
		talonWinch = new Talon(Constants.TALON_WINCH);
		talonArm = new Talon(Constants.TALON_ARM);

		System.out.println("Winch initialized");
	}

	public static void teleopPeriodic() {
		if (Input.getLeft().getRawButton(2)) {
			talonWinch.set(1);
		} else {
			talonWinch.set(0);
		}
		
		if (Input.getLeft().getPOV() == 0) {
			talonArm.set(ARM_SPEED);
		} else if (Input.getLeft().getPOV() == 180) {
			talonArm.set(-ARM_SPEED);
		} else {
			talonArm.set(0);
		}
	}

}
