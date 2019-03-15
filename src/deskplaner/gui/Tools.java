package deskplaner.gui;

import deskplaner.main.Main;
import deskplaner.util.GUILayout;
import deskplaner.util.Program;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Tools extends GUILayout {

	public Tools() {
		super("Tools");
		
		addMenuItem("Dashboard", e -> Main.getStage().setScene(Main.dashboard.getScene()));
		addMenuItem("Tasks", e -> Main.getStage().setScene(Main.notes.getScene()));
		addMenuItem("Tools", e -> Main.getStage().setScene(Main.tools.getScene()));
		addMenuItem("Project", e -> {});
		addMenuItem("Quit", e -> new Main().exit(), true);
		addMenuItem("Settings", e -> {}, true);
		addMenuItem("Help", e -> {}, true);
		
		getContent().add(new Label("Title"), 0, 1);
		getContent().add(new Label("Version"), 1, 1);
		getContent().add(new Label("Author"), 2, 1);
		getContent().add(new Label("Open"), 3, 1);
		
		getContent().add(new Label("Console"), 0, 2);
		getContent().add(new Label("0.1"), 1, 2);
		getContent().add(new Label("DeskPlaner"), 2, 2);
		getContent().add(new Button("Open"), 3, 2);
		
		getScene().getStylesheets().add(getClass().getResource(Program.getStylePath()).toExternalForm());
		
	}

}
