package deskplaner.tool.notes;

import java.io.IOException;
import java.util.ArrayList;

import deskplaner.util.Configuration;
import deskplaner.util.ConfigItem;

public class NoteConfiguration {

	private static Configuration configuration;

	/**
	 * Save a note in the configuration file.<br>
	 * <br>
	 * <i>Speichert eine Notiz der der Konfigurationsdatei.</i>
	 * 
	 * @param Notes the note to be saved<br>
	 *              <i>Die Notiz, die gespeichert werden soll</i>
	 * @author André Sommer
	 */
	public static void saveNote(Note note) {
		configuration.set(note.getTitle(), note.getText());
		writeNotesIntoConfigurationFile();
	}

	/**
	 * Delete a note from the configuration file.<br>
	 * <br>
	 * <i>Löscht eine Notiz aus der Konfigurationsdtei.</i>
	 * 
	 * @param note The note to be deleted<br>
	 *             <i>Die Notiz, die gelöscht werden soll</i>
	 * @author André Sommer
	 */
	public static void deleteNote(Note note) {
		configuration.remove(note.getTitle());
		writeNotesIntoConfigurationFile();
	}

	/**
	 * Load all saved notes from the configuration file.<br>
	 * <br>
	 * <i>Läd alle Notizen aus der Konfigurationsdatei.</i>
	 * 
	 * @author André Sommer
	 */
	public NoteConfiguration() {
		try {
			configuration = new Configuration("Notes", "notes.txt");
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		ArrayList<Note> notes = new ArrayList<>();
		for (ConfigItem configitem : configuration.getAllEntrys()) {
			Note note = new Note(configitem.getKey(), configitem.getValue());
			notes.add(note);
		}
		for (Note note : notes) {
			Notes.addNote(note);
		}
	}

	/**
	 * Writes all notes into the configuration file.<br>
	 * <br>
	 * <i>Schreibt alle Notizen in die Konfigurationsdatei.</i>
	 * 
	 * @author André Sommer
	 */
	private static void writeNotesIntoConfigurationFile() {
		try {
			configuration.saveEntriesInFile();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

}
