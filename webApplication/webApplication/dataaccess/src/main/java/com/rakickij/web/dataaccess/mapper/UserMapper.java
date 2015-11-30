package com.rakickij.web.dataaccess.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rakickij.web.dataaccess.model.User;

public class UserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		
		User user = new User();
		user.setId(rs.getLong("id"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("user_password"));
		user.setFirstName(rs.getString("first_name"));
		user.setSecondName(rs.getString("second_name"));
		user.setRegisterDate(rs.getDate("register_date"));
		
		return user;
		
	}
	
}
