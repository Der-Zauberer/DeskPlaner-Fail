package deskplaner.util;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class Widget extends GridPane{
	
	private Label lbTitle;
	private Label lbText;
	
	public Widget(String title) {
		super();
		this.setId("widget");
		lbTitle = new Label(title);
		lbTitle.setStyle("-fx-font-size: 20px");
		this.add(lbTitle, 0, 0);
		lbText = new Label();
		lbText.setVisible(false);
		this.add(lbText, 0, 1);
	}
	
	public Widget(String title, EventHandler<MouseEvent> event) {
		this(title);
		this.setOnMouseClicked(event);
	}
	
	public void setText(String text) {
		lbText.setText(text);
		lbText.setVisible(true);
	}
	
	public void setColor(String hexcolor) {
		this.setStyle("-fx-background-color: #" + hexcolor);
	}
	
	public void setTextColor(String hexcolor) {
		lbTitle.setStyle("-fx-text-fill: #" + hexcolor + "; -fx-font-size: 20px;");
		lbText.setStyle("-fx-text-fill: #" + hexcolor);
	}

}
