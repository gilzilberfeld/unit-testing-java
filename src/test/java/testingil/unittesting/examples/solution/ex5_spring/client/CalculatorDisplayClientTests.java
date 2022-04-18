package testingil.unittesting.examples.solution.ex5_spring.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testingil.unittesting.examples.demo.d04_spring.d8.clients.ItemClient;

import static org.springframework.test.web.client.ExpectedCount.once;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
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
        mockServer
                .expect(once(), requestTo(REAL_CALC_PATH))
                .andExpect(
                        content().string("1Plus2"))
                .andRespond(
                        withSuccess("3", MediaType.TEXT_PLAIN));
        pressing("1+2=").shouldDisplay("3");
        mockServer.verify();
    }

    @Test
    public void division_by_zero() throws Exception {
        mockServer
                .expect(once(), requestTo(REAL_CALC_PATH))
                .andExpect(
                        content().string("4Div0"))
                .andRespond(
                        withStatus(HttpStatus.FORBIDDEN));
        pressing("4/0=").shouldDisplay("E");
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
