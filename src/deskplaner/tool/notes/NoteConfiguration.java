package deskplaner.tool.notes;

import java.io.IOException;
import deskplaner.util.Configuration;

public class NoteConfiguration {

	private static Configuration config;

	/**
	 * Load all saved notes from the configuration file.<br><br>
	 * <i>Läd alle Notizen aus der Konfigurationsdatei.</i>
	 * 
	 * @author André Sommer
	 */
	public static void initialize() {
		try {
			config = new Configuration("Notes", "notes");
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		for (String entry : config.getAllEntries().keySet()) {
			Note note = new Note(entry, config.get(entry));
			Notes.addNote(note);
		}
	}
	
	/**
	 * Save a note in the configuration file.<br><br>
	 * <i>Speichert eine Notiz der der Konfigurationsdatei.</i>
	 * 
	 * @param Notes the note to be saved<br><i>Die Notiz, die gespeichert werden soll</i>
	 * @author André Sommer
	 */
	public static void saveNote(Note note) {
		config.set(note.getTitle(), note.getText());
		saveConfig();
	}

	/**
	 * Delete a note from the configuration file.<br><br>
	 * <i>Löscht eine Notiz aus der Konfigurationsdatei.</i>
	 * 
	 * @param note The note to be deleted<br><i>Die Notiz, die gelöscht werden soll</i>
	 * @author André Sommer
	 */
	public static void deleteNote(Note note) {
		config.remove(note.getTitle());
		saveConfig();
	}

	/**
	 * Writes all notes into the configuration and save file.<br><br>
	 * <i>Schreibt alle Notizen in die Konfigurationsdatei und spiechert die anschließend.</i>
	 * 
	 * @author André Sommer
	 */
	private static void saveConfig() {
		try {
			config.saveEntriesInFile();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

}
