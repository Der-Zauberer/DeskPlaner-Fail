package deskplaner.util;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DeskLayout {

	private HBox hbox;
	private Scene scene;
	private VBox menu;
	private VBox content;

	private Label lbContent;

	/**
	 * Create a scene and two vboxes with menu and content area.
	 */
	public DeskLayout() {
		hbox = new HBox();
		scene = new Scene(hbox);

		menu = new VBox();
		menu.setAlignment(Pos.TOP_LEFT);
		menu.setId("menu");
		menu.setMinWidth(250);
		content = new VBox();
		content.setAlignment(Pos.TOP_LEFT);
		content.setId("content");
		
		Label lbTitle = new Label("DeskPlaner");
		lbTitle.setId("menutitle");
		menu.getChildren().add(lbTitle);

		lbContent = new Label();
		lbContent.setText("Default");
		lbContent.setStyle("-fx-font-size: 40px;");
		lbContent.setMinHeight(100);
		lbContent.setAlignment(Pos.TOP_LEFT);
		content.getChildren().add(lbContent);

		hbox.setAlignment(Pos.TOP_LEFT);
		hbox.getChildren().addAll(menu, content);
	}
	
	/**
	 * Create a scene and two stackpanes with menu and content area.
	 */
	public DeskLayout(String title) {
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
		button.setId("menuitem");
		button.setPrefHeight(40);
		button.setPrefWidth(250);
		button.setAlignment(Pos.CENTER_LEFT);
		button.setOnAction(event);
		menu.getChildren().add(button);
	}

	/**
	 * Returns the stackpane of the menu.
	 * 
	 * @return The stackpane of the menu.
	 */
	public VBox getMenu() {
		return menu;
	}

	/**
	 * Returns the stackpane of the content area.
	 * 
	 * @return The stackpane of the content area.
	 */
	public VBox getContent() {
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
