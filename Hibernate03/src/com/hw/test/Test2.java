package com.hw.test;

import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hw.entity.User;
import com.hw.util.HBUtils;

public class Test2 {
	
	@Test
	public void addUser(){
		
		Session session = HBUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		User user1 = new User("zengxiaoxian","ÔøÐ¡ÏÍ","123","13625025025");
		
		session.save(user1);
		
		tx.commit();
		
		session.close();
	}
	
	@Test
	public void modifyUser(){
		
		Session session = HBUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		User user1 = (User) session.get(User.class, "zengxiaoxian",LockOptions.UPGRADE);
		
		user1.setPassword("321");
		
		tx.commit();
		
		session.close();
	}
	
	@Test
	public void query(){
		Session session = HBUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		User user1 = (User) session.get(User.class, "zengxiaoxian");
		
		System.out.println(user1);
	}
}
