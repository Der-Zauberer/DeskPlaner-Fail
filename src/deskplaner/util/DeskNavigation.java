package deskplaner.util;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class DeskNavigation extends VBox{
	
	private Label title;

	public DeskNavigation(String title) {
		super();
		this.setAlignment(Pos.TOP_LEFT);
		this.getStyleClass().add("navigation");
		this.setMinWidth(250);
		this.title = new Label(title);
		this.getChildren().add(this.title);
	}
	
	public void setTitle(String title) {
		this.title.setText(title);
	}
	
	public String getTitle() {
		return title.getText();
	}
	
	public Button addButton(String title) {
		Button button = new Button(title);
		button.setPrefHeight(40);
		button.setPrefWidth(250);
		button.setAlignment(Pos.CENTER_LEFT);
		this.getChildren().add(button);
		return button;
	}

}
