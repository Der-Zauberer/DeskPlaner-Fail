package deskplaner.res;

public class Resource {

	/**
	 * Get the path of the stylesheet.
	 * 
	 * @param name The name of the stylesheet
	 * @return The Stylesheet URL string 
	 */
	public static String getStyleSheet(String name) {
		return Resource.class.getResource(name).toExternalForm();
	}

}
