package testingil.unittesting.examples.s01.d03.advanced.features;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import testingil.unittesting.examples.s01.d03.advanced.features.Calculator;

class ConditionalTests {
	private Calculator calc;

	@BeforeEach
	public void setup() {
		calc = new Calculator();
	}

	@Test
	@EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_13)
	void java_runtime_dependent() {
		assertThat(calc.add(2, 3), is(5));
	}

	@Test
	@EnabledOnOs(OS.LINUX)
	void os_dependent() {
		assertThat(calc.add(4, 6), is(10));
	}

}
