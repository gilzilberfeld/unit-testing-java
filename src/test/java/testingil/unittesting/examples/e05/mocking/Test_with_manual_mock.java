package testingil.unittesting.examples.e05.mocking;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import testingil.unittesting.examples.e05.mocking.Car;
import testingil.unittesting.examples.e05.mocking.Driver;

class Test_with_manual_mock{

	@Test
	void cannot_drive_a_running_car() {
		Car mockCar = new Mock_RunningCar();
		Driver driver = new Driver(mockCar);
		
		assertFalse(driver.canDrive());
		
	}

}
