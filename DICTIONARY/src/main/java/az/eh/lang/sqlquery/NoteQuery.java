package az.eh.lang.sqlquery;

public class NoteQuery {
	
	public static final String noteList 	= "Select ID,LANG,NOTE From LANG.NOTE;";
	public static final String noteById 	= "Select ID,LANG,NOTE From LANG.NOTE Where ID = ?;";
	
	public static final String noteInsert 	= "INSERT INTO LANG.NOTE (ID, LANG, NOTE) VALUES(?,?,?);";
	
	public static final String noteUpdate 	= "Update LANG.NOTE Set LANG=?,NOTE=? Where ID = ?;";
	
	public static final String noteDelete 	= "Delete From LANG.NOTE Where ID = ?;";

}
