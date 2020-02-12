package deskplaner.tool.example;

import deskplaner.handler.CommandHandler;
import deskplaner.tool.example.commands.ExampleCommand;
import deskplaner.util.Tool;

public class Example extends Tool {

	/**
	 * @see deskplaner.util.Tool#Tool()
	 * @author André Sommer
	 */
	public Example() {
		super("Example", 1);
	}
	
	
	/**
	 * @see deskplaner.util.Tool#onEnable()
	 * @author André Sommer
	 */
	@Override
	public void onEnable() {
		System.out.println("Loades example Tool!");
		CommandHandler.addCommand(new ExampleCommand());
	}
	
	

}
