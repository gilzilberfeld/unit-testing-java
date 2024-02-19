package testingil.unittesting.examples.demo.d01.testng.d3_parameterized;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testingil.unittesting.examples.demo.d01.testng.Factorial;

import static org.testng.Assert.assertEquals;

public class FactorialTests {

	@DataProvider(name="factorial_values")
	public Object[][] factorial_provider(){
		return new Object[][]{
				{1, 1},
				{2, 2},
				{3, 6},
				{-3, 0},
				{10, 3628800}
		};
	}

	@Test(enabled = false, dataProvider = "factorial_values")
	public void factorial_tests(int input, int result) {
		Factorial factorial 	= new Factorial();
		assertEquals(factorial.calculate(input), result);
	}
}