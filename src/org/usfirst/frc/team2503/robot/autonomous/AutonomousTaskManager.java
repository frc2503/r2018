package org.usfirst.frc.team2503.robot.autonomous;

import java.util.Vector;

import org.usfirst.frc.team2503.robot.Input;

import edu.wpi.first.wpilibj.DriverStation;

public class AutonomousTaskManager {

	private static Vector<TaskBase> taskList = new Vector<TaskBase>();
	
	public static int GetRemainingTasks()
	{
		return taskList.size();
	}

	public static void Initialize() {
		
		// Which side are we on? Hopefully not the middle
		// False = left, true = right
		boolean side = Input.getLeft().getRawAxis(2) < 0;
		
		System.out.println("We are on the " + (!side ? "left" : "right") + " side");
		System.out.println("Game message: " + DriverStation.getInstance().getGameSpecificMessage());
		
		// Move forward task
		taskList.addElement(new TaskMove(2.5, -0.5, -0.5));
		
		/*
		// Get FMS data
		if (DriverStation.getInstance().getGameSpecificMessage().charAt(0) == 'L')
		{
			// We need to go to the left
			// If we are on the right and we need to score on the left, don't bother
			if (side == false)
			{
				System.out.println("Scoring left");
				taskList.addElement(new TaskShoot(0.40));
			} else
			{
				System.out.println("Not scoring");
			}
			
		} else {
			// We need to score on the right
			// If we are on the left and we need to go to the right, don't bother
			if (side == true)
			{
				System.out.println("Scoring right");
				// Turn to the right
				//taskList.addElement(new TaskMove(1, 0.5, -0.5));
				// Move forward so we are against the switch wall
				//taskList.addElement(new TaskMove(0.5, -0.4, -0.4));
				// Shoot
				taskList.addElement(new TaskShoot(0.40));
			} else
			{
				System.out.println("Not scoring");
			}
		}
		*/
		
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
