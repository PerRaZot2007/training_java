package com.rakickij.web.dataaccess.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rakickij.web.dataaccess.model.CarDriver;


public class CarDriverMapper implements RowMapper<CarDriver> {
	@Override
	public CarDriver mapRow(ResultSet rs, int arg) throws SQLException {
		CarDriver driver = new CarDriver();
		driver.setId(rs.getLong("id"));
		driver.setFirstName(rs.getString("first_name"));
		driver.setSecondName(rs.getString("second_name"));
		driver.setTripCount(rs.getLong("trip_count"));
		driver.setWorkStart(rs.getDate("work_start"));
		
		return driver;
	}

}
