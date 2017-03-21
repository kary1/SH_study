package com.hw.entity;

public class User {

	private String username;
	private String realName;
	private String password;
	private String telphone;
	
	private int version;
	
	public User() {
	}
	public User(String username, String realName, String password, String telphone) {
		this.username = username;
		this.realName = realName;
		this.password = password;
		this.telphone = telphone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
}
