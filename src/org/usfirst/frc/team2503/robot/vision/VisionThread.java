package org.usfirst.frc.team2503.robot.vision;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
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
	
	public static final int CAMERA_WIDTH = 640;
	public static final int CAMERA_HEIGHT = 480;

	// currentCamera is essentially just whatever Drive.direction was 1 update ago
	private boolean currentCamera;

	public void run() {

		currentCamera = Drive.direction;

		UsbCamera cameraFront = CameraServer.getInstance().startAutomaticCapture(Constants.CAMERA_FRONT);
		UsbCamera cameraBack = CameraServer.getInstance().startAutomaticCapture(Constants.CAMERA_BACK);

		cameraFront.setResolution(CAMERA_WIDTH, CAMERA_HEIGHT);
		cameraBack.setResolution(CAMERA_WIDTH, CAMERA_HEIGHT);

		CvSink cvSink = CameraServer.getInstance().getVideo(currentCamera ? cameraFront : cameraBack);
		CvSource outputStream = CameraServer.getInstance().putVideo("VisionProcessing", CAMERA_WIDTH, CAMERA_HEIGHT);

		Mat src = new Mat();

		while (!Thread.interrupted()) {
			// Switch video sinks if we have switched directions
			if (currentCamera != Drive.direction) {
				currentCamera = Drive.direction;
				cvSink = CameraServer.getInstance().getVideo(Drive.direction ? cameraFront : cameraBack);
			}
			
			// Draw a HUD
			Imgproc.circle(src, new Point(100, 100), 10, new Scalar(255, 255, 255, 255));
			
			// Get the last frame
			cvSink.grabFrame(src);

			// Output the frame
			outputStream.putFrame(src);
		}

	}

}
