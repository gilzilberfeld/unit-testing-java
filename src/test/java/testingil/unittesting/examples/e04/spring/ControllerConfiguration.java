package testingil.unittesting.examples.e04.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(JdbcConfiguration.class)	
public class ControllerConfiguration {
	
	@Bean 
	public ItemController itemController() {
		return new ItemController();
	}
}
