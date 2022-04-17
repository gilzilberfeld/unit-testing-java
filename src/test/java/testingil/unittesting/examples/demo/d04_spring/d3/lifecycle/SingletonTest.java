package testingil.unittesting.examples.demo.d04_spring.d3.lifecycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import testingil.unittesting.examples.demo.d04_spring.d2.mocking.ItemRepository;

import static org.mockito.Mockito.verify;

@SpringBootTest
@ContextConfiguration(classes = { ItemRepositoryConfiguration.class })
public class SingletonTest extends AbstractTestNGSpringContextTests {

    @Autowired
    ItemRepository mockRepository;

    @Test
    public void test_one_call() {
        mockRepository.findTotal();
        verify(mockRepository).findTotal();
    }

    @Test
    public void test_zero_calls() {
        verify(mockRepository).findTotal();
    }
}
