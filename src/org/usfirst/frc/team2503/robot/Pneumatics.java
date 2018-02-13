package org.usfirst.frc.team2503.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Pneumatics {

	private static Compressor compressor;
	private static DoubleSolenoid solenoidLeft;
	private static DoubleSolenoid solenoidRight;

	public static void init() {
		compressor = new Compressor();
		solenoidLeft = new DoubleSolenoid(Constants.SOLENOID_RIGHT, Constants.SOLENOID_RIGHT + 1);
		solenoidRight = new DoubleSolenoid(Constants.SOLENOID_LEFT, Constants.SOLENOID_LEFT + 1);

		compressor.setClosedLoopControl(true);
		compressor.start();
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
