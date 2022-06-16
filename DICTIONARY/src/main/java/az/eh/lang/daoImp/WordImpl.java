package az.eh.lang.daoImp;

import java.util.List;
import az.eh.lang.dto.WordDto;

public interface WordImpl {
	
	public List<WordDto> selectList();
	public void insert(WordDto wordDto);
	public WordDto select(int wordId);
	public void update(WordDto wordDto);
	public void delete(int wordId);	

}
