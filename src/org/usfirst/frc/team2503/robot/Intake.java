package org.usfirst.frc.team2503.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;

/*
 * Troubleshooting:
 * 1. Make sure "Intake.init()" is called on robotInit()
 * 		and "Intake.teleopPeriodic()" is called on teleopPeriodic()
 * 2. Check the physical connections of Talons
 * 3. Check the physical connections of the joysticks
 */

public class Intake {

	private static Talon talonIntakeLeft;
	private static Talon talonIntakeRight;
	private static DigitalInput limitSwitchLeft;
	private static DigitalInput limitSwitchRight;

	private static final double INTAKE_SPEED = 0.9;

	public static void init() {
		talonIntakeLeft = new Talon(Constants.TALON_INTAKE_LEFT);
		talonIntakeRight = new Talon(Constants.TALON_INTAKE_RIGHT);
		
		// Commented out because these are not a thing yet
		//limitSwitchLeft = new DigitalInput(Constants.LIMIT_LEFT);
		//limitSwitchRight = new DigitalInput(Constants.LIMIT_RIGHT);

	}

	public static void teleopPeriodic() {
		// Commented out because these are not a thing yet
		if (Input.getRight().getRawButton(3)/* &&
				!limitSwitchLeft.get() &&
				!limitSwitchRight.get()*/) {
			talonIntakeLeft.set(-INTAKE_SPEED);
			talonIntakeRight.set(INTAKE_SPEED);
		} else {
			talonIntakeLeft.set(0);
			talonIntakeRight.set(0);
		}
	}

}
