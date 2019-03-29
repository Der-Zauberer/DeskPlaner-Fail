package deskplaner.main;

import deskplaner.gui.Dashboard;
import deskplaner.gui.Notes;
import deskplaner.gui.Tools;
import deskplaner.prototypes.Editor;
import deskplaner.util.Program;
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

		Program.setName("DeskPlaner");
		Program.setVersion(0.1);
		Program.setAuthor("André Sommer");
		Program.setStylePath("/deskplaner/res/style.css");

		dashboard = new Dashboard();
		notes = new Notes();
		tools = new Tools();
		
		new Editor();

		Program.configurateStage(stage);
		
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
