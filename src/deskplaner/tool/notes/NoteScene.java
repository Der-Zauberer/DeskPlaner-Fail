package deskplaner.tool.notes;

import deskplaner.gui.DeskScene;
import javafx.scene.control.Label;

public class NoteScene extends DeskScene {
	
	public NoteScene() {
		super();
		getContent().getChildren().add(new Label("Test"));
	}

}
