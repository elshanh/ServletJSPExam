package az.eh.lang.daoImp;

import az.eh.lang.dto.SentenceDto;

public interface SentenceImpl {
	
	public void insert(SentenceDto sentenceDto);
	public void update(SentenceDto sentenceDto);
	public void delete(SentenceDto sentenceDto);
	public SentenceDto select(SentenceDto sentenceDto);

}
