package services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rakickij.web.dataaccess.model.Car;
import com.rakickij.web.services.CarService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-db-context.xml")
public class CarServiceTest {
	
	@Autowired
	private CarService service;
	
	@Test
	public void updateCarNumberTest(){
		Car car = service.get(1L);
		service.updateCarNumber(1L, "4207 ae-2");
		Assert.assertNotEquals(car, service.get(1L));
		
		service.updateCarNumber(1L, car.getNumberPlate());
		Assert.assertEquals(car, service.get(1L));
	}
	
	@Test
	public void updateCarConditionTest(){
		Car car = service.get(1L);
		service.updateCarCondition(1L, "great");
		Assert.assertNotEquals(car, service.get(1L));
		
		service.updateCarCondition(1L, car.getCondition());
		Assert.assertEquals(car, service.get(1L));
	}
	
	@Test
	public void addNewCarTest(){
		Long newId = 7L;
		Car car = new Car();
		car.setCarModelId(1L);
		car.setCondition("new");
		car.setNumberPlate("3954 EK-4");
		service.insertCar(car.getNumberPlate(), car.getCondition(), car.getCarModelId());
		
		Assert.assertEquals(car, service.get(newId));
	}
	
	
	
	
}
