package az.eh.lang.sqlquery;

public class UserQuery {
	
	public static final String controlLogin 	= "Select ID,NAME,SURNAME,USERNAME,PASSWORD,STATE,STATUS From LANG.USER Where USERNAME = ? and PASSWORD = ?; ";

}
