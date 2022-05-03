package testingil.unittesting.examples.demo.d01.testng.d2_fixture;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testingil.unittesting.examples.demo.d01.testng.Factorial;

import static org.testng.Assert.assertEquals;

public class FactorialTests {

	private Factorial factorial;

	@BeforeMethod
	public void setup(){
		factorial = new Factorial();
	}

	@Test
	public void factorial_tests() {
		assertEquals(factorial.calculate(1), 1);
		assertEquals(factorial.calculate(2), 2);
		assertEquals(factorial.calculate(3), 6 );
	}

	@Test(enabled = false)
	public void negative_factorial() {
		assertEquals(factorial.calculate(-3), 0);
	}

	@Test
	public void big_factorial() {
		assertEquals(factorial.calculate(10), 3628800);
	}
}