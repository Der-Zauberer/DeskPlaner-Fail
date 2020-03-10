package deskplaner.gui;

import java.util.ArrayList;
import deskplaner.main.DeskPlaner;
import deskplaner.util.Tool;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Navigation {
	
	private static VBox vbox = new VBox();
	private static ArrayList<Button> buttons = new ArrayList<>();
	
	/**
	 * Return the VBox of the navigation menu.<br><br>
	 * <i>Gibt die VBox der Navigationsleiste zurück.</i>
	 * 
	 * @author André Sommer
	 * @return The VBox of the Navigation menu<br><i>Die VBox der Navigationsleiste</i>
	 */
	public static VBox getVbox() {
		vbox.setMinWidth(250);
		vbox.getStyleClass().add("navigation");
		Label label = new Label("DeskPlaner");
		vbox.getChildren().add(label);
		for(Tool tool : DeskPlaner.getRegistredTools()) {
			createButton(tool.getName());
		}
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
	
	private static void createButton(String name) {
		Button button = new Button(name);
		button.setAlignment(Pos.CENTER_LEFT);
		button.setTranslateX(20);
		buttons.add(button);
		vbox.getChildren().add(button);
	}

}