package deskplaner.tool.notes;

import deskplaner.util.Command;

public class NoteCommand implements Command {
	
	/**
	 * The command creates, lists, deletes or search the notes.<br>
	 * <i>Das Kommando kann eine Notiz erstellen, auflisten, löschen oder suchen.</i>
	 *
	 * @author Jakob Bolenbach, Paul Leppich
	 */
	@Override
	public boolean onCommand(String[] args) {
		if(args.length > 0 && args[0] != null) {
			if(args[0].equalsIgnoreCase("create")) {
				if(args.length > 2 && args[1] != null && args[2] != null) {
					if(args.length > 3) {
						String text = String.join(" ", args).substring(8 + args[1].length());
						Notes.addNote(new Note(args[1], text));
					} else {
						Notes.addNote(new Note(args[1], args[2]));
					}
					return true;
				} else {
					return false;
				}
			} else if(args[0].equalsIgnoreCase("list")) {
				for (Note note : Notes.getNotes()) {
					System.out.println(note);
				}
				return true;
			} else if(args[0].equalsIgnoreCase("delete")) {
				if(args.length > 1 && args[1] != null && Notes.getNote(args[1]) != null) {
					Notes.deleteNote(Notes.getNote(args[1]));
					return true;
				} else if(args[0].equalsIgnoreCase("search")) {
					if (args.length > 1 && args[1] != null) {
						for (Note note : Notes.seachNote(args[1])) {
							System.out.println(note.toString());
						}
					}
					return true;
				}
			}	
		}
		return false;
	}

	@Override
	public String getLabel() {
		return "note";
	}
	
}
