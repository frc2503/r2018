package org.usfirst.frc.team2503.robot.autonomous;

import java.util.Vector;

public class AutonomousTaskManager {

	private static Vector<TaskBase> taskList = new Vector<TaskBase>();

	public static void Initialize() {
		// Add tasks
		taskList.addElement(new TaskMove(3.5, 0.35));
	}

	/**
	 * This will run tasks in the order they are set in the "tasks" Vector
	 * 
	 * @return False if there are no more tasks to run
	 */
	public static boolean Run() {
		if (taskList.size() == 0)
			return false;

		switch (taskList.get(0).Run()) {
		case IN_PROGRESS:
			break;
		case DONE:
			System.out.println("Autonomous task completed: \"" + taskList.get(0).GetName() + "\"");
			taskList.remove(0);
			break;
		case ERROR:
			System.err.println("An error has occured in task \"" + taskList.get(0).GetName() + "\"! Aborting...");
			taskList.remove(0);
			break;
		}

		return true;
	}

}
