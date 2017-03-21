package com.hw.service;

import com.hw.dao.CarDao;

public class CarServiceImpl implements CarService {

	private CarDao carDao;
	
	public CarServiceImpl(){
		
	}
	
	public CarServiceImpl(CarDao carDao){
		this.carDao = carDao;
	}
	
	@Override
	public boolean payment() {
		
		return carDao.payment();
	}

	/*public void setCarDao(CarDao carDao) {
		this.carDao = carDao;
	}*/

}
