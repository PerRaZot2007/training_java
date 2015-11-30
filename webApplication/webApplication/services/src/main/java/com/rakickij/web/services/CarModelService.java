package com.rakickij.web.services;

import com.rakickij.web.dataaccess.model.CarModel;

public interface CarModelService {	
	void addNewCarModel(String name, String carMark);
	
	void changeCarModelName(Long id, String name);
	
	void changeCarModelMark(Long id, String carMark);
	
	void deleteCarMark(Long id);

	CarModel get(Long Id);
}
