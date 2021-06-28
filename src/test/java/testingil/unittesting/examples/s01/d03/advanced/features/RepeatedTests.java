package testingil.unittesting.examples.s01.d03.advanced.features;

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

import testingil.unittesting.examples.e03.advanced.features.Calculator;

class RepeatedTests {
	private Calculator calc;
	
	@RepeatedTest(3)
	void i_feel_like_i_am_repeating_myself(RepetitionInfo rep) {
		calc = new Calculator();
		int current = rep.getCurrentRepetition();
		String message = "#" + current+ " failed"; 
		assertThat(message, calc.add(2,current ), lessThan (5)); 
	}
}
