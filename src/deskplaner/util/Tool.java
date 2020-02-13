package deskplaner.util;

public abstract class Tool {
	
	private String name;
	private int version;
	
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
	 * The method onEnable() is called when the tool is loaded.<br><br>
	 * <i>Die Methode onEnable() wird beim laden des Tools aufgerufen.</i>
	 * 
	 * @author André Sommer
	 */
	public void onEnable() {
	
	}
	
	/**
	 * The method onDisable() is called when the tool is stoped.<br><br>
	 * <i>Die Methode onDisable() wird beim stoppen des Tools aufgerufen.</i>
	 * 
	 * @author André Sommer
	 */
	public void onDisable() {
		
	}
	
	public String getName() {
		return name;
	}
	
	public int getVersion() {
		return version;
	}
	
}
