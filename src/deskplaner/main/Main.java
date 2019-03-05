package deskplaner.main;

import deskplaner.gui.Dashboard;
import deskplaner.util.Program;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
	
	private static Stage stage;

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {

		Main.stage = stage;
		
		System.setProperty("prism.lcdtext", "false");
		
		Program.setName("DeskPlaner");
		Program.setVersion(0.1);
		Program.setAuthor("André Sommer");
		Program.setStylePath("/deskplaner/res/style.css");
		
		new Dashboard();
		
		Program.configurateStage(stage);
		
		Main.stage.setScene(Dashboard.getScene());
		Main.stage.show();
		
	}

	public static Stage getStage() {
		return stage;
	}
	
	public void exit() {
		System.exit(0);
	}

}
