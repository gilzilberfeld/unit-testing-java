package testingil.unittesting.examples.solution.ex4_refactoring;

import org.approvaltests.Approvals;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalculatorDisplayTests {

	CalculatorDisplay cd;
	TestLogger log;
	
	@BeforeTest
	public void setup() {
		cd = new CalculatorDisplay();
		log = new TestLogger();
	}

	@Test(enabled = true)
	public void CharacterizationTests() throws Exception	{
		pressSequence("1");
		pressSequence("12");
		pressSequence("13+");
		pressSequence("11+5");
		pressSequence("21/3");
		pressSequence("15/5=");
		pressSequence("1+2=");
		pressSequence("1C");
		pressSequence("21C");
		pressSequence("C1C");
		Approvals.verify(log.getAll());
	}

	private void pressSequence(String sequence) throws Exception {
		sequence.chars().mapToObj(i -> 
			(char) i).forEach(c -> press (c));
	}

	private void press(char key) {
		cd.press(Character.toString(key));
		log.append(key, cd.getDisplay());
	}

}
