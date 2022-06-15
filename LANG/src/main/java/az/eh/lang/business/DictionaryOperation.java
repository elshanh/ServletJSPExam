package az.eh.lang.business;

import java.util.ArrayList;
import java.util.List;

import az.eh.lang.dao.DictionaryDao;
import az.eh.lang.dto.DictionaryDto;
import az.eh.lang.webdto.DictionaryWebDto;

public class DictionaryOperation {
	
	public static DictionaryDto getAllWord() {
		DictionaryDao dictionaryDao = new DictionaryDao();
		
		DictionaryDto dictionaryDto = new DictionaryDto();
		dictionaryDto = dictionaryDao.select(dictionaryDto, "all");
		return dictionaryDto;
	}
	public static List<DictionaryDto> getAllWordList() {
		List<DictionaryDto> dictionaryDtos = new ArrayList<>();
		DictionaryDto dictionaryDto = new DictionaryDto();
		DictionaryDao dictionaryDao = new DictionaryDao(); 
		return dictionaryDao.selectList(dictionaryDto,"all");
	}
	public static DictionaryDto getWordById(int id) {
		
		DictionaryDto dictionaryDto = new DictionaryDto();
		dictionaryDto.setId(id);
		
		DictionaryDao dictionaryDao = new DictionaryDao();
		dictionaryDto = dictionaryDao.select(dictionaryDto,"id");
		
		return dictionaryDto;
	}	
	
	public static void delete(int id) {
		DictionaryDto dictionaryDto = new DictionaryDto();
		dictionaryDto.setId(id);
		
		DictionaryDao dictionaryDao = new DictionaryDao();
		dictionaryDao.delete(dictionaryDto);
	}
	
	public static void update(DictionaryDto dictionaryDto) {
		DictionaryDao dictionaryDao = new DictionaryDao();
		dictionaryDao.update(dictionaryDto);		
	}	
	
	public static void insert(DictionaryWebDto dictionaryWebDto) {
		convertWebToBack(dictionaryWebDto);		
	}
	
	private static void convertWebToBack(DictionaryWebDto dictionaryWebDto) {
		DictionaryDto dictionaryDto = new DictionaryDto();
		dictionaryDto.setWordEng(dictionaryWebDto.getWordEng());
		dictionaryDto.setSpeaksEng(dictionaryWebDto.getSpeaksEng());
		dictionaryDto.setWordGer(dictionaryWebDto.getWordGer());
		dictionaryDto.setSpeaksGer(dictionaryWebDto.getSpeaksGer());
		dictionaryDto.setWordRus(dictionaryWebDto.getWordRus());
		dictionaryDto.setSpeaksRus(dictionaryWebDto.getSpeaksRus());
		dictionaryDto.setTranslateAz(dictionaryWebDto.getTranslateAz());
		dictionaryDto.setTranslateTr(dictionaryWebDto.getTranslateTr());
		
		DictionaryDao dao = new DictionaryDao();
		dao.insert(dictionaryDto);
	}

}
