package deskplaner.main;

import java.net.URLDecoder;

import deskplaner.gui.Dashboard;
import deskplaner.gui.Notes;
import deskplaner.gui.Tools;
import javafx.application.Application;
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

		dashboard = new Dashboard();
		notes = new Notes();
		tools = new Tools();

		stage.setTitle("DeskPlaner");
		stage.setHeight(720);
		stage.setWidth(1280);
		stage.setMinHeight(720);
		stage.setMinWidth(1280);
		stage.setMaximized(true);
		
		Main.stage.setScene(dashboard.getScene());
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
