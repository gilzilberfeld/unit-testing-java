package testingil.unittesting.examples.demo.d01.testng.d1_factorial;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import testingil.unittesting.examples.demo.d01.testng.Factorial;

public class FactorialTests {

	@Test
	public void factorial_tests() {
		Factorial factorial = new Factorial();
		assertEquals(1, factorial.calculate(1));
		assertEquals(2, factorial.calculate(2));
		assertEquals(6, factorial.calculate(3));

	}

	@Test(enabled = false)
	public void negative_factorial() {
		Factorial factorial = new Factorial();
		assertEquals(0, factorial.calculate(-3));
	}

	@Test
	public void big_factorial() {
		Factorial factorial = new Factorial();
		assertEquals(3628800, factorial.calculate(10));
	}
}