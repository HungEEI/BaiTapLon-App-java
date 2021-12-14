package model;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {

	List<User> ls1 = new ArrayList<>();
	List<User> ls2 = new ArrayList<>();
	List<User> ls3 = new ArrayList<>();

	public UserDAO() {
		
		ls1.add(new User("admin", "123", true));	
		ls2.add(new User("sinhVien", "123", true));
		ls3.add(new User("giaoVien", "123", true));
	} 
	
	
	public boolean checkLogIn(String name, String pass) {
		for(User u : ls1) {
			
			if(u.getUserName().equals(name) && u.getPassWord().equals(pass)) {
				return true;
			}
			
		}
		return false;
	}	
	
	public boolean checkLogIn2(String name, String pass) {
		for(User u : ls2) {
			
			if(u.getUserName().equals(name) && u.getPassWord().equals(pass)) {
				return true;
			}
			
		}
		return false;
	}	
	
	public boolean checkLogIn3(String name, String pass) {
		for(User u : ls3) {
			
			if(u.getUserName().equals(name) && u.getPassWord().equals(pass)) {
				return true;
			}
			
		}
		return false;
	}	
}
