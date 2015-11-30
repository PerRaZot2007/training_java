package com.rakickij.web.dataaccess.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.rakickij.web.dataaccess.dao.CarDao;
import com.rakickij.web.dataaccess.mapper.CarMapper;
import com.rakickij.web.dataaccess.model.Car;

@Repository
public class CarDaoImpl implements CarDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void updateCarConditon(Long id, String condition) {
		jdbcTemplate.update("UPDATE car_table SET condition=? where id=?", condition, id);
	}

	@Override
	public void updateCarNumberPlate(Long id, String newNumberPlate) {
		jdbcTemplate.update("UPDATE car_table SET number_plate=? where id=?", newNumberPlate, id);
	}

	@Override
	public Long insert(final Car car) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection)
					throws SQLException {
				PreparedStatement ps = connection.prepareStatement(
						"INSERT INTO car_table (number_plate, condition, car_model_id)"
						+ "VALUES (?,?,?)",
						new String[] { "id" });
				ps.setString(1, car.getNumberPlate());
				ps.setString(2, car.getCondition());
				ps.setLong(3, car.getCarModelId());
				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().longValue();
	}

	@Override
	public Car getById(Long carId) {
		return jdbcTemplate.queryForObject("select * from car_table where id=?", new Object[] {carId}, new CarMapper());
	}

	@Override
	public void deleteCar(Long id) {
		jdbcTemplate.update("DELETE FROM car_table * where id=?", id);
	}
	
	
}
