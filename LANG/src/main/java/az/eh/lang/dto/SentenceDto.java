package az.eh.lang.dto;

public class SentenceDto {

	private int id;
	private String sentence;
	private String lang;
	private String tranlateAz;
	private String tranlateTr;
	
	public SentenceDto() {
		// TODO Auto-generated constructor stub
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
		return tranlateAz;
	}

	public void setTranlateAz(String tranlateAz) {
		this.tranlateAz = tranlateAz;
	}

	public String getTranlateTr() {
		return tranlateTr;
	}

	public void setTranlateTr(String tranlateTr) {
		this.tranlateTr = tranlateTr;
	}
	
	
}
