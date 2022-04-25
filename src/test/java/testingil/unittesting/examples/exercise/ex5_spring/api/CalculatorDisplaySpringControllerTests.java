package testingil.unittesting.examples.exercise.ex5_spring.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testingil.unittesting.examples.exercise.ex5_spring.CalculatorControllerConfiguration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.testng.Assert.assertEquals;

// add some characterization tests
// refactor the tests
// add reset method

@SpringBootTest
@ContextConfiguration(classes = { CalculatorControllerConfiguration.class })
public class CalculatorDisplaySpringControllerTests extends AbstractTestNGSpringContextTests {

	public static final String CALCULATOR_PRESS_URL = "/calculator/press";
	public static final String CALCULATOR_DISPLAY_URL = "/calculator/display";
	MockMvc mockMvc;

	@Autowired
	CalculatorController controller;

	@BeforeMethod
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test(enabled = false)
	public void firstTest() throws Exception {
		pressSequence("1");
		assertEquals(getDisplay(), "1");
	}


	private void pressSequence(String sequence) throws Exception {
		sequence.chars().mapToObj(i -> (char) i).forEach(c -> {
			try {
				press(c);
			} catch (Exception e) {
			}
		});
	}

	private void press(char key) throws Exception {
	}

	private String getDisplay() throws Exception {
		return null;
	}
}
