package com.capg.otms.user.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_info_table")
public class User {
	
	@Id
	private long userId;
	private String userName;
	private String userPassword;
	private long userTest;
	private boolean adminOrNot;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public long getUserTest() {
		return userTest;
	}
	public void setUserTest(long userTest) {
		this.userTest = userTest;
	}
	public boolean isAdminOrNot() {
		return adminOrNot;
	}
	public void setAdminOrNot(boolean adminOrNot) {
		this.adminOrNot = adminOrNot;
	}
	public User(long userId, String userName, String userPassword, long userTest, boolean adminOrNot) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userTest = userTest;
		this.adminOrNot = adminOrNot;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (adminOrNot ? 1231 : 1237);
		result = prime * result + (int) (userId ^ (userId >>> 32));
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userPassword == null) ? 0 : userPassword.hashCode());
		result = prime * result + (int) (userTest ^ (userTest >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (adminOrNot != other.adminOrNot)
			return false;
		if (userId != other.userId)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userPassword == null) {
			if (other.userPassword != null)
				return false;
		} else if (!userPassword.equals(other.userPassword))
			return false;
		if (userTest != other.userTest)
			return false;
		return true;
	}
	

}
