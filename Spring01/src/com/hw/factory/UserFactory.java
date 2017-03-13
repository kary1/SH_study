package com.hw.factory;

import com.hw.entity.User;

public class UserFactory {
	
	/**
	 * 静态工厂方法
	 * @return
	 */
	public static User getUser(){
		
		User user = new User();
		
		return user;
	}
}
