package deskplaner.gui;

import deskplaner.main.DeskPlaner;
import deskplaner.resources.Resource;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DeskScene {
	
	private Scene scene;
	private VBox content;
	private HBox root;
	/**
	 * Create a scene with navigation and content area.<br><br>
	 * <i>Erstellt eine neue Scene mit Navigation und Bereich für den Inhalt.</i>
	 * 
	 * @author André Sommer
	 */
	public DeskScene() {
		root = new HBox();
		scene = new Scene(root);
		root.getChildren().add(Navigation.getVbox());
		content = new VBox();
		root.getChildren().add(content);
		scene.getStylesheets().add(Resource.getStyleSheet("style.css"));
	}
	/**
	 * Add the navigation-VBox to the root HBox.<br><br>
	 * <i>Fügt die Navigations-VBox zu der root HBox hinzu.</i>
	 * 
	 * @author Pau Leppich
	 */
	public void linkNavigationAgain() {
		root.getChildren().add(0, Navigation.getVbox());
		double rootWidth = DeskPlaner.getStage().getWidth()-Navigation.getVbox().getWidth();
		content.setMaxWidth(rootWidth);
		content.setMinWidth(rootWidth);
		content.setMinHeight(DeskPlaner.getStage().getHeight());
	}
	
	public VBox getContent() {
		return content;
	}
	
	public Scene getScene() {
		return scene;
	}

}