package testingil.unittesting.examples.e05.mocking;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class Test_with_mockito_behavior {

	@Test
	void a_running_car() {
		Car mockCar = mock(Car.class);
		when(mockCar.isRunning()).thenReturn(true);
		
		Driver driver = new Driver(mockCar);
		
		assertFalse(driver.canDrive());
	}

}
