package az.eh.lang.dto;

public class NoteDto {
	
	private int id;
	private String lang;
	private String note;	
	
	public NoteDto() {

	}
	
	public NoteDto(int id, String lang, String note) {
		super();
		this.id = id;
		this.lang = lang;
		this.note = note;
	}		

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	

}
