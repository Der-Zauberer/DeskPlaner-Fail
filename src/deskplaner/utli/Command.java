package deskplaner.utli;

public abstract class Command {
	
	private String label;
	
	/**
	 * The method "onCommand()" contains the instructions, who describe the function of the command.
	 * Not every command has the same function. If you are creating a new command you have to implement the function of the command.
	 * I don't know why we need a command without a function. So this method must be implemented in every special command.
	 * The method should return true if the execution of the command was successful. If it wasn't successful the method should return false.<br><br>
	 * <i>Die Methode "onCommand()" beinhaltet die Befehle, welche die Funktion des Commands beschreiben.
	 * Nicht jeder Command hat die selbe Funktion. Wenn Sie einen neuen Command erstellen, müssen Sie daher die Funktion Ihres Commands implementieren.
	 * Ich kann nicht nachvollziehen, warum wir einen Command ohne Funktion benötigen könnten. Daher muss diese Methode in jedem speziellen Command implementiert sein.
	 * Die Methode soll Wahr (true) zurückgeben, falls der Command erfolgreich ausgeführt wurde. Falls die Ausführung des Commands nicht erfolgreich verlief, soll die Methode den Wert falsch (false) liefern.</i>
	 * 
	 * @author Paul Leppich
	 */
	public abstract boolean onCommand();
	
	/**
	 * The method "getLabel()" returns the private Sring "label".<br><br>
	 * <i>Die Methode "getLabel()" liefert den privaten String (Zeichenkette) "label".</i>
	 * 
	 * @author Paul Leppich
	 */
	public String getLabel() {
		return label;
	}
}
