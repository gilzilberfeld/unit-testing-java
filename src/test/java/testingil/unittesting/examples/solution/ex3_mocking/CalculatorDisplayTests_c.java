package testingil.unittesting.examples.solution.ex3_mocking;

import org.mockito.ArgumentCaptor;


import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static org.mockito.Mockito.*;

// 3. Use Mockito with argument matching
public class CalculatorDisplayTests_c {

	@Test
	public void when_display_passed_9999_the_display_shows_E() {
		ExternalDisplay display = mock(ExternalDisplay.class);
		when(display.isOn()).thenReturn(true);

//		when(display.show("9999")).thenThrow(new RuntimeException());
		doThrow(new RuntimeException()).when(display).show("9999");

		CalculatorDisplay cd = new CalculatorDisplay(display);
		cd.press("9");
		cd.press("9");
		cd.press("9");
		cd.press("9");
		assertEquals(cd.getDisplay(),"E");
	}

}
