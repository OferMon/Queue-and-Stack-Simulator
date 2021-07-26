import javax.swing.*;
/**
 * This Class inherits from the abstract class "GeneralHandler" - it defines two overloaded constructors, in order to match the overloaded constructors in "GeneralHandler" class. Each of these constructors simply invokes the appropriate "super" (super class constructor) constructor and pass it the corresponding reference to Integer Queue/Stack respectively. It then implements "processRequest" to Pop/Dequeue an item from Stack/Queue respectively. Then present it on a GUI message dialog.
 */
public class DequeuePopHandler extends GeneralHandler
{
	/**
	 * DequeuePopHandler constructor, initializes a new DequeuePopHandler with a reference to a Queue of Integers (the Stack reference will be initialized to null by default) - passed via the super constructor.
	 * @param intQ reference to the Queue of Integers
	 */
	public DequeuePopHandler(Queue<Integer> intQ)
	{
		super(intQ);
	}
	
	/**
	* DequeuePopHandler overloaded constructor, initializes a new DequeuePopHandler with a reference to a Stack of Integers (the Queue reference will be initialized to null by default) - passed via the super constructor.
	* @param intSt reference to the Stack of Integers
	*/
	public DequeuePopHandler(Stack<Integer> intSt)
	{
		super(intSt);
	}
	
	/**
	 * This method implements the abstract method "processRequest", inherited from GeneralHandler class. This method Dequeue/Pop an item from the Queue/Stack respectively, and presents it on via showMessageDialog method of JOptionPane. If the examined Queue/Stack is empty, issues an appropriate message to the user using showInputDialog method of JOptionPane Java swing class (input dialog GUI). Likewise, ALL user messages are performed via showMessageDialog method of JOptionPane Java swing class (message dialog GUI).
	 */
	public void processRequest()
	{
		Integer num;
		String elementName,operation;
		if (intQ!=null)
		{
			elementName = "Queue";
			operation = "Dequeue";
			num= intQ.dequeue();
		}
		else
		{
			elementName = "Stack";
			operation = "Pop";
			num= intSt.pop();
		}
		if (num==null)
			JOptionPane.showMessageDialog(null,elementName + " is Empty!!!");
		else
			JOptionPane.showMessageDialog(null,"Value " + operation + " from " + elementName + " is: " + num);
				
	}
}