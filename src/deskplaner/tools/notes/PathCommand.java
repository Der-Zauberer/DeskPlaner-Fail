package deskplaner.tools.notes;

import java.io.File;
import java.net.URISyntaxException;

import deskplaner.main.DeskPlaner;
import deskplaner.util.Command;
import deskplaner.util.Tool;

public class PathCommand implements Command{

	@Override
	public boolean onCommand(String label, String[] args) {
		try {
			System.out.println(new File(DeskPlaner.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()));
		} catch (URISyntaxException e) {
		}
		return true;
	}

	@Override
	public String getCommandName() {
		return "path";
	}

	@Override
	public Tool getCommandTool() {
		return Notes.getInstance();
	}

}
