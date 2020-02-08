package deskplaner.main;

import java.util.Arrays;
import java.util.Scanner;

public class DeskPlaner {

	/**
	 * This is the main method of the program.<br><br>
	 * <i>Dies ist die Startmethode des Programms.</i>
	 * 
	 * @param args The java start arguments <br><i>Die Java Startargumente</i>
	 * @author André Sommer
	 */
	public static void main(String[] args) {
		console();
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

}
