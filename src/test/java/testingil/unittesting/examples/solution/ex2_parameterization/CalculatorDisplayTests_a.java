package testingil.unittesting.examples.solution.ex2_parameterization;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

//  1. Add parameterized tests
public class CalculatorDisplayTests_a {

	private CalculatorDisplay cd;

	@BeforeMethod
	public void setup(){
		cd = new CalculatorDisplay();
	}

	@DataProvider(name = "press_displays")
	Object[][] provider(){
		return new Object[][]{
				{"1", "1"},
				{"12", "12"}
		};
	}

	@Test
	public void at_start_display_0() {
				assertEquals(cd.getDisplay(), "0" );
	}

	@Test(dataProvider = "press_displays")
	public void pressing_keys_and_displays(String keys, String result) throws Exception{
		pressSequence(keys);
		assertEquals(cd.getDisplay(), result);
	}

	private void pressSequence(String sequence) throws Exception {
		sequence.chars().mapToObj(i -> (char) i).forEach(c -> {
				cd.press(c.toString());
		});
	}

}
