package testingil.unittesting.examples.demo.d04_spring.d1.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes = { ItemRepositoryConfiguration.class })
public class AutowiringUsingConfigurationTest extends AbstractTestNGSpringContextTests {

	@Autowired
	ItemRepository repository;

	@Test
	public void repository_is_created() {
		assertNotNull(repository);
		assertNotNull(repository.getTemplate());
	}
}
