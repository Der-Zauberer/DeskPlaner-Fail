package deskplaner.handler;

import java.util.ArrayList;
import deskplaner.util.Command;

public class CommandHandler {
	
	private static ArrayList<Command> commands = new ArrayList<>();
	
	/**
	 * The method register a new command.<br><br>
	 * <i>Die Methode registiert einen neuen Command</i>
	 * 
	 * @param command which should be added.<br><i>Der Command, der hinzugefügt werden soll.</i>
	 * @author Paul Leppich
	 */
	public static void registerCommand(Command command) {
		commands.add(command);
	}
	
	/**
	 * The method executes the command with the given label. If the execution was successful the method returns true.<br><br>
	 * <i>Die Methode führt den Command mit dem gegebenen Label aus. Falls die Ausführung erfolgreich war, gibt die Methode "wahr" zurück.</i>
	 * 
	 * @param label the label of the command that should be executed.<br><i>Das Label, des Commands, der ausgeführtwerden soll.</i>
	 * @param args[] the arguments that the command should use.<br><i>Die Argumente, die der Command verwenden soll.</i>
	 * @author Paul Leppich
	 */
	
	public static boolean executeCommand(String label, String args[]) {
		for (Command command : commands) {
			if (command.getLabel().equals(label)) {
				if (command.onCommand(args)) {
					return true;
				}else {
					System.out.println("Error: Executing command failed!");
					return false;
				}
			}
		}
		System.out.println("Error: Command not found!");
		return false;
	}
}
