package az.eh.lang.dto;

public class WordDto {
	
	private int id;
	private String wordEng;
	private String speaksEng;
	private String wordGer;
	private String speaksGer;
	private String wordRus;
	private String speaksRus;
	private String translateAz;
	private String translateTr;
	
	public WordDto() {
	}
	
	 
	
	public WordDto(int id, String wordEng, String speaksEng, String wordGer, String speaksGer, String wordRus,
			String speaksRus, String translateAz, String translateTr) {
		super();
		this.id = id;
		this.wordEng = wordEng;
		this.speaksEng = speaksEng;
		this.wordGer = wordGer;
		this.speaksGer = speaksGer;
		this.wordRus = wordRus;
		this.speaksRus = speaksRus;
		this.translateAz = translateAz;
		this.translateTr = translateTr;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWordEng() {
		return wordEng;
	}
	public void setWordEng(String wordEng) {
		this.wordEng = wordEng;
	}
	public String getSpeaksEng() {
		return speaksEng;
	}
	public void setSpeaksEng(String speaksEng) {
		this.speaksEng = speaksEng;
	}
	public String getWordGer() {
		return wordGer;
	}
	public void setWordGer(String wordGer) {
		this.wordGer = wordGer;
	}
	public String getSpeaksGer() {
		return speaksGer;
	}
	public void setSpeaksGer(String speaksGer) {
		this.speaksGer = speaksGer;
	}
	public String getWordRus() {
		return wordRus;
	}
	public void setWordRus(String wordRus) {
		this.wordRus = wordRus;
	}
	public String getSpeaksRus() {
		return speaksRus;
	}
	public void setSpeaksRus(String speaksRus) {
		this.speaksRus = speaksRus;
	}
	public String getTranslateAz() {
		return translateAz;
	}
	public void setTranslateAz(String translateAz) {
		this.translateAz = translateAz;
	}
	public String getTranslateTr() {
		return translateTr;
	}
	public void setTranslateTr(String translateTr) {
		this.translateTr = translateTr;
	}	

}
