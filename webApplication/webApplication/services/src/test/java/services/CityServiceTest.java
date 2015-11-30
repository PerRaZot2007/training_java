package services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rakickij.web.dataaccess.model.City;
import com.rakickij.web.services.CityService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-db-context.xml")
public class CityServiceTest {
	
	@Autowired
	private CityService service;
	
	@Test
	public void updateCityNameTest(){
		City city = service.get(1L);
		service.updateCityName(1L, "Pinsk");
		Assert.assertNotEquals(city, service.get(1L));
		
		service.updateCityName(1L, "Brest");
		Assert.assertEquals(city, service.get(1L));
	}
	
	@Test
	public void addNewCityTest(){
		Long newId = 10L;
		City city = new City();
		city.setName("Ozery");
		city.setId(newId);
		service.addNewCity("Ozery");
		
		Assert.assertEquals(city, service.get(newId));
	}
	
	
}
