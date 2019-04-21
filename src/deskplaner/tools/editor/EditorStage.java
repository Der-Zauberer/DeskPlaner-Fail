package deskplaner.tools.editor;

import java.io.IOException;

import deskplaner.util.DeskStage;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;

/**
 *	Work in progress!
 */
public class EditorStage extends DeskStage {
	
	private TabPane tabpane;

	public EditorStage() {
		super();
		
		tabpane = new TabPane();
		getParent().getChildren().add(tabpane);
		tabpane.getTabs().add(createCodeTab());

	}
	
	private Tab createCodeTab() {
		Tab tab = new Tab();
		tab.setText("Unnamed");
		VBox parent = new VBox();
		parent.getStyleClass().add("tool");
		tab.setContent(parent);

		Button btNew = new Button("New");
		Button btOpen = new Button("Open");
		Button btSave = new Button("Save");
		ToolBar toolbar = new ToolBar();
		parent.getChildren().add(toolbar);
		toolbar.getStyleClass().add("menu");
		toolbar.getItems().addAll(btNew, btOpen, btSave);

		TextArea textarea = new TextArea();
		textarea.setPrefHeight(parent.getHeight());
		textarea.setId("editor");
		parent.getChildren().add(textarea);
		
		parent.heightProperty().addListener((obs, oldVal, newVal) -> {
			textarea.setPrefHeight(parent.getWidth() - 100);
		});

		btNew.setOnAction(e -> tabpane.getTabs().add(createCodeTab()));
		btOpen.setOnAction(e -> {
			try {
				tab.setText(Editor.open(textarea));
			} catch (IOException e1) {
			}
		});
		btSave.setOnAction(e -> Editor.saveFile(textarea));
		return tab;
	}

}
