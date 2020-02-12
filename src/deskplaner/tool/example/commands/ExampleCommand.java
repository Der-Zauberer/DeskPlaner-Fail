package deskplaner.tool.example.commands;

import deskplaner.util.Command;

public class ExampleCommand implements Command {

	/**
	 * @see deskplaner.util.Command#onCommand(String[] args)
	 * @author Paul Leppich
	 */
	@Override
	public boolean onCommand(String[] args) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getLabel() {
		return "example";
	}

}
