package testingil.unittesting.examples.solution.ex2_parameterization;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.testng.Assert.assertEquals;

//  2. read values form CSV file
public class CalculatorDisplayTests_b {

	public static final String DATA_CSV = "src\\test\\java\\testingil\\unittesting\\examples\\solution\\ex2\\data.csv";
	private CalculatorDisplay cd;

	@BeforeMethod
	public void setup(){
		cd = new CalculatorDisplay();
	}

	@DataProvider(name = "press_displays_csv")
	Object[][] provider() throws Exception {
		Object[][] data = new Object[2][2];

		BufferedReader br =
				new BufferedReader(new FileReader(DATA_CSV));
		String line;
		int counter = 0;
		while ((line = br.readLine()) != null) {
			String[] values = line.split(",");
			data[counter][0] = values[0];
			data[counter][1] = values[1];
			counter++;
		}
		return data;
	};


	@Test
	public void at_start_display_0() {
		assertEquals(cd.getDisplay(), "0" );
	}

	@Test(dataProvider = "press_displays_csv")
	public void pressing_keys_and_displays(String keys, String result) throws Exception{
		pressSequence(keys);
		assertEquals(cd.getDisplay(), result);
	}

	private void pressSequence(String sequence) throws Exception {
		sequence.chars().mapToObj(i -> (char) i).forEach(c -> {
				cd.press(c.toString());
		});
	}

}
