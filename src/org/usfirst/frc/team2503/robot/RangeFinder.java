package org.usfirst.frc.team2503.robot;

import edu.wpi.first.wpilibj.AnalogInput;

/**
 * This class contains methods for getting range finder distances
 * @author warri
 *
 */
public class RangeFinder {
	
	public static double rangeLeftMM;
	public static double rangeRightMM;
	
	private static AnalogInput rangeFinderLeft;
	private static AnalogInput rangeFinderRight;
	
	private static boolean rangeSwitch;
	
	private static final double VOLTS_PER_5MM = 5 / 1024;
	
	public static void init() {
		rangeSwitch = true;
		rangeLeftMM = 0d;
		rangeRightMM = 0d;
		rangeFinderLeft = new AnalogInput(Constants.RANGEFINDER_LEFT);
		rangeFinderRight = new AnalogInput(Constants.RANGEFINDER_RIGHT);
		
		System.out.println("RangeFinder.init() done");
	}
	
	public static double getLeft() { return rangeLeftMM; }
	public static double getRight() { return rangeRightMM; }
	
	private static double voltageToDistance(double measuredVolatage) {
		// https://www.maxbotix.com/ultrasonic-sensor-hrlv%E2%80%91maxsonar%E2%80%91ez-guide-158		
		// VOLTS_PER_5MM = Supplied Voltage / 1024
		
		return 5 * (measuredVolatage / VOLTS_PER_5MM);
		
	}

	public static void run() {
		if (rangeSwitch)
		{
			rangeLeftMM = voltageToDistance(rangeFinderLeft.getVoltage());
		}
		else
		{
			rangeRightMM = voltageToDistance(rangeFinderRight.getVoltage());
		}
		
		rangeSwitch = !rangeSwitch;
	}
}
