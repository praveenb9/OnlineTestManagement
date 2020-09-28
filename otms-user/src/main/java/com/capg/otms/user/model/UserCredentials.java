package com.capg.otms.user.model;

public class UserCredentials {

	private long userId;
	private String password;
	public UserCredentials() {
		// TODO Auto-generated constructor stub
	}
	
	
	public UserCredentials(long userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}
	
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "UserCredentials [userId=" + userId + ", password=" + password +  "]";
	}
	
	
}
