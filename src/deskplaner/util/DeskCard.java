package deskplaner.util;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class DeskCard extends AnchorPane {

	public enum WidgetType {
		TITLE, TITLEANDTEXT, NUMBER
	}

	private Label lbTitle;
	private Label lbText;
	private Label lbNumber;

	/**
	 * Set a new card.
	 */
	public DeskCard() {
		super();
		this.setMinWidth(200);
		this.setMinHeight(100);
		this.getStyleClass().add("card");
		lbTitle = new Label();
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

	/**
	 * Set a new card with title.
	 * 
	 * @param title Set the title of the card
	 */
	public DeskCard(String title) {
		this();
		lbTitle.setText(title);
	}

	/**
	 * Set a new card with title.
	 * 
	 * @param title Set the title of the card
	 * @param event Set the action on clicked
	 */
	public DeskCard(String title, EventHandler<MouseEvent> event) {
		this(title);
		this.setOnMouseClicked(event);
	}

	/**
	 * Set the title of the card.
	 * 
	 * @param title Set the title of the card
	 */
	public void setTitle(String title) {
		lbTitle.setText(title);
	}

	/**
	 * Returns the label of the title.
	 * 
	 * @return The label of the title.
	 */
	public Label getTitle() {
		return lbTitle;
	}

	/**
	 * Set the text of the card.
	 * 
	 * @param text Set the text of the card
	 */
	public void setText(String text) {
		lbText.setText(text);
		lbText.setVisible(true);
		setDistances(WidgetType.TITLEANDTEXT);
	}

	/**
	 * Returns the label of the text.
	 * 
	 * @return The label of the text.
	 */
	public Label getText() {
		return lbText;
	}

	/**
	 * Set the backgroundcolor of the Card
	 * 
	 * @param hexcolor Set the color as hexadecimal
	 */
	public void setColor(String hexcolor) {
		this.setStyle("-fx-background-color: #" + hexcolor);
	}

	/**
	 * Set the font color of the Card
	 * 
	 * @param hexcolor Set the color as hexadecimal
	 */
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