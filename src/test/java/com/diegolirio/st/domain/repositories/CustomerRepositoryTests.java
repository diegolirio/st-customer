package com.diegolirio.st.domain.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

@DataMongoTest
@RunWith(SpringRunner.class)
public class CustomerRepositoryTests {
	
//	@Autowired
//	private CustomerRepository customerRepository;
//	
//	private Customer customer = Customer.builder().build();

    @Test
    public void testExample() {
    	//assertEquals(customer, customerRepository.findByCpfCnpj("35357659869"));
        //assertEquals(supplier, repository.findOne(Specification.sponsorId(customer.getId().getSponsorId())));        
    }
	
}
