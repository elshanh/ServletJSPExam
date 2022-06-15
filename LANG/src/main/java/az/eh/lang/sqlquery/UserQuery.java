package az.eh.lang.sqlquery;

public class UserQuery {
	
	public static final String userControlLogin = "Select "+ 
												  "		Case When STATUS='admin' Then 1  Else Case When STATUS='user' Then 2 Else 0 End End "+ 
												  "	From "+
												  "		LANG.USER Where STATE = 'A' and USERNAME = ? and PASSWORD = ?;";
	public static final String userList 		= "Select ID,NAME,SURNAME,USERNAME,PASSWORD,STATE,STATUS From LANG.USER;";
	public static final String userById 		= "Select ID,NAME,SURNAME,USERNAME,PASSWORD From LANG.USER Where ID = ?;";
	
	public static final String userInsert 		= "INSERT INTO LANG.USER (ID, NAME, SURNAME, USERNAME, PASSWORD, STATE, STATUS) VALUES(?,?,?,?,?,'A','user');";
	
	public static final String userUpdate 		= "Update LANG.USER Set NAME=?,SURNAME=?,USERNAME=?,PASSWORD=? Where ID = ?;";
	
	public static final String userDelete 		= "Delete From LANG.USER Where ID = ?;";
}
