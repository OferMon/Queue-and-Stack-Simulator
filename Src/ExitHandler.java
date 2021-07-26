/**
 * This Class realizing the interface "IntQueueStackHandler". It implements "processRequest" to completely exit the porgam.
 */
public class ExitHandler implements IntQueueStackHandler
{
	/**
	 * This method implements the abstact method "processRequest" from IntQueueStackHandler interface. The method completely exit the porgam with code 0 (System.exit(0)).
	 */
	public void processRequest()
	{
		System.exit(0);
	}
}
