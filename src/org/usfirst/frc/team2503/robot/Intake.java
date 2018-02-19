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
	
	private static Talon talonShooterBackLeft;
	private static Talon talonShooterBackRight;

	private static final double INTAKE_SPEED = 0.7;
	private static final double BACK_POWER = 0.4;

	public static void init() {
		talonIntakeLeft = new Talon(Constants.TALON_INTAKE_LEFT);
		talonIntakeRight = new Talon(Constants.TALON_INTAKE_RIGHT);
		talonShooterBackLeft = new Talon(Constants.TALON_SHOOT_BACK_LEFT);
		talonShooterBackRight = new Talon(Constants.TALON_SHOOT_BACK_RIGHT);

		// Limit switches with automatically stop the intake
		limitSwitchLeft = new DigitalInput(Constants.LIMIT_LEFT);
		limitSwitchRight = new DigitalInput(Constants.LIMIT_RIGHT);
		System.out.println("Intake initialized");

	}
	
	public static void setCubeShifters(double power) {
		talonShooterBackLeft.set(-power);
		talonShooterBackRight.set(power);
	}
	
	// static boolean toggle = false;
	static boolean lastLimit = false;
	private static boolean intakeCooldown = false;

	
	public static void teleopPeriodic() {
		
		// System.out.println("Limit left: " + !limitSwitchLeft.get() + "Limit right: " + !limitSwitchRight.get() + " lastLimit: " + lastLimit + " intakeCooldown: " + intakeCooldown);
		
		// Set cooldown if either limit switch is activated but both
		// limit switches were inactive last update
		if ((!limitSwitchLeft.get() || !limitSwitchRight.get()) && !lastLimit) {
			intakeCooldown = true;
		}		
		
		// Stop intake if either limit switch is activated
		if ((Input.getRight().getRawButton(3) || Input.getRight().getRawButton(4)) && !intakeCooldown) {
			talonIntakeLeft.set(INTAKE_SPEED * (Input.getRight().getRawButton(3) ? -1 : 1));
			talonIntakeRight.set(INTAKE_SPEED * (Input.getRight().getRawButton(3) ? 1 : -1));
			setCubeShifters(BACK_POWER * (Input.getRight().getRawButton(3) ? 1 : -1));
		} else {
			talonIntakeLeft.set(0);
			talonIntakeRight.set(0);
			setCubeShifters(0);
		}
		
		// Remove cooldown if either button is reset
		if (Input.getRight().getRawButtonPressed(3) || Input.getRight().getRawButtonPressed(4))
			intakeCooldown = false;
		
		// Update status of lastLimit
		lastLimit = (!limitSwitchLeft.get() || !limitSwitchRight.get());
		
	}

}
