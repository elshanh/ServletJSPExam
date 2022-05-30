package az.eh.lang.business;

import az.eh.lang.dao.DictionaryDao;
import az.eh.lang.dto.DictionaryDto;
import az.eh.lang.webdto.DictionaryWebDto;

public class DictionaryOperation {
	
	public static void insert(DictionaryWebDto dictionaryWebDto) {
		convertWebToBack(dictionaryWebDto);		
	}
	
	private static void convertWebToBack(DictionaryWebDto dictionaryWebDto) {
		DictionaryDto dictionaryDto = new DictionaryDto();
		
		DictionaryDao dao = new DictionaryDao();
		dao.insert(dictionaryDto);
	}

}
