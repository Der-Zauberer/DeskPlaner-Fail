package deskplaner.tool.notes;

import java.io.IOException;
import java.util.ArrayList;

import deskplaner.util.Config;
import deskplaner.util.ConfigItem;

public class NoteConfig {
	
	private static Config config;
	
	/**
	 * Load all saved notes from the configuration file.<br><br>
	 * <i>Läd alle Notizen aus der Konfigurationsdatei.</i>
	 * 
	 * @author André Sommer
	 */
	public NoteConfig() {
		try {
			config = new Config("Notes", "notes.txt");
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		ArrayList<Note> notes = new ArrayList<>();
		for(ConfigItem configitem : config.getAllEntrys()) {
			Note note = new Note(configitem.getKey(), configitem.getValue());
			notes.add(note);
		}
		for (Note note : notes) {
			Notes.addNote(note);
		}
	}
	
	/**
	 * Save a note in the configuration file.<br><br>
	 * <i>Speichert eine Notiz der der Konfigurationsdtei.</i>
	 * 
	 * @param note The note to be saved<br><i>Die Notiz, die gespeichert werden soll</i>
	 * @author André Sommer
	 */
	public static void saveNote(Note note) {
		config.set(note.getTitle(), note.getText());
		save();
	}
	
	/**
	 * Delete a note from the configuration file.<br><br>
	 * <i>Löscht eine Notiz aus der Konfigurationsdtei.</i>
	 * 
	 * @param note The note to be deleted<br><i>Die Notiz, die gelöscht werden soll</i>
	 * @author André Sommer
	 */
	public static void deleteNote(Note note) {
		config.remove(note.getTitle());
		save();
	}
	
	/**
	 * Write all notes in the configuration file.<br><br>
	 * <i>Schreibt alle Notizen in die Konfigurationsdatei.</i>
	 * 
	 * @author André Sommer
	 */
	private static void save() {
		try {
			config.save();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

}
