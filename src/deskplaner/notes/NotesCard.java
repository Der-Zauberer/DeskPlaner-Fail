package deskplaner.notes;

import deskplaner.util.DeskCard;
import deskplaner.util.DeskDialog;
import deskplaner.util.DeskDialog.CloseOption;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class NotesCard extends DeskCard{

	public NotesCard() {
		super();
		setTitle("Untitled");
		setText("");
		this.setOnMouseClicked(e -> showDialog());
	}
	
	private void showDialog() {
		DeskDialog dialog = new DeskDialog("Note", null, CloseOption.OKCANCEL);
		
		dialog.setHeight(300);
		
		TextField textfield = new TextField(this.getTitle().getText());
		dialog.getGridPane().add(textfield, 0, 0);
		
		TextArea textarea = new TextArea(this.getText().getText());
		dialog.getGridPane().add(textarea, 0, 1);
		
		dialog.setOnOk(e -> {
			this.setPrefHeight(getText().getHeight() + 110);
			setText(textfield.getText());
			setText(textarea.getText());
			dialog.close();
		});
	}

}
