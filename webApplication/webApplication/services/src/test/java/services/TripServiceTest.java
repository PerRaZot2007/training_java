package services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rakickij.web.dataaccess.model.Trip;
import com.rakickij.web.dataaccess.model.User;
import com.rakickij.web.services.TripService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-db-context.xml")
public class TripServiceTest {

	@Autowired
	private TripService service;

	private Long id = 1L;

	@Test
	public void changeTripDriverTest() {
		Trip trip = service.get(id);
		Assert.assertEquals(trip, service.get(id));

		service.changeTripDriver(id, 3L);
		Assert.assertNotEquals(trip, service.get(id));
	}

	@Test
	public void changeTripCarTest() {
		Trip trip = service.get(id);
		Assert.assertEquals(trip, service.get(id));

		service.changeTripCar(id, 1L);
		Assert.assertNotEquals(trip, service.get(id));		
	}
	
	@Test
	public void addNewUserTest(){
		Trip trip = new Trip();
		trip.setArrivalCityId(1L);
		trip.setDepartureCityId(4L);
		trip.setDriverId(3L);
		trip.setCarId(2L);
		service.insert(trip.getDriverId(), trip.getCarId(), trip.getDepartureDate(), trip.getArrivalDate(), trip.getDepartureCityId(), trip.getArrivalCityId());
	}

}
