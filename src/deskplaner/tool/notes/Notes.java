package deskplaner.tool.notes;

import java.util.ArrayList;

import deskplaner.handler.CommandHandler;
import deskplaner.util.Tool;

public class Notes extends Tool {
	
	private static ArrayList<Note> notes = new ArrayList<>();

	/**
	 * Create a new Tool with name "Notes" and Version 1.<br><br>
	 * <i>Erstellt das Tool mit dem Namen "Notizen" und der Version 1.</i>
	 * 
	 * @author André Sommer
	 */
	public Notes() {
		super("Notes", 1);
		CommandHandler.addCommand(new NoteCommand());
		new NoteConfig();
	}

	/**
	 * Add a Note to the tool of Notes. A note will only be added if no other note with the same name exists.<br><br>
	 * <i>Fügt eine neue Notiz zum Tool Notes hinzu. Eine Notiz wird nur hinzugefügt, wenn keine weitere Notiz mit dem gleichen Namen existiert.</i>
	 * 
	 * @author André Sommer
	 */
	public static void addNote(Note note) {
		for (Note notes : notes) {
			if(notes.getTitle().equalsIgnoreCase(note.getTitle())) {
				return;
			}
		}
		notes.add(note);
		NoteConfig.saveNote(note);
	}
	
	public static void deleteNote(Note note) {
		notes.remove(note);
		NoteConfig.deleteNote(note);
	}
	
	public static Note getNote(int index) {
		return notes.get(index);
	}
	
	public static Note getNote(String title) {
		for (Note note : notes) {
			if(note.getTitle().equalsIgnoreCase(title)) {
				return note;
			}
		}
		return null;
	}
	
	public static ArrayList<Note> getNotes() {
		return notes;
	}
	

}
