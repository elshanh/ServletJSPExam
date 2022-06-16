package az.eh.lang.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GenerateId {
	
	public static int createNewId() {
		int newId = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try (
				Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.113:3306/LANG?useSSL=false","root","bM3YSse2P1Da746eMuRnaQsJ6qs3idQR");
				PreparedStatement preparedStatement = connection.prepareStatement("Select LANG.GENERATE_NEW_ID() From Dual")){
	            ResultSet resultSet = preparedStatement.executeQuery();
	            
	            while (resultSet.next()) {
	            	newId = resultSet.getInt(1);
				}
	            
			} catch (Exception e) {
				// TODO: handle exception
			}
		
		return newId;
	}

}
