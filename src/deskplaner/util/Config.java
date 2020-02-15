package deskplaner.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import deskplaner.main.DeskPlaner;

public class Config {
	
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
	public Config(String folder, String filename) throws IOException {
		new File(DeskPlaner.getDeskPlanerLocation().getParent(), "DeskPlaner\\" + folder).mkdir();
		file = new File(DeskPlaner.getDeskPlanerLocation().getParent() + "\\DeskPlaner\\" + folder, filename);
		FileReader filereader = new FileReader(file);
		BufferedReader bufferedreader = new BufferedReader(filereader);
		String line;
		while ((line = bufferedreader.readLine()) != null) {
			String[] configitem = line.split(": ");
			configitems.add(new ConfigItem(configitem[0], configitem[1]));
		}
		bufferedreader.close();
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
	 * Save the entrys in the file.<br><br><i>Speichert die Einträge in der Datei.</i>
	 * 
	 * @throws IOException
	 * @author André Sommer
	 */
	public void save() throws IOException {
		FileWriter filewriter = new FileWriter(file);
		BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
		for (ConfigItem configitem : configitems) {
			bufferedwriter.write(configitem.getKey() + ": " + configitem.getValue());
			bufferedwriter.newLine();
		}
		bufferedwriter.close();
	}

}

class ConfigItem {
	
	private String key;
	private String value;
	
	public ConfigItem(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}
	
	public String getValue() {
		return value;
	}
	
}
