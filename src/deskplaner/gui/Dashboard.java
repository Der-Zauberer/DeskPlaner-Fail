package deskplaner.gui;

import deskplaner.main.Main;
import deskplaner.util.Console;
import deskplaner.util.GUILayout;
import deskplaner.util.Program;
import deskplaner.util.Web;
import deskplaner.util.Widget;

public class Dashboard extends GUILayout{
	
	public Dashboard() {
		
		setTitle("Dashboard");
		
		Widget wgTest = new Widget("Console", e -> new Console());
		wgTest.setText("Open");
		getContent().add(wgTest, 0, 2);
		
		Widget wgYouTube = new Widget("YouTube", e -> Web.openWebsite("https://www.youtube.com"));
		wgYouTube.setText("Link: youtube.com");
		wgYouTube.setColor("ff0000");
		wgYouTube.setTextColor("ffffff");
		getContent().add(wgYouTube, 0, 1);
		
		Widget wgTwitter = new Widget("Twitter", e -> Web.openWebsite("https://www.twitter.com"));
		wgTwitter.setText("Link: twitter.com");
		wgTwitter.setColor("1da1f2");
		wgTwitter.setTextColor("ffffff");
		getContent().add(wgTwitter, 1, 1);

		getContent().add(new Widget("Test"), 1, 2);
		
		addMenuItem("Dashboard", e -> {});
		addMenuItem("Tasks", e -> Main.getStage().setScene(Main.notes.getScene()));
		addMenuItem("Tools", e -> {});
		addMenuItem("Project", e -> {});
		addMenuItem("Quit", e -> new Main().exit(), true);
		addMenuItem("Settings", e -> {}, true);
		addMenuItem("Help", e -> {}, true);
		
		getScene().getStylesheets().add(getClass().getResource(Program.getStylePath()).toExternalForm());
		
	}

}
