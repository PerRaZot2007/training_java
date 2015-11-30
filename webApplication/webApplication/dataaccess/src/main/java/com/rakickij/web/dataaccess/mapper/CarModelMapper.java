package com.rakickij.web.dataaccess.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rakickij.web.dataaccess.model.CarModel;

public class CarModelMapper implements RowMapper<CarModel>{
	@Override
	public CarModel mapRow(ResultSet rs, int arg) throws SQLException {
		CarModel carModel = new CarModel();
		carModel.setId(rs.getLong("id"));
		carModel.setName(rs.getString("model_name"));
		carModel.setCarMark(rs.getString("car_mark"));
		return carModel;
	}
}
