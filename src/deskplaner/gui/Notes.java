package deskplaner.gui;

import deskplaner.main.Main;
import deskplaner.util.GUILayout;
import deskplaner.util.Program;
import javafx.scene.control.Button;

public class Notes extends GUILayout{

	public Notes() {
		
		super("Notes");
		
		Button button = new Button("Button");
		button.setTranslateY(100);
		button.setOnAction(e -> {});
		getContent().getChildren().add(button);
		
		addMenuItem("Dashboard", e -> Main.getStage().setScene(Main.dashboard.getScene()));
		addMenuItem("Tasks", e -> Main.getStage().setScene(Main.notes.getScene()));
		addMenuItem("Tools", e -> Main.getStage().setScene(Main.tools.getScene()));
		addMenuItem("Project", e -> {});
		
		getScene().getStylesheets().add(getClass().getResource(Program.getStylePath()).toExternalForm());
		
	}

}
