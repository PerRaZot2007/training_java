package com.rakickij.web.dataaccess.dao;

import com.rakickij.web.dataaccess.model.CarDriver;

public interface CarDriverDao {
	void updateName(Long id, String firstName, String secondName);
	
	void updateTripCount(Long id, Long tripCount);
	
	void delete(Long id);
	
	CarDriver getById(Long id);
	
	Long insert(CarDriver driver);
}
