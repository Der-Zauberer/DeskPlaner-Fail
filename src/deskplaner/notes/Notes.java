package deskplaner.notes;

import deskplaner.main.Main;
import deskplaner.res.Resource;
import deskplaner.util.DeskLayout;
import javafx.scene.layout.FlowPane;

public class Notes extends DeskLayout{

	public Notes() {
		
		super("Notes");
		
		FlowPane flowpane = new FlowPane();
		flowpane.setHgap(20);
		flowpane.setVgap(20);
		getContent().getChildren().add(flowpane);
		
		NotesCard notescard = new NotesCard();
		flowpane.getChildren().add(notescard);
		
		addMenuItem("Dashboard", e -> Main.getStage().setScene(Main.dashboard.getScene()));
		addMenuItem("Notes", e -> Main.getStage().setScene(Main.notes.getScene()));
		addMenuItem("Tools", e -> Main.getStage().setScene(Main.tools.getScene()));
		addMenuItem("Project", e -> {});
		
		getScene().getStylesheets().add(Resource.getStyleSheet("style.css"));
		
	}

}
