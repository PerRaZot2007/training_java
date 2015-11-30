package com.rakickij.web.dataaccess.dao;

import com.rakickij.web.dataaccess.model.Car;

public interface CarDao {
	
	void updateCarConditon(Long id, String condition);
	
	void updateCarNumberPlate(Long id, String newNumberPlate);
	
	void deleteCar(Long id);
	
	Long insert(Car car);
	
	Car getById(Long carId);
}
