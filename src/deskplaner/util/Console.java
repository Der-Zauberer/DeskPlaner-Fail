package deskplaner.util;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Console extends Stage {

	public Console() {

		StackPane root = new StackPane();
		Scene scene = new Scene(root);
		Stage stage = new Stage();

		stage.setHeight(480);
		stage.setWidth(640);

		VBox vbox = new VBox();
		vbox.setMinHeight(stage.getHeight() - 100);
		vbox.setStyle("-fx-background-color: black");

		ScrollPane scrollpane = new ScrollPane();
		scrollpane.setContent(vbox);
		scrollpane.setHbarPolicy(ScrollBarPolicy.NEVER);
		scrollpane.setStyle("-fx-background-color: black");

		Label label = new Label("Console");
		label.setStyle("-fx-font-family: consolas; -fx-font-size: 14; -fx-text-fill: white;");
		vbox.getChildren().add(label);

		TextField textfield = new TextField();
		textfield.setPrefHeight(25);
		vbox.getChildren().add(textfield);
		textfield.setPrefWidth(stage.getWidth() - 20);
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

		root.setAlignment(Pos.TOP_LEFT);
		root.getChildren().addAll(scrollpane);
		root.setStyle("-fx-background-color: black");

		stage.setScene(scene);
		stage.show();

	}

}
