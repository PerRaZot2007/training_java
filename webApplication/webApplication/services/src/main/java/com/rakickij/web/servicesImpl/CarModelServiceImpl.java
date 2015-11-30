package com.rakickij.web.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.rakickij.web.dataaccess.util.LoggerClass.LOGGER;
import com.rakickij.web.dataaccess.dao.CarModelDao;
import com.rakickij.web.dataaccess.model.CarModel;
import com.rakickij.web.services.CarModelService;

@Service
public class CarModelServiceImpl implements CarModelService {
	
	
	@Autowired
	private CarModelDao carModelDao;
		
	@Override
	public CarModel get(Long id) {
		return carModelDao.getById(id);
	}

	@Override
	public void addNewCarModel(String name, String carMark) {
		CarModel carModel = new CarModel();
		carModel.setName(name);
		carModel.setCarMark(carMark);		
		carModelDao.insert(carModel);
		LOGGER.info("New carmodel has successfuly added." + carModel.toString());
	}

	@Override
	public void changeCarModelName(Long id, String name) {		
		carModelDao.update(id, name, carModelDao.getById(id).getCarMark());
		LOGGER.info("CarModel with id= " +id+" now have new name = " + name);
	}

	@Override
	public void changeCarModelMark(Long id, String carMark) {
		carModelDao.update(id, carModelDao.getById(id).getName(), carMark);
		LOGGER.info("CarModel with id= " +id+" now have new carMark = " + carMark);
	}

	@Override
	public void deleteCarMark(Long id) {
		carModelDao.delete(id);
		LOGGER.info("CarModel with id= " +id+" was successfuly deleted.");
	}

}
