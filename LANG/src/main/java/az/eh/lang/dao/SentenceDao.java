package az.eh.lang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import az.eh.lang.daoImp.SentenceImpl;
import az.eh.lang.db.ConnectDB;
import az.eh.lang.dto.SentenceDto;
import az.eh.lang.sqlquery.SentenceQuery;
import az.eh.lang.tools.GenerateId;

public class SentenceDao implements SentenceImpl{

	@Override
	public List<SentenceDto> selectList() {
		List<SentenceDto> sentenceDtos = new ArrayList<>();
		try (
			Connection connection = ConnectDB.openConnect();
			PreparedStatement preparedStatement = connection.prepareStatement(SentenceQuery.sentenceList)
			){
	            
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				sentenceDtos.add(new SentenceDto(
		            	resultSet.getInt(1),
		            	resultSet.getString(2),
		            	resultSet.getString(3),
		            	resultSet.getString(4),
		            	resultSet.getString(5)
	            	));
				}
			ConnectDB.closeConnect(connection);
		} catch (Exception e) {
			//TODO: handle exception
		}
		
		return sentenceDtos;
	}

	@Override
	public void insert(SentenceDto sentenceDto) {
		int newId = GenerateId.createNewId();
		try (
			Connection connection = ConnectDB.openConnect();
			PreparedStatement preparedStatement = connection.prepareStatement(SentenceQuery.sentenceInsert)) {
				
			preparedStatement.setInt(1, newId);
			preparedStatement.setString(2, sentenceDto.getSentence());
			preparedStatement.setString(3, sentenceDto.getLang());
			preparedStatement.setString(4, sentenceDto.getTranlateAz());
			preparedStatement.setString(5, sentenceDto.getTranlateTr());
			preparedStatement.executeUpdate();
			
			ConnectDB.closeConnect(connection);				
		} catch (SQLException e) {
			e.getMessage();
		}
	}

	@Override
	public SentenceDto select(int sentenceId) {
		SentenceDto sentenceDto = new SentenceDto();
		try (
			Connection connection = ConnectDB.openConnect();
			PreparedStatement preparedStatement = connection.prepareStatement(SentenceQuery.sentenceById)){
			preparedStatement.setInt(1,sentenceId);
			ResultSet resultSet = preparedStatement.executeQuery();
	        while (resultSet.next()) {
	        	sentenceDto.setId(resultSet.getInt(1));
	        	sentenceDto.setSentence(resultSet.getString(2));
	        	sentenceDto.setLang(resultSet.getString(3));
	        	sentenceDto.setTranlateAz(resultSet.getString(4));
	        	sentenceDto.setTranlateTr(resultSet.getString(5));
	        }
	        ConnectDB.closeConnect(connection);
		} catch (Exception e) {
				// TODO: handle exception
		}
		return sentenceDto;
	}

	@Override
	public void update(SentenceDto sentenceDto) {
		try (
				Connection connection = ConnectDB.openConnect();
				PreparedStatement preparedStatement = connection.prepareStatement(SentenceQuery.sentenceUpdate)) {
					
				preparedStatement.setString(1, sentenceDto.getLang());
				preparedStatement.setString(2, sentenceDto.getSentence());
				preparedStatement.setString(3, sentenceDto.getTranlateAz());
				preparedStatement.setString(4, sentenceDto.getTranlateTr());
				preparedStatement.setInt(5, sentenceDto.getId());
				
				preparedStatement.executeUpdate();
				ConnectDB.closeConnect(connection);	
			} catch (SQLException e) {
				e.getMessage();
			}	
	}

	@Override
	public void delete(int sentenceId) {
		try (
				Connection connection = ConnectDB.openConnect();
				PreparedStatement preparedStatement = connection.prepareStatement(SentenceQuery.sentenceDelete)) {
				preparedStatement.setInt(1, sentenceId);
				preparedStatement.executeUpdate();
				ConnectDB.closeConnect(connection);	
			} catch (SQLException e) {
				e.getMessage();
			}
	}


}
