package deskplaner.tools.notes;

import deskplaner.util.Command;
import deskplaner.util.Tool;

public class NoteCommand implements Command {

	@Override
	public boolean onCommand(String label, String[] args) {
		if(args.length == 0) {
			return false;
		}
		if(args[0].equals("create") && args.length == 3) {
			Notes.createNote(args[1], args[2]);
			return true;
		} else if(args[0].equals("deleate") && args.length == 3) {
			Notes.deleateNote(args[1]);
			return true;
		} else if(args[0].equals("list") && args.length == 1) {
			for (Note note : Notes.getNotes()) {
				System.out.println(note.getTitle() + " -> " + note.getContent());
			}
			return true;
		}
		return false;
	}

	@Override
	public String getCommandName() {
		return "note";
	}

	@Override
	public Tool getCommandTool() {
		return Notes.getInstance();
	}

}
