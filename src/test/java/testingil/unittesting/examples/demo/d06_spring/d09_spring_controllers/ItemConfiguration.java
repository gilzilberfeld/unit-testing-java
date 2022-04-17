package testingil.unittesting.examples.demo.d06_spring.d09_spring_controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemConfiguration {
	@Bean
	public ItemController itemController() {
		return new ItemController();
	}
}