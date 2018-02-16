package org.usfirst.frc.team2503.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/*
 * Troubleshooting:
 * 1. Make sure "Pneumatics.init()" is called on robotInit() and
 * 		"Pneumatics.teleopPeriodic" is called on teleopPeriodic()
 * 2. Check the light on the PCM and Brandt or someone from electrical
 * 		if it is working
 * 3. Check the physical connections from the PCM to the compressor
 * 		or other components
 */

public class Pneumatics {

	private static Compressor compressor;
	private static DoubleSolenoid solenoidLeft;
	private static DoubleSolenoid solenoidRight;

	public static void init() {
		compressor = new Compressor();
		solenoidLeft = new DoubleSolenoid(Constants.SOLENOID_RIGHT, Constants.SOLENOID_RIGHT + 1);
		solenoidRight = new DoubleSolenoid(Constants.SOLENOID_LEFT, Constants.SOLENOID_LEFT + 1);

		// compressor.setClosedLoopControl(true);
		// This won't actually start until you switch to
		// autonomous, teleoperated, or test mode
		compressor.start();
		System.out.println("Pneumatics initialized");
	}

	public static void teleopPeriodic() {

		if (Input.getRight().getPOV() == 0) {
			solenoidLeft.set(Value.kForward);
			solenoidRight.set(Value.kForward);
		} else if (Input.getRight().getPOV() == 180) {
			solenoidLeft.set(Value.kReverse);
			solenoidRight.set(Value.kReverse);
		} else {
			solenoidLeft.set(Value.kOff);
			solenoidRight.set(Value.kOff);
		}

	}

}
