package deskplaner.gui;

import deskplaner.util.Console;
import deskplaner.util.GUILayout;
import deskplaner.util.Program;
import deskplaner.util.Web;
import javafx.scene.control.Button;

public class Dashboard extends GUILayout{
	
	public Dashboard() {
		
		Button button = new Button("Button");
		button.setTranslateY(100);
		button.setOnAction(e -> Web.openWebsite("http://www.youtube.com"));
		getContent().getChildren().add(button);
		
		setTitle("Dashboard");
		
		addMenuItem("Dashboard", e -> new Console());
		addMenuItem("Dashboard", e -> new Console());
		addMenuItem("Dashboard", e -> new Console());
		addMenuItem("Dashboard", e -> new Console());
		
		getScene().getStylesheets().add(getClass().getResource(Program.getStylePath()).toExternalForm());
		
	}

	

}
