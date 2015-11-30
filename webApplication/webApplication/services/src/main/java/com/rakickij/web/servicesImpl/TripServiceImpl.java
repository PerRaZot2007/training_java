package com.rakickij.web.servicesImpl;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.rakickij.web.dataaccess.util.LoggerClass.LOGGER;
import com.rakickij.web.dataaccess.dao.TripDao;
import com.rakickij.web.dataaccess.model.Trip;
import com.rakickij.web.services.TripService;

@Service
public class TripServiceImpl implements TripService{

	@Autowired
	TripDao tripDao;
	
	@Override
	public void changeTripTime(Long id, Date departureDate, Date arrivalDate) {
		tripDao.updateTripTime(id, departureDate, arrivalDate);
		LOGGER.info("Trip with id=" +id+ "now have new time =" + departureDate +" - " + arrivalDate);
	}

	@Override
	public void changeTripDriver(Long id, Long driverId) {
		tripDao.updateTripDriver(id, driverId);	
		LOGGER.info("Trip with id=" +id+ "now have new driver with id= " +driverId);
	}

	@Override
	public void changeTripCar(Long id, Long carId) {
		tripDao.updateTripCar(id, carId);
		LOGGER.info("Trip with id=" +id+ "now have new car with id = " +carId);
	}

	@Override
	public void delete(Long id) {
		tripDao.delete(id);
		LOGGER.info("Trip with id=" +id+ "was successfuly deleted.");
	}

	@Override
	public Trip get(Long id) {
		return tripDao.getById(id);
	}

	@Override
	public void insert(Long driverId, Long carId, Date departureDate, Date arrivalDate, Long departureCityId, Long arrivalCityId) {
		Trip trip = new Trip();
		trip.setDriverId(driverId);
		trip.setCarId(carId);
		trip.setDepartureDate(departureDate);
		trip.setArrivalDate(arrivalDate);
		trip.setDepartureCityId(departureCityId);
		trip.setArrivalCityId(arrivalCityId);
		tripDao.insert(trip);
		LOGGER.info("Trip has been added."+ trip.toString());
	}

}
