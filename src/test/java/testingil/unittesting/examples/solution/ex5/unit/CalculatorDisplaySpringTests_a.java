package testingil.unittesting.examples.solution.ex5.unit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertFalse;

@SpringBootTest
@ContextConfiguration(classes = {CalculatorConfiguration.class})
public class CalculatorDisplaySpringTests_a extends AbstractTestNGSpringContextTests {

    @Autowired
    CalculatorDisplay cd;
    @Autowired
    ExternalDisplay display;


    @Test(enabled = false)
    public void when_display_is_off_calc_not_connected() {
        when(display.isOn()).thenReturn(false);
        cd.press("1");
        assertFalse(cd.hasDisplayConnected);
    }

    @Test
    public void when_display_is_on_display_is_correct() {
        when(display.isOn()).thenReturn(true);
        cd.press("1");
        verify(display).show("1");
    }
}
