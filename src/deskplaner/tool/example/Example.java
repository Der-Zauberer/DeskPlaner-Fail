package deskplaner.tool.example;

import deskplaner.util.Tool;

public class Example extends Tool {

	/**
	 * @see deskplaner.utli.Tool#Tool()
	 * @author Andr� Sommer
	 */
	public Example() {
		super("Example", 1);
	}
	
	
	/**
	 * @see deskplaner.utli.Tool#onEnable()
	 * @author Andr� Sommer
	 */
	@Override
	public void onEnable() {
		System.out.println("Loades example Tool!");
	}
	
	

}
