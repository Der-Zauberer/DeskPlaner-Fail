package deskplaner.handler;

import java.util.ArrayList;

import deskplaner.utli.Command;

public class CommandHandler {
	
	private ArrayList<Command> commands = new ArrayList<Command>();
	
	/**
	 * The method "addCommand(Command addCommand)" add the "addCommand" to the "commands" Arraylist.<br><br>
	 * <i>Die Methode "addCommand(Command addCommand)" fügt den Command "addCommand" der dynamischen Liste "commands" hinzu.</i>
	 * 
	 * @param addCommand The Command that you want to add.<br><i>Der Command, den Sie hinzufügen wollen.</i>
	 * @author Paul Leppich
	 */
	public void addCommand(Command addCommand) {
		commands.add(addCommand);
	}
}
