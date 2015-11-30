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

import com.rakickij.web.dataaccess.dao.CarModelDao;
import com.rakickij.web.dataaccess.mapper.CarModelMapper;
import com.rakickij.web.dataaccess.model.CarModel;

@Repository
public class CarModelDaoImpl implements CarModelDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public Long insert(final CarModel carModel) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection)
					throws SQLException {
				PreparedStatement ps = connection.prepareStatement(
						"INSERT INTO car_model (model_name, car_mark)"
						+ "VALUES (?,?)",
						new String[] { "id" });
				ps.setString(1, carModel.getName());
				ps.setString(2, carModel.getCarMark());
				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().longValue();
	}

	@Override
	public void update(Long id, String name, String carMark) {
		jdbcTemplate.update("UPDATE car_model SET model_name=?, car_mark=? where id=?", name, carMark, id);
	}

	@Override
	public CarModel getById(Long id) {
		return jdbcTemplate.queryForObject("select * from car_model where id=?", new Object[] {id}, new CarModelMapper());
	}

	@Override
	public void delete(Long id) {
		jdbcTemplate.update("DELETE FROM car_model * where id=?", id);
	}

}
