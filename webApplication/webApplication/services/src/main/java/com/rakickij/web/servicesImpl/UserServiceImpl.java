package com.rakickij.web.servicesImpl;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.rakickij.web.dataaccess.util.LoggerClass.LOGGER;
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
		LOGGER.info("User with id = "+ id +"now have new name " + firstName+" "+secondName);
	}

	@Override
	public void changePassword(Long id, String password) {
		userDao.updatePassword(id, password);
		LOGGER.info("User with id= "+id+" now have new password= "+ password);
	}

	@Override
	public void changeEmail(Long id, String email) {
		userDao.updateEmail(id, email);
		LOGGER.info("User with id= "+id+" now have new email= "+ email);
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
		LOGGER.info("New user was successfuly added." + user.toString());
	}

	@Override
	public User get(Long id) {
		return userDao.getById(id);
	}

	@Override
	public void delete(Long id) {
		userDao.delete(id);
		LOGGER.info("User with id= " + " was successfuly deleted.");
	}

	
	
}
