package org.usfirst.frc.team2503.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;

public class Intake {

	private static Talon talonIntakeLeft;
	private static Talon talonIntakeRight;
	private static DigitalInput limitSwitchLeft;
	private static DigitalInput limitSwitchRight;

	private static final double INTAKE_SPEED = 0.25;

	public static void init() {
		talonIntakeLeft = new Talon(Constants.TALON_INTAKE_LEFT);
		talonIntakeRight = new Talon(Constants.TALON_INTAKE_RIGHT);
		limitSwitchLeft = new DigitalInput(Constants.LIMIT_LEFT);
		limitSwitchRight = new DigitalInput(Constants.LIMIT_RIGHT);

	}

	public static void teleopPeriodic() {
		if (Input.getRight().getRawButton(2) &&
				!limitSwitchLeft.get() &&
				!limitSwitchRight.get()) {
			talonIntakeLeft.set(INTAKE_SPEED);
			talonIntakeRight.set(INTAKE_SPEED);
		} else {
			talonIntakeLeft.set(0);
			talonIntakeRight.set(0);
		}
	}

}
