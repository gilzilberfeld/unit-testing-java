package testingil.unittesting.examples.exercise.ex5_spring.unit;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
// 1. add mocked external display with injection
// 2. check both on/off situations
@SpringBootTest
public class CalculatorDisplaySpringTests extends AbstractTestNGSpringContextTests {

	@Test(enabled = false)
	public void firstTest() {

	}
}
