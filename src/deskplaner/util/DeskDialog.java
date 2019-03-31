package deskplaner.util;

import deskplaner.res.Resource;
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
		root.setId("dialog");
		root.getChildren().addAll(gridpane, toolbar);
		
		switch (closeoption) {
		case OK:
			btYes = new Button("Ok");
			toolbar.getItems().addAll(placeholder, btYes);
			break;
		case OKCANCEL:
			btYes = new Button("Ok");
			btCancel = new Button("Cancel");
			toolbar.getItems().addAll(btCancel, placeholder, btYes);
			break;
		case YESNO:
			btYes = new Button("Yes");
			btNo = new Button("No");
			toolbar.getItems().addAll(btNo, placeholder, btYes);
			break;
		case YESNOCANCEL:
			btYes = new Button("Yes");
			btNo = new Button("No");
			btCancel = new Button("Cancel");
			toolbar.getItems().addAll(btCancel, placeholder,btNo, btYes);
			break;
		default:
			break;
		}
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(Resource.getStyleSheet("style.css"));
		
		this.setScene(scene);
		this.setTitle(name);
		this.setHeight(165);
		this.setWidth(400);
		this.setResizable(false);
		this.show();
	}

}
