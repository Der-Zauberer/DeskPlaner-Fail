package deskplaner.tool.notes;

import deskplaner.gui.DeskScene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class NoteScene extends DeskScene {

	public NoteScene() {
		super();

		ToolBar toolbar = new ToolBar();
		getContent().getChildren().add(toolbar);
		toolbar.getItems().add(new Button("create"));
		toolbar.getItems().add(new Button("delete"));
		toolbar.getItems().add(new Button("edit"));

		FlowPane flowpane = new FlowPane();
		flowpane.setHgap(20);
		flowpane.setVgap(20);
		flowpane.setPadding(new Insets(50));
		flowpane.setPrefWidth(1670);
		getContent().getChildren().add(flowpane);

		for (Note note : Notes.getNotes()) {
			VBox vbox = new VBox();
			vbox.getStyleClass().add("note");
			Label notetile = new Label(note.getTitle());
			notetile.getStyleClass().add("note-title");
			vbox.getChildren().add(notetile);
			vbox.getChildren().add(new Label(note.getText()));
			flowpane.getChildren().add(vbox);
		}

	}

}