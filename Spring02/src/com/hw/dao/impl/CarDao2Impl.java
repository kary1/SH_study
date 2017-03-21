package com.hw.dao.impl;

import org.springframework.stereotype.Repository;

import com.hw.dao.CarDao;

@Repository("carDao2")
public class CarDao2Impl implements CarDao{

	@Override
	public boolean buyCar() {
		
		return false;
	}

}
