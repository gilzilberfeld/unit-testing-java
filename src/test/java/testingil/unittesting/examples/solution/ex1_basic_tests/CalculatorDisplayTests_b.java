package testingil.unittesting.examples.solution.ex1_basic_tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

// 3. Refactor tests
public class CalculatorDisplayTests_b {

	private CalculatorDisplay cd;

	@BeforeMethod
	public void setup(){
		cd = new CalculatorDisplay();
	}

	@Test
	public void at_start_display_0() {
		shouldDisplay("0");
	}

	@Test
	public void pressing_1_displays_1(){
		cd.press("1");
		shouldDisplay("1");
	}

	@Test
	public void pressing_12_displays_12() throws Exception{
		pressSequence("12");
		shouldDisplay("12");
	}

	private void shouldDisplay(String s) {
		assertEquals(cd.getDisplay(), s);
	}

	private void pressSequence(String sequence) throws Exception {
		sequence.chars().mapToObj(i -> (char) i).forEach(c -> {
				cd.press(c.toString());
		});
	}

}
