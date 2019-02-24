package deskplaner.util;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class Program {

	private static String name = "default";
	private static double version = 1;
	private static String datum;
	private static String author;
	private static String website;
	private static String description;
	private static String iconpath;
	private static String stylepath;

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		Program.name = name;
	}

	public static double getVersion() {
		return version;
	}

	public static void setVersion(double version) {
		Program.version = version;
	}

	public static String getDatum() {
		return datum;
	}

	public static void setDatum(String datum) {
		Program.datum = datum;
	}

	public static String getAuthor() {
		return author;
	}

	public static void setAuthor(String author) {
		Program.author = author;
	}

	public static String getWebsite() {
		return website;
	}

	public static void setWebsite(String website) {
		Program.website = website;
	}

	public static String getDescription() {
		return description;
	}

	public static void setDescription(String description) {
		Program.description = description;
	}

	public static String getIconPath() {
		return iconpath;
	}

	public static void setIconPath(String iconpath) {
		Program.iconpath = iconpath;
	}
	
	public static String getStylePath() {
		return stylepath;
	}
	
	public static void setStylePath(String stylepath) {
		Program.stylepath = stylepath;
	}
	
	public static void configurateStage(Stage stage) {
		stage.setTitle(name);
		stage.setHeight(720);
		stage.setWidth(1280);
		stage.setMaximized(true);
	}
	
	public static void configurateStage(Stage stage, double height, double witdh) {
		stage.setTitle(name);
		stage.setHeight(height);
		stage.setWidth(witdh);
	}
	
	public static void configurateStage(Stage stage, double height, double witdh, boolean maximized) {
		stage.setTitle(name);
		stage.setHeight(height);
		stage.setWidth(witdh);
		stage.setMaximized(maximized);
	}
	
	public static void setStylesheet(Scene scene) {
		scene.getStylesheets().add(scene.getClass().getResource(stylepath).toExternalForm());
	}

}
