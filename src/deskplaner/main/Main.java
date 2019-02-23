package deskplaner.main;

import deskplaner.gui.Dashboard;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
	
	private static Stage stage;

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {

		Main.setStage(stage);
		new Dashboard();
		Main.stage.setScene(Dashboard.getScene());
		Main.stage.setHeight(720);
		Main.stage.setWidth(1280);
		Main.stage.show();
		
	}

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		Main.stage = stage;
	}

}
