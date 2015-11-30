package com.rakickij.web.dataaccess.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rakickij.web.dataaccess.model.Trip;


public class TripMapper implements RowMapper<Trip> {
	@Override
	public Trip mapRow(ResultSet rs, int arg) throws SQLException {
		Trip trip = new Trip();
		trip.setId(rs.getLong("id"));
		trip.setDriverId(rs.getLong("driver_id"));
		trip.setCarId(rs.getLong("car_id"));
		trip.setDepartureDate(rs.getDate("departure_date"));
		trip.setArrivalDate(rs.getDate("arrival_date"));
		trip.setDepartureCityId(rs.getLong("departure_city_id"));
		trip.setArrivalCityId(rs.getLong("arrival_city_id"));
		return trip;
	}
}
