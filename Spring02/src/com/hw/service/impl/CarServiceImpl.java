package com.hw.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hw.dao.CarDao;
import com.hw.service.CarService;

@Service("carService")
public class CarServiceImpl implements CarService{

	//Ĭ��ʹ��byTypeװ�䣬����Ҳ�����ʹ��byName
	//��spring����ṩ
	@Autowired(required=false)
	@Qualifier(value="carDao")
	private CarDao carDao;
	//Ĭ�ϰ���byName���ң�����Ҳ���������byType
	//��javaEE�ṩ��ע��
	@Resource(name="carDao")
	private CarDao carDao1;
	
	@Override
	public void buyCar(double price) {
		if(carDao.buyCar()){
			System.out.println("����һ����");
		}
		
		int a = 1/0;
		
		return;
	}

}
