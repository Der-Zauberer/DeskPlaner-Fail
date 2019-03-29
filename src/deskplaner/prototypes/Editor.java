package deskplaner.prototypes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Editor extends Stage{

	public Editor() {
		VBox vbox = new VBox();
		Scene scene = new Scene(vbox);
		
		Button btNew = new Button("New");
		Button btOpen = new Button("Open");
		Button btSave = new Button("Save");
		Button btSaveAs = new Button("SaveAs");
		
		ToolBar toolbar = new ToolBar();
		toolbar.getItems().addAll(btNew, btOpen, btSave, btSaveAs);
		vbox.getChildren().add(toolbar);
		
		TextArea textarea = new TextArea();
		vbox.getChildren().add(textarea);
		
		this.setScene(scene);
		this.show();
	}

}
