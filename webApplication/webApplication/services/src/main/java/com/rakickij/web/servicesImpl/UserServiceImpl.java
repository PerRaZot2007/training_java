package com.rakickij.web.servicesImpl;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakickij.web.dataaccess.dao.UserDao;
import com.rakickij.web.dataaccess.model.User;
import com.rakickij.web.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	
	@Override
	public void changeName(Long id, String firstName, String secondName) {
		userDao.updateName(id, firstName, secondName);
	}

	@Override
	public void changePassword(Long id, String password) {
		userDao.updatePassword(id, password);
	}

	@Override
	public void changeEmail(Long id, String email) {
		userDao.updateEmail(id, email);
	}

	@Override
	public void registerUser(String firstName, String secondName, String email, String password) {
		User user = new User();
		user.setFirstName(firstName);
		user.setSecondName(secondName);
		user.setEmail(email);
		user.setPassword(password);
		//user.setRegisterDate(new Date(user.getRegisterDate().getTime()));
		userDao.insert(user);
	}

	@Override
	public User get(Long id) {
		return userDao.getById(id);
	}

	@Override
	public void delete(Long id) {
		userDao.delete(id);
	}

	
	
}
