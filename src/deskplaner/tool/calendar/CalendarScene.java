package deskplaner.tool.calendar;

import deskplaner.gui.DeskScene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class CalendarScene extends DeskScene{
	//VBox monday,tuesday, wednessday, thursday, friday, saturday, sunday ;
	
	private static VBox[] vbox = new VBox[7]; 
	
	public CalendarScene() {
		Button next = new Button("next");
		Button back = new Button("back");
		Pane pane = new Pane();
        HBox.setHgrow(pane, Priority.SOMETIMES);
		ToolBar toolbar = new ToolBar();
		getContent().getChildren().add(toolbar);
		toolbar.getItems().add(pane);
		toolbar.getItems().add(next);
		toolbar.getItems().add(back);
		TilePane tilepane = new TilePane();
		tilepane.setPrefWidth(1670);
		tilepane.setHgap(20);
		tilepane.setVgap(20);
		tilepane.setPadding(new Insets(50));
		getContent().getChildren().add(tilepane);
		addDay(0, "Moday");
		addDay(1, "Tuesday ");
		addDay(2, "Wednesday ");
		addDay(3, "Thursday ");
		addDay(4, "Friday ");
		addDay(5, "Saturday ");
		addDay(6, "Sunday ");
		tilepane.getChildren().addAll(vbox);
	}
	
	private static void addDay(int position, String name) {
		vbox[position] = new VBox();
		vbox[position].setPrefWidth(205);
		vbox[position].setPrefHeight(500);
		vbox[position].getChildren().add(new Label(name));
		vbox[position].getStyleClass().add("CBox");
	}
	
//	private void deleteLastWeek() {
//		ArrayList<Node> childrens = new ArrayList<>();
//		for(Node node : hbox.getChildren()) {
//			childrens.add((Node) node);  
//		}
//		for(Node node : childrens) {
//			hbox.getChildren().remove(node);
//		}
//	}
	
}
