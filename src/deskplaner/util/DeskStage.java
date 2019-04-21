package deskplaner.util;

import deskplaner.res.Resource;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *	Work in progress!
 */
public class DeskStage extends Stage{
	
	private Scene scene;
	private VBox parent;

	public DeskStage() {
		parent = new VBox();
		scene = new Scene(parent);
		
		scene.getStylesheets().add(Resource.getStyleSheet("style.css"));
		
		this.setScene(scene);
		this.setHeight(720);
		this.setWidth(1280);
		this.show();
	}
	
	public VBox getParent() {
		return parent;
	}

}
