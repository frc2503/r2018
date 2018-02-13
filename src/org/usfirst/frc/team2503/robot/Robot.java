/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2503.robot;

import org.usfirst.frc.team2503.robot.vision.Vision;

import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		Input.init();
		//Drive.init();
		//RangeFinder.init();
		//Shooter.init();
		//Vision.Init();
	}

	@Override
	public void robotPeriodic() {
		System.out.println(Input.getRight().getPOV());
		//RangeFinder.run();
		//System.out.println(RangeFinder.getLeft());
		//Shooter.teleopPeriodic();
		
	}

	/**
	 * This function is called when switching to autonomous control
	 */
	@Override
	public void autonomousInit() {

	}

	/**
	 * This function is called when switching to operator control
	 */
	@Override
	public void teleopInit() {
		
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {

	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		//Drive.teleopPeriodic();
		//Shooter.teleopPeriodic();
	}
}
