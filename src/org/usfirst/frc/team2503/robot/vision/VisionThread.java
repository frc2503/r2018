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
import edu.wpi.cscore.VideoMode;
import edu.wpi.cscore.VideoMode.PixelFormat;
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
	
	private int frame = 0;

	public void run() {
		/*
		
		UsbCamera cameraBack = CameraServer.getInstance().startAutomaticCapture(Constants.CAMERA_BACK);
        cameraBack.setResolution(640, 480);
        cameraBack.setResolution(CAMERA_WIDTH, CAMERA_HEIGHT);
		cameraBack.setFPS(20);        
        
        CvSink cvSink = CameraServer.getInstance().getVideo(cameraBack);
        CvSource outputStream = CameraServer.getInstance().putVideo("VisionProcessing", CAMERA_WIDTH, CAMERA_HEIGHT);
        if (!outputStream.setFPS(30))
        	System.out.println("Failed to set CvSource fps");
        
        Mat source = new Mat();
        
        while(!Thread.interrupted()) {
            cvSink.grabFrame(source);
            //Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
            outputStream.putFrame(source);
        }
        */
        		
		UsbCamera cameraFront = CameraServer.getInstance().startAutomaticCapture(Constants.CAMERA_FRONT);
		UsbCamera cameraBack = CameraServer.getInstance().startAutomaticCapture(Constants.CAMERA_BACK);

		cameraFront.setResolution(CAMERA_WIDTH, CAMERA_HEIGHT);
		cameraBack.setResolution(CAMERA_WIDTH, CAMERA_HEIGHT);
		cameraBack.setFPS(20);

		CvSink cvSink = CameraServer.getInstance().getVideo(currentCamera ? cameraFront : cameraBack);
		CvSource outputStream = CameraServer.getInstance().putVideo("VisionProcessing", CAMERA_WIDTH, CAMERA_HEIGHT);
		outputStream.setResolution(CAMERA_WIDTH, CAMERA_HEIGHT);
		//cvSink.setSource(cameraBack);
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
