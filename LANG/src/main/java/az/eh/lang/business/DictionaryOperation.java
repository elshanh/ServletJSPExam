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
		DictionaryDto dictionaryDto = new DictionaryDto();
		DictionaryDao dictionaryDao = new DictionaryDao();
		
		List<DictionaryDto> dictionaryDtos = new ArrayList<>();
		dictionaryDtos = dictionaryDao.selectList(dictionaryDto,"all");
		return dictionaryDtos;
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
