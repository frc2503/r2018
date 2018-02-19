package org.usfirst.frc.team2503.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/*
 * Troubleshooting:
 * 1. Make sure "Pneumatics.init()" is called on robotInit() and
 * 		"Pneumatics.teleopPeriodic" is called on teleopPeriodic()
 * 2. Check the light on the PCM with Brandt or someone from electrical
 * 		if it is working
 * 3. Check the physical connections from the PCM to the compressor
 * 		or other components
 * 4. Make sure the PCM is set to use 24V and not 12V
 */

public class Pneumatics {

	private static Compressor compressor;
	private static DoubleSolenoid mainSolenoid;

	public static void init() {
		compressor = new Compressor();
		mainSolenoid = new DoubleSolenoid(0, 1);

		compressor.setClosedLoopControl(true);
		// This won't actually start until you switch to
		// autonomous, teleoperated, or test mode
		compressor.start();
		System.out.println("Pneumatics initialized");
	}

	public static void teleopPeriodic() {
		
		if (Input.getRight().getPOV() == 0) {
			mainSolenoid.set(Value.kReverse);
		} else if (Input.getRight().getPOV() == 180) {
			mainSolenoid.set(Value.kForward);
		} else {
			mainSolenoid.set(Value.kOff);
		}

	}

}
