package com.chinasofti.entity;

public class Admin {
	
	private String login;
	private String pwd;
	
	public Admin(String logins, String pwds){
		login = logins;
		pwd = pwds;
	}

	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPwd() {
		return pwd;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
