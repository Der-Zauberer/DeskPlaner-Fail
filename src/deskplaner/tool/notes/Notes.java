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
		CommandHandler.registerCommand(new NoteCommand());
		NoteConfiguration.initialize();
		addDeskScene(new NoteScene());
	}

	/**
	 * Add a Note to the tool of Notes. A note will only be added if no other note with the same name exists.<br><br>
	 * <i>Fügt eine neue Notiz zum Tool Notes hinzu. 
	 * Eine Notiz wird nur hinzugefügt, wenn keine weitere Notiz mit dem gleichen Namen existiert.</i>
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
		NoteConfiguration.saveNote(note);
	}
	
	/**
	 * Delete a existing note.<br><br>
	 * <i>Löscht eine vorhandene Notiz.</i>
	 * 
	 * @author André Sommer
	 */
	public static void deleteNote(Note note) {
		notes.remove(note);
		NoteConfiguration.deleteNote(note);
	}
	
	/**
	 * Return all notes who contain the text.<br><br>
	 * <i>Gibt alle Notizen zurück, die den Text beinhalten.</i>
	 * 
	 * @param text the searched text.<br><i>Der gesuchte Text.</i>
	 * 
	 * @author Paul Leppich
	 */
	public static ArrayList<Note> searchNote(String text) {
		ArrayList<Note> searchResult = new ArrayList<>();
		for (Note note : notes) {
			if (note.getTitle().contains(text)||note.getText().contains(text)) {
				searchResult.add(note);
			}
		}
		return searchResult;
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
