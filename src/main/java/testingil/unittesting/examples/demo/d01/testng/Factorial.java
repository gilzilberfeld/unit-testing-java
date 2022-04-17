package testingil.unittesting.examples.demo.d01.testng;

public class Factorial {
	public int calculate(int number) {
		if (number <= 1)
			return number;
		else
			return calculate(number-1)*number;
	}
}
