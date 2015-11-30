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

import com.rakickij.web.dataaccess.dao.CityDao;
import com.rakickij.web.dataaccess.mapper.CityMapper;
import com.rakickij.web.dataaccess.model.City;

@Repository
public class CityDaoImpl implements CityDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public void update(Long id, String name) {
		jdbcTemplate.update("UPDATE city_table SET city_name=? where id=?", name, id);
	}

	@Override
	public Long insert(final City city) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection)
					throws SQLException {
				PreparedStatement ps = connection.prepareStatement(
						"INSERT INTO city_table (city_name)"
						+ "VALUES (?)",
						new String[] { "id" });
				ps.setString(1, city.getName());
				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().longValue();
	}

	@Override
	public City getById(Long id) {
		return jdbcTemplate.queryForObject("select * from city_table where id=?", new Object[] {id}, new CityMapper());
	}

	@Override
	public void delete(Long id) {
		jdbcTemplate.update("DELETE FROM city_table * WHERE id=?", id);
	}

}
