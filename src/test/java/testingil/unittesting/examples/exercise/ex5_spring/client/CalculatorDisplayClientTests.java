package testingil.unittesting.examples.exercise.ex5_spring.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@SpringBootTest
@ContextConfiguration(classes = {CalculatorDisplayConfiguration.class})
public class CalculatorDisplayClientTests extends AbstractTestNGSpringContextTests {

    public static final String REAL_CALC_PATH = "/calc/";
    @Autowired
    CalculatorDisplay cd;
    @Autowired
    RestTemplate template;

    MockRestServiceServer mockServer;

    @BeforeMethod
    public void setup() {
        mockServer = MockRestServiceServer.createServer(template);
    }

    @Test
    public void adding_two_numbers() throws Exception {
    }

    @Test
    public void division_by_zero() throws Exception {
    }


    private CalculatorDisplayClientTests pressing(String keys) {
        cd.press("C");
        keys.chars().mapToObj(i -> (char) i).forEach(c -> {
            try {
                cd.press(c.toString());
            } catch (Exception e) {
            }
        });
        return this;

    }

    private void shouldDisplay(String expected) throws Exception {
        assertEquals(cd.getDisplay(), expected);
    }

}
