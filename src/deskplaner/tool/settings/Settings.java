package deskplaner.tool.settings;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import deskplaner.util.Tool;

public class Settings extends Tool {

	public Settings() {
		super("Settings");
		addDeskScene(new SettingsScene());
	}
	
	public static String getTime() {
		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		 LocalDateTime localdatetime = LocalDateTime.now();
		 return dateformat.format(localdatetime);
	}

}
