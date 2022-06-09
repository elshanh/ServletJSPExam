package az.eh.lang.daoImp;

import java.util.List;

import az.eh.lang.dto.DictionaryDto;

public interface DictionaryImpl {
	
	public void insert(DictionaryDto dictionaryDto);
	public void update(DictionaryDto dictionaryDto);
	public void delete(DictionaryDto dictionaryDto);
	public DictionaryDto select(DictionaryDto dictionaryDto,String type);
	public List<DictionaryDto> selectList(DictionaryDto dictionaryDto,String type);

}
