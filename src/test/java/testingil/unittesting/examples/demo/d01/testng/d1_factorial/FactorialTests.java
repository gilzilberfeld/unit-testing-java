package testingil.unittesting.examples.demo.d01.testng.d1_factorial;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;
import testingil.unittesting.examples.demo.d01.testng.Factorial;

public class FactorialTests {

	@Test
	public void factorial_tests() {
		Factorial factorial = new Factorial();
		assertEquals(factorial.calculate(1), 1);
		assertEquals(factorial.calculate(2), 2);
		assertEquals(factorial.calculate(3), 6 );

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