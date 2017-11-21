package com.diegolirio.st.apis.v1;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.diegolirio.st.domain.orm.Customer;
import com.diegolirio.st.domain.orm.Telephone;
import com.diegolirio.st.fixture.FixtureTests;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class TelephoneApiRestServiceTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private FixtureTests fixture;
	
	private Telephone telephone;

	@Before
	public void before() throws UnsupportedEncodingException, Exception {
		telephone = fixture.fixtureTelephone(null); 
	}	
	
	@Test
	public void testFindByCpfCnpj() throws Exception {
		mockMvc.perform(get(TelephoneApiRestService.URL+"/people-cpfcnpj/35357659869")
							.accept(MediaType.APPLICATION_JSON_UTF8))
						.andExpect(status().isOk());
	}
	
	@Test
	public void testSave() throws Exception {
		Customer customer = postCustomer();
		telephone.setPeople(customer);
		String json = objectMapper.writeValueAsString(telephone);
		System.out.println(json);
		mockMvc.perform(post(TelephoneApiRestService.URL)
							.accept(MediaType.APPLICATION_JSON_UTF8)
							.contentType(MediaType.APPLICATION_JSON_UTF8)
							.content(json))
						.andExpect(status().isOk());
	}
	
	private Customer postCustomer() throws UnsupportedEncodingException, Exception {
		Customer customer = fixture.fixtureCustomer();
		String jsonCustomer = objectMapper.writeValueAsString(customer);
		String jsonCustomerSaved = mockMvc.perform(post(CustomerApiRestService.URL)
													.accept(MediaType.APPLICATION_JSON_UTF8)
													.contentType(MediaType.APPLICATION_JSON_UTF8)
													.content(jsonCustomer ))
												.andExpect(status().isOk())
												.andReturn().getResponse().getContentAsString();
		return objectMapper.readValue(jsonCustomerSaved, Customer.class);
	}		
	
}
