package az.eh.lang.daoImp;

import java.util.List;

import az.eh.lang.dto.SentenceDto;

public interface SentenceImpl {
	
	public List<SentenceDto> selectList();
	public void insert(SentenceDto sentenceDto);
	public SentenceDto select(int sentenceId);
	public void update(SentenceDto sentenceDto);
	public void delete(int sentenceId);

}
