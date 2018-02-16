package org.usfirst.frc.team2503.robot.autonomous;
/**
 * Interface that contains methods shared by all autonomous tasks
 */
public interface TaskBase {
	/**
	 * @return Returns the name of the task
	 */
	public String GetName();
	/**
	 * Called upon entering autonomous mode
	 */
	public void Initialize();
	/**
	 * Called every autonomous update
	 * @return Return task result enum
	 */
	public TaskReturnType Run();

}