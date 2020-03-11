package deskplaner.gui;

import java.util.ArrayList;
import deskplaner.main.DeskPlaner;
import deskplaner.util.Tool;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Navigation {
	
	private static VBox vbox = new VBox();
	private static ArrayList<Button> buttons = new ArrayList<>();
	
	/**
	 * The initialize function has to be called before the navigation can be used.<br><br>
	 * <i>Die Initialisierungsmethode muss vor der Benutzung der Navigation aufgerufen werden.</i>
	 * 
	 * @author André Sommer
	 */
	public static void initialize() {
		vbox.setMinWidth(250);
		vbox.getStyleClass().add("navigation");
		Label label = new Label("DeskPlaner");
		vbox.getChildren().add(label);
		for(Tool tool : DeskPlaner.getRegistredTools()) {
			System.out.println(tool.getName());
			if(tool.hasScene()) {
				System.out.println(tool.hasScene());
				createButton(tool.getName(), e-> {
					DeskPlaner.getStage().setScene(tool.getMainScene());
				});
			}
		}
	}
	
	/**
	 * Return the VBox of the navigation menu.<br><br>
	 * <i>Gibt die VBox der Navigationsleiste zurück.</i>
	 * 
	 * @author André Sommer
	 * @return The VBox of the Navigation menu<br><i>Die VBox der Navigationsleiste</i>
	 */
	public static VBox getVbox() {
		return vbox;
	}
	
	/**
	 * Set the button, which should displayed as active tab.<br><br>
	 * <i>Setzt den Button, der als aktiver Tab angezeigt werden soll.</i>
	 * 
	 * @author André Sommer
	 * @param name The name of the button<br><i>Der Name des Buttons</i>
	 */
	public static void setActiveButton(String name) {
		for(Button button : buttons) {
			if(button.getText().equals(name)) {
				button.getStyleClass().add("active");
			} else {
				button.getStyleClass().remove("active");
			}
		}
	}
	
	private static void createButton(String name, EventHandler<ActionEvent> event) {
		Button button = new Button(name);
		button.setAlignment(Pos.CENTER_LEFT);
		button.setTranslateX(20);
		button.setOnAction(event);
		buttons.add(button);
		vbox.getChildren().add(button);
	}

}