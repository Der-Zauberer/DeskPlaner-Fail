package deskplaner.util;

import deskplaner.main.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class GUILayout {

	private StackPane stackpane;
	private static Scene scene;
	private StackPane menu, content;

	private static int countMenuItems = 0;
	private static int countMenuBottomItems = 0;

	/**
	 * Create a scene and two stackpanes with menu and content area.
	 */
	public GUILayout() {

		stackpane = new StackPane();
		scene = new Scene(stackpane);

		menu = new StackPane();
		menu.setAlignment(Pos.TOP_LEFT);
		menu.setId("menu");
		content = new StackPane();
		content.setAlignment(Pos.TOP_LEFT);
		content.setId("content");

		menu.setPrefWidth(250);
		menu.setPrefHeight(1080);
		content.setTranslateX(250);
		content.setPrefWidth(1670);
		content.setPrefHeight(1080);

		Label lbTitle = new Label(Program.getName());
		lbTitle.setTranslateX(40);
		lbTitle.setTranslateY(40);
		lbTitle.setStyle("-fx-font-size: 30px; -fx-text-fill: #ffffff;");
		menu.getChildren().add(lbTitle);

		stackpane.setAlignment(Pos.TOP_LEFT);
		stackpane.getChildren().addAll(menu, content);

	}

	/**
	 * Set the title of the content area.
	 * 
	 * @param title Set the title of the content area.
	 */
	public void setTitle(String title) {
		Label label = new Label(title);
		label.setTranslateX(0);
		label.setTranslateY(0);
		label.setStyle("-fx-font-size: 40px;");
		content.getChildren().add(label);
	}

	/**
	 * Set a menu entry on the side of the scene.
	 * 
	 * @param title Set the title of the menu entry.
	 * @param event Set the event, which is called on click the button.
	 */
	public void addMenuItem(String title, EventHandler<ActionEvent> event) {
		Button button = new Button(title);
		button.setPrefHeight(40);
		button.setPrefWidth(250);
		button.setAlignment(Pos.CENTER_LEFT);
		button.setTranslateY(120 + countMenuItems * 40);
		button.setOnAction(event);
		button.setId("menuitem");
		menu.getChildren().add(button);
		countMenuItems++;
	}

	/**
	 * Set a menu entry on the side of the scene.
	 * 
	 * @param title  Set the title of the menu entry.
	 * @param event  Set the event, which is called on click the button.
	 * @param bottom Set the menu entry to the bottom of the menu.
	 */
	public void addMenuItem(String title, EventHandler<ActionEvent> event, boolean bottom) {
		Button button = new Button(title);
		button.setPrefHeight(40);
		button.setPrefWidth(250);
		button.setAlignment(Pos.CENTER_LEFT);
		button.setTranslateY(120 + countMenuItems * 40);
		button.setOnAction(event);
		button.setId("menuitem");
		if (bottom) {
			button.setTranslateY(935 - countMenuBottomItems * 40);
			countMenuBottomItems++;
			countMenuItems--;
			int itemnumber = countMenuBottomItems;
			Main.getStage().heightProperty().addListener((obs, oldVal, newVal) -> {
				button.setTranslateY((Main.getStage().getHeight() - 80) - itemnumber * 40);
			});
		}
		menu.getChildren().add(button);
		countMenuItems++;
	}

	/**
	 * Returns the stackpane of the menu.
	 * 
	 * @return The stackpane of the menu.
	 */
	public StackPane getMenu() {
		return menu;
	}

	/**
	 * Returns the stackpane of the content area.
	 * 
	 * @return The stackpane of the content area.
	 */
	public StackPane getContent() {
		return content;
	}

	/**
	 * Returns the scene.
	 * 
	 * @return Returns the scene.
	 */
	public static Scene getScene() {
		return scene;
	}

}
