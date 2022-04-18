package testingil.unittesting.examples.solution.ex5.unit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Configuration
public class CalculatorConfiguration {

	@Bean
	public CalculatorDisplay calculator() {
		return new CalculatorDisplay();
	}

	@Bean
	public ExternalDisplay externalDisplay(){
		return mock(ExternalDisplay.class);
	}
}
