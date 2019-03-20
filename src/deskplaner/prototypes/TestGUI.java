package deskplaner.prototypes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestGUI extends Stage{
	
	public TestGUI() {
		super();
		
		HBox parent = new HBox();
		Scene scene = new Scene(parent);
		parent.setStyle("-fx-background-color: #ffffff");
		
		VBox menu = new VBox();
		parent.getChildren().add(menu);
		menu.setPrefWidth(250);
		menu.setStyle("-fx-background-color: #007fff");
		
		Button bt1 = new Button("Button");
		Button bt2 = new Button("Button");
		menu.getChildren().addAll(bt1, bt2);
		
		VBox content = new VBox();
		parent.getChildren().add(content);
		content.setStyle("-fx-background-color: #ffffff");
		content.getChildren().addAll(bt1, bt2);
		
		this.setScene(scene);
		this.setHeight(720);
		this.setWidth(1280);
		this.show();
		
	}

}
