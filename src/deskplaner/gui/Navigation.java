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

public class Navigation extends VBox{
	
	private static ArrayList<Button> buttons = new ArrayList<>();
	
	/**
	 * Return the VBox of the navigation menu.<br><br>
	 * <i>Gibt die VBox der Navigationsleiste zurück.</i>
	 * 
	 * @author André Sommer
	 * @return The VBox of the Navigation menu<br><i>Die VBox der Navigationsleiste</i>
	 */
	public Navigation() {
		this.setMinWidth(250);
		this.getStyleClass().add("navigation");
		Label label = new Label("DeskPlaner");
		this.getChildren().add(label);
		updateButtons();
	}
	
	/**
	 * Update the buttons of the Navigation.<br><br>
	 * <i>Aktualisiert die Buttons der Navigation.</i>
	 * 
	 * @author André Sommer
	 */
	public void updateButtons() {
		for(Button button : buttons) {
			this.getChildren().remove(button);
		}
		buttons.clear();
		for(Tool tool : DeskPlaner.getRegistredTools()) {
			if(tool.hasScene()) {
				createButton(this, tool.getName(), e-> {
					DeskPlaner.getStage().setScene(tool.getMainScene());
					setActiveButton(tool.getName());
				});
			}
		}
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
	
	private static void createButton(VBox vbox, String name, EventHandler<ActionEvent> event) {
		Button button = new Button(name);
		button.setAlignment(Pos.CENTER_LEFT);
		button.setTranslateX(20);
		button.setOnAction(event);
		buttons.add(button);
		vbox.getChildren().add(button);
	}

}