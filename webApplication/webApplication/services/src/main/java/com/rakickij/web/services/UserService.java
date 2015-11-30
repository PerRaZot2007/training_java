package com.rakickij.web.services;

import com.rakickij.web.dataaccess.model.User;

public interface UserService {
	void changeName(Long id, String firstName, String secondName);
	
	void changePassword(Long id, String password);
	
	void changeEmail(Long id, String email);
	
	void registerUser(String firstName, String secondName, String email, String password);
	
	User get(Long id);
	
	void delete(Long id);
}
