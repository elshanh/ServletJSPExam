package az.eh.lang.daoImp;

import java.util.List;

import az.eh.lang.dto.UserDto;

public interface UserImpl {
	
	public int select(String username,String password);
	public List<UserDto> selectList();
	public void insert(UserDto userDto);
	public UserDto select(int userId);
	public void update(UserDto userDto);
	public void delete(int userId);
}
