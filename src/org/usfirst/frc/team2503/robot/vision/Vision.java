package org.usfirst.frc.team2503.robot.vision;

/**
 * This class starts our vision thread
 * 
 * @author warri
 *
 */
public class Vision {

	public static void init() {

		VisionThread visionThread = new VisionThread();

		// daemon thread will not prevent our robot from restarting
		visionThread.setDaemon(true);
		visionThread.start();

		System.out.println("Vision thread started");
	}

}
