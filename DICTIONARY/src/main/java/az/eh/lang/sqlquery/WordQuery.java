package az.eh.lang.sqlquery;

public class WordQuery {
	
	public static final String wordList 	= "Select ID,WORD_ENG,SPEAK_ENG,WORD_GER,SPEAK_GER,WORD_RUS,SPEAK_RUS,TRANSLATE_AZ,TRANSLATE_TR From LANG.WORD ";

	public static final String wordById 	= "Select ID,WORD_ENG,SPEAK_ENG,WORD_GER,SPEAK_GER,WORD_RUS,SPEAK_RUS,TRANSLATE_AZ,TRANSLATE_TR From LANG.WORD Where id = ?";
	
	public static final String wordInsert 	= "INSERT INTO LANG.WORD (ID, WORD_ENG, SPEAK_ENG, WORD_GER, SPEAK_GER, WORD_RUS, SPEAK_RUS, TRANSLATE_AZ, TRANSLATE_TR) "+
												"VALUES(?,?,?,?,?,?,?,?,?);";
	
	public static final String wordUpdate 	= "Update LANG.WORD Set WORD_ENG=?,SPEAK_ENG=?,WORD_GER=?,SPEAK_GER=?,WORD_RUS=?,SPEAK_RUS=?,TRANSLATE_AZ=?,TRANSLATE_TR=? Where ID=?;";

	public static final String wordDelete 	= "Delete From LANG.WORD Where ID = ?;";

}
