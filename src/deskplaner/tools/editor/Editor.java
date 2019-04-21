package deskplaner.tools.editor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

public class Editor {
	
	private static EditorStage stage;

	public Editor() {
		stage = new EditorStage();
	}

	protected static void saveFile(TextArea text) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save File");
		fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt"));
		fileChooser.setInitialFileName("file.txt");
		File file = fileChooser.showSaveDialog(stage);

		if (file != null) {
			try {
				FileWriter fileWriter = new FileWriter(file);
				fileWriter.write(text.getText());
				fileWriter.close();
			} catch (IOException ex) {

			}
		}
	}

	protected static String open(TextArea text) throws IOException {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("open File");
		fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt"));
		fileChooser.setInitialFileName("file.txt");
		File file = fileChooser.showOpenDialog(stage);

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
		return file.getName();
	}

}
