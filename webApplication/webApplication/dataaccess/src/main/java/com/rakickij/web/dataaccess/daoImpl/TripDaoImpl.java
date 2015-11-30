package com.rakickij.web.dataaccess.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.rakickij.web.dataaccess.dao.TripDao;
import com.rakickij.web.dataaccess.mapper.TripMapper;
import com.rakickij.web.dataaccess.model.Trip;

@Repository
public class TripDaoImpl implements TripDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void delete(Long id) {
		jdbcTemplate.update("DELETE FROM trip_table * WHERE id=?", id);
	}

	@Override
	public Trip getById(Long id) {
		return jdbcTemplate.queryForObject("select * from trip_table where id=?", new Object[] { id }, new TripMapper());
	}

	@Override
	public Long insert(final Trip trip) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(
						"INSERT INTO trip_table (driver_id, car_id, departure_date, arrival_date, departure_city_id, arrival_city_id)"
								+ "VALUES (?,?,?,?,?,?)",
						new String[] { "id" });
				ps.setLong(1, trip.getDriverId());
				ps.setLong(2, trip.getCarId());
				ps.setDate(3, trip.getDepartureDate());
				ps.setDate(4, trip.getArrivalDate());
				ps.setLong(5, trip.getDepartureCityId());
				ps.setLong(6, trip.getArrivalCityId());

				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().longValue();
	}

	@Override
	public void updateTripTime(Long id, Date departureDate, Date arrivalDate) {
		jdbcTemplate.update("UPDATE trip_table SET departure_date=?, arrival_date=? WHERE id=?", departureDate, arrivalDate, id);
	}

	@Override
	public void updateTripDriver(Long id, Long driverId) {
		jdbcTemplate.update("UPDATE trip_table SET driver_id=? WHERE id=?", driverId, id);

	}

	@Override
	public void updateTripCar(Long id, Long carId) {
		jdbcTemplate.update("UPDATE trip_table SET car_id=? WHERE id=?", carId, id);

	}

}
