package testingil.unittesting.examples.demo.d02_mocking.d1.manual;


import static org.testng.Assert.assertFalse;

import org.testng.annotations.Test;
import testingil.unittesting.examples.demo.d02_mocking.Car;
import testingil.unittesting.examples.demo.d02_mocking.Driver;

public class Test_with_manual_mock{

	@Test
	void cannot_drive_a_running_car() {
		Car mockCar = new Mock_RunningCar();
		Driver driver = new Driver(mockCar);
		
		assertFalse(driver.canDrive());
		
	}

}
