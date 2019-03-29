package deskplaner.prototypes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import deskplaner.main.Main;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Editor extends Stage {

	public Editor() {
		VBox vbox = new VBox();
		Scene scene = new Scene(vbox);

		Button btNew = new Button("New");
		Button btOpen = new Button("Open");
		Button btSave = new Button("Save");

		ToolBar toolbar = new ToolBar();
		toolbar.getItems().addAll(btNew, btOpen, btSave);
		vbox.getChildren().add(toolbar);

		TextArea textarea = new TextArea();
		vbox.getChildren().add(textarea);
		
		btNew.setOnAction(e -> textarea.setText(""));
		btOpen.setOnAction(e -> {
			try {
				open(Main.getStage(), textarea);
			} catch (IOException e1) {
			}
		});
		btSave.setOnAction(e -> saveFile(Main.getStage(), textarea));

		this.setScene(scene);
		this.show();
	}

	public void saveFile(Stage primaryStage, TextArea text) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save File");
		fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt"));
		fileChooser.setInitialFileName("file.txt");
		File file = fileChooser.showSaveDialog(primaryStage);

		if (file != null) {
			try {
				FileWriter fileWriter = null;
				fileWriter = new FileWriter(file);
				fileWriter.write(text.getText());
				fileWriter.close();
			} catch (IOException ex) {

			}
		}
	};

	public void open(Stage primaryStage, TextArea text) throws IOException {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("open File");
		fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt"));
		fileChooser.setInitialFileName("file.txt");
		File file = fileChooser.showOpenDialog(primaryStage);

		if (file != null) {
			InputStream in = new FileInputStream(file);
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			StringBuilder out = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				out.append(line + "\n");
			}
			text.setText(out.toString());
			reader.close();
		}
	};

}
