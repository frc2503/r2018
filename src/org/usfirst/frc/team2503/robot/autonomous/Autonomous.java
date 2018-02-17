package org.usfirst.frc.team2503.robot.autonomous;

public class Autonomous {

	private static boolean done;

	public static void init() {
		done = false;
		AutonomousTaskManager.Initialize();
		System.out.println("Autonomous initialized");
	}

	public static void autonomousPeriodic() {
		if (!AutonomousTaskManager.Run() && !done) {
			System.out.println("Autonomous tasks completed");
			done = true;
		}
	}

}
