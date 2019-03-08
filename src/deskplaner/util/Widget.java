package deskplaner.util;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Widget extends AnchorPane{
	
	public enum WidgetType{TITLE, TITLEANDTEXT, NUMBER}
	
	private Label lbTitle;
	private Label lbText;
	private Label lbNumber;
	
	public Widget(String title) {
		super();
		this.setMinWidth(200);
		this.setMinHeight(100);
		this.setId("widget");
		lbTitle = new Label(title);
		lbTitle.setPrefWidth(150);
		lbTitle.setTranslateX(20);
		lbTitle.setStyle("-fx-font-size: 20px");
		this.getChildren().add(lbTitle);
		lbText = new Label();
		lbText.setTranslateX(20);
		this.getChildren().add(lbText);
		lbNumber = new Label();
		lbNumber.setTranslateX(20);
		this.getChildren().add(lbNumber);
		setDistances(WidgetType.TITLE);
	}
	
	public Widget(String title, EventHandler<MouseEvent> event) {
		this(title);
		this.setOnMouseClicked(event);
	}
	
	public void setText(String text) {
		lbText.setText(text);
		lbText.setVisible(true);
		setDistances(WidgetType.TITLEANDTEXT);
	}
	
	public void setColor(String hexcolor) {
		this.setStyle("-fx-background-color: #" + hexcolor);
	}
	
	public void setTextColor(String hexcolor) {
		lbTitle.setStyle("-fx-text-fill: #" + hexcolor + "; -fx-font-size: 20px;");
		lbText.setStyle("-fx-text-fill: #" + hexcolor);
	}
	
	private void setDistances(WidgetType widgettype) {
		switch (widgettype) {
		case TITLE:
			lbTitle.setTranslateY(35);
			lbTitle.setAlignment(Pos.CENTER);
			lbText.setVisible(false);
			lbNumber.setVisible(false);
			break;
		case TITLEANDTEXT:
			lbTitle.setTranslateY(15);
			lbTitle.setAlignment(Pos.TOP_LEFT);
			lbText.setVisible(true);
			lbText.setTranslateY(60);
			lbNumber.setVisible(false);
			break;
		default:
			lbTitle.setTranslateY(40);
			lbTitle.setAlignment(Pos.CENTER);
			lbText.setVisible(false);
			lbNumber.setVisible(false);
			break;
		}
	}

}
