package testingil.unittesting.examples.demo.d04_spring.d1.configuration;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@Import(JdbcConfiguration.class)
public class ItemRepositoryConfiguration {
	
	@Bean
	public ItemRepository itemRepository() {
		return new ItemRepository();
	}

}
