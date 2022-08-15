package testingil.unittesting.examples.demo.d02_mocking.d2.mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

import org.mockito.Mockito;
import org.testng.annotations.Test;

import testingil.unittesting.examples.demo.d02_mocking.ACMode;
import testingil.unittesting.examples.demo.d02_mocking.Car;
import testingil.unittesting.examples.demo.d02_mocking.Driver;

public class Test_with_mockito_behavior {

	@Test
	public void a_running_car() {
		Car mockCar = mock(Car.class, Mockito.RETURNS_DEEP_STUBS);
		when(mockCar.isRunning()).thenReturn(true);


		Driver driver = new Driver(mockCar);
		
		assertFalse(driver.canDrive());
	}

	@Test
	public void mocking_with_deep_stubs() {
		Car mockCar = mock(Car.class, Mockito.RETURNS_DEEP_STUBS);
		assertNotNull(mockCar.getAC());
		var ac = mockCar.getAC();
		when(ac.getMode()).thenReturn(ACMode.On);
		assertEquals(ac.getMode(), ACMode.On);
	}

}
