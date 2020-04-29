package deskplaner.tool.settings;

import java.util.ArrayList;
import deskplaner.gui.DeskScene;
import deskplaner.handler.CommandHandler;
import deskplaner.util.Command;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class SettingsScene extends DeskScene{
	
	 public SettingsScene() {
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(40));
		getContent().getChildren().add(vbox);
		createCommandSection(vbox);
		createDateSection(vbox);
		createLabelsSection(vbox);
	}
	 
	private static void createCommandSection(VBox vbox) {
		Label commandslabel = new Label("Commands");
		commandslabel.getStyleClass().add("h2");
		vbox.getChildren().add(commandslabel);
		for(Command command : CommandHandler.getCommands()) {
			VBox commandbox = new VBox();
			commandbox.setPadding(new Insets(40));
			commandbox.getStyleClass().add("box");
			commandbox.getChildren().add(new Label(command.getLabel()));
			vbox.getChildren().add(commandbox);
		}
	}
	
	private static void createDateSection(VBox vbox) {
		Label timelabel = new Label("Date and Time");
		timelabel.getStyleClass().add("h2");
		timelabel.getStyleClass().add("hheader");
		vbox.getChildren().add(timelabel);
		vbox.getChildren().add(new Label(Settings.getTime()));
	}
	
	private static void createLabelsSection(VBox vbox) {
		Label labelslabel = new Label("Labels");
		labelslabel.getStyleClass().add("h2");
		labelslabel.getStyleClass().add("hheader");
		vbox.getChildren().add(labelslabel);
		TextField labelnametexfield = new TextField("Labelname");
		TextField hexcolortexfield = new TextField("00ff00");
		Button button = new Button("Add Label"); 
		vbox.getChildren().addAll(labelnametexfield, hexcolortexfield, button);
		button.setOnAction(event -> {
			Settings.addLabel(labelnametexfield.getText(), hexcolortexfield.getText());
			ArrayList<Node> nodes = new ArrayList<>();
			for(Node node : vbox.getChildren()) {
				if(node.getStyleClass().contains("notelabel")) {
					nodes.add(node);
				}
			}
			for (Node node : nodes) {
				vbox.getChildren().remove(node);
			}
			for(String labelname : Settings.getLabels().keySet()) {
				Label label = new Label(labelname);
				label.getStyleClass().add("notelabel");
				label.setStyle("-fx-background-color: #" + Settings.getLabelColor(labelname) + ";");
				vbox.getChildren().add(label);
			}
		});
		for(String labelname : Settings.getLabels().keySet()) {
			Label label = new Label(labelname);
			label.getStyleClass().add("notelabel");
			label.setStyle("-fx-background-color: #" + Settings.getLabelColor(labelname) + ";");
			vbox.getChildren().add(label);
		}
	}

}
