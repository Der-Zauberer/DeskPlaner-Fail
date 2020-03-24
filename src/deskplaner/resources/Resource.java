package deskplaner.resources;

public class Resource {

	/**
	 * Get the path of the stylesheet.<br><br>
	 * <i>Gibt den Pfad der CSS-Datei</i>
	 * 
	 * @author André Sommer
	 * @param name The name of the stylesheet<br><i>Der Name der CSS-Datei</i>
	 * @return The URL string of the stylesheet<br><i>Den Dateipfad der CSS-Datei als String</i>
	 */
	public static String getStyleSheet(String name) {
		return Resource.class.getResource(name).toExternalForm();
	}

}