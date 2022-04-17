package testingil.unittesting.examples.demo.d04_spring.d4.prototype;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import testingil.unittesting.examples.demo.d04_spring.d2.mocking.ItemRepository;

@Configuration
public class ItemRepositoryConfiguration {
	
	@Bean
	@Scope("prototype")
	public ItemRepository itemRepository() {
		return Mockito.mock((ItemRepository.class));
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return Mockito.mock(JdbcTemplate.class);
	}
}
