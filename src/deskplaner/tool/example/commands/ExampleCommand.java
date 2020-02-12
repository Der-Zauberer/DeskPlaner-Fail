package deskplaner.tool.example.commands;

import java.util.Arrays;
import deskplaner.util.Command;

public class ExampleCommand implements Command {

	/**
	 * The examplecommand shows the arguments on the console.<br><br>
	 * <i>Der Beispielcommand zeigt die Argumente auf der Konsole.</i>
	 * 
	 * @see deskplaner.util.Command#onCommand(String[] args)
	 * @author Paul Leppich
	 */
	@Override
	public boolean onCommand(String[] args) {
		System.out.println(" arguments: " + Arrays.toString(args));
		return true;
	}

	@Override
	public String getLabel() {
		return "example";
	}

}
