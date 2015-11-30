package com.rakickij.web.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import static com.rakickij.web.dataaccess.util.LoggerClass.LOGGER;
import com.rakickij.web.dataaccess.dao.CarDao;
import com.rakickij.web.dataaccess.model.Car;
import com.rakickij.web.services.CarService;

@Service
public class CarServiceImpl implements CarService{
	
	
	@Autowired
	private CarDao carDao;
	 
	
	@Override
	public void updateCarNumber(Long id, String nubmer) {
		carDao.updateCarNumberPlate(id, nubmer);
		LOGGER.info("Car with id = " + id  + " now have number plate = " + nubmer);
	}

	@Override
	public void insertCar(String numberPlate, String condition, Long carModelId) {
		Car car = new Car();
		car.setNumberPlate(numberPlate);
		car.setCondition(condition);
		car.setCarModelId(carModelId);
		carDao.insert(car);
		LOGGER.info("Car added successfuly.");
	}

	@Override
	public void updateCarCondition(Long id, String condition) {
		carDao.updateCarConditon(id, condition);
		LOGGER.info("Condition of car with id = " + id + "has been set to =" + condition);
	}

	@Override
	public Car get(Long id) {
		return carDao.getById(id);
	}

	@Override
	public void deleteCar(Long id) {
		carDao.deleteCar(id);
		LOGGER.info("Car with id = " + id + "was successfuly deleted.");
	}
	
}
