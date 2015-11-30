package com.rakickij.web.services;

import com.rakickij.web.dataaccess.model.City;

public interface CityService {
	void updateCityName(Long id, String name);
	
	void addNewCity(String name);
	
	City get(Long id);
	
	void deleteCity(Long id);
}
