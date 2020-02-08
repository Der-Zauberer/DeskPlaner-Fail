package deskplaner.tool.example;

import deskplaner.utli.Tool;

public class Example extends Tool {

	/**
	 * @see deskplaner.utli.Tool#Tool()
	 * @author André Sommer
	 */
	public Example() {
		super("Example", 1);
	}
	
	
	/**
	 * @see deskplaner.utli.Tool#onEnable()
	 * @author André Sommer
	 */
	@Override
	public void onEnable() {
		System.out.println("Loades example Tool!");
	}
	
	

}
