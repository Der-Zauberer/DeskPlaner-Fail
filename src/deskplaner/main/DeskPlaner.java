package deskplaner.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import deskplaner.tool.example.Example;
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
		registerTool(new Example());
		enableTools();
		console();
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
	 * 
	 * In the method the entered string from the console is split into single words.
	 * The first word is the label, all other words are stored in args.<br><br>
	 * <i>In der Metode wird der eingegebene String aus der Konsole in einzelne Wörter aufgeteilt.
	 * Das erste Wort ist das Label, alle anderen Wörter werden in args gespeichert.<i>
	 * 
	 * @author André Sommer
	 */
	@SuppressWarnings("resource")
	private static void console() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String input = scanner.nextLine();
			String command[] = input.split(" ");
			String label = command[0];
			String args[] = Arrays.copyOfRange(command, 1, command.length);
			System.out.println("Label: " + label + " Arguments: " + Arrays.toString(args));
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
