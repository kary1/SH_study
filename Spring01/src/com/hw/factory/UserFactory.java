package com.hw.factory;

import com.hw.entity.User;

public class UserFactory {
	
	/**
	 * ��̬��������
	 * @return
	 */
	public static User getUser(){
		
		User user = new User();
		
		return user;
	}
}
