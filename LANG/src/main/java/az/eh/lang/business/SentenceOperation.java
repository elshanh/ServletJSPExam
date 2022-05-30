package az.eh.lang.business;

import az.eh.lang.dao.SentenceDao;
import az.eh.lang.dto.SentenceDto;
import az.eh.lang.webdto.SentenceWebDto;

public class SentenceOperation {
	
	public static void insert(SentenceWebDto sentenceWebDto) {
		convertWebToBack(sentenceWebDto);		
	}
	
	private static void convertWebToBack(SentenceWebDto sentenceWebDto) {
		SentenceDto sentenceDto = new SentenceDto();
		
		SentenceDao dao = new SentenceDao();
		dao.insert(sentenceDto);
	}

}
