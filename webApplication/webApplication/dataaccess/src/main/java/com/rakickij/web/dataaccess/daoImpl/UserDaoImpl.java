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

import com.rakickij.web.dataaccess.dao.UserDao;
import com.rakickij.web.dataaccess.mapper.UserMapper;
import com.rakickij.web.dataaccess.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Long insert(final User user) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection)
					throws SQLException {
				PreparedStatement ps = connection.prepareStatement(
						"INSERT INTO users_table (first_name, second_name, register_date, email, user_password)"
						+ "VALUES (?,?,?,?,?)",
						new String[] { "id" });
				ps.setString(1, user.getFirstName());
				ps.setString(2, user.getSecondName());
				ps.setDate(3, user.getRegisterDate());
				ps.setString(4, user.getEmail());
				ps.setString(5, user.getPassword());
				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().longValue();
	}

	@Override
	public User getById(Long id) {
		return jdbcTemplate.queryForObject("select * from users_table where id=?", new Object[] {id}, new UserMapper());
	}

	@Override
	public void delete(Long id) {
		jdbcTemplate.update("DELETE FROM users_table * WHERE id=?", id);
	}

	@Override
	public void updateName(Long id, String firstName, String secondName) {
		jdbcTemplate.update("UPDATE users_table SET first_name=?, second_name=? WHERE id=?", firstName, secondName, id);
		
	}

	@Override
	public void updatePassword(Long id, String password) {
		jdbcTemplate.update("UPDATE users_table SET user_password=? WHERE id=?", password, id);
		
		
	}

	@Override
	public void updateEmail(Long id, String email) {
		jdbcTemplate.update("UPDATE users_table SET email=? WHERE id=?", email, id);
		
	}

}
