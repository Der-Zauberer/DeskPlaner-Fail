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
	
	/**
	 * The method "executeCommand(String label, String args[])" search in the arraylist "commands" for a command that have the same text in the attribut label than the given string "label".
	 * If the method finds an fitting command in the list, it calls the method "onCommand(String args[])", to execute the command.
	 * If the method "onCommand(String args[])" returns "false" the method shows an error at the console.
	 * If the given parameter "label" does not fit to any command in the list, the method shows an error at the console.<br><br>
	 * <i>Die Methode "executeCommand(String label, String args[])" sucht in der Arraylist "commands" nach einem eintrag, welcher den selben Text im Attribut Label hat, wie auch der gegebene String "label".
	 * Falls die Methode einen passenden Command findet, ruft es die Methode "onCommand(String args[])" auf, um den Command auszuführen.
	 * Falls die Methode "onCommand(String args[])" falsch zurückgibt, zeigt die MEthode einen Error auf der Konsole.
	 * Falls der gegebene Parameter "label" mit keinem Command aus der Liste passt, zeigt die Methode eine Fehlermeldung auf der Konsole.</i>
	 * 
	 * @param label The label of the command that should be executed.<br><i>Das Label, des Commands, der ausgeführtwerden soll.</i>
	 * @param args[] The arguments that the command should use.<br><i>Die Argumente, die der Command verwenden soll.</i>
	 * @author Paul Leppich
	 */
	public void executeCommand(String label, String args[]) {
		boolean successful = false;
		for (int i = 0; i < commands.size(); i++) {
			if (label.equals(commands.get(i).getLabel())) {
				successful = commands.get(i).onCommand(args);
				if (successful == false) {
					System.out.println("Error: Executing command failed!");
				}
				return;
			}
		}
		System.out.println("Error: Command not found!");
	}
}
