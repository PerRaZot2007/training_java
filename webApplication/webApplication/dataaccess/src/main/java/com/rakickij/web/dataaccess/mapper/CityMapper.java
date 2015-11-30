package com.rakickij.web.dataaccess.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rakickij.web.dataaccess.model.City;

public class CityMapper implements RowMapper<City> {

	@Override
	public City mapRow(ResultSet rs, int arg) throws SQLException {
		City city = new City();
		city.setId(rs.getLong("id"));
		city.setName(rs.getString("city_name"));		
		return city;
	}
	
}
