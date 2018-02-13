package org.usfirst.frc.team2503.robot;

import edu.wpi.first.wpilibj.Talon;

/**
 * This class contains out code for intake and shooting
 * 
 * @author warri
 *
 */
public class Shooter {

	private static final double FRONT_POWER = 0.75;
	private static final double BACK_POWER = 0.8;

	private static Talon talonShooterFrontLeft;
	private static Talon talonShooterFrontRight;
	private static Talon talonShooterBackLeft;
	private static Talon talonShooterBackRight;

	public static void init() {
		talonShooterFrontLeft = new Talon(Constants.TALON_SHOOT_FRONT_LEFT);
		talonShooterFrontRight = new Talon(Constants.TALON_SHOOT_FRONT_RIGHT);
		talonShooterBackLeft = new Talon(Constants.TALON_SHOOT_BACK_LEFT);
		talonShooterBackRight = new Talon(Constants.TALON_SHOOT_BACK_RIGHT);
	}

	public static void teleopPeriodic() {
		// Button 2 on right joystick
		if (Input.getRight().getRawButton(1)) {
			// Down
			talonShooterFrontLeft.set(FRONT_POWER);
			talonShooterFrontRight.set(-FRONT_POWER);
		} else {
			// Up
			talonShooterFrontLeft.set(0);
			talonShooterFrontRight.set(0);
		}

		// Trigger button on right joystick
		if (Input.getRight().getRawButton(0)) {
			// Down
			talonShooterBackLeft.set(BACK_POWER);
			talonShooterBackRight.set(-BACK_POWER);
		} else {
			// Up
			talonShooterBackLeft.set(0);
			talonShooterBackRight.set(0);
		}
		
	}

}
