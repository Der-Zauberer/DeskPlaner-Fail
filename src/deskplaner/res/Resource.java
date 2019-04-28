package deskplaner.res;

import javafx.scene.image.Image;

public class Resource {

	/**
	 * Get the path of the stylesheet.
	 * 
	 * @param name The name of the stylesheet
	 * @return The stylesheet URL string 
	 */
	public static String getStyleSheet(String name) {
		return Resource.class.getResource(name).toExternalForm();
	}
	
	/**
	 * Get the path of the image.
	 * 
	 * @param name The name of the image
	 * @return The image URL string
	 */
	public static String getIcon(String name) {
		return Image.class.getResource(name).toExternalForm();
	}

}
