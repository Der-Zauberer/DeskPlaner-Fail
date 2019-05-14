package deskplaner.util;

import deskplaner.res.Resource;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class DeskScene {

	private HBox hbox;
	private Scene scene;
	private VBox content;
	
	DeskNavigation navigation;

	private Label lbTitle;
	private ToolBar header;
	private HBox placeholder;

	/**
	 * Create a scene and two vboxes with menu and content area.
	 */
	public DeskScene() {
		hbox = new HBox();
		scene = new Scene(hbox);
		
		navigation = new DeskNavigation("DeskPlaner");
		
		content = new VBox();
		content.setAlignment(Pos.TOP_LEFT);
		content.getStyleClass().add("content");
		content.setStyle("-fx-padding: 50px 70px");

		placeholder = new HBox();
		HBox.setHgrow(placeholder, Priority.ALWAYS);

		lbTitle = new Label();
		lbTitle.setText("Default");
		lbTitle.setStyle("-fx-font-size: 40px;");
		lbTitle.setAlignment(Pos.TOP_LEFT);

		header = new ToolBar();
		header.getStyleClass().add("header");
		header.setPadding(new Insets(0, 0, 50, 0));
		header.setBackground(Background.EMPTY);
		header.getItems().addAll(lbTitle, placeholder);

		hbox.setAlignment(Pos.TOP_LEFT);
		hbox.getChildren().addAll(navigation, content);

		scene.widthProperty().addListener((obs, oldVal, newVal) -> {
			content.setPrefWidth(scene.getWidth() - 250);
		});

		scene.getStylesheets().add(Resource.getStyleSheet("style.css"));
	}

	/**
	 * Create a scene and two stackpanes with menu and content area.
	 */
	public DeskScene(String title) {
		this();
		lbTitle.setText(title);
		content.getChildren().add(header);
	}

	/**
	 * Set the title of the content area.
	 * 
	 * @param title Set the title of the content area.
	 */
	public void setTitle(String title) {
		lbTitle.setText(title);
		if(content.getChildren().contains(content)) {
			lbTitle.setText(title);
		} else {
			lbTitle.setText(title);
			content.getChildren().add(header);
		}
	}

	/**
	 * Set a menu entry on the side of the scene.
	 * 
	 * @param title Set the title of the menu entry.
	 * @param event Set the event, which is called on click the button.
	 */
	public void addNavigationItem(String title, EventHandler<ActionEvent> event) {
		Button button = navigation.addButton(title);
		button.setOnAction(event);
	}

	public void addHeaderItem(String title, EventHandler<ActionEvent> event) {
		Button button = new Button(title);
		button.setOnAction(event);
		header.getItems().add(button);
	}

	/**
	 * Returns the stackpane of the menu.
	 * 
	 * @return The stackpane of the menu.
	 */
	public VBox getNavigation() {
		return navigation;
	}
	
	public void addNavigation(VBox navigation) {
		hbox.getChildren().clear();
		hbox.getChildren().addAll(navigation, content);
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