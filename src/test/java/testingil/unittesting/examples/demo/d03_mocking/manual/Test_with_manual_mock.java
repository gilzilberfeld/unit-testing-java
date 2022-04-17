package testingil.unittesting.examples.demo.d03_mocking.manual;


import static org.testng.Assert.assertFalse;

import org.testng.annotations.Test;
import testingil.unittesting.examples.demo.d03_mocking.Car;
import testingil.unittesting.examples.demo.d03_mocking.Driver;

class Test_with_manual_mock{

	@Test
	void cannot_drive_a_running_car() {
		Car mockCar = new Mock_RunningCar();
		Driver driver = new Driver(mockCar);
		
		assertFalse(driver.canDrive());
		
	}

}
