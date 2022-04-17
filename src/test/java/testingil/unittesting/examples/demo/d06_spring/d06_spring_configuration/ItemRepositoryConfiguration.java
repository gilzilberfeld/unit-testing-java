package testingil.unittesting.examples.demo.d06_spring.d06_spring_configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(JdbcConfiguration.class)	
public class ItemRepositoryConfiguration {
	
	@Bean
	public ItemRepository itemRepository() {
		return new ItemRepository();
	}

}
