package az.eh.lang.business;

import az.eh.lang.dao.UserDao;
import az.eh.lang.dto.UserDto;
import az.eh.lang.webdto.UserWebDto;

public class UserOperation {
	
	public static void insert(UserWebDto userWebDto) {
		convertWebToBack(userWebDto);		
	}
	
	private static void convertWebToBack(UserWebDto userWebDto) {
		UserDto userDto = new UserDto();
		
		UserDao dao = new UserDao();
		dao.insert(userDto);
	}

}
