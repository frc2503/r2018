package org.usfirst.frc.team2503.robot;

import edu.wpi.first.wpilibj.Talon;

/*
 * Troubleshooting:
 * 1. Make sure "Shooter.init()" is called on robotInit() and
 * 		"Shooter.teleopPeriodic()" is called on robotPeriodic()
 * 2. Check the physical connections of the Talons
 * 3. Check the physical connections of the joysticks
 */

/**
 * This class contains out code for intake and shooting
 * 
 * @author warri
 *
 */
public class Shooter {

	private static double FRONT_POWER = 1;

	private static Talon talonShooterFrontLeft;
	private static Talon talonShooterFrontRight;

	public static void init() {
		talonShooterFrontLeft = new Talon(Constants.TALON_SHOOT_FRONT_LEFT);
		talonShooterFrontRight = new Talon(Constants.TALON_SHOOT_FRONT_RIGHT);

		System.out.println("Shooter initialized");
	}

	public static void setShooters(double power) {
		talonShooterFrontLeft.set(-power);
		talonShooterFrontRight.set(power);
	}

	public static void teleopPeriodic() {
		// Button 2 on right joystick

		FRONT_POWER = ((Input.getRight().getRawAxis(2) - 1) / -2);
		if (Input.getRight().getRawButton(1)) {
			setShooters(FRONT_POWER);
		} else {
			setShooters(0);
		}

		// Move cube into front motors
		if (Input.getRight().getRawButton(2)) {
			Intake.setCubeShifters(0.5);
		}

	}

}
