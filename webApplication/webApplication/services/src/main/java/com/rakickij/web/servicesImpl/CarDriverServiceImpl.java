package com.rakickij.web.servicesImpl;

import org.apache.commons.lang3.math.Fraction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.rakickij.web.services.util.LoggerClass.LOGGER;
import com.rakickij.web.dataaccess.dao.CarDriverDao;
import com.rakickij.web.dataaccess.model.CarDriver;
import com.rakickij.web.services.CarDriverService;

@Service
public class CarDriverServiceImpl implements CarDriverService {

	@Autowired
	private CarDriverDao carDriverDao;

	@Override
	public void updateName(Long id, String firstName, String secondName) {
		carDriverDao.updateName(id, firstName, secondName);
		LOGGER.info("Name of  driver with id = " + id + " changed to " + firstName + " " + secondName);

	}

	@Override
	public void updateTripCount(Long id, Long addTripCount) {
		carDriverDao.updateTripCount(id, addTripCount);
		LOGGER.info("Driver with id= " + id + " now is = " + addTripCount);

	}

	@Override
	public void delete(Long id) {
		carDriverDao.delete(id);
		LOGGER.info("Driver with id= " + id + " was successfuly deleted.");
	}

	@Override
	public CarDriver get(Long id) {
		return carDriverDao.getById(id);
	}

	@Override
	public void addNewDriver(String firstName, String secondName) {
		CarDriver driver = new CarDriver();
		driver.setFirstName(firstName);
		driver.setSecondName(secondName);
		driver.setTripCount(0L);
		carDriverDao.insert(driver);
		LOGGER.info("Driver " + firstName + " " + secondName + " was successfuly added.");
	}

}
