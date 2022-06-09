package az.eh.lang.business;

import az.eh.lang.dao.UserDao;
import az.eh.lang.dto.UserDto;
import az.eh.lang.webdto.UserWebDto;

public class UserOperation {
	
	public static int loginControl(String usr, String psw) {
	    int result = 0;
		
		UserDto userDto = new UserDto();
	    userDto.setUsername(usr);
	    userDto.setPassword(psw);
	    
	    UserDao userDao = new UserDao();
	    userDto = userDao.select(userDto,"login");
	    
	    if (userDto.getState().equals("A")) {
	    	if (userDto.getStatus().equals("Admin")) {
	    		result = 1;
	    	}else {
	    		result = 2;
	    	}
	    }
		return result;
	}		
	
	public static void insert(UserWebDto userWebDto) {
		convertWebToBack(userWebDto);		
	}
	
	private static void convertWebToBack(UserWebDto userWebDto) {
		UserDto userDto = new UserDto();
		
		UserDao dao = new UserDao();
		dao.insert(userDto);
	}

}
