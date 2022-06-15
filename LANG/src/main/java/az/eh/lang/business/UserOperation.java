package az.eh.lang.business;

import java.util.ArrayList;
import java.util.List;

import az.eh.lang.dao.UserDao;
import az.eh.lang.dto.UserDto;

public class UserOperation {
	
	public static int loginControl(String usr, String psw) {
		UserDao userDao = new UserDao();
		return userDao.select(usr,psw);
	}
	public static List<UserDto> getAllUsersList() {
		UserDao userDao = new UserDao();
		List<UserDto> userDtos = new ArrayList<>();
		return userDao.selectList();
	}
	public static void insert(UserDto userDto) {
		UserDao userDao = new UserDao();
		userDao.insert(userDto);
	}
	public static UserDto select(int userId) {
		UserDao userDao = new UserDao();
		return userDao.select(userId);
	}
	
	public static void update(UserDto userDto) {
		UserDao userDao = new UserDao();
		userDao.update(userDto);
	}	
	public static void delete(int id) {
		UserDao userDao = new UserDao();
		userDao.delete(id);
	}
}
