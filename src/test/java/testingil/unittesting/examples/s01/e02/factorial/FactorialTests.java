package testingil.unittesting.examples.s01.e02.factorial;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class FactorialTests {

	@Test
	public void factorials() {
		assertEquals(1, Factorial.calculate(1));
		assertEquals(2, Factorial.calculate(2));
		assertEquals(6, Factorial.calculate(3));
		assertEquals(3628800, Factorial.calculate(10));
	}
}