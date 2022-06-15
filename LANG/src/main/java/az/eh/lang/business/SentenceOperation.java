package az.eh.lang.business;

import java.util.ArrayList;
import java.util.List;

import az.eh.lang.dao.SentenceDao;
import az.eh.lang.dto.SentenceDto;

public class SentenceOperation {
	
	public static List<SentenceDto> getAllSentenceList() {
		SentenceDao sentenceDao = new SentenceDao();
		List<SentenceDto> sentenceDtos = new ArrayList<>();
		return sentenceDao.selectList();
	}
	public static void insert(SentenceDto sentenceDto) {
		SentenceDao sentenceDao = new SentenceDao();
		sentenceDao.insert(sentenceDto);
	}
	public static SentenceDto select(int userId) {
		SentenceDao sentenceDao = new SentenceDao();
		return sentenceDao.select(userId);
	}
	
	public static void update(SentenceDto sentenceDto) {
		SentenceDao sentenceDao = new SentenceDao();
		sentenceDao.update(sentenceDto);
	}	
	public static void delete(int id) {
		SentenceDao sentenceDao = new SentenceDao();
		sentenceDao.delete(id);
	}

}
