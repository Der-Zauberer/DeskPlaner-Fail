package deskplaner.tools;

import deskplaner.main.Main;
import deskplaner.prototypes.Browser;
import deskplaner.prototypes.Editor;
import deskplaner.res.Resource;
import deskplaner.util.Console;
import deskplaner.util.DeskLayout;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Tools extends DeskLayout {
	
	private static int numberOfTools = 1;
	private static GridPane gridpane;

	public Tools() {
		super("Tools");
		
		addMenuItem("Dashboard", e -> Main.getStage().setScene(Main.dashboard.getScene()));
		addMenuItem("Notes", e -> Main.getStage().setScene(Main.notes.getScene()));
		addMenuItem("Tools", e -> Main.getStage().setScene(Main.tools.getScene()));
		addMenuItem("Project", e -> {});
		
		gridpane = new GridPane();
		gridpane.setId("list");
		gridpane.setHgap(50);
		gridpane.setVgap(30);
		getContent().getChildren().add(gridpane);
		gridpane.setPadding(new Insets(10));
		
		gridpane.add(new Label("Title"), 0, 0);
		gridpane.add(new Label("Version"), 1, 0);
		gridpane.add(new Label("Author"), 2, 0);
		gridpane.add(new Label("Type"), 3, 0);
		gridpane.add(new Label("Open"), 4, 0);
		
		addToolEntry("Console", 0.1, "André Sommer", "Utilities", e -> new Console());
		addToolEntry("Editor", 0.1, "André Sommer", "Prototypes", e -> new Editor());
		addToolEntry("Browser", 0.1, "André Sommer", "Prototypes", e -> new Browser());
		
		getScene().getStylesheets().add(Resource.getStyleSheet("style.css"));
		
	}
	
	private void addToolEntry(String name, double version, String author, String type, EventHandler<ActionEvent> event) {
		gridpane.add(new Label(name), 0, numberOfTools);
		gridpane.add(new Label(version + ""), 1, numberOfTools);
		gridpane.add(new Label(author), 2, numberOfTools);
		gridpane.add(new Label(type), 3, numberOfTools);
		Button button = new Button("Open");
		button.setOnAction(event);
		gridpane.add(button, 4, numberOfTools);
		numberOfTools++;
	}

}
