package deskplaner.gui;

import deskplaner.resources.Resource;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DeskScene {
	
	private Scene scene;
	private VBox content;
	private Navigation navigation;
	
	/**
	 * Create a scene with navigation and content area.<br><br>
	 * <i>Erstellt eine neue Scene mit Navigation und Bereich für den Inhalt.</i>
	 * 
	 * @author André Sommer
	 */
	public DeskScene() {
		HBox root = new HBox();
		scene = new Scene(root);
		navigation = new Navigation();
		root.getChildren().add(navigation);
		content = new VBox();
		root.getChildren().add(content);
		scene.getStylesheets().add(Resource.getStyleSheet("style.css"));
	}
	
	public VBox getContent() {
		return content;
	}
	
	public Scene getScene() {
		navigation.updateButtons();
		return scene;
	}

}