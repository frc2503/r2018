package org.usfirst.frc.team2503.robot.autonomous;

import org.usfirst.frc.team2503.robot.Drive;

import edu.wpi.first.wpilibj.Timer;

public class TaskTurn implements TaskBase {
	
	private double duration, turn;
	private boolean initialized;
	private Timer taskTimer;

	TaskTurn(double time, double turn)
	{
		this.duration = time;
		this.turn = turn;
		initialized = false;
	}
	
	@Override
	public String GetName() {
		// TODO Auto-generated method stub
		return "Turn";
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
		if (taskTimer.get() < duration)
		{
			Drive.set(turn, -turn);
		} else {
			Drive.set(0, 0);
			return TaskReturnType.DONE;
		}		
		return TaskReturnType.IN_PROGRESS;
	}

}
