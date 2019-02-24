package deskplaner.gui;

import deskplaner.util.Console;
import deskplaner.util.GUILayout;
import deskplaner.util.Program;
import javafx.scene.control.Button;

public class Dashboard extends GUILayout{
	
	public Dashboard() {
		
		Button button = new Button("Button");
		button.setOnAction(e -> new Console());
		getContent().getChildren().add(button);
		
		//Program.setStylesheet(getScene());
		
		getScene().getStylesheets().add(getClass().getResource(Program.getStylePath()).toExternalForm());
		
	}

	

}
