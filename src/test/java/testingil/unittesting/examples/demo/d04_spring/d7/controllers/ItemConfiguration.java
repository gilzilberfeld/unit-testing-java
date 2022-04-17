package testingil.unittesting.examples.demo.d04_spring.d7.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemConfiguration {
	@Bean
	public ItemController itemController() {
		return new ItemController();
	}
}