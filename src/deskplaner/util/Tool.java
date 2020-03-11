package deskplaner.util;

import java.util.ArrayList;
import deskplaner.gui.DeskScene;
import javafx.scene.Scene;

public abstract class Tool {
	
	private String name;
	private int version;
	private ArrayList<DeskScene> scenes = new ArrayList<DeskScene>();
	
	/**
	 * In the constructor the name of the Tool is set and the version is initialized with 1 by default.<br><br>
	 * <i>Im Konstruktor wird der Name des Tools eingestellt und die Version mit 1 standardmäßig initialisiert.</i>
	 * 
	 * @param name The name for the Tool<br><i>Der Name für das Tool</i>
	 * @author André Sommer
	 */
	public Tool(String name) {
		this.name = name;
		this.version = 0;
	}
	
	/**
	 * In the constructor the name and the version of the Tool is set.<br><br>
	 * <i>Im Konstruktor wird der Name und die Version des Tools eingestellt.</i>
	 * 
	 * @param name The name for the Tool<br><i>Der Name für das Tool</i>
	 * @param version The version for the Tool<br><i>Die Version für das Tool</i>
	 * @author André Sommer
	 */
	public Tool(String name, int version) {
		this.name = name;
		this.version = version;
	}
	
	/**
	 * The method is called when the tool is loaded.<br><br>
	 * <i>Die Methode wird beim laden des Tools aufgerufen.</i>
	 * 
	 * @author André Sommer
	 */
	public void onEnable() {
	
	}
	
	/**
	 * The method is called when the tool is stoped.<br><br>
	 * <i>Die Methode wird beim stoppen des Tools aufgerufen.</i>
	 * 
	 * @author André Sommer
	 */
	public void onDisable() {
		
	}
	
	/**
	 * Add new DeskScene to the tool.<br><br>
	 * <i>Fügt neue DeskScene zum Tool hinzu</i>
	 * 
	 * @author André Sommer
	 * @param deskstage The DeskStage to be registered<br><i>Die DeskStage, die hinzugefügt werden soll</i>
	 */
	public void addDeskScene(DeskScene deskscene) {
		scenes.add(deskscene);
	}
	
	/**
	 * Get a DeskScene by index.<br><br>
	 * <i>Gibt die DeskScene über die den index zurück.</i>
	 * 
	 * @author André Sommer
	 * @return The DeskScene by index<br><i>Die DeskScene über den index</i>
	 */
	public DeskScene getDeskScene(int index) {
		return scenes.get(index);
	}
	
	/**
	 * Get the main scene of the tool.<br><br>
	 * <i>Gibt die Hauptszene des Tools zurück.</i>
	 * 
	 * @author André Sommer
	 * @return The mainscene of the tool<br><i>Die Hauptszene des Tools</i>
	 */
	public Scene getMainScene() {
		return scenes.get(0).getScene();
	}
	
	/**
	 * Check if the tool have a scene.<br><br>
	 * <i>Überprüft, ob das Tool eine Szene beinhaltet.</i>
	 * 
	 * @author André Sommer
	 * @return If scene exists<br><i>Wenn die Szene existiert</i>
	 */
	public boolean hasScene()  {
		if(scenes.get(0) != null) {
			return true;
		}
		return false; 
	}
	
	public String getName() {
		return name;
	}
	
	public int getVersion() {
		return version;
	}
	
}
