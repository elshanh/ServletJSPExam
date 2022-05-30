package az.eh.lang.daoImp;

import az.eh.lang.dto.NoteDto;

public interface NoteImpl {
	
	public void insert(NoteDto noteDto);
	public void update(NoteDto noteDto);
	public void delete(NoteDto noteDto);
	public NoteDto select(NoteDto noteDto);

}
