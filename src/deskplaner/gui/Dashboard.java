package deskplaner.gui;

import deskplaner.main.Main;
import deskplaner.res.Resource;
import deskplaner.util.Console;
import deskplaner.util.DeskLayout;
import deskplaner.util.DeskWeb;
import deskplaner.util.DeskWidget;
import javafx.scene.layout.GridPane;

public class Dashboard extends DeskLayout{
	
	public Dashboard() {
		
		super("Dashboard");
		
		GridPane gridpane = new GridPane();
		gridpane.setHgap(40);
		gridpane.setVgap(40);
		getContent().getChildren().add(gridpane);
		
		DeskWidget wgTest = new DeskWidget("Console", e -> new Console());
		wgTest.setText("Open");
		gridpane.add(wgTest, 0, 2);
		
		DeskWidget wgYouTube = new DeskWidget("YouTube", e -> DeskWeb.openWebsite("https://www.youtube.com"));
		wgYouTube.setText("Link: youtube.com");
		wgYouTube.setColor("ff0000");
		wgYouTube.setTextColor("ffffff");
		gridpane.add(wgYouTube, 0, 1);
		
		DeskWidget wgTwitter = new DeskWidget("Twitter", e -> DeskWeb.openWebsite("https://www.twitter.com"));
		wgTwitter.setText("Link: twitter.com");
		wgTwitter.setColor("1da1f2");
		wgTwitter.setTextColor("ffffff");
		gridpane.add(wgTwitter, 1, 1);

		gridpane.add(new DeskWidget("Test"), 1, 2);
		
		addMenuItem("Dashboard", e -> Main.getStage().setScene(Main.dashboard.getScene()));
		addMenuItem("Notes", e -> Main.getStage().setScene(Main.notes.getScene()));
		addMenuItem("Tools", e -> Main.getStage().setScene(Main.tools.getScene()));
		addMenuItem("Project", e -> {});
		
		getScene().getStylesheets().add(Resource.getStyleSheet("style.css"));
		
	}

}
