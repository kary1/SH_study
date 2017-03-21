package com.hw.dao.impl;

import org.springframework.stereotype.Repository;

import com.hw.dao.CarDao;

@Repository("carDao")
public class CarDaoImpl implements CarDao{

	public boolean buyCar(){
		
		return true;
	}
}
