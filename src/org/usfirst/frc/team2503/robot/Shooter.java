package org.usfirst.frc.team2503.robot;

import edu.wpi.first.wpilibj.Talon;

/**
 * This class contains out code for intake and shooting
 * 
 * @author warri
 *
 */
public class Shooter {

	private static final double FRONT_POWER = 0.25;
	private static final double BACK_POWER = 0.25;
	private static final double INTAKE_POWER = 0.25;

	private static Talon talonShooterFrontLeft;
	private static Talon talonShooterFrontRight;
	private static Talon talonShooterBackLeft;
	private static Talon talonShooterBackRight;
	private static Talon talonIntakeLeft;
	private static Talon talonIntakeRight;

	public static void init() {
		talonShooterFrontLeft = new Talon(Constants.TALON_SHOOT_FRONT_LEFT);
		talonShooterFrontRight = new Talon(Constants.TALON_SHOOT_FRONT_RIGHT);
		talonShooterBackLeft = new Talon(Constants.TALON_SHOOT_BACK_LEFT);
		talonShooterBackRight = new Talon(Constants.TALON_SHOOT_BACK_RIGHT);
		talonIntakeLeft = new Talon(Constants.TALON_INTAKE_LEFT);
		talonIntakeRight = new Talon(Constants.TALON_INTAKE_RIGHT);
	}

	public static void teleopPeriodic() {

		if (Input.getRight().getRawButton(1)) {
			talonShooterFrontLeft.set(FRONT_POWER);
			talonShooterFrontRight.set(-FRONT_POWER);
			talonShooterBackLeft.set(BACK_POWER);
			talonShooterBackRight.set(-BACK_POWER);
		} else {
			talonShooterFrontLeft.set(0);
			talonShooterFrontRight.set(0);
			talonShooterBackLeft.set(0);
			talonShooterBackRight.set(0);
		}

		if (Input.getRight().getRawButton(4)) {
			talonIntakeLeft.set(INTAKE_POWER);
			talonIntakeRight.set(INTAKE_POWER);
		} else {
			talonIntakeLeft.set(0);
			talonIntakeRight.set(0);
		}

	}

}
