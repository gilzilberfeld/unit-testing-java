package testingil.unittesting.examples.s01.d03.advanced.features;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import testingil.unittesting.examples.e03.advanced.features.Calculator;

class DisplayNames {

	@Test
	@DisplayName("Magnificent Name!!!1")
	void a_simple_test() {
		Calculator calc = new Calculator();
		assertThat(calc.add(2, 3), is(5));
	}

}
