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
	
	public void setTitle(String title) {
		Label label = new Label(title);
		label.setTranslateX(0);
		label.setTranslateY(0);
		label.setStyle("-fx-font-size: 40px;");
		content.getChildren().add(label);
	}
	
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
	
	public void addMenuItem(String title, EventHandler<ActionEvent> event, boolean bottom) {
		Button button = new Button(title);
		button.setPrefHeight(40);
		button.setPrefWidth(250);
		button.setAlignment(Pos.CENTER_LEFT);
		button.setTranslateY(120 + countMenuItems * 40);
		button.setOnAction(event);
		button.setId("menuitem");
		if(bottom) {
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
	
	public StackPane getMenu() {
		return menu;
	}
	
	public StackPane getContent() {
		return content;
	}
	
	public StackPane getStackpane() {
		return stackpane;
	}
	
	public static Scene getScene() {
		return scene;
	}

}
