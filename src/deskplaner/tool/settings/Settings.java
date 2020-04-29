package deskplaner.tool.settings;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import deskplaner.util.Tool;

public class Settings extends Tool {

	private static HashMap<String, String> labels = new HashMap<String, String>();
	
	public Settings() {
		super("Settings");
		addDeskScene(new SettingsScene());
	}
	
	public static String getTime() {
		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime localdatetime = LocalDateTime.now();
		return dateformat.format(localdatetime);
	}
	
	public static void addLabel(String name, String hexcolor) {
		labels.put(name, hexcolor);
	}
	
	public static boolean containsLabel(String name) {
		return labels.containsKey(name);
	}
	
	public static String getLabelColor(String name) {
		return labels.get(name);
	}
	
	public static HashMap<String, String> getLabels() {
		return labels;
	}

}
