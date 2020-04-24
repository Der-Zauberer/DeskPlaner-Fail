package deskplaner.util;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;


import deskplaner.main.DeskPlaner;

public class Configuration {
	
	private HashMap<String, String> entries = new HashMap<>();
	private Path path;
	
	/**
	 * Creates a new folder and a new file if it does not exist and opens it.<br><br>
	 * <i>Erstellt einen neuen Ordner und eine neue Datei, wenn diese nicht existiert und öffnet diese.</i>
	 * 
	 * @param folder The folder of the file inside the DeskPlaner folder<br><i>Der Ordner der Datei innerhalb des DeskPlaner Ordners</i>
	 * @param filename The name of the file<br><i>The name of the folder</i>
	 * @throws IOException
	 * @author André Sommer, Paul Leppich
	 */
	public Configuration(String folder, String filename) throws IOException {
		String pathstring = DeskPlaner.getDeskPlanerLocation() + "/DeskPlaner/" + folder;
		Path directory = Paths.get(pathstring);
		if(!Files.exists(directory)) {
			Files.createDirectories(directory);
		}
		filename = filename + ".json";
		path = Paths.get(pathstring, filename);
		if(!Files.exists(path)) {
			Files.createFile(path);
		}
		FileReader reader = new FileReader(path.toString(), Charset.forName("UTF-8"));
		JSONParser jsonParser = new JSONParser();
		try {
			Object data = jsonParser.parse(reader);
			JSONArray entriesArray = (JSONArray) data;
			entriesArray.forEach(entry -> set((JSONObject) entry));
			
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *Remove an existing entry in the file with the key.<br><br>
	 * <i>Löscht einen vorhandenen Eintrag in der Datei mit der Identifikation.</i>
	 * 
	 * @param key The unique identity of the entry<br><i>Die einmalige Identität des Eintrags</i>
	 * @author André Sommer
	 */
	public void remove(String key) {
		if(entries.containsKey(key)) {
			entries.remove(key);
		}
	}
	
	/**
	 * Save the entries in the file.<br><br><i>Speichert die Einträge in der Datei.</i>
	 * 
	 * @throws IOException
	 * @author André Sommer, Paul Leppich
	 */
	public void saveEntriesInFile() throws IOException {
		JSONArray entriesArray = new JSONArray();
		for (String entry : entries.keySet()) {
			JSONObject entryObject = new JSONObject();
			entryObject.put("key", entry);
			entryObject.put("value", entries.get(entry));
			entriesArray.add(entryObject);
		}
		Files.write(path, entriesArray.toJSONString().getBytes());
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
		entries.put(key, value);
	}
	
	/**
	 * Create a new entry or edit an existing entry in the list(HashMap) by using a json-object.<br><br>
	 * <i>Erstellt einen neuen Eintrag oder ändert einen vorhandenen Eintrag in der Liste(HashMap) unter Nutzung eines json-Objketes.</i>
	 * 
	 * @param entry The new entry.<br><i>Der neue Eintrag.</i>
	 * @author Paul Leppich
	 */
	private void set(JSONObject entry) {
		entries.put((String) entry.get("key"), (String) entry.get("value"));
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
		if(entries.containsKey(key)) {
			return entries.get(key);
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
	public HashMap<String, String> getAllEntries() {
		return entries;
	}

}