package deskplaner.tool.notes;

import java.util.ArrayList;
import java.util.List;

import deskplaner.gui.DeskScene;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class NoteScene extends DeskScene {
	
	private static FlowPane flowpane;

	public NoteScene() {
		super();
		Button btcreate = new Button("+");
		btcreate.setOnAction(e -> {createNote();});
		Pane pane = new Pane();
        HBox.setHgrow(pane, Priority.SOMETIMES);
		ToolBar toolbar = new ToolBar();
		TextField searchField = new TextField();
		searchField.setOnAction(searchEvent -> {searchNote(searchField.getText());});
		getContent().getChildren().add(toolbar);
		toolbar.getItems().add(pane);
		toolbar.getItems().add(searchField);
		toolbar.getItems().add(btcreate);
		flowpane = new FlowPane();
		flowpane.setHgap(20);
		flowpane.setVgap(20);
		flowpane.setPadding(new Insets(50));
		flowpane.setPrefWidth(1670);
		getContent().getChildren().add(flowpane);
		for (Note note : Notes.getNotes()) {
			VBox vbox = new VBox();
			vbox.getStyleClass().add("box");
			flowpane.getChildren().add(vbox);
			setNote(vbox, note.getTitle(), note.getText());
		}
	}
	
	private void searchNote(String text) {
		List<Node> nodelist = flowpane.getChildren();
		flowpane.getChildren().removeAll(nodelist);
		ArrayList<Note> notes;
		if(text.equalsIgnoreCase("")) {
			notes = Notes.getNotes();
		} else {
			notes = Notes.searchNote(text);
		}
		for (Note note : notes) {
			VBox vbox = new VBox();
			vbox.getStyleClass().add("box");
			flowpane.getChildren().add(vbox);
			setNote(vbox, note.getTitle(), note.getText());
		}
	}
	
	private void createNote() {
		VBox vbox = new VBox();
		vbox.getStyleClass().add("box");
		flowpane.getChildren().add(vbox);
		editNote(vbox, "Title", "Text");
	}
	
	private void editNote(VBox vbox, String title, String text) {
		vbox.getChildren().clear();
		TextField textfield = new TextField(title);
		TextArea textarea = new TextArea(text);
		Button button = new Button("Save");
		button.setOnAction(e -> {
			setNote(vbox, textfield.getText(), textarea.getText());
			if(Notes.getNote(title) != null) {
				Note note = Notes.getNote(title);
				Notes.deleteNote(note);
				note.setTitle(textfield.getText());
				note.setText(textarea.getText());
				Notes.addNote(note);
			} else {
				Notes.addNote(new Note(textfield.getText(), textarea.getText()));
			}
		});
		vbox.getChildren().addAll(textfield, textarea, button);
	}
	
	private void setNote(VBox vbox, String title, String text) {
		vbox.getChildren().clear();
		Label labeltitle = new Label(title);
		labeltitle.getStyleClass().add("h4");
		Label labeltext = new Label(text);
		Button button = new Button("Edit");
		button.setOnAction(e -> {editNote(vbox, labeltitle.getText(), labeltext.getText());});
		vbox.getChildren().addAll(labeltitle, labeltext, button);
	}
	
}