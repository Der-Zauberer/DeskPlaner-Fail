package deskplaner.tools.notes;

import java.util.ArrayList;
import deskplaner.main.DeskPlaner;
import deskplaner.util.Tool;

public class Notes extends Tool{
	
	private static Tool instance;
	
	private static ArrayList<Note> notes = new ArrayList<>();

	public Notes() {
		super("Notes", 0, 0);
		instance = this;
	}
	
	@Override
	public void onEnable() {
		System.out.println("Activated Notes");
		DeskPlaner.registerCommand(new NoteCommand());
		DeskPlaner.registerCommand(new PathCommand());
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public static Tool getInstance() {
		return instance;
	}
	
	public static void createNote(String title, String content) {
		notes.add(new Note(title, content));
	}
	
	public static Note getNote(String title) {
		for (Note note : notes) {
			if(note.getTitle().equals(title)) {
				return note;
			}
		}
		return null;
	}
	
	public static ArrayList<Note> getNotes() {
		return notes;
	}
	
	public static void deleateNote(String title) {
		for (Note note : notes) {
			if(note.getTitle().equals(title)) {
				notes.remove(note);
			}
		}
	}

}
class Note {
	
	private String title;
	private String content;
	
	public Note(String title) {
		this.title = title;
	}
	
	public Note(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}
	
}