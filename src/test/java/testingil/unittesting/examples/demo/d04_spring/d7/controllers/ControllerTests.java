package testingil.unittesting.examples.demo.d04_spring.d7.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.testng.Assert.assertEquals;

import org.mockito.Answers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SpringBootTest
@ContextConfiguration(classes = { ItemConfiguration.class })
@DirtiesContext
public class ControllerTests extends AbstractTestNGSpringContextTests {

	@Autowired
	ItemRepository mockrepository;

	@Autowired
	ItemController controller;

	MockMvc mockMvc;

	@BeforeMethod
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void when_no_items_returns_error() throws Exception {
		setupRepositoryToReturn(0);
		String result = callGetAllItems_error();
		assertEquals(result, "Error");
	}

	private String callGetAllItems_error() throws Exception {
		MvcResult result =
				mockMvc.perform(
				get("/items/"))
				.andExpect(status().isServiceUnavailable())
				.andReturn();
		return result.getResponse().getContentAsString();
	}

	private void setupRepositoryToReturn(int i) {
		when(mockrepository.findTotal()).thenReturn(0);
	}
}
