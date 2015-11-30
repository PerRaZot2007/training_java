package com.rakickij.web.dataaccess.dao;

import com.rakickij.web.dataaccess.model.User;

public interface UserDao {
	void updateName(Long id, String firstName, String secondName);
	
	void updatePassword(Long id, String password);
	
	void updateEmail(Long id, String email);
	
	Long insert(User user);
	
	User getById(Long id);
	
	void delete(Long id);
}
