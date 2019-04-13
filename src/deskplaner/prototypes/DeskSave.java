package deskplaner.prototypes;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class DeskSave {
	
	private String path;

	public DeskSave() {
		
		try {
			setPath(URLDecoder.decode(DeskSave.class.getProtectionDomain().getCodeSource().getLocation().getPath(), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
				
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
