package deskplaner.notes;

import deskplaner.util.DeskCard;

public class NotesCard extends DeskCard{
	
	private String title = "Untitled";
	private String text = "";

	public NotesCard() {
		super();
		setTitle(title);
		setText(text);
		this.setOnMouseClicked(e -> {
			new NotesDialog(this, getTitle(), getText());
		});
	}

}
