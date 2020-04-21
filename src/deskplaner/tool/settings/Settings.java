package deskplaner.tool.settings;

import deskplaner.util.Tool;

public class Settings extends Tool {

	public Settings() {
		super("Settings");
		addDeskScene(new SettingsScene());
	}

}
