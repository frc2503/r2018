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

	private static final double FRONT_POWER = 1;
	private static final double BACK_POWER = 1;
	private static final double BACK_POWER_SLOW = .3;

	private static Talon talonShooterFrontLeft;
	private static Talon talonShooterFrontRight;
	private static Talon talonShooterBackLeft;
	private static Talon talonShooterBackRight;

	public static void init() {
		talonShooterFrontLeft = new Talon(Constants.TALON_SHOOT_FRONT_LEFT);
		talonShooterFrontRight = new Talon(Constants.TALON_SHOOT_FRONT_RIGHT);
		talonShooterBackLeft = new Talon(Constants.TALON_SHOOT_BACK_LEFT);
		talonShooterBackRight = new Talon(Constants.TALON_SHOOT_BACK_RIGHT);

		System.out.println("Shooter initialized");
	}

	public static void setShooters(double power) {
		talonShooterFrontLeft.set(-power);
		talonShooterFrontRight.set(power);
	}

	public static void setCubeShifters(double power) {
		talonShooterBackLeft.set(-power);
		talonShooterBackRight.set(power);
	}

	public static void teleopPeriodic() {
		// Button 2 on right joystick

		if (Input.getRight().getRawButton(1)) {
			setShooters(FRONT_POWER);
		} else {
			setShooters(0);
		}

		// Trigger button on right joystick
		if (Input.getRight().getRawButton(2)) {
			// Down
			setCubeShifters(BACK_POWER);
		} else if (Input.getRight().getRawButton(6)) {
			// Up
			setCubeShifters(BACK_POWER_SLOW);
		} else {
			// Up
			setCubeShifters(0);
		}

	}

}
