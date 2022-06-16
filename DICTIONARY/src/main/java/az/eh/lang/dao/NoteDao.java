package az.eh.lang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import az.eh.lang.daoImp.NoteImpl;
import az.eh.lang.db.ConnectDB;
import az.eh.lang.dto.NoteDto;
import az.eh.lang.sqlquery.NoteQuery;
import az.eh.lang.tools.GenerateId;

public class NoteDao implements NoteImpl{

	@Override
	public List<NoteDto> selectList() {
		List<NoteDto> noteDtos = new ArrayList<>();
		try (
			Connection connection = ConnectDB.openConnect();
			PreparedStatement preparedStatement = connection.prepareStatement(NoteQuery.noteList)
			){
	            
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				noteDtos.add(new NoteDto(
		            	resultSet.getInt(1),
		            	resultSet.getString(2),
		            	resultSet.getString(3)
	            	));
				}
			ConnectDB.closeConnect(connection);
		} catch (Exception e) {
			//TODO: handle exception
		}
		
		return noteDtos;
	}
	@Override
	public void insert(NoteDto noteDto) {
		int newId = GenerateId.createNewId();
		try (
			Connection connection = ConnectDB.openConnect();
			PreparedStatement preparedStatement = connection.prepareStatement(NoteQuery.noteInsert)) {
				
			preparedStatement.setInt(1, newId);
			preparedStatement.setString(2, noteDto.getNote());
			preparedStatement.setString(3, noteDto.getLang());
			preparedStatement.executeUpdate();
			
			ConnectDB.closeConnect(connection);				
		} catch (SQLException e) {
			e.getMessage();
		}
	}
	@Override
	public NoteDto select(int noteId) {
		NoteDto noteDto = new NoteDto();
		try (
			Connection connection = ConnectDB.openConnect();
			PreparedStatement preparedStatement = connection.prepareStatement(NoteQuery.noteById)){
			preparedStatement.setInt(1,noteId);
			ResultSet resultSet = preparedStatement.executeQuery();
	        while (resultSet.next()) {
	        	noteDto.setId(resultSet.getInt(1));
	        	noteDto.setNote(resultSet.getString(2));
	        	noteDto.setLang(resultSet.getString(3));
	        }
	        ConnectDB.closeConnect(connection);
		} catch (Exception e) {
				// TODO: handle exception
		}
		return noteDto;
	}
	@Override
	public void update(NoteDto noteDto) {
		try (
			Connection connection = ConnectDB.openConnect();
			PreparedStatement preparedStatement = connection.prepareStatement(NoteQuery.noteUpdate)) {
					
			preparedStatement.setString(1, noteDto.getLang());
			preparedStatement.setString(2, noteDto.getNote());
			preparedStatement.setInt(3, noteDto.getId());
				
			preparedStatement.executeUpdate();
			ConnectDB.closeConnect(connection);	
		} catch (SQLException e) {
			e.getMessage();
		}	
	}
	@Override
	public void delete(int noteId) {
		try (
			Connection connection = ConnectDB.openConnect();
			PreparedStatement preparedStatement = connection.prepareStatement(NoteQuery.noteDelete)) {
			preparedStatement.setInt(1, noteId);
			preparedStatement.executeUpdate();
			ConnectDB.closeConnect(connection);	
		} catch (SQLException e) {
			e.getMessage();
		}
	}

}
