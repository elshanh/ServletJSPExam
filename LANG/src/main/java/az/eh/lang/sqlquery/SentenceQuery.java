package az.eh.lang.sqlquery;

public class SentenceQuery {
	
	public static final String sentenceList 		= "Select ID,SENTENCE,LANG,TRANSLATE_AZ,TRANSLATE_TR From LANG.SENTENCE;";
	public static final String sentenceById 		= "Select ID,SENTENCE,LANG,TRANSLATE_AZ,TRANSLATE_TR From LANG.SENTENCE Where ID = ?;";
	
	public static final String sentenceInsert 		= "INSERT INTO LANG.SENTENCE (ID, SENTENCE, LANG, TRANSLATE_AZ, TRANSLATE_TR) VALUES(?,?,?,?,?);";
	
	public static final String sentenceUpdate 		= "Update LANG.SENTENCE Set SENTENCE=?,LANG=?,TRANSLATE_AZ=?,TRANSLATE_TR=? Where ID = ?;";
	
	public static final String sentenceDelete 		= "Delete From LANG.SENTENCE Where ID = ?;";


}
