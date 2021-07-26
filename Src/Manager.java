import java.util.*;
import javax.swing.*;
/**
 * This Class implements the state and behaviour of the Manager. It uses a "Polymorphic" array, that holds references to 6 class objects that implement the "IntQueueStackHandler" interface. Each implements the "processRequest" abstract method, in a way that will serve the menu item needed. This substantially simplifies the menu handler.
 * @author Ofer Montano
 * @author Roye Mizrahi
 */
public class Manager<T>
{
	private Stack<Integer> st;
	private Queue<Integer> q;
	IntQueueStackHandler [] handlers;
	
	private String [] menuOptions = {"1. Enqueue", "2. Dequeue", "3. Display Queue", "4. Push", "5. Pop", "6. Display Stack", "7. Exit"};
	/**
	 * Manager no-argument constructor, initializes a new Stack object and a new Queue object (of Integer type).
	 */
	public Manager()
	{
		q = new Queue<>();
		st = new Stack<>();
		initHandlers();
		displayMenu();
	}
	
	/**
	 * displays and handles the user choices interactively.
	 */
	private void displayMenu()
	{
		Scanner sc = new Scanner(System.in);
		int input = 1;
		
		while(true)
		{
			System.out.println("Please Enter your choice:");
			for(String str : menuOptions)
				System.out.println(str);
			
			input = sc.nextInt();
			try 
			{
				handlers[input-1].processRequest();
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				JOptionPane.showMessageDialog(null,input + " is an invalid choice! Please try again.");
			}
		}
	}
	
	/**
	* private method to initalize the handlers array and to allocate the corresponding menu object to each appropriate cell.
	*/
	private void initHandlers()
	{
		handlers = new IntQueueStackHandler[menuOptions.length];
		
		handlers[0]= new EnqueuePushHandler(q);
		handlers[1]= new DequeuePopHandler(q);
		handlers[2]= new DisplayHandler(q);
		handlers[3]= new EnqueuePushHandler(st);
		handlers[4]= new DequeuePopHandler(st);
		handlers[5]= new DisplayHandler(st);
		handlers[6]= new ExitHandler();
	}
	
	/**
	 * static main method simply defines and initializes a new manager object. This would invoke its constructor, which then invokes the displayMenu to handle the user choices.
	 */	  
	public static void main(String[] args)
	{
		Manager mngr = new Manager();
	}
}
	