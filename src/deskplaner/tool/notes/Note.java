package deskplaner.tool.notes;

public class Note {
	
	private String title;
	private String text;
	
	/**
	 * Create a Note with a title and a empty text.<br><br>
	 * <i>Erstellt eine Notiz mit einem Titel und einen leeren Text.</i>
	 * 
	 * @param title The title of the Note<br><i>Der Titel der Notiz</i>
	 * @author André Sommer
	 */
	public Note(String title) {
		this.title = title;
	}
	
	/**
	 * Create a Note with a title and a empty text.<br><br>
	 * <i>Erstellt eine Notiz mit einem Titel und einen Text.</i>
	 * 
	 * @param title The title of the Note<br><i>Der Titel der Notiz</i>
	 * @param text The text of the Note<br><i>Der Text der Notiz</i>
	 * @author André Sommer
	 */
	public Note(String title, String text) {
		this.title = title;
		this.text = text;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Note [title=" + title + ", text=" + text + "]";
	}	
	
}
