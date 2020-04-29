package deskplaner.tool.settings;

import deskplaner.gui.DeskScene;
import deskplaner.handler.CommandHandler;
import deskplaner.util.Command;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SettingsScene extends DeskScene{
	
	 public SettingsScene() {
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(40));
		Label commandslabel = new Label("Commands");
		commandslabel.getStyleClass().add("h2");
		vbox.getChildren().add(commandslabel);
		getContent().getChildren().add(vbox);
		for(Command command : CommandHandler.getCommands()) {
			VBox commandbox = new VBox();
			commandbox.setPadding(new Insets(40));
			commandbox.getStyleClass().add("box");
			commandbox.getChildren().add(new Label(command.getLabel()));
			vbox.getChildren().add(commandbox);
		}
		Label timelabel = new Label("Date and Time");
		timelabel.getStyleClass().add("h2");
		timelabel.getStyleClass().add("hheader");
		vbox.getChildren().add(timelabel);
		vbox.getChildren().add(new Label(Settings.getTime()));
	} 

}
