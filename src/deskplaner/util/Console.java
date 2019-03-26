package deskplaner.util;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Console extends Stage {

	public Console() {
		super();
		
		VBox vbox = new VBox();
		vbox.setMinHeight(this.getHeight() - 100);
		vbox.setStyle("-fx-background-color: black");
		
		ScrollPane scrollpane = new ScrollPane();
		scrollpane.setContent(vbox);
		scrollpane.setHbarPolicy(ScrollBarPolicy.NEVER);
		scrollpane.setStyle("-fx-background-color: black");
		
		Scene scene = new Scene(scrollpane);

		this.setHeight(480);
		this.setWidth(640);

		Label label = new Label("Console");
		label.setStyle("-fx-font-family: consolas; -fx-font-size: 14; -fx-text-fill: white;");
		vbox.getChildren().add(label);

		TextField textfield = new TextField();
		textfield.setPrefHeight(25);
		vbox.getChildren().add(textfield);
		textfield.setPrefWidth(this.getWidth() - 20);
		textfield.setStyle("-fx-font-family: consolas; -fx-font-size: 14; -fx-text-fill: white; -fx-padding: 0; -fx-background-color: black");

		textfield.setOnAction(e -> {
			if (textfield.getText().equals("")) {
			} else {
				label.setText(label.getText() + "\n" + textfield.getText());
				textfield.setText("");
				scrollpane.setVvalue(1);
			}
		});

		vbox.setAlignment(Pos.TOP_LEFT);

		this.setScene(scene);
		this.show();

	}

}
