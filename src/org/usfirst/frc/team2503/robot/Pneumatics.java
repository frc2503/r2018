package org.usfirst.frc.team2503.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Pneumatics {

	private static Compressor compressor;
	private static DoubleSolenoid ds;

	public static void init() {
		compressor = new Compressor();
		ds = new DoubleSolenoid(0, Constants.SOLENOID);

		compressor.setClosedLoopControl(true);
		compressor.start();
	}

	public static void teleopPeriodic() {
		if (Input.getRight().getPOV() == 0) {
			ds.set(Value.kForward);
		} else if (Input.getRight().getPOV() == 180) {
			ds.set(Value.kReverse);
		} else {
			ds.set(Value.kOff);
			// Don't flippin break
		}
	}

}
