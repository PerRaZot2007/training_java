package com.rakickij.web.dataaccess.dao;

import com.rakickij.web.dataaccess.model.City;

public interface CityDao {
	void update(Long id, String name);
	
	Long insert(City city);
	
	City getById(Long id);
	
	void delete(Long id);
}
