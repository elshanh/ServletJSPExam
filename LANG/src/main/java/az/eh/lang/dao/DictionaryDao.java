package az.eh.lang.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import az.eh.lang.daoImp.DictionaryImpl;
import az.eh.lang.dto.DictionaryDto;
import az.eh.lang.sqlquery.DictionaryQuery;
import az.eh.lang.sqlquery.UserQuery;

public class DictionaryDao implements DictionaryImpl{

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://192.168.0.113:3306/LANG?useSSL=false","root","bM3YSse2P1Da746eMuRnaQsJ6qs3idQR");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}	

	public void insert(DictionaryDto dictionaryDto) {
		
		System.out.println(DictionaryQuery.insertNewWord);
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(DictionaryQuery.insertNewWord)) {
			
			preparedStatement.setString(1, dictionaryDto.getWordEng());
			preparedStatement.setString(2, dictionaryDto.getSpeaksEng());
			preparedStatement.setString(3, dictionaryDto.getWordGer());
			preparedStatement.setString(4, dictionaryDto.getSpeaksGer());
			preparedStatement.setString(5, dictionaryDto.getWordRus());
			preparedStatement.setString(6, dictionaryDto.getSpeaksRus());
			preparedStatement.setString(7, dictionaryDto.getTranslateAz());
			preparedStatement.setString(8, dictionaryDto.getTranslateTr());
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.getMessage();
		}
	}

	@Override
	public void update(DictionaryDto dictionaryDto) {
		System.out.println(DictionaryQuery.updateNewWord);
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(DictionaryQuery.updateNewWord)) {
			
			preparedStatement.setString(1, dictionaryDto.getWordEng());
			preparedStatement.setString(2, dictionaryDto.getSpeaksEng());
			preparedStatement.setString(3, dictionaryDto.getWordGer());
			preparedStatement.setString(4, dictionaryDto.getSpeaksGer());
			preparedStatement.setString(5, dictionaryDto.getWordRus());
			preparedStatement.setString(6, dictionaryDto.getSpeaksRus());
			preparedStatement.setString(7, dictionaryDto.getTranslateAz());
			preparedStatement.setString(8, dictionaryDto.getTranslateTr());
			preparedStatement.setInt(9, dictionaryDto.getId());
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.getMessage();
		}
	}

	@Override
	public void delete(DictionaryDto dictionaryDto) {
		
		System.out.println(DictionaryQuery.deleteWord);
		
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(DictionaryQuery.deleteWord)) {
			
			preparedStatement.setInt(1, dictionaryDto.getId());
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.getMessage();
		}
	}
	@Override
	public DictionaryDto select(DictionaryDto dictionaryDto,String type) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		if (type.toString().equals("all")) {
			try (
				Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.113:3306/LANG?useSSL=false","root","bM3YSse2P1Da746eMuRnaQsJ6qs3idQR");
				PreparedStatement preparedStatement = connection.prepareStatement(DictionaryQuery.gelAllWord)){
				
				System.out.println(preparedStatement);
	            
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	            	dictionaryDto.setId(resultSet.getInt(1));
	            	dictionaryDto.setWordEng(resultSet.getString(2));
	            	dictionaryDto.setSpeaksEng(resultSet.getString(3));
	            	dictionaryDto.setWordGer(resultSet.getString(4));
	            	dictionaryDto.setSpeaksGer(resultSet.getString(5));
	            	dictionaryDto.setWordRus(resultSet.getString(6));
	            	dictionaryDto.setSpeaksRus(resultSet.getString(7));
	            	dictionaryDto.setTranslateAz(resultSet.getString(8));
	            	dictionaryDto.setTranslateTr(resultSet.getString(9));
				}
	            
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		if (type.toString().equals("id")) {
			try (
				Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.113:3306/LANG?useSSL=false","root","bM3YSse2P1Da746eMuRnaQsJ6qs3idQR");
				PreparedStatement preparedStatement = connection.prepareStatement(DictionaryQuery.gelWordById)){
	            
				System.out.println(preparedStatement);
	            
				preparedStatement.setInt(1, dictionaryDto.getId());
				
	            System.out.println(preparedStatement);
	            
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	            	dictionaryDto.setId(resultSet.getInt(1));
	            	dictionaryDto.setWordEng(resultSet.getString(2));
	            	dictionaryDto.setSpeaksEng(resultSet.getString(3));
	            	dictionaryDto.setWordGer(resultSet.getString(4));
	            	dictionaryDto.setSpeaksGer(resultSet.getString(5));
	            	dictionaryDto.setWordRus(resultSet.getString(6));
	            	dictionaryDto.setSpeaksRus(resultSet.getString(7));
	            	dictionaryDto.setTranslateAz(resultSet.getString(8));
	            	dictionaryDto.setTranslateTr(resultSet.getString(9));
				}
	            
			} catch (Exception e) {
				// TODO: handle exception
			}
		}		
		
		return dictionaryDto;
	}

	@Override
	public List<DictionaryDto> selectList(DictionaryDto dictionaryDto, String type) {
		List<DictionaryDto> dictionaryDtos = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		if (type.toString().equals("all")) {
			try (
				Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.113:3306/LANG?useSSL=false","root","bM3YSse2P1Da746eMuRnaQsJ6qs3idQR");
				PreparedStatement preparedStatement = connection.prepareStatement(DictionaryQuery.gelAllWord)){
	            
	            System.out.println(preparedStatement);
	            
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	            	dictionaryDtos.add(new DictionaryDto(
		            	resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),
		            	resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),
		            	resultSet.getString(7),resultSet.getString(8),resultSet.getString(9)
	            	));
				}
	            
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		return dictionaryDtos;
	}

}
