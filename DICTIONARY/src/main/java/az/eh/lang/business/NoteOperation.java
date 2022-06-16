package az.eh.lang.business;

import java.util.ArrayList;
import java.util.List;

import az.eh.lang.dao.NoteDao;
import az.eh.lang.dto.NoteDto;

public class NoteOperation {
	
	public static List<NoteDto> getAllNoteList() {
		NoteDao noteDao = new NoteDao();
		List<NoteDto> noteDtos = new ArrayList<>();
		return noteDao.selectList();
	}
	public static void insert(NoteDto noteDto) {
		NoteDao noteDao = new NoteDao();
		noteDao.insert(noteDto);
	}
	public static NoteDto select(int userId) {
		NoteDao noteDao = new NoteDao();
		return noteDao.select(userId);
	}
	
	public static void update(NoteDto noteDto) {
		NoteDao noteDao = new NoteDao();
		noteDao.update(noteDto);
	}	
	public static void delete(int id) {
		NoteDao noteDao = new NoteDao();
		noteDao.delete(id);
	}
}
