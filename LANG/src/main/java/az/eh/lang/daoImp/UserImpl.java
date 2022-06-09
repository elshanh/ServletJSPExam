package az.eh.lang.daoImp;

import az.eh.lang.dto.UserDto;

public interface UserImpl {
	
	public void insert(UserDto userDto);
	public void update(UserDto userDto);
	public void delete(UserDto userDto);
	public UserDto select(UserDto userDto,String type);

}
