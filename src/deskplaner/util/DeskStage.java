package deskplaner.util;

import deskplaner.res.Resource;
import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *	Work in progress!
 */
public class DeskStage extends Stage{
	
	private Scene scene;
	private VBox parent;
	private ToolBar toolbar;

	public DeskStage() {
		parent = new VBox();
		scene = new Scene(parent);
		
		toolbar = new ToolBar();
		toolbar.getStyleClass().add("menu");
		parent.getChildren().add(toolbar);
		
		scene.getStylesheets().add(Resource.getStyleSheet("style.css"));
		
		this.setScene(scene);
		this.setHeight(720);
		this.setWidth(1280);
		this.show();
	}
	
	public ToolBar getToolbar() {
		return toolbar;
	}
	
	public VBox getParent() {
		return parent;
	}

}
