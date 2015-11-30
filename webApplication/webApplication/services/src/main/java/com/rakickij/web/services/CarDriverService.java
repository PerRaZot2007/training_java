package com.rakickij.web.services;

import com.rakickij.web.dataaccess.model.CarDriver;

public interface CarDriverService {
	void updateName(Long id, String firstName, String secondName);
	
	void updateTripCount(Long id, Long tripCount);
	
	void delete(Long id);
	
	CarDriver get(Long id);
	
	void addNewDriver(String firstName, String secondName);
}
