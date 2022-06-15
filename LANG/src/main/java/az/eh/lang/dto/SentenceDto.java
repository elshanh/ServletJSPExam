package az.eh.lang.dto;

public class SentenceDto {

	private int id;
	private String sentence;
	private String lang;
	private String translateAz;
	private String translateTr;
	
	public SentenceDto() {
		// TODO Auto-generated constructor stub
	}
	
	public SentenceDto(int id, String sentence, String lang, String translateAz, String translateTr) {
		super();
		this.id = id;
		this.sentence = sentence;
		this.lang = lang;
		this.translateAz = translateAz;
		this.translateTr = translateTr;
	}	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSentence() {
		return sentence;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getTranlateAz() {
		return translateAz;
	}

	public void setTranlateAz(String tranlateAz) {
		this.translateAz = tranlateAz;
	}

	public String getTranlateTr() {
		return translateTr;
	}

	public void setTranlateTr(String tranlateTr) {
		this.translateTr = tranlateTr;
	}
	
	
}
