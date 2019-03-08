package deskplaner.gui;

import deskplaner.main.Main;
import deskplaner.util.GUILayout;
import deskplaner.util.Program;
import javafx.scene.control.Button;

public class Dashboard extends GUILayout{
	
	public Dashboard() {
		
		Button button = new Button("Button");
		button.setTranslateY(100);
		button.setOnAction(e -> {});
		getContent().getChildren().add(button);
		
		setTitle("Dashboard");
		
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
