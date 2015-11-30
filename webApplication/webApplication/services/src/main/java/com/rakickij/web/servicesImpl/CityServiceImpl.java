package com.rakickij.web.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakickij.web.dataaccess.dao.CityDao;
import com.rakickij.web.dataaccess.model.City;
import static com.rakickij.web.dataaccess.util.LoggerClass.LOGGER;
import com.rakickij.web.services.CityService;
@Service
public class CityServiceImpl implements CityService {
	
	@Autowired
	CityDao cityDao;
	
	@Override
	public void updateCityName(Long id, String name) {
		cityDao.update(id, name);

		LOGGER.info("City with id= " + id + " changed city name to = " + name);
	}

	@Override
	public void addNewCity(String name) {
		City city = new City();
		city.setName(name);		
		cityDao.insert(city);
		LOGGER.info("City = " + name + " was successfuly added.");
	}

	@Override
	public City get(Long id) {
		return cityDao.getById(id);
	}

	@Override
	public void deleteCity(Long id) {
		cityDao.delete(id);
		LOGGER.info("City with id = " + id +" was successfuly deleted.");
	}

}
