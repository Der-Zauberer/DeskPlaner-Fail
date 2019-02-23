package deskplaner.gui;

import deskplaner.util.Console;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class Dashboard {

	private static StackPane stackpane;
	private static Scene scene;
	
	public Dashboard() {
		stackpane = new StackPane();
		scene = new Scene(stackpane);
		
		Button button = new Button("Button");
		button.setOnAction(e -> new Console());
		stackpane.getChildren().add(button);
		
	}

	public static StackPane getStackpane() {
		return stackpane;
	}

	public static void setStackpane(StackPane stackpane) {
		Dashboard.stackpane = stackpane;
	}

	public static Scene getScene() {
		return scene;
	}

	public static void setScene(Scene scene) {
		Dashboard.scene = scene;
	}

}
