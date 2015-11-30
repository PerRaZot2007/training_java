package com.rakickij.web.servicesImpl;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	}

	@Override
	public void changeTripDriver(Long id, Long driverId) {
		tripDao.updateTripDriver(id, driverId);		
	}

	@Override
	public void changeTripCar(Long id, Long carId) {
		tripDao.updateTripCar(id, carId);
	}

	@Override
	public void delete(Long id) {
		tripDao.delete(id);
		
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
	}

}
