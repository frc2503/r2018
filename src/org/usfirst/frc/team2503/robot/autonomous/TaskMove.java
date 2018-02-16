package org.usfirst.frc.team2503.robot.autonomous;

import org.usfirst.frc.team2503.robot.Drive;

import edu.wpi.first.wpilibj.Timer;

public class TaskMove implements TaskBase {

	private double time, speed;
	private boolean initialized;
	private Timer taskTimer;

	TaskMove(double stopTime, double speed) {
		this.time = stopTime;
		this.speed = speed;
		initialized = false;
	}

	@Override
	public String GetName() {
		return "Move Forward";
	}

	@Override
	public void Initialize() {
		initialized = true;
		taskTimer = new Timer();
		taskTimer.start();
	}

	@Override
	public TaskReturnType Run() {
		
		if (!initialized)
			Initialize();
		
		if (taskTimer.get() < time) {
			Drive.set(speed, speed);
		} else {
			return TaskReturnType.DONE;
		}
		return TaskReturnType.IN_PROGRESS;
	}

}
