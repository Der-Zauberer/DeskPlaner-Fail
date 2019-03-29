package deskplaner.gui;

import deskplaner.main.Main;
import deskplaner.res.Resource;
import deskplaner.util.DeskLayout;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Tools extends DeskLayout {

	public Tools() {
		super("Tools");
		
		addMenuItem("Dashboard", e -> Main.getStage().setScene(Main.dashboard.getScene()));
		addMenuItem("Notes", e -> Main.getStage().setScene(Main.notes.getScene()));
		addMenuItem("Tools", e -> Main.getStage().setScene(Main.tools.getScene()));
		addMenuItem("Project", e -> {});
		
		GridPane gridpane = new GridPane();
		gridpane.setId("list");
		gridpane.setHgap(40);
		gridpane.setVgap(20);
		getContent().getChildren().add(gridpane);
		gridpane.setPadding(new Insets(10));
		
		gridpane.add(new Label("Title"), 0, 1);
		gridpane.add(new Label("Version"), 1, 1);
		gridpane.add(new Label("Author"), 2, 1);
		gridpane.add(new Label("Open"), 3, 1);
		
		gridpane.add(new Label("Console"), 0, 2);
		gridpane.add(new Label("0.1"), 1, 2);
		gridpane.add(new Label("DeskPlaner"), 2, 2);
		gridpane.add(new Button("Open"), 3, 2);
		
		gridpane.add(new Label("Music"), 0, 3);
		gridpane.add(new Label("0.1"), 1, 3);
		gridpane.add(new Label("DeskPlaner"), 2, 3);
		gridpane.add(new Button("Open"), 3, 3);
		
		getScene().getStylesheets().add(Resource.getStyleSheet("style.css"));
		
	}

}
