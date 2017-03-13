package com.hw.service;

import com.hw.dao.UserDao;

public class UserServiceImpl implements UserService {

	private UserDao uu;
	private String userName;
	private String color;
	private double balance;
	private String address;
	private UserDao userDao;
	
	public UserServiceImpl(){
		
	}
	public UserServiceImpl(String color, String address, double balance ,UserDao userDao){
		this.color = color;
		this.balance = balance;
		this.address = address;
		this.userDao = userDao;
	}
	
	@Override
	public boolean login() {
		
//		UserDao userDao = new UserDaoImpl();
		System.out.println(userName);
		
		System.out.println(
				"color:"+color 
				+" balance:"+balance
				+" address:"+address);
		
		return userDao.login();
	}

	public void setUserDao(UserDao userDao) {
		this.uu = userDao;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
