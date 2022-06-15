package az.eh.lang.sqlquery;

public class DictionaryQuery {
	
	public static final String gelAllWord 	= "Select ID,WORD_ENG,SPEAK_ENG,WORD_GER,SPEAK_GER,WORD_RUS,SPEAK_RUS,TRANSLATE_AZ,TRANSLATE_TR From LANG.DICTIONARY ";
	public static final String gelWordById 	= "Select ID,WORD_ENG,SPEAK_ENG,WORD_GER,SPEAK_GER,WORD_RUS,SPEAK_RUS,TRANSLATE_AZ,TRANSLATE_TR From LANG.DICTIONARY Where id = ?";
	
	public static final String INSERT_USERS_SQL 	= "INSERT INTO users" + "  (name, email, country) VALUES (?, ?, ?);";
	
	public static final String insertNewWord = "INSERT INTO LANG.DICTIONARY "+
												"(ID, WORD_ENG, SPEAK_ENG, WORD_GER, SPEAK_GER, WORD_RUS, SPEAK_RUS, TRANSLATE_AZ, TRANSLATE_TR) "+
												"VALUES(0,?,?,?,?,?,?,?,?);";
	public static final String updateNewWord = "Update LANG.DICTIONARY Set WORD_ENG=?,SPEAK_ENG=?,WORD_GER=?,SPEAK_GER=?,WORD_RUS=?,SPEAK_RUS=?,TRANSLATE_AZ=?,TRANSLATE_TR=? "+
												" Where ID=?;";
	
	public static final String deleteWord = "Delete From LANG.DICTIONARY Where ID = ?;";	

}
