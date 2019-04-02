package deskplaner.notes;

import deskplaner.main.Main;
import deskplaner.res.Resource;
import deskplaner.util.DeskLayout;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class Notes extends DeskLayout{

	private FlowPane flowpane;
	
	public Notes() {
		
		super("Notes");
		
		flowpane = new FlowPane();
		flowpane.setHgap(50);
		flowpane.setVgap(50);
		getContent().getChildren().add(flowpane);
		
		Button btAdd = new Button("+ Add");
		btAdd.setOnAction(e -> addNoteCard());
		
		VBox vbox = new VBox();
		vbox.getChildren().add(btAdd);
		getContent().getChildren().add(vbox);
		
		addMenuItem("Dashboard", e -> Main.getStage().setScene(Main.dashboard.getScene()));
		addMenuItem("Notes", e -> Main.getStage().setScene(Main.notes.getScene()));
		addMenuItem("Tools", e -> Main.getStage().setScene(Main.tools.getScene()));
		addMenuItem("Project", e -> {});
		
		getScene().getStylesheets().add(Resource.getStyleSheet("style.css"));
		
	}
	
	public void addNoteCard() {
		NotesCard notescard = new NotesCard();
		flowpane.getChildren().add(notescard);
		flowpane.setPadding(new Insets(0, 0, 50, 0));
	}

}
