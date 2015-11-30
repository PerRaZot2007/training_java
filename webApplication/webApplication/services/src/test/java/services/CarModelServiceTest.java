package services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rakickij.web.dataaccess.model.CarModel;
import com.rakickij.web.services.CarModelService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-db-context.xml")
public class CarModelServiceTest {
	
	@Autowired
	private CarModelService service;
	
	private Long id = 18L;
	
	@Test
	public void addNewCarModelTest(){
		CarModel carModel = new CarModel();
		carModel.setCarMark("Ford");
		carModel.setName("Transit");
		service.addNewCarModel(carModel.getName(), carModel.getCarMark());
		
		Assert.assertEquals(carModel, service.get(id));
		
	}
	
	@Test
	public void getCarModelTest(){
				
		CarModel carModel = new CarModel();
		carModel.setCarMark("VW");
		carModel.setName("vito");
		
		Assert.assertEquals(carModel.getName(), service.get(2L).getName());
		Assert.assertEquals(carModel.getCarMark(), service.get(1L).getCarMark());
		carModel.setName("lt40");
		
		Assert.assertEquals(carModel, service.get(1L));
	}
	@Test
	public void changeCarModelNameTest() {		
		CarModel carModel = service.get(id);
		
		service.changeCarModelName(id, "new VW");
		carModel.setName("new VW");
		Assert.assertEquals(carModel, service.get(id));
		
		service.changeCarModelName(id, "lt40");
		carModel.setName("lt40");
		Assert.assertEquals(carModel, service.get(id));
		
	}

	@Test
	public void changeCarModelMarkTest() {
		CarModel carModel = service.get(id);
		
		service.changeCarModelMark(id, "BMW");
		carModel.setCarMark("BMW");
		Assert.assertEquals(carModel, service.get(id));
		
		service.changeCarModelMark(id, "Mercedes");
		carModel.setCarMark("Mercedes");	
		Assert.assertEquals(carModel, service.get(id));
	}
	
	@Test 
	public void deleteCarModelTest(){
		//service.deleteCarMark(id);
	}
	
}
