package deskplaner.util;

public abstract class Tool {
	
	private String name;
	private int version;
	private int minDeskPlanerVersion;
	private String author;
	private String description;
	private String webURL;
	
	public Tool(String name) {
		this.name = name;
		this.version = 1;
		this.minDeskPlanerVersion = 1;
	}
	
	public Tool(String name, int version, int minDeskPlanerVersion) {
		this.name = name;
		this.version = version;
		this.minDeskPlanerVersion = minDeskPlanerVersion;
	}
	
	public void onEnable() {
		
	}
	
	public void onDisable() {
		
	}
	
	public String getName() {
		return name;
	}
	
	protected void setVersion(int version) {
		this.version = version;
	}
	
	public int getVersion() {
		return version;
	}
	
	public int getMinDeskPlanerVersion() {
		return minDeskPlanerVersion;
	}
	
	protected void setAuthor(String author) {
		this.author = author;
	}
	
	public String getAuthor() {
		return author;
	}
	
	protected void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	protected void setWebURL(String webURL) {
		this.webURL = webURL;
	}
	
	public String getWebURL() {
		return webURL;
	}

}
