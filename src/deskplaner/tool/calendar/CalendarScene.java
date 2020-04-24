package deskplaner.tool.calendar;



import java.util.ArrayList;



import deskplaner.gui.DeskScene;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.layout.FlowPane;

public class CalendarScene extends DeskScene{
	//VBox monday,tuesday, wednessday, thursday, friday, saturday, sunday ;
	public CalendarScene() {
		
		Button next = new Button("next");
		Button back = new Button("back");
		Pane pane = new Pane();
        HBox.setHgrow(pane, Priority.SOMETIMES);
		ToolBar toolbar = new ToolBar();
		getContent().getChildren().add(toolbar);
		Label label = new Label("Weekly-Calendar");
		label.getStyleClass().add("h2");
		toolbar.getItems().add(label);
		toolbar.getItems().add(pane);
		toolbar.getItems().add(next);
		toolbar.getItems().add(back);
		createCalendar();
		
	} 
	private void createCalendar() {
		
		HBox hbox = new HBox();
		hbox.setSpacing(5);
		hbox.setPadding(new Insets(5));
	
		
		VBox monday = new VBox(5);
		monday.getChildren().add(new Label("Monday"));
		getContent().getChildren().add(hbox);
		monday.getStyleClass().add("CBox");
		
		
		VBox tuesday = new VBox(5);
		tuesday.getChildren().add(new Label("Tuesday"));
		getContent().getChildren().add(tuesday);
		tuesday.getStyleClass().add("CBox");
		
		VBox wednessday = new VBox();
		wednessday.getChildren().add(new Label("Wednessday"));
		getContent().getChildren().add(wednessday);
		wednessday.getStyleClass().add("CBox");
		
		VBox thursday = new VBox();
		thursday.getChildren().add(new Label("Thursday"));
		getContent().getChildren().add(thursday);
		thursday.getStyleClass().add("CBox");
		
		VBox friday = new VBox();
		friday.getChildren().add(new Label("Friday"));
		getContent().getChildren().add(friday);
		friday.getStyleClass().add("CBox");
		
		VBox saturday = new VBox();
		saturday.getChildren().add(new Label("Saturday"));
		getContent().getChildren().add(saturday);
		saturday.getStyleClass().add("CBox");
		
		VBox sunday = new VBox();
		sunday.getChildren().add(new Label("Sunday"));
		getContent().getChildren().add(sunday);
		sunday.getStyleClass().add("CBox");
		
		
		hbox.getChildren().addAll(monday,tuesday, wednessday, thursday, friday, saturday, sunday);
	
	}
	
		private void deleteLastWeek() {
//			ArrayList<Node> childrens = new ArrayList<>();
//			for(Node node : hbox.getChildren()) {
//			  childrens.add((Node) node);
//			  
//			}
//			for(Node node : childrens) {
//			  hbox.getChildren().remove(node);
//			}

		}
	
}
