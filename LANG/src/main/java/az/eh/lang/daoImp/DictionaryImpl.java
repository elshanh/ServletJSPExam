package az.eh.lang.daoImp;

import az.eh.lang.dto.DictionaryDto;

public interface DictionaryImpl {
	
	public void insert(DictionaryDto dictionaryDto);
	public void update(DictionaryDto dictionaryDto);
	public void delete(DictionaryDto dictionaryDto);
	public DictionaryDto select(DictionaryDto dictionaryDto);

}
