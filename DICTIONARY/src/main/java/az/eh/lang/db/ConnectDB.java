package az.eh.lang.db;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	
	public class ConnectDB {
		
		public static Connection openConnect() {
		    try
		    {
		    	Class.forName("com.mysql.cj.jdbc.Driver");
		    } 
		    catch (ClassNotFoundException e) {
		      System.out.println("MySQL JDBC Driver not Found !! \n"+e.getMessage());
		    }			
			
			Connection connection = null;
			try {
				connection = DriverManager.getConnection("jdbc:mysql://192.168.0.113:3306/LANG?useSSL=false","root","bM3YSse2P1Da746eMuRnaQsJ6qs3idQR");
			} catch (SQLException e) {
				System.out.println("Connection Failed! Check Console !! \n"+e.getMessage());
			}
			
			return connection;
		}
		
		public static void closeConnect(Connection connection) {
			try {
		        if(connection != null)
		          connection.close();
			} catch (SQLException e) {
				System.out.println("Close Connection Failed! Check Console !! \n"+e.getMessage());
			}
		}
}
