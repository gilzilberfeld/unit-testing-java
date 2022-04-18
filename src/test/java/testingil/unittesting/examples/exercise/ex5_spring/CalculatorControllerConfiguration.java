package testingil.unittesting.examples.exercise.ex5_spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculatorControllerConfiguration {

	@Bean
	public CalculatorController calculatorController() {
		return new CalculatorController();
	}
	
	@Bean
	public CalculatorDisplay calculator() {
		return new CalculatorDisplay();
	}
}
