package deskplaner.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
		Path directory = Paths.get(DeskPlaner.getDeskPlanerLocation().toString(), "DeskPlaner", folder);
		if(!Files.exists(directory)) {
			Files.createDirectories(directory);
		}
		filename = filename + ".json";
		path = Paths.get(directory.toString(), filename);
		if(!Files.exists(path)) {
			Files.createFile(path);
			return;
		}
		String data = new String(Files.readAllBytes(path));
		if (!data.isEmpty()) {
			JSONParser jsonParser = new JSONParser();
			try {
				JSONObject entriesJSONObject = (JSONObject) jsonParser.parse(data);
				for (Map.Entry entriesFromJSONObject : (Set<Map.Entry>) entriesJSONObject.entrySet()) {
					set(entriesFromJSONObject.getKey().toString(), (String) entriesFromJSONObject.getValue());
				}
			} catch (ParseException exception) {
				exception.printStackTrace();
			}
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
		JSONObject entriesJSONObject = new JSONObject();
		for (String entry : entries.keySet()) {
			entriesJSONObject.put(entry, entries.get(entry));
		}
		Files.write(path, entriesJSONObject.toJSONString().getBytes());
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