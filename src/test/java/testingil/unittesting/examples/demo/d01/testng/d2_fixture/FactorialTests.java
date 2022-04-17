package testingil.unittesting.examples.demo.d01.testng.d2_fixture;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testingil.unittesting.examples.demo.d01.testng.Factorial;

import static org.testng.Assert.assertEquals;

public class FactorialTests {

	private Factorial factorial;

	@BeforeTest
	public void setup(){
		factorial = new Factorial();
	}

	@Test
	public void factorial_tests() {
		assertEquals(1, factorial.calculate(1));
		assertEquals(2, factorial.calculate(2));
		assertEquals(6, factorial.calculate(3));
	}

	@Test(enabled = false)
	public void negative_factorial() {
		assertEquals(0, factorial.calculate(-3));
	}

	@Test
	public void big_factorial() {
		assertEquals(3628800, factorial.calculate(10));
	}
}