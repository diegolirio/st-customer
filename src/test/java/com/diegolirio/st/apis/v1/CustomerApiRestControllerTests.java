package com.diegolirio.st.apis.v1;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.diegolirio.st.domain.orm.Customer;
import com.diegolirio.st.fixture.FixtureTests;
import com.diegolirio.st.services.customer.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class CustomerApiRestControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private FixtureTests fixture;
	
	private Customer customer;

	@Mock
	private CustomerService customerService;
	
    @Before
    public void init() {
    	customer = fixture.fixtureCustomer();
    }
	
	@Test
	public void testFindAll() throws Exception {
		mockMvc.perform(get(CustomerApiRestService.URL).accept(MediaType.APPLICATION_JSON_UTF8))
							.andExpect(status().isOk());
	}
	
	@Test
	public void testSave() throws Exception {
		postCustomer();
	}
	
	@Test
	public void testDelete() throws Exception {
		customer.setCpfCnpj("626261515"); 
		Customer customerSaved = postCustomer();
		mockMvc.perform(delete(CustomerApiRestService.URL+"/"+customerSaved.getId())
								.accept(MediaType.APPLICATION_JSON_UTF8))
							.andExpect(status().isOk());
	}

	private Customer postCustomer() throws UnsupportedEncodingException, Exception {
		String jsonCustomer = objectMapper.writeValueAsString(customer);
		when(customerService.save(customer)).thenReturn(customer);
		String jsonCustomerSaved = mockMvc.perform(post(CustomerApiRestService.URL)
													.accept(MediaType.APPLICATION_JSON_UTF8)
													.contentType(MediaType.APPLICATION_JSON_UTF8)
													.content(jsonCustomer ))
												.andExpect(status().isOk())
												.andReturn().getResponse().getContentAsString();
		return objectMapper.readValue(jsonCustomerSaved, Customer.class);
	}	
	
	
}
