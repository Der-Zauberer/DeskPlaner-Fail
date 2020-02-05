package deskplaner.util;

public abstract interface Command {
	
	public boolean onCommand(String label, String args[]);
	public String getCommandName();
	public Tool getCommandTool();

}
