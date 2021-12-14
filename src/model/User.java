package model;

public class User {

	private String userName;
	private String passWord;
	private boolean role;
	
	public User() {
	}

	public User(String userName, String passWord, boolean role) {
		this.userName = userName;
		this.passWord = passWord;
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public boolean isRole() {
		return role;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public void setRole(boolean role) {
		this.role = role;
	}
	
}
