package deskplaner.gui;

import deskplaner.main.Main;
import deskplaner.util.Console;
import deskplaner.util.GUILayout;
import deskplaner.util.Program;
import deskplaner.util.Web;
import deskplaner.util.Widget;
import javafx.scene.layout.GridPane;

public class Dashboard extends GUILayout{
	
	public Dashboard() {
		
		super("Dashboard");
		
		GridPane gridpane = new GridPane();
		gridpane.setHgap(20);
		gridpane.setVgap(20);
		getContent().getChildren().add(gridpane);
		
		Widget wgTest = new Widget("Console", e -> new Console());
		wgTest.setText("Open");
		gridpane.add(wgTest, 0, 2);
		
		Widget wgYouTube = new Widget("YouTube", e -> Web.openWebsite("https://www.youtube.com"));
		wgYouTube.setText("Link: youtube.com");
		wgYouTube.setColor("ff0000");
		wgYouTube.setTextColor("ffffff");
		gridpane.add(wgYouTube, 0, 1);
		
		Widget wgTwitter = new Widget("Twitter", e -> Web.openWebsite("https://www.twitter.com"));
		wgTwitter.setText("Link: twitter.com");
		wgTwitter.setColor("1da1f2");
		wgTwitter.setTextColor("ffffff");
		gridpane.add(wgTwitter, 1, 1);

		gridpane.add(new Widget("Test"), 1, 2);
		
		addMenuItem("Dashboard", e -> Main.getStage().setScene(Main.dashboard.getScene()));
		addMenuItem("Tasks", e -> Main.getStage().setScene(Main.notes.getScene()));
		addMenuItem("Tools", e -> Main.getStage().setScene(Main.tools.getScene()));
		addMenuItem("Project", e -> {});
		
		getScene().getStylesheets().add(getClass().getResource(Program.getStylePath()).toExternalForm());
		
	}

}
