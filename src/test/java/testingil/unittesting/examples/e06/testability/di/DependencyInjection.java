package testingil.unittesting.examples.e06.testability.di;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import testingil.unittesting.examples.e06.testability.di.AdderRepository;
import testingil.unittesting.examples.e06.testability.di.BetterAdder;


class DependencyInjection {

	@Test
	@DisplayName("This one goes to the database")
	void adderTest() {
		Adder adder = new Adder();
		adder.add(3, 4);
		assertThat(adder.getResult(), is(7));
	}
	
	@Test
	@DisplayName("This one definitely doesn't because it's mocked")
	void improvedAdderTest() {
		AdderRepository mockRepository = mock(AdderRepository.class);
		BetterAdder adder = new BetterAdder(mockRepository);
		adder.add(3, 4);
		assertThat(adder.getResult(), is(7));
	}
	

}
