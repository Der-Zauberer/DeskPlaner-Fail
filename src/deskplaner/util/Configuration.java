package deskplaner.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import deskplaner.main.DeskPlaner;

public class Configuration {
	
	private ArrayList<ConfigItem> configitems = new ArrayList<>();
	private File file;
	
	/**
	 * Creates a new folder and a new file if it does not exist and opens it.<br><br>
	 * <i>Erstellt einen neuen Ordner und eine neue Datei, wenn diese nich nicht existiert und öffnet diese.</i>
	 * 
	 * @param folder The folder of the file inside the DeskPlaner folder<br><i>Der Ordner der Datei innerhalb des DeskPlaner Ordners</i>
	 * @param filename The name of the file<br><i>The name of the folder</i>
	 * @throws IOException
	 * @author André Sommer
	 */
	public Configuration(String folder, String filename) throws IOException {
		new File(DeskPlaner.getDeskPlanerLocation().getParent(), "DeskPlaner\\" + folder).mkdir();
		file = new File(DeskPlaner.getDeskPlanerLocation().getParent() + "\\DeskPlaner\\" + folder, filename);
		FileReader filereader = new FileReader(file);
		BufferedReader bufferedreader = new BufferedReader(filereader);
		String line;
		while ((line = bufferedreader.readLine()) != null) {
			String[] configitem = line.split(": ");
			set(configitem[0], configitem[1]);
		}
		bufferedreader.close();
	}
	
	/**
	 *Remove an existing entry in the file with the key.<br><br>
	 * <i>Löscht einen vorhandenen Eintrag in der Datei mit der Identifikation.</i>
	 * 
	 * @param key The unique identity of the entry<br><i>Die einmalige Identität des Eintrags</i>
	 * @author André Sommer
	 */
	public void remove(String key) {
		for(ConfigItem configitem : configitems) {
			if(configitem.getKey().equals(key)) {
				configitems.remove(configitem);
				return;
			}
		}
	}
	
	/**
	 * Save the entries in the file.<br><br><i>Speichert die Einträge in der Datei.</i>
	 * 
	 * @throws IOException
	 * @author André Sommer
	 */
	public void saveEntriesInFile() throws IOException {
		FileWriter filewriter = new FileWriter(file);
		BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
		for (ConfigItem configitem : configitems) {
			bufferedwriter.write(configitem.getKey() + ": " + configitem.getValue());
			bufferedwriter.newLine();
		}
		bufferedwriter.close();
	}
	
	/**
	 * Create a new entry or edit an existing entry in the file with key and a value.<br><br>
	 * <i>Erstellt einen neuen Eintrag oder ändert einen vorhandenen Eintrag in der Datei mit der Identifikation und einem Wert.</i>
	 * 
	 * @param key The unique identity of the entry<br><i>Die einmalige Identität des Eintrags</i>
	 * @param value The value of the entry<br><i>Der Wert des Eintrags</i>
	 * @author André Sommer
	 */
	public void set(String key, String value) {
		for(ConfigItem configitem : configitems) {
			if(configitem.getKey().equals(key)) {
				configitem.setValue(value);
				return;
			}
		}
		configitems.add(new ConfigItem(key, value));
	}
	
	/**
	 * Read and return an existing entry in the file with key and a value.<br><br>
	 * <i>Der vorhandenen Eintrag wird in der Datei mit der Identifikation und einem Wert gelesen und zurückgegeben.</i>
	 * 
	 * @param key The unique identity of the entry<br><i>Die einmalige Identität des Eintrags</i>
	 * @param value The value of the entry<br><i>Der Wert des Eintrags</i>
	 * @author André Sommer
	 */
	public String get(String key) {
		for (ConfigItem configitem : configitems) {
			if(configitem.getKey().equals(key)) {
				return configitem.getValue();
			}
		}
		return null;
	}
	
	/**
	 * Returns all entries in the file.<br><br>
	 * <i>Gibt alle Einträge der Datei zurück.<i/>
	 * 
	 * @return The entries of the file<br><i>Die Einträge der Datei.</i>
	 * @author André Sommer
	 */
	public ArrayList<ConfigItem> getAllEntrys() {
		return configitems;
	}

}