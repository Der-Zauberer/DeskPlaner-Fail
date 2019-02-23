package deskplaner.util;

public class Programm {

	private static String name = "default";
	private static int version = 1;
	private static String datum;
	private static String author;
	private static String website;
	private static String description;
	private static String iconpath;

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		Programm.name = name;
	}

	public static int getVersion() {
		return version;
	}

	public static void setVersion(int version) {
		Programm.version = version;
	}

	public static String getDatum() {
		return datum;
	}

	public static void setDatum(String datum) {
		Programm.datum = datum;
	}

	public static String getAuthor() {
		return author;
	}

	public static void setAuthor(String author) {
		Programm.author = author;
	}

	public static String getWebsite() {
		return website;
	}

	public static void setWebsite(String website) {
		Programm.website = website;
	}

	public static String getDescription() {
		return description;
	}

	public static void setDescription(String description) {
		Programm.description = description;
	}

	public static String getIconpath() {
		return iconpath;
	}

	public static void setIconpath(String iconpath) {
		Programm.iconpath = iconpath;
	}

}
