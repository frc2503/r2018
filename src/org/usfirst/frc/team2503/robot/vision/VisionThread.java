package org.usfirst.frc.team2503.robot.vision;

import org.opencv.core.Mat;
import org.usfirst.frc.team2503.robot.Constants;
import org.usfirst.frc.team2503.robot.Drive;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

/**
 * This class is a thread that will handle camera switching and display
 * @author warri
 *
 */
public class VisionThread extends Thread {

	// currentCamera is essentially just whatever Drive.direction was 1 update ago
	private boolean currentCamera;

	public void run() {

		currentCamera = Drive.direction;

		UsbCamera cameraFront = CameraServer.getInstance().startAutomaticCapture(Constants.CAMERA_FRONT);
		UsbCamera cameraBack = CameraServer.getInstance().startAutomaticCapture(Constants.CAMERA_BACK);

		cameraFront.setResolution(640, 480);
		cameraBack.setResolution(640, 480);

		CvSink cvSink = CameraServer.getInstance().getVideo(currentCamera ? cameraFront : cameraBack);
		CvSource outputStream = CameraServer.getInstance().putVideo("VisionProcessing", 640, 480);

		Mat src = new Mat();

		while (!Thread.interrupted()) {
			// Switch video sinks if we have switched directions
			if (currentCamera != Drive.direction) {
				currentCamera = Drive.direction;
				cvSink = CameraServer.getInstance().getVideo(Drive.direction ? cameraFront : cameraBack);
			}

			// Get the last frame
			cvSink.grabFrame(src);

			// Output the frame
			outputStream.putFrame(src);
		}

	}

}
