package deskplaner.notes;

import deskplaner.util.DeskDialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class NotesDialog extends DeskDialog {

	public NotesDialog(NotesCard card, Label title, Label text) {
		super("Notes", null, CloseOption.OKCANCEL);
		setHeight(300);
		
		TextField textfield = new TextField(title.getText());
		getGridPane().add(textfield, 0, 0);
		
		TextArea textarea = new TextArea(text.getText());
		getGridPane().add(textarea, 0, 1);
		
		setOnOk(e -> {
			card.setPrefHeight(text.getHeight() + 100);
			title.setText(textfield.getText());
			text.setText(textarea.getText());
			this.close();
		});
	}

}
