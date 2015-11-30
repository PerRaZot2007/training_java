package com.rakickij.web.services;

import java.sql.Date;

import com.rakickij.web.dataaccess.model.Trip;

public interface TripService {
	void changeTripTime(Long id, Date departureDate, Date arrivalDate);

	void changeTripDriver(Long id, Long driverId);

	void changeTripCar(Long id, Long carId);

	void delete(Long id);

	Trip get(Long id);

	void insert(Long driverId, Long carId, Date departureDate, Date arrivalDate, Long departureCityId, Long arrivalCityId);
}
