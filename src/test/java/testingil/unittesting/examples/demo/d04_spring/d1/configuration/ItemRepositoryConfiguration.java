package testingil.unittesting.examples.demo.d04_spring.d1.configuration;

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
