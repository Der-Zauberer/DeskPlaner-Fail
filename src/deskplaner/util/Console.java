package deskplaner.util;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Console {

	public Console() {

		StackPane root = new StackPane();
		Scene scene = new Scene(root);
		Stage stage = new Stage();

		stage.setHeight(480);
		stage.setWidth(640);

		StackPane stackpane = new StackPane();
		stackpane.setMinHeight(stage.getHeight() - 100);
		stackpane.setStyle("-fx-background-color: black");

		ScrollPane scrollpane = new ScrollPane();
		scrollpane.setContent(stackpane);
		scrollpane.setHbarPolicy(ScrollBarPolicy.NEVER);
		scrollpane.setStyle("-fx-background-color: black");

		Label label = new Label("Console");
		label.setStyle("-fx-font-family: consolas; -fx-font-size: 14; -fx-text-fill: white;");

		TextField textfield = new TextField();
		textfield.setPrefHeight(25);
		textfield.setTranslateY(20);
		textfield.setPrefWidth(stage.getWidth() - 20);
		textfield.setStyle("-fx-font-family: consolas; -fx-font-size: 14; -fx-text-fill: white; -fx-padding: 0; -fx-background-color: black");

		textfield.setOnAction(e -> {
			if (textfield.getText().equals("")) {
			} else {
				textfield.setTranslateY(label.getHeight() + textfield.getHeight());
				label.setText(label.getText() + "\n" + textfield.getText());
				textfield.setText("");
				stackpane.setPrefHeight(label.getHeight() + textfield.getHeight() * 3);
				scrollpane.setVvalue(1);
			}
		});

		stackpane.setAlignment(Pos.TOP_LEFT);
		stackpane.getChildren().addAll(label, textfield);

		root.setAlignment(Pos.TOP_LEFT);
		root.getChildren().addAll(scrollpane);
		root.setStyle("-fx-background-color: black");

		stage.setScene(scene);
		stage.show();

	}

}
