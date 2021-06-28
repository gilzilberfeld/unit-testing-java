package testingil.unittesting.examples.s01.d03.advanced.features;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import testingil.unittesting.examples.e03.advanced.features.Calculator;

class Grouping {

	private Calculator calc;

	@BeforeEach
	public void setup() {
		calc = new Calculator();
	}

	@Nested
	public class FirstGroup {
		@Test
		void first() {
			assertThat(calc.add(2, 3), is(5));
		}
	}

	@Nested
	public class SecondGroup {
		@Test
		void second() {
			assertThat(calc.add(4, 6), is(10));
		}
	}

	@Disabled
	@Test
	void ignored_test() {
		fail("I don't like being ignored");
	}

}
