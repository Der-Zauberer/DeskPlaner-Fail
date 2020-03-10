package deskplaner.main;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import deskplaner.handler.CommandHandler;
import deskplaner.tool.notes.Notes;
import deskplaner.util.Tool;

public class DeskPlaner {
	
	private static ArrayList<Tool> tools = new ArrayList<>();

	/**
	 * This is the main method of the program.<br><br>
	 * <i>Dies ist die Startmethode des Programms.</i>
	 * 
	 * @param args The java start arguments <br><i>Die Java Startargumente</i>
	 * @author André Sommer
	 */
	public static void main(String[] args) {
		registerTool(new Notes()) ;
		enableTools();
		splitCommandForConsole();
		disableTools();
	}
	
	/**
	 * This method can be used to register tools.<br><br>
	 * <i>Mit dieser Methode lassen sich Tools registrieren.</i>
	 * @param tool The tool to be registered<br><i>Das Tool, das registriert werden soll</i>
	 * @author André Sommer
	 */
	public static void registerTool(Tool tool) {
		tools.add(tool);
	}
	
	/**
	 * Return the file location of the executed .jar file.<br><br>
	 * <i>Gibt den Dateiort der ausgeführten .jar datei zurück.</i>
	 * 
	 * @return The location of the executed .jar file.<br><i>Den Speicherort der ausgeführten .jar Datei.</i>
	 * @author André Sommer
	 */
	
	public static File getDeskPlanerLocation() {
		try {
			return new File(DeskPlaner.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
		} catch (URISyntaxException exception) {
		}
		return null;
	}
	
	/**
	 * 
	 * In the method the entered string from the console is split into single words.
	 * The first word is the label, all other words are stored in args.<br><br>
	 * <i>In der Methode wird der eingegebene String aus der Konsole in einzelne Wörter aufgeteilt.
	 * Das erste Wort ist das Label, alle anderen Wörter werden in args gespeichert.<i>
	 * 
	 * @author André Sommer
	 */
	@SuppressWarnings("resource")
	private static void splitCommandForConsole() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String input = scanner.nextLine();
			String command[] = input.split(" ");
			String label = command[0];
			String args[] = Arrays.copyOfRange(command, 1, command.length);
			CommandHandler.executeCommand(label, args);
		}
	}
	
	
	
	/**
	 * The method calls all onEnable() methods of the registered tools.<br><br>
	 * <i>Die Methode ruft alle onEnable() Methoden der Registrierten Tools auf.</i>
	 * 
	 * @author André Sommer
	 */
	private static void enableTools() {
		for (Tool tool : tools) {
			tool.onEnable();
			System.out.println("[ToolLoader] " + tool.getName() + " successfully loaded!");
		}
	}
	
	
	/**
	 * The method calls all onDisable() methods of the registered tools.<br><br>
	 * <i>Die Methode ruft alle onDisable() Methoden der Registrierten Tools auf.</i>
	 * 
	 * @author André Sommer
	 */
	private static void disableTools() {
		for (Tool tool : tools) {
			tool.onDisable();
		}
	}

}
