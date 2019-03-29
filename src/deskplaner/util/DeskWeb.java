package deskplaner.util;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class DeskWeb {

	/**
	 * Open a website with the url of the website.
	 * 
	 * @param url The url of the website
	 */
	public static void openWebsite(String url) {
		try {
			Desktop.getDesktop().browse(new URL(url).toURI());
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Open a file with the File object.
	 * 
	 * @param file The File object
	 */
	public static void openFile(File file) {
		try {
			Desktop.getDesktop().open(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
