import javax.swing.*;
/**
 * This Class inherits from the abstract class "GeneralHandler" - it defines two overloaded constructors, in order to match the overloaded constructors in "GeneralHandler" class. Each of these constructors simply invokes the appropriate "super" (super class constructor) constructor and pass it the corresponding reference to Integer Queue/Stack respectively. It then implements "processRequest" to acquire input from the user via showInputDialog method of JOptionPane Java swing class (input dialog GUI). validate the input and if valid puts it in the Queue/Stack respectively.
 */
public class EnqueuePushHandler extends GeneralHandler
{
	/**
	 * EnqueuePushHandler constructor, initializes a new EnqueuePushHandler with a reference to a Queue of Integers (the Stack reference will be initialized to null by default) - passed via the super constructor.
	 * @param intQ reference to the Stack of Integers
 	 */
	public EnqueuePushHandler(Queue<Integer> intQ)
	{
		super(intQ);
	}
	
	/**
	 * EnqueuePushHandler overloaded constructor, initializes a new EnqueuePushHandler with a reference to a Stack of Integers (the Queue reference will be initialized to null by default) - passed via the super constructor.
	 * @param intSt reference to the Stack of Integers
	 */
	public EnqueuePushHandler(Stack<Integer> intSt)
	{
		super(intSt);
	}
	
	
	/**
	 * This method implements the abstact method "processRequest", inherited from GeneralHandler class. This method acquires input from the user via showInputDialog method of JOptionPane Java swing class (input dialog GUI). validate the input and if valid puts it in the Queue/Stack respectively. ALL user messages are performed via showMessageDialog method of JOptionPane Java swing class (message dialog GUI), and ALL inputs are performed via showInputDialog method of JOptionPane Java swing class (input dialog GUI).
	 */
	public void processRequest()
	{
		int num;
		String input,elementName,operation;
		if (intQ!=null)
		{
			elementName = "Queue";
			operation = "Enqueue";
		}
		else
		{
			elementName = "Stack";
			operation = "Push";
		}
		input=(JOptionPane.showInputDialog("Please Enter a number to " + operation + " the " + elementName));
		try
		{
			num=Integer.parseInt(input);
		}
		catch (NumberFormatException e)
		{
			if (input!=null)
				JOptionPane.showMessageDialog(null,input + " is Not numeric, operationaborted!");
			return;
		}
		if (intQ!=null)
			intQ.enqueue(num);
		else
			intSt.push(num);
	}
}