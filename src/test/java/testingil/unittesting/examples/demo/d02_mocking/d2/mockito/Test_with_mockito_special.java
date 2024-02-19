package testingil.unittesting.examples.demo.d02_mocking.d2.mockito;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

import testingil.unittesting.examples.demo.d02_mocking.ACMode;
import testingil.unittesting.examples.demo.d02_mocking.AirCondition;
import testingil.unittesting.examples.demo.d02_mocking.Car;
import testingil.unittesting.examples.demo.d02_mocking.Driver;

import org.mockito.*;
import static org.mockito.Mockito.*;

public class Test_with_mockito_special {

	@Test
	void cannot_drive_without_keys() {
		Driver driver = new Driver(null);
		try(MockedStatic<Driver> mockHandler = mockStatic(Driver.class)){
			when(Driver.hasKeys()).thenReturn(false);
			assertFalse(driver.canDrive());
		}
	}

	@Test
	void AC_is_set_off_before_we_drive() {
		Car mockCar = mock(Car.class);
		Driver driver = new Driver(mockCar);

		ArgumentCaptor<AirCondition> acCaptor =
				ArgumentCaptor.forClass(AirCondition.class);

		try(MockedConstruction<AirCondition> mockHandler = mockConstruction(AirCondition.class,
				(mock,context)-> {
			when(mock.getMode()).thenReturn(ACMode.Off);
			}
		)){
			driver.drive();
		}

		verify(mockCar).setAC(acCaptor.capture());

		AirCondition ac = acCaptor.getValue();
		assertEquals(ac.getMode(),ACMode.Off);
	}
}
