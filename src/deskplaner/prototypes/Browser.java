package deskplaner.prototypes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Browser extends Stage{

	public Browser() {
		VBox vbox = new VBox();
		Scene scene = new Scene(vbox);
		
		Button btOpen = new Button("Open");
		TextField textfield = new TextField();
		
		ToolBar toolbar = new ToolBar();
		toolbar.getItems().addAll(textfield, btOpen);
		vbox.getChildren().add(toolbar);
		
		WebView webview = new WebView();
		WebEngine webengine = webview.getEngine();
		vbox.getChildren().add(webview);
		
		btOpen.setOnAction(e -> {
			webengine.load(textfield.getText());
		});
		
		this.setScene(scene);
		this.show();
		
	}

}
