package services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rakickij.web.dataaccess.model.User;
import com.rakickij.web.services.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-db-context.xml")
public class UserServiceTest {
	
	@Autowired
	private UserService service;
	
	private Long id = 1L;
	
	@Test
	public void registerUserTest(){
		Long newId = 10L;
		User user = new User();
		user.setFirstName("sasha");
		user.setSecondName("aleksandrov");
		user.setEmail("sasha@mail.com");
		user.setPassword("asdqwe");
		service.registerUser(user.getFirstName(), user.getSecondName(), user.getEmail(), user.getPassword());
		
		Assert.assertEquals(user, service.get(newId));
	}
	
	@Test
	public void changeNameTest(){
		User user = service.get(id);
		service.changeName(id, "anatoliy", "saveliev");
		Assert.assertNotEquals(user, service.get(id));
		
		service.changeName(id, user.getFirstName(), user.getSecondName());
		Assert.assertEquals(user, service.get(id));
	}
	
	@Test
	public void changeEmailTest(){
		User user = service.get(id);
		service.changeEmail(id, "anatoliy@mail.com");
		Assert.assertNotEquals(user, service.get(id));
		
		service.changeEmail(id, user.getEmail());
		Assert.assertEquals(user, service.get(id));
	}
	
	@Test
	public void changePasswordTest(){
		User user = service.get(id);
		service.changePassword(id, "new password");
		Assert.assertNotEquals(user, service.get(id));
		
		service.changePassword(id,user.getPassword());
		Assert.assertEquals(user, service.get(id));
	}
}
