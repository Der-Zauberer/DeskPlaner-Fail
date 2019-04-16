package deskplaner.tab.notes;

import deskplaner.main.Main;
import deskplaner.util.DeskTab;
import javafx.geometry.Insets;
import javafx.scene.layout.FlowPane;

public class Notes extends DeskTab{

	private FlowPane flowpane;
	
	public Notes() {
		
		super("Notes");
		
		flowpane = new FlowPane();
		flowpane.setHgap(50);
		flowpane.setVgap(50);
		getContent().getChildren().add(flowpane);
		
		addHeaderItem("+ Add", e -> addNoteCard());
		
		addNavigationItem("Dashboard", e -> Main.getStage().setScene(Main.dashboard.getScene()));
		addNavigationItem("Notes", e -> Main.getStage().setScene(Main.notes.getScene()));
		addNavigationItem("Tools", e -> Main.getStage().setScene(Main.tools.getScene()));
		addNavigationItem("Projects", e -> {});		
	}
	
	public void addNoteCard() {
		NotesCard notescard = new NotesCard();
		flowpane.getChildren().add(notescard);
		flowpane.setPadding(new Insets(0, 0, 50, 0));
	}

}
