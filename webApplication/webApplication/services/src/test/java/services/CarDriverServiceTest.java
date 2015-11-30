package services;

import java.sql.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rakickij.web.dataaccess.model.CarDriver;
import com.rakickij.web.services.CarDriverService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-db-context.xml")
public class CarDriverServiceTest {
	
	@Autowired
	private CarDriverService service;
	
	private Long id = 1L;
	
	@Test
	public void updateNameTest(){
		CarDriver driver = service.get(id);
		
		service.updateName(id, "vasiliy", "vasiliev");
		driver.setFirstName("vasiliy");
		driver.setSecondName("vasiliev");
		Assert.assertEquals(driver, service.get(id));
	}
	
	@Test 
	public void updateTripCount(){
		CarDriver driver = service.get(id);
		
		service.updateTripCount(id, service.get(id).getTripCount() + 3);
		driver.setTripCount(driver.getTripCount()+3);
		
		Assert.assertEquals(driver, service.get(id));
	}
	
	@Test 
	public void addNewDriverTest(){
		Long newId = 9L;
		
		CarDriver driver = new CarDriver();
		
		driver.setFirstName("Andrey");
		driver.setSecondName("Andreev");
		driver.setId(newId);
		driver.setTripCount(0L);
		service.addNewDriver(driver.getFirstName(), driver.getSecondName());
		
		Assert.assertEquals(driver, service.get(newId));
		
		driver.setTripCount(10L);
		Assert.assertNotEquals(driver, service.get(newId));
	}
}
