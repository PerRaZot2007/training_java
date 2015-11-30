package com.rakickij.web.services;

import com.rakickij.web.dataaccess.model.Car;

public interface CarService {
	void updateCarNumber(Long id, String number);
	
	void updateCarCondition(Long id, String Condition);
	
	void insertCar(String numberPlate, String condition, Long carModelId);
	
	void deleteCar(Long id);
	
	Car get(Long id);
}
