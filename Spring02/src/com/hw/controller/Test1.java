package com.hw.controller;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.hw.service.CarService;
import com.hw.service.impl.CarServiceImpl;

@Controller("test1")
//@Component
public class Test1 {

	@Test
	public void test1(){
		BeanFactory bf = new ClassPathXmlApplicationContext("spring.xml");
		CarService carService = bf.getBean("carService",CarService.class);
		
		carService.buyCar(-100000);
	}
	
}
