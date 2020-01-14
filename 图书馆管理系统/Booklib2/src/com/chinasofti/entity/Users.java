package com.chinasofti.entity;

public class Users {

	public Users(String login, String pwd) {
		userLogin = login;
		userPwd = pwd;
	}

	private String userLogin;
	private String userPwd;

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

}
