package testingil.unittesting.examples.demo.d04_spring.d3.lifecycle;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import testingil.unittesting.examples.demo.d04_spring.d2.mocking.ItemRepository;

@Configuration
public class ItemRepositoryConfiguration {
	
	@Bean
	public ItemRepository itemRepository() {
		return Mockito.mock((ItemRepository.class));
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return Mockito.mock(JdbcTemplate.class);
	}
}
