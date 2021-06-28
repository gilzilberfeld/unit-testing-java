package testingil.unittesting.examples.e03.advanced.features;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class DataDriven {
	private Calculator calc;
	
	@ParameterizedTest
	@CsvSource({"1, 2, 3", 
				"2, 4, 6",
				"3, 6, 9"}) 
	void multi_test(int a, int b, int expected) {
		calc = new Calculator();
		assertThat(calc.add(a, b), is(expected));
	}
	
	
}
