package az.eh.lang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import az.eh.lang.daoImp.WordImpl;
import az.eh.lang.db.ConnectDB;
import az.eh.lang.dto.WordDto;
import az.eh.lang.sqlquery.WordQuery;
import az.eh.lang.tools.GenerateId;

public class WordDao implements WordImpl{
	
	@Override
	public List<WordDto> selectList() {
		List<WordDto> wordDtos = new ArrayList<>();

		try (
			Connection connection = ConnectDB.openConnect();
			PreparedStatement preparedStatement = connection.prepareStatement(WordQuery.wordList)){
			ResultSet resultSet = preparedStatement.executeQuery();
	        
			while (resultSet.next()) {
				wordDtos.add(new WordDto(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
		            	resultSet.getString(4),
		            	resultSet.getString(5),
		            	resultSet.getString(6),
		            	resultSet.getString(7),
		            	resultSet.getString(8),
		            	resultSet.getString(9)
	            	));
				}
			ConnectDB.closeConnect(connection);
	            
			} catch (Exception e) {
				// TODO: handle exception
			}
		
		return wordDtos;
	}
	@Override
	public void insert(WordDto wordDto) {
		int newId = GenerateId.createNewId();
		try (Connection connection = ConnectDB.openConnect();
			PreparedStatement preparedStatement = connection.prepareStatement(WordQuery.wordInsert)) {
			
			preparedStatement.setInt(1, newId);
			preparedStatement.setString(2, wordDto.getWordEng());
			preparedStatement.setString(3, wordDto.getSpeaksEng());
			preparedStatement.setString(4, wordDto.getWordGer());
			preparedStatement.setString(5, wordDto.getSpeaksGer());
			preparedStatement.setString(6, wordDto.getWordRus());
			preparedStatement.setString(7, wordDto.getSpeaksRus());
			preparedStatement.setString(8, wordDto.getTranslateAz());
			preparedStatement.setString(9, wordDto.getTranslateTr());
			preparedStatement.executeUpdate();
			ConnectDB.closeConnect(connection);	
			
		} catch (SQLException e) {
			e.getMessage();
		}	
	}	
	@Override
	public WordDto select(int wordId) {
		WordDto wordDto = new WordDto();
		try (
			Connection connection = ConnectDB.openConnect();
			PreparedStatement preparedStatement = connection.prepareStatement(WordQuery.wordById)){
			preparedStatement.setInt(1, wordId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				wordDto.setId(resultSet.getInt(1));
				wordDto.setWordEng(resultSet.getString(2));
				wordDto.setSpeaksEng(resultSet.getString(3));
				wordDto.setWordGer(resultSet.getString(4));
				wordDto.setSpeaksGer(resultSet.getString(5));
				wordDto.setWordRus(resultSet.getString(6));
				wordDto.setSpeaksRus(resultSet.getString(7));
				wordDto.setTranslateAz(resultSet.getString(8));
				wordDto.setTranslateTr(resultSet.getString(9));
			}
			ConnectDB.closeConnect(connection);
			} catch (Exception e) {
				// TODO: handle exception
			}
		
		return wordDto;
	}
	@Override
	public void update(WordDto wordDto) {
		try (
			Connection connection = ConnectDB.openConnect();
			PreparedStatement preparedStatement = connection.prepareStatement(WordQuery.wordUpdate)) {
			
			preparedStatement.setString(1, wordDto.getWordEng());
			preparedStatement.setString(2, wordDto.getSpeaksEng());
			preparedStatement.setString(3, wordDto.getWordGer());
			preparedStatement.setString(4, wordDto.getSpeaksGer());
			preparedStatement.setString(5, wordDto.getWordRus());
			preparedStatement.setString(6, wordDto.getSpeaksRus());
			preparedStatement.setString(7, wordDto.getTranslateAz());
			preparedStatement.setString(8, wordDto.getTranslateTr());
			preparedStatement.setInt(9, wordDto.getId());			
				
			preparedStatement.executeUpdate();
			ConnectDB.closeConnect(connection);	
		} catch (SQLException e) {
			e.getMessage();
		}			
	}
	@Override
	public void delete(int wordId) {
		try (
			Connection connection = ConnectDB.openConnect();
			PreparedStatement preparedStatement = connection.prepareStatement(WordQuery.wordDelete)) {
			preparedStatement.setInt(1, wordId);
			preparedStatement.executeUpdate();
			ConnectDB.closeConnect(connection);	
		} catch (SQLException e) {
			e.getMessage();
		}
	}

}
