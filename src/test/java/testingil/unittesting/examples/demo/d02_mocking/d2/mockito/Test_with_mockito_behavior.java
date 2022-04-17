package testingil.unittesting.examples.demo.d02_mocking.d2.mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertFalse;

import org.testng.annotations.Test;

import testingil.unittesting.examples.demo.d02_mocking.Car;
import testingil.unittesting.examples.demo.d02_mocking.Driver;

class Test_with_mockito_behavior {

	@Test
	void a_running_car() {
		Car mockCar = mock(Car.class);
		when(mockCar.isRunning()).thenReturn(true);
		
		Driver driver = new Driver(mockCar);
		
		assertFalse(driver.canDrive());
	}

}
