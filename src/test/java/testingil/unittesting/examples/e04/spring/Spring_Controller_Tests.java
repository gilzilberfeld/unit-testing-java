package testingil.unittesting.examples.e04.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@Sql(scripts = "classpath:CreateItemsSchema.sql", 
	executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "classpath:DeleteItemsSchema.sql", 
	executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@ContextConfiguration(classes= {ControllerConfiguration.class})
@AutoConfigureMockMvc
public class Spring_Controller_Tests{

	@Autowired MockMvc mockMvc;
	
	@Test
	public void whenNoItemsAvailable_thenGetReturnsAnErrorCode() throws Exception {
		this.mockMvc
		.perform(get("/items/"))
    	.andExpect(status().isServiceUnavailable());
	}
	
	@Test
	public void whenItemsAreAdded_thenGetReturnsNumberOfItems() throws Exception {
		
		mockMvc.perform(
	    		post("/items/add/")
	    		.content(asJsonString("Item1"))
				.contentType("application/json"))
				.andExpect(status().isOk());

		mockMvc.perform(
	    		post("/items/add/")
	    		.content(asJsonString("Item2"))
				.contentType("application/json"))
				.andExpect(status().isOk());

	    MvcResult result =  mockMvc.perform(
	    		get("/items/"))
	    	.andExpect(status().isOk())
	    	.andReturn();
	    
	    assertEquals("2 Items",result.getResponse().getContentAsString());
    
	}

	@Test
	public void refactored_whenItemsAreAdded_thenGetReturnsNumberOfItems() throws Exception {
		addItem("Item1");
		addItem("Item2");
	    assertEquals("2 Items",getTotal());
		
	}


	private void addItem(String name) throws Exception {
		mockMvc.perform(
				post("/items/add/")
				.content(asJsonString(name))
				.contentType("application/json"))
	    		.andExpect(status().isOk());
	}
	
	private String getTotal() throws Exception, UnsupportedEncodingException {
		MvcResult result =  mockMvc.perform(
				get("/items/"))
				.andExpect(status().isOk())
				.andReturn();
		
		return result.getResponse().getContentAsString();
	}
	
	private String asJsonString(Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}
