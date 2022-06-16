package az.eh.lang.daoImp;

import java.util.List;

import az.eh.lang.dto.NoteDto;

public interface NoteImpl {
	
	public List<NoteDto> selectList();
	public void insert(NoteDto noteDto);
	public NoteDto select(int noteId);
	public void update(NoteDto noteDto);
	public void delete(int noteId);	

}
