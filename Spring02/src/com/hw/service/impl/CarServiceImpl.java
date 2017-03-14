package com.hw.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hw.dao.CarDao;
import com.hw.service.CarService;

@Service("carService")
public class CarServiceImpl implements CarService{

	//默认使用byType装配，如果找不到，使用byName
	//由spring框架提供
	@Autowired(required=false)
	@Qualifier(value="carDao")
	private CarDao carDao;
	//默认按照byName查找，如果找不到，按照byType
	//由javaEE提供的注解
	@Resource(name="carDao")
	private CarDao carDao1;
	
	@Override
	public void buyCar(double price) {
		if(carDao.buyCar()){
			System.out.println("买了一辆车");
		}
		
		int a = 1/0;
		
		return;
	}

}
