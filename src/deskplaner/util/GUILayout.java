package deskplaner.util;

import deskplaner.main.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class GUILayout {

	private HBox hbox;
	private Scene scene;
	private GridPane menu;
	private GridPane content;

	private Label lbContent;

	private int countMenuItems = 0;
	private int countMenuBottomItems = 0;

	/**
	 * Create a scene and two stackpanes with menu and content area.
	 */
	public GUILayout() {
		hbox = new HBox();
		scene = new Scene(hbox);

		menu = new GridPane();
		menu.setAlignment(Pos.TOP_LEFT);
		menu.setId("menu");
		menu.setPrefWidth(250);
		content = new GridPane();
		content.setAlignment(Pos.TOP_LEFT);
		content.setId("content");
		content.setHgap(20);
		content.setVgap(20);

		Label lbTitle = new Label(Program.getName());
		lbTitle.setId("menutitle");
		menu.add(lbTitle, 0, 0);

		lbContent = new Label();
		lbContent.setText("Default");
		lbContent.setStyle("-fx-font-size: 40px;");
		content.add(lbContent, 0, 0);
		
		GridPane.setColumnSpan(lbContent, 2);

		hbox.setAlignment(Pos.TOP_LEFT);
		hbox.getChildren().addAll(menu, content);
	}
	
	public GUILayout(String title) {
		this();
		lbContent.setText(title);
	}

	/**
	 * Set the title of the content area.
	 * 
	 * @param title Set the title of the content area.
	 */
	public void setTitle(String title) {
		lbContent.setText(title);
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
		menu.add(button, 0, countMenuItems + 1);
		button.setOnAction(event);
		button.setId("menuitem");
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
				button.setTranslateY((Main.getStage().getHeight() - 120) - itemnumber * 40);
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
	public GridPane getMenu() {
		return menu;
	}

	/**
	 * Returns the stackpane of the content area.
	 * 
	 * @return The stackpane of the content area.
	 */
	public GridPane getContent() {
		return content;
	}

	/**
	 * Returns the scene.
	 * 
	 * @return Returns the scene.
	 */
	public Scene getScene() {
		return scene;
	}

}
