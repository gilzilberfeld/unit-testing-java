package testingil.unittesting.examples.e06.testability.modularity;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootTest
class Full_calculator_tests {

	@Autowired
	public CalculatorService calc;

	@Configuration
	static class ContextConfiguration {

		@Bean
		public CalculatorService calculator() {
			return new CalculatorService();
		}

		@Bean
		public AdderLogic adderLogic() {
			return new AdderLogic();
		}

		@Bean
		public PowerInfo powerInfo() {
			return mock(PowerInfo.class);
		}

		@Bean
		public PowerLogic powerLogic() {
			return mock(PowerLogic.class);
		}

		@Bean
		public PowerRepository powerRepository() {
			return mock(PowerRepository.class);
		}

	}

	@Test
	@DisplayName("Requires many dependencies that it doesn't need")
	void calculator_with_many_dependencies() {
		calc.add(2);
		assertThat(calc.getResult(), is(2));
	}

}