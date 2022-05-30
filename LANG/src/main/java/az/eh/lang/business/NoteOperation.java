package az.eh.lang.business;

import az.eh.lang.dao.NoteDao;
import az.eh.lang.dto.NoteDto;
import az.eh.lang.webdto.NoteWebDto;

public class NoteOperation {
	
	public static void insert(NoteWebDto noteWebDto) {
		convertWebToBack(noteWebDto);		
	}
	
	private static void convertWebToBack(NoteWebDto noteWebDto) {
		NoteDto noteDto = new NoteDto();
		
		NoteDao dao = new NoteDao();
		dao.insert(noteDto);
	}

}
