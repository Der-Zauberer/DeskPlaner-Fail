package deskplaner.util;

import deskplaner.res.Resource;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class DeskDialog extends Stage{

	public enum MessageType{DEFAULT, INFO, SUCCESS, WARNING, ERROR}
	public enum CloseOption{OK, OKCANCEL, YESNO, YESNOCANCEL}
	
	private GridPane gridpane;
	private ToolBar toolbar;
	private Label lbMessage;
	private Button btYes, btNo, btCancel;
	private HBox placeholder;
	
	/**
	 * Create a dialog with message and buttons.
	 * 
	 * @param name Set the title of the window
	 * @param message Set the message of the dialog 
	 * @param closeoption Set the the buttons of the dialog
	 */
	public DeskDialog(String name, String message, CloseOption closeoption) {
		super();
		
		lbMessage = new Label(message);
		
		gridpane = new GridPane();
		gridpane.setPadding(new Insets(40));
		gridpane.setHgap(20);
		gridpane.setVgap(20);
		gridpane.getChildren().add(lbMessage);
		
		placeholder = new HBox();
		HBox.setHgrow(placeholder, Priority.ALWAYS);
		
		toolbar = new ToolBar();
		
		VBox root = new VBox();
		root.getStyleClass().add("dialog");
		root.getChildren().addAll(gridpane, toolbar);
		
		btYes = new Button("Yes");
		btNo = new Button("No");
		btCancel = new Button("Cancel");
		
		switch (closeoption) {
		case OK:
			btYes.setText("Ok");
			toolbar.getItems().addAll(placeholder, btYes);
			break;
		case OKCANCEL:
			btYes.setText("Ok");
			toolbar.getItems().addAll(btCancel, placeholder, btYes);
			break;
		case YESNO:
			toolbar.getItems().addAll(btNo, placeholder, btYes);
			break;
		case YESNOCANCEL:
			toolbar.getItems().addAll(btCancel, placeholder,btNo, btYes);
			break;
		default:
			break;
		}
		
		btYes.setOnAction(e -> this.close());
		btNo.setOnAction(e -> this.close());
		btCancel.setOnAction(e -> this.close());
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(Resource.getStyleSheet("style.css"));
		
		this.setScene(scene);
		this.setTitle(name);
		this.setHeight(165);
		this.setWidth(400);
		this.setResizable(false);
		this.show();
	}
	
	/**
	 * Get the GridPane of the dialog.
	 * 
	 * @return The GridPaneof the dialog
	 */
	public GridPane getGridPane() {
		return gridpane;
	}
	
	/**
	 * Set the action on button click.
	 * 
	 * @param event The event which is called by clicking the Button
	 */
	public void setOnOk(EventHandler<ActionEvent> event) {
		btYes.setOnAction(event);
	}
	
	/**
	 * Set the action on button click.
	 * 
	 * @param event The event which is called by clicking the Button
	 */
	public void setOnYes(EventHandler<ActionEvent> event) {
		btYes.setOnAction(event);
	}

	/**
	 * Set the action on button click.
	 * 
	 * @param event The event which is called by clicking the Button
	 */
	public void setOnNo(EventHandler<ActionEvent> event) {
		btNo.setOnAction(event);
	}
	
	/**
	 * Set the action on button click.
	 * 
	 * @param event The event which is called by clicking the Button
	 */
	public void setOnCancel(EventHandler<ActionEvent> event, EventHandler<WindowEvent> windowevent) {
		btCancel.setOnAction(event);
		this.setOnCloseRequest(windowevent);
	}
	
}
