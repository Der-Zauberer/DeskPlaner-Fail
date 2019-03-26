package deskplaner.gui;

import deskplaner.main.Main;
import deskplaner.util.GUILayout;
import deskplaner.util.Program;
import deskplaner.util.Widget;
import javafx.scene.layout.FlowPane;

public class Notes extends GUILayout{

	public Notes() {
		
		super("Notes");
		
		FlowPane flowpane = new FlowPane();
		flowpane.setHgap(20);
		flowpane.setVgap(20);
		getContent().getChildren().add(flowpane);
		
		Widget note1 = new Widget("Note");
		note1.setText("Todo \n - Dashboard \n - Notes \n - Tools \n - Files");
		note1.setPrefSize(100, 180);
		flowpane.getChildren().add(note1);
		
		addMenuItem("Dashboard", e -> Main.getStage().setScene(Main.dashboard.getScene()));
		addMenuItem("Notes", e -> Main.getStage().setScene(Main.notes.getScene()));
		addMenuItem("Tools", e -> Main.getStage().setScene(Main.tools.getScene()));
		addMenuItem("Project", e -> {});
		
		getScene().getStylesheets().add(getClass().getResource(Program.getStylePath()).toExternalForm());
		
	}

}
