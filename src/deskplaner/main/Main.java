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
		
		Program.setName("DeskPlaner");
		Program.setVersion(0.1);
		Program.setAuthor("André Sommer");
		Program.setStylePath("/deskplaner/res/style.css");
		
		Dashboard dashboard = new Dashboard();
		
		Program.configurateStage(stage);
		
		Main.stage.setScene(dashboard.getScene());
		Main.stage.show();
		
	}

	public static Stage getStage() {
		return stage;
	}

}
