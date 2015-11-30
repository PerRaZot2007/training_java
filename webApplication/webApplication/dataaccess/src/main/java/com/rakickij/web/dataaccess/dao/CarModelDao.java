package com.rakickij.web.dataaccess.dao;

import com.rakickij.web.dataaccess.model.CarModel;

public interface CarModelDao {
	Long insert(CarModel carModel);

	void update(Long id, String name, String carMark);
	
	void delete(Long id);
	
	CarModel getById(Long id);
}
