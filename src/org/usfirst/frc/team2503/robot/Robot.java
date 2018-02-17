/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2503.robot;

import edu.wpi.first.wpilibj.DigitalOutput;
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
	DigitalOutput led1 = new DigitalOutput(0);
	DigitalOutput led2 = new DigitalOutput(1);
	DigitalOutput led3 = new DigitalOutput(2);
	DigitalOutput led4 = new DigitalOutput(3);

	@Override
	public void robotInit() {
		led1.set(true); // 1
		led2.set(true); // 1
		led3.set(false); // 0
		led4.set(true); // 1
		Input.init();
		Pneumatics.init();
		// Drive.init();
		// RangeFinder.init();
		// Intake.init();
		//Shooter.init();
		// Arm.init();
		// Vision.Init();

		System.out.println("Robot initialized");
	}

	@Override
	public void robotPeriodic() {
		// RangeFinder.run();

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
		// Drive.teleopPeriodic();
		Pneumatics.teleopPeriodic();
		//Shooter.teleopPeriodic();
		// Intake.teleopPeriodic();
		// Arm.teleopPeriodic();
	}
}
