package org.usfirst.frc.team2503.robot.vision;

import org.usfirst.frc.team2503.robot.Constants;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

/**
 * This class is a thread that will handle camera switching and display
 * 
 * @author warri
 *
 */
public class VisionThread extends Thread {

	public static final int CAMERA_WIDTH = 640;
	public static final int CAMERA_HEIGHT = 480;

	//private boolean direction = Drive.direction;

	public void run() {

		UsbCamera frontCamera = CameraServer.getInstance().startAutomaticCapture(Constants.CAMERA_FRONT);
		frontCamera.setResolution(CAMERA_WIDTH, CAMERA_HEIGHT);
		frontCamera.setFPS(30);
		/*
		Mat src = new Mat();
		CameraServer.getInstance().getVideo("USB Camera 0").grabFrame(src);

		CvSource outputStream = CameraServer.getInstance().putVideo("VisionProcessing", 640, 480);
		while(!Thread.interrupted()) {
			
		}
*/
	}

}
