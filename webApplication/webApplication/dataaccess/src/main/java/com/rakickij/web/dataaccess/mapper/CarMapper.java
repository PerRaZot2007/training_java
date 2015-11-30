package com.rakickij.web.dataaccess.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rakickij.web.dataaccess.model.Car;

public final class CarMapper implements RowMapper<Car> {

	@Override
	public Car mapRow(ResultSet rs, int arg) throws SQLException {
		Car car = new Car();
		car.setId(rs.getLong("id"));
		car.setNumberPlate(rs.getString("number_plate"));
		car.setCondition(rs.getString("condition"));
		car.setCarModelId(rs.getLong("car_model_id"));
		return car;
	}

}
