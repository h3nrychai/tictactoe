package com.arrdude.henry.pojos;

public class UserPojo {
	private String id;
	private String userName;
	private String password;

	public UserPojo(String userName, String password){
		this.userName = userName;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
