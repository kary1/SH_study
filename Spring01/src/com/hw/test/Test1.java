package com.hw.test;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hw.dao.UserDao;
import com.hw.dao.UserDaoImpl;
import com.hw.service.CarService;
import com.hw.service.UserService;

public class Test1 {

	@Test
	public void test1(){
//		UserDao userDao = new UserDaoImpl();
		
		//加载spring配置文件，生成bean工厂
		BeanFactory bf = new ClassPathXmlApplicationContext("spring.xml");
		
//		UserDao userDao1 = bf.getBean(UserDao.class);
		
		UserDao userDao2 = (UserDao) bf.getBean("userDao1");
		
		UserDao userDao3 = bf.getBean("userDao2",UserDao.class);
		
		UserDao userDao4 = bf.getBean("userDao002",UserDao.class);
		
		userDao4.login();
	}
	
	@Test
	public void test2(){
		BeanFactory bf = new ClassPathXmlApplicationContext("spring.xml");
		UserService userService = bf.getBean("userService1", UserService.class);
		
		userService.login();
	}
	
	@Test
	public void test3(){
		BeanFactory bf = new ClassPathXmlApplicationContext("spring.xml");
		CarService carService = bf.getBean("carService1", CarService.class);
		
		System.out.println(carService.payment());
	}
}
