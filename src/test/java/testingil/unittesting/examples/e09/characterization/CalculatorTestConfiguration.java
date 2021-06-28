package testingil.unittesting.examples.e09.characterization;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
public class CalculatorTestConfiguration {
	
	@Bean 
	CalculatorController controller() {
		return new CalculatorController();
	}
	
	@Bean 
	Calculator calculator() {
		return new Calculator();
	}
	
	@Bean 
	Logger logger() {
		return new TestLogger();
	}
}

