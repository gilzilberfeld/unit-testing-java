package testingil.unittesting.examples.demo.d04_spring.d7.controllers;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.Mockito.*;

@Configuration
public class ItemConfiguration {
	@Bean
	public ItemController itemController() {
		return new ItemController();
	}

	@Bean ItemRepository itemRepository() {
		return mock(ItemRepository.class);
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return Mockito.mock(JdbcTemplate.class);
	}

}