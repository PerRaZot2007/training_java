package com.rakickij.web.dataaccess.dao;

import java.sql.Date;

import com.rakickij.web.dataaccess.model.Trip;

public interface TripDao {
	void updateTripTime(Long id, Date departureDate, Date arrivalDate);
	
	void updateTripDriver(Long id, Long driverId);
	
	void updateTripCar(Long id , Long carId);

	void delete(Long id);

	Trip getById(Long id);

	Long insert(Trip trip);
}
