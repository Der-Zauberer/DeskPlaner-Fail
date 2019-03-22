package deskplaner.prototypes;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
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
		
		Label lbTitle = new Label("DeskPlaner");
		menu.getChildren().add(lbTitle);
		lbTitle.setStyle("-fx-text-fill: #ffffff; -fx-padding: 40px; -fx-font-size: 30px;"); 
		
		Button btDashboard = new Button("Dashboard");
		btDashboard.setStyle("-fx-pref-height: 40px; -fx-font-size: 16px; -fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-padding: 0px 40px;");
		Button btNotes = new Button("Notes");
		btNotes.setStyle("-fx-pref-height: 40px; -fx-font-size: 16px; -fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-padding: 0px 40px;");
		Button btTasks = new Button("Tasks");
		btTasks.setStyle("-fx-pref-height: 40px; -fx-font-size: 16px; -fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-padding: 0px 40px;");
		Button btTools = new Button("Tools");
		btTools.setStyle("-fx-pref-height: 40px; -fx-font-size: 16px; -fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-padding: 0px 40px;");
		Button btProjects = new Button("Projects");
		btProjects.setStyle("-fx-pref-height: 40px; -fx-font-size: 16px; -fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-padding: 0px 40px;");
		menu.getChildren().addAll(btDashboard, btNotes, btTasks, btTools, btProjects);
		
		VBox content = new VBox();
		parent.getChildren().add(content);
		content.setStyle("-fx-background-color: #ffffff; -fx-margin: 40px;");
		
		GridPane gpMusic = new GridPane();
		content.getChildren().add(gpMusic);
		gpMusic.setPadding(new Insets(40, 100, 40, 100));
		gpMusic.add(new Label("Depeche Mode - People Are People"), 0, 0);
		gpMusic.setStyle("-fx-background-color: ffcccc");
		GridPane.setVgrow(gpMusic, Priority.ALWAYS);
		
		HBox hbList = new HBox();
		hbList.getChildren().addAll(new Label("Depeche Mode"), new Label("People Are People"), new Label("Test"));
		content.getChildren().add(hbList);
		
		this.setScene(scene);
		this.setHeight(720);
		this.setWidth(1280);
		this.show();
		
	}

}
