package az.eh.lang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import az.eh.lang.daoImp.UserImpl;
import az.eh.lang.db.ConnectDB;
import az.eh.lang.dto.UserDto;
import az.eh.lang.sqlquery.UserQuery;
import az.eh.lang.tools.GenerateId;

public class UserDao implements UserImpl{
	
	@Override
	public int select(String username,String password) {
		int result = 0;
		try (
			Connection connection = ConnectDB.openConnect();
			PreparedStatement preparedStatement = connection.prepareStatement(UserQuery.userControlLogin)){
			preparedStatement.setString(1, username);
	        preparedStatement.setString(2, password);
	            
	        ResultSet resultSet = preparedStatement.executeQuery();
	        while (resultSet.next()) {
	        	result = resultSet.getInt(1);
	        }
	        ConnectDB.closeConnect(connection);
		} catch (Exception e) {
				System.out.println(e.getMessage());
		}
		
		return result;
	}
	@Override
	public List<UserDto> selectList(){
		List<UserDto> userDtos = new ArrayList<>();
		try (
			Connection connection = ConnectDB.openConnect();
			PreparedStatement preparedStatement = connection.prepareStatement(UserQuery.userList)
			){
	            
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				userDtos.add(new UserDto(
		            	resultSet.getInt(1),
		            	resultSet.getString(2),
		            	resultSet.getString(3),
		            	resultSet.getString(4),
		            	resultSet.getString(5),
		            	resultSet.getString(6),
		            	resultSet.getString(7)
	            	));
				}
			ConnectDB.closeConnect(connection);
		} catch (Exception e) {
			//TODO: handle exception
		}
		
		return userDtos;		
	};
	@Override
	public void insert(UserDto userDto) {
		int newId = GenerateId.createNewId();
		try (
			Connection connection = ConnectDB.openConnect();
			PreparedStatement preparedStatement = connection.prepareStatement(UserQuery.userInsert)) {
				
			preparedStatement.setInt(1, newId);
			preparedStatement.setString(2, userDto.getName());
			preparedStatement.setString(3, userDto.getSurname());
			preparedStatement.setString(4, userDto.getUsername());
			preparedStatement.setString(5, userDto.getPassword());
			preparedStatement.executeUpdate();
			
			ConnectDB.closeConnect(connection);				
		} catch (SQLException e) {
			e.getMessage();
		}
	}
	@Override
	public UserDto select(int userId) {
		UserDto userDto = new UserDto();
		try (
			Connection connection = ConnectDB.openConnect();
			PreparedStatement preparedStatement = connection.prepareStatement(UserQuery.userById)){
			preparedStatement.setInt(1,userId);
			ResultSet resultSet = preparedStatement.executeQuery();
	        while (resultSet.next()) {
            	userDto.setId(resultSet.getInt(1));
            	userDto.setName(resultSet.getString(2));
            	userDto.setSurname(resultSet.getString(3));
            	userDto.setUsername(resultSet.getString(4));
            	userDto.setPassword(resultSet.getString(5));
	        }
	        ConnectDB.closeConnect(connection);
		} catch (Exception e) {
				// TODO: handle exception
		}
		return userDto;
	}	
	@Override
	public void update(UserDto userDto) {
		try (
			Connection connection = ConnectDB.openConnect();
			PreparedStatement preparedStatement = connection.prepareStatement(UserQuery.userUpdate)) {
				
			preparedStatement.setString(1, userDto.getName());
			preparedStatement.setString(2, userDto.getSurname());
			preparedStatement.setString(3, userDto.getUsername());
			preparedStatement.setString(4, userDto.getPassword());
			preparedStatement.setInt(5, userDto.getId());
			
			preparedStatement.executeUpdate();
			ConnectDB.closeConnect(connection);	
		} catch (SQLException e) {
			e.getMessage();
		}		
	}
	@Override
	public void delete(int userId) {
		try (
			Connection connection = ConnectDB.openConnect();
			PreparedStatement preparedStatement = connection.prepareStatement(UserQuery.userDelete)) {
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();
			ConnectDB.closeConnect(connection);	
		} catch (SQLException e) {
			e.getMessage();
		}
	}

}
