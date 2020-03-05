package deskplaner.tool.notes;

import deskplaner.util.Command;

public class NoteCommand implements Command {
	
	/**
	 * The command can creates, lists or deletes the notes.<br>
	 *<i>Das Kommando kann eine Notiz erstellen, auflisten oder löschen.</i>
	 *
	 * @author  Jakob Bolenbach
	 */
	@Override
	public boolean onCommand(String[] args) {
		if(args.length > 0 && args[0] != null) {
			if(args[0].equalsIgnoreCase("create")) {
				if(args.length > 1 && args[1] != null && args[2] != null) {
					String text = "";
					for (int i = 2; i < args.length; i++) {
						text += args[i];
						if (i < args.length - 1) {
							text += " ";
						}
					}
					Notes.addNote(new Note(args[1], text));
					return true;
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
