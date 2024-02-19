package testingil.unittesting.examples.demo.d04_spring.d6.mockbean;

import org.mockito.Answers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ContextConfiguration(classes = { EmptyConfiguration.class })
public class MockBeanTest extends AbstractTestNGSpringContextTests {

	@MockBean
	ItemRepository mockRepository;

	@Test
	public void test_one_call() {
		mockRepository.findTotal();
		verify(mockRepository).findTotal();
	}

	@Test
	public void test_zero_calls() {
		verify(mockRepository, never()).findTotal();
	}

}
