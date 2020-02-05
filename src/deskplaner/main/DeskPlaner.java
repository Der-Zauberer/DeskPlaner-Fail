package deskplaner.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import deskplaner.tools.notes.Notes;
import deskplaner.util.Command;
import deskplaner.util.Tool;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DeskPlaner extends Application {
	
	private static ArrayList<Command> commands = new ArrayList<>();
	private static ArrayList<Tool> tools = new ArrayList<>();
	
	public static void main(String[] args) {
		new File(getDeskPlanerLocation().getParent(), "DeskPlaner").mkdir();
		File testfile = new File(getDeskPlanerLocation().getParent() + "\\DeskPlaner", "test.txt");
		try {
			FileWriter filewriter = new FileWriter(testfile);
			BufferedWriter writer = new BufferedWriter(filewriter);
			writer.write("Test");
			writer.close();
		} catch (IOException exception) {
		}
		
		if(args != null && args.length == 1) {
			if(args[0].equals("console")) {
				console();
			}
		}
	}
	
	private static void console() {
		System.out.println("DeskPlaner 1");
		registerTool(new Notes());
		enableTools();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String input = scanner.nextLine();
			String command[] = input.split(" ");
			String label = command[0];
			String args[] = Arrays.copyOfRange(command, 1, command.length);
			try {
				executeCommand(label, args);
			} catch (IndexOutOfBoundsException exception1) {
			} catch (Exception exception2) {
				exception2.printStackTrace();
			}
		}
	}
	
	public static void registerCommand(Command command) {
		commands.add(command);
	}
	
	public static void registerTool(Tool tool) {
		tools.add(tool);
	}
	
	public static File getDeskPlanerLocation() {
		try {
			return new File(DeskPlaner.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
		} catch (URISyntaxException exception) {
		}
		return null;
	}
	
	/*
	 * args mistake!
	 */
	public static void executeCommand(String label, String args[]) {
		for (Command command : commands) {
			if (command.getCommandName().equals(label)) {
				if(command.onCommand(label, args)) {
					return;
				} else {
					System.out.println("Error: Executing command failed!");
					return;
				}
			}
		}
		System.out.println("Error: Command not found!");
	}
	
	private static void enableTools() {
		for (Tool tool : tools) {
			tool.onEnable();
			System.out.println("[ToolLoader] " + tool.getName() + " successfully loaded!");
		}
	}
	
	private static void disableTools() {
		for (Tool tool : tools) {
			tool.onDisable();
		}
	}

	@Override
	public void start(Stage stage) throws Exception {
		System.setProperty("prism.lcdtext", "false");
		
		HBox root = new HBox();
		
		VBox sideMenu = new VBox();
		root.getChildren().add(sideMenu);
		sideMenu.setStyle("-fx-background-color: #0080ff; -fx-padding: 40px; -fx-pref-width: 250px;");
		Label sideMenuTitle = new Label("DeskPlaner");
		sideMenu.getChildren().add(sideMenuTitle);
		sideMenuTitle.setStyle("-fx-text-fill: #ffffff; -fx-font-size: 30px; -fx-padding-bottom: 40px;");
		
		HBox content = new HBox();
		root.getChildren().add(content);
		Label test = new Label("test");
		content.getChildren().add(test);
		
		Scene scene = new Scene(root);
		
		stage.setScene(scene);
		stage.setTitle("DeskPlaner 1.0");
		stage.setMaximized(true);
		stage.show();
	}
	
}
