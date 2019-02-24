package deskplaner.util;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class GUILayout {
	
	private StackPane stackpane;
	private Scene scene;
	private StackPane menu, content;

	public GUILayout() {
		
		stackpane = new StackPane();
		scene = new Scene(stackpane);
		
		menu = new StackPane();
		menu.setAlignment(Pos.TOP_LEFT);
		content = new StackPane();
		content.setAlignment(Pos.TOP_LEFT);
		
		menu.setPrefWidth(250);
		menu.setPrefHeight(1080);
		content.setTranslateX(250);
		content.setPrefWidth(1670);
		content.setPrefHeight(1080);
		
		stackpane.setAlignment(Pos.TOP_LEFT);
		stackpane.getChildren().addAll(menu, content);
		
	}
	
	public StackPane getMenu() {
		return menu;
	}
	
	public StackPane getContent() {
		return content;
	}
	
	public StackPane getStackpane() {
		return stackpane;
	}
	
	public Scene getScene() {
		return scene;
	}

}
