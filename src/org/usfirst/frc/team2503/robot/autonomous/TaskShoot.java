package org.usfirst.frc.team2503.robot.autonomous;

import org.usfirst.frc.team2503.robot.Intake;
import org.usfirst.frc.team2503.robot.Shooter;

import edu.wpi.first.wpilibj.Timer;

public class TaskShoot implements TaskBase {

	private double power;
	private Timer taskTimer;
	private boolean initialized;

	public TaskShoot(double power) {
		initialized = false;
		this.power = power;
	}

	@Override
	public String GetName() {
		return "Shoot";
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

		Shooter.setShooters(1);

		if (taskTimer.get() > 0.75) {
			Intake.setCubeShifters(power);
		}

		if (taskTimer.get() > 2) {
			Intake.setCubeShifters(0);
			Shooter.setShooters(0);
			return TaskReturnType.DONE;
		}

		return TaskReturnType.IN_PROGRESS;

	}

}
