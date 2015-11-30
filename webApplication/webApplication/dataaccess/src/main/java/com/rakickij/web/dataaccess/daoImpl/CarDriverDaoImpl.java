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

import com.rakickij.web.dataaccess.dao.CarDriverDao;
import com.rakickij.web.dataaccess.mapper.CarDriverMapper;
import com.rakickij.web.dataaccess.model.CarDriver;

@Repository
public class CarDriverDaoImpl implements CarDriverDao{
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void updateName(Long id, String firstName, String secondName) {
		jdbcTemplate.update("UPDATE drivers_table SET first_name=?, second_name=? WHERE id=?", firstName, secondName, id);
	}

	@Override
	public void delete(Long id) {
		jdbcTemplate.update("DELETE FROM drivers_table * where id=?", id);
	}

	@Override
	public CarDriver getById(Long id) {
		return jdbcTemplate.queryForObject("select * from drivers_table where id=?", new Object[] {id}, new CarDriverMapper());
	}

	@Override
	public Long insert(final CarDriver driver) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection)
					throws SQLException {
				PreparedStatement ps = connection.prepareStatement(
						"INSERT INTO drivers_table (first_name, second_name, trip_count)"
						+ "VALUES (?,?,?)",
						new String[] { "id" });
				ps.setString(1, driver.getFirstName());
				ps.setString(2, driver.getSecondName());
				ps.setLong(3, driver.getTripCount());
				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().longValue();
	}

	@Override
	public void updateTripCount(Long id, Long tripCount) {
		jdbcTemplate.update("UPDATE drivers_table SET trip_count=? where id=?", tripCount, id);
	}

}
