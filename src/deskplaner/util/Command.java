package deskplaner.util;

public abstract interface Command {
	
	/**
	 * The Method executes the command. The method returns true, if the execution was .<br><br>
	 * <i>Diese Methode führt den Befehl aus. Falls die Ausführung erfolgreich war, wird "wahr" zurückgegeben.</i>
	 * 
	 * @param args[] The arguments of the command.<br><i>Die Argumente des Befehls.</i>
	 * @author Paul Leppich
	 */
	public abstract boolean onCommand(String args[]);
	
	public abstract String getLabel();
}
