package miniProject.service;

import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import miniProject.entity.User;

public class UserService {
	private static UserService service = new UserService();
	private UserService() {}
	public static UserService getInstance() {
		return service;
	}
	
	private List<User> list = new ArrayList<>();
	
	//회원가입, 로그인
	public boolean join(User user) {
		String inputPassword = user.getPassword();
		String encodedPassword = BCrypt.hashpw(inputPassword, BCrypt.gensalt());
		user.setPassword(encodedPassword);
		list.add(user);
		return true;
	}
	public boolean login(User user) {
		String inputUsername = user.getUsername();
		String inputPassword = user.getPassword();
		String encodedPassword = null;
		for(User u:list) {
			if(u.getUsername().equals(inputUsername)==true) 
				encodedPassword = u.getPassword();
		}
		if(encodedPassword==null) {
			return false;
		}
		return BCrypt.checkpw(inputPassword, encodedPassword);
	}
	public String find(String email) {
		for(User u:list) {
			if(u.getEmail().equals(email)==true) {
				return u.getUsername();
			}
		}
		return null;
	}
}
