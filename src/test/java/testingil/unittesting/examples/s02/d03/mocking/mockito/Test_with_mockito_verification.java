package testingil.unittesting.examples.s02.d03.mocking.mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;

import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import testingil.unittesting.examples.s02.d02.mocking.ACMode;
import testingil.unittesting.examples.s02.d02.mocking.AirCondition;
import testingil.unittesting.examples.s02.d02.mocking.Car;
import testingil.unittesting.examples.s02.d02.mocking.Driver;

import static org.testng.Assert.*;

class Test_with_mockito_verification{

	@Test
	void AC_is_set_before_we_drive() {
		Car mockCar = mock(Car.class);
		Driver driver = new Driver(mockCar);
		driver.drive();
		
		Mockito.verify(mockCar,atLeast(1)).
			setAC(any(AirCondition.class));
	}

	
	@Test
	void AC_is_set_on_before_we_drive() {
		Car mockCar = mock(Car.class);
		Driver driver = new Driver(mockCar);
		ArgumentCaptor<AirCondition> acCaptor = 
				ArgumentCaptor.forClass(AirCondition.class);
		

		driver.drive();
		
		Mockito.verify(mockCar).setAC(acCaptor.capture());
		
		AirCondition ac = acCaptor.getValue();
		assertEquals (ACMode.On, ac.getMode());
	}

}
