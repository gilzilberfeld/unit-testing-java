package testingil.unittesting.examples.solution.ex3_mocking;

import org.mockito.ArgumentCaptor;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

// 3. Use Mockito
public class CalculatorDisplayTests_b {

	@Test
	public void when_display_is_off_calc_not_connected() {
		ExternalDisplay display = mock(ExternalDisplay.class);
		when(display.isOn()).thenReturn(false);
		CalculatorDisplay cd = new CalculatorDisplay(display);
		cd.press("1");
		assertFalse(cd.hasDisplayConnected);
	}

	@Test
	public void when_display_is_on_display_is_correct()  {
		ExternalDisplay display = mock(ExternalDisplay.class);
		when(display.isOn()).thenReturn(true);
		CalculatorDisplay cd = new CalculatorDisplay(display);
		cd.press("1");
		verify(display).show("1");
	}

	@Test
	public void when_display_is_on_display_is_correct_with_arg_captor() {
		ExternalDisplay display = mock(ExternalDisplay.class);
		when(display.isOn()).thenReturn(true);
		ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
		CalculatorDisplay cd = new CalculatorDisplay(display);
		cd.press("1");
		verify(display).show(argumentCaptor.capture());
		String sentText = argumentCaptor.getValue();
		assertEquals(sentText,"1");
	}
}
