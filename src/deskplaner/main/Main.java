package deskplaner.main;

import deskplaner.tab.dashboard.Dashboard;
import deskplaner.tab.notes.Notes;
import deskplaner.tab.tools.Tools;
import deskplaner.util.DeskNavigation;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

	private static Stage stage;

	/**
	 * Start the JavaFX application.
	 * 
	 * @param args are unused
	 */
	public static void main(String[] args) {
		launch();
	}
	
	public static Dashboard dashboard;
	public static Notes notes;
	public static Tools tools;

	/**
	 * All main actions are in this method.
	 */
	@Override
	public void start(Stage stage) throws Exception {

		Main.stage = stage;

		System.setProperty("prism.lcdtext", "false");
		
		DeskNavigation navigation = new DeskNavigation("DeskPlaner");
		Button navDashboard = navigation.addButton("Dashboard");
		Button navNotes = navigation.addButton("Notes");
		Button navTools = navigation.addButton("Tools");
		
		dashboard = new Dashboard();
		dashboard.addNavigation(navigation);
		notes = new Notes();
		tools = new Tools();
	
		navDashboard.setOnAction(e -> stage.setScene(dashboard.getScene()));
		navNotes.setOnAction(e -> stage.setScene(notes.getScene()));
		navTools.setOnAction(e -> stage.setScene(tools.getScene()));

		stage.setTitle("DeskPlaner");
		stage.setHeight(720);
		stage.setWidth(1280);
		stage.setMinHeight(720);
		stage.setMinWidth(1280);
		
		Main.stage.setScene(dashboard.getScene());
		Main.stage.getIcons().add(new Image("/deskplaner/res/logo.png")); 
		Main.stage.show();

	}

	/**
	 * Returns the Stage of the application.
	 * 
	 * @return The Stage of the application.
	 */
	public static Stage getStage() {
		return stage;
	}

	/**
	 * Close all DeskPlaner systems.
	 */
	public void exit() {
		System.exit(0);
	}

}
