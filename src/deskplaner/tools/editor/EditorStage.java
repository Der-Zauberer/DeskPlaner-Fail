package deskplaner.tools.editor;

import java.io.IOException;

import deskplaner.util.DeskStage;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 *	Work in progress!
 */
public class EditorStage extends DeskStage {

	public EditorStage() {
		super();

		Button btNew = new Button("New");
		Button btOpen = new Button("Open");
		Button btSave = new Button("Save");
		getToolbar().getItems().addAll(btNew, btOpen, btSave);

		TextArea textarea = new TextArea();
		textarea.setPrefHeight(getScene().getHeight());
		textarea.setId("editor");
		getParent().getChildren().add(textarea);
		
		getScene().heightProperty().addListener((obs, oldVal, newVal) -> {
			textarea.setPrefHeight(getScene().getWidth() - 100);
		});

		btNew.setOnAction(e -> textarea.setText(""));
		btOpen.setOnAction(e -> {
			try {
				Editor.open(this, textarea);
			} catch (IOException e1) {
			}
		});
		btSave.setOnAction(e -> Editor.saveFile(this, textarea));
	}

}
