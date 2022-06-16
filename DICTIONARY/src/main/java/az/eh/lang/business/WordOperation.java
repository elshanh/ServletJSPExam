package az.eh.lang.business;

import java.util.ArrayList;
import java.util.List;

import az.eh.lang.dao.WordDao;
import az.eh.lang.dto.WordDto;

public class WordOperation {
	
	public static List<WordDto> getAllWordList() {
		WordDao wordDao = new WordDao();
		List<WordDto> wordDtos = new ArrayList<>();
		return wordDao.selectList();
	}
	public static void insert(WordDto wordDto) {
		WordDao wordDao = new WordDao();
		wordDao.insert(wordDto);
	}
	public static WordDto select(int userId) {
		WordDao wordDao = new WordDao();
		return wordDao.select(userId);
	}
	
	public static void update(WordDto wordDto) {
		WordDao wordDao = new WordDao();
		wordDao.update(wordDto);
	}	
	public static void delete(int id) {
		WordDao wordDao = new WordDao();
		wordDao.delete(id);
	}

}
