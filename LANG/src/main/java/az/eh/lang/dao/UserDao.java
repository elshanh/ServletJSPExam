package az.eh.lang.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import az.eh.lang.daoImp.UserImpl;
import az.eh.lang.dto.UserDto;
import az.eh.lang.sqlquery.UserQuery;

public class UserDao implements UserImpl{

	@Override
	public void insert(UserDto userDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UserDto userDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UserDto userDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserDto select(UserDto userDto, String type) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		if (type.toString().equals("login")) {
			try (
				Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.113:3306/LANG?useSSL=false","root","bM3YSse2P1Da746eMuRnaQsJ6qs3idQR");
				PreparedStatement preparedStatement = connection.prepareStatement(UserQuery.controlLogin)){
					
				preparedStatement.setString(1, userDto.getUsername());
	            preparedStatement.setString(2, userDto.getPassword());
	            
	            System.out.println(preparedStatement);
	            
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	            	userDto.setId(resultSet.getInt(1));
	            	userDto.setName(resultSet.getString(2));
	            	userDto.setSurname(resultSet.getString(3));
	            	userDto.setUsername(resultSet.getString(4));
	            	userDto.setPassword(resultSet.getString(5));
	            	userDto.setState(resultSet.getString(6));
	            	userDto.setStatus(resultSet.getString(7));
				}
	            
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		return userDto;
	}

}
