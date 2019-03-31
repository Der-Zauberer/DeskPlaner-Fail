package deskplaner.dashboard;

import deskplaner.main.Main;
import deskplaner.res.Resource;
import deskplaner.util.Console;
import deskplaner.util.DeskLayout;
import deskplaner.util.DeskWeb;
import deskplaner.util.DeskCrad;
import javafx.scene.layout.GridPane;

public class Dashboard extends DeskLayout{
	
	public Dashboard() {
		
		super("Dashboard");
		
		GridPane gridpane = new GridPane();
		gridpane.setHgap(50);
		gridpane.setVgap(50);
		getContent().getChildren().add(gridpane);
		
		DeskCrad dgTest = new DeskCrad("Console", e -> new Console());
		dgTest.setText("Open");
		gridpane.add(dgTest, 0, 1);
		
		DeskCrad dgYouTube = new DeskCrad("YouTube", e -> DeskWeb.openWebsite("https://www.youtube.com"));
		dgYouTube.setText("Link: youtube.com");
		dgYouTube.setColor("ff0000");
		dgYouTube.setTextColor("ffffff");
		gridpane.add(dgYouTube, 0, 0);
		
		DeskCrad dgTwitter = new DeskCrad("Twitter", e -> DeskWeb.openWebsite("https://www.twitter.com"));
		dgTwitter.setText("Link: twitter.com");
		dgTwitter.setColor("1da1f2");
		dgTwitter.setTextColor("ffffff");
		gridpane.add(dgTwitter, 1, 0);

		gridpane.add(new DeskCrad("Test"), 1, 1);

		gridpane.add(new DeskCrad("Test"), 2, 0);
		gridpane.add(new DeskCrad("Test"), 3, 0);
		gridpane.add(new DeskCrad("Test"), 4, 0);
		gridpane.add(new DeskCrad("Test"), 5, 0);
		
		addMenuItem("Dashboard", e -> Main.getStage().setScene(Main.dashboard.getScene()));
		addMenuItem("Notes", e -> Main.getStage().setScene(Main.notes.getScene()));
		addMenuItem("Tools", e -> Main.getStage().setScene(Main.tools.getScene()));
		addMenuItem("Project", e -> {});
		
		getScene().getStylesheets().add(Resource.getStyleSheet("style.css"));
		
	}

}
