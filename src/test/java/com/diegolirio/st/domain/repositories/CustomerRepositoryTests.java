package com.diegolirio.st.domain.repositories;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.diegolirio.st.domain.orm.Customer;
import com.diegolirio.st.services.customer.CustomerRepository;

@DataMongoTest
@RunWith(SpringRunner.class)
public class CustomerRepositoryTests {
	
	@Autowired
	private CustomerRepository customerRepository;
	 
	private Customer customer = Customer.builder().build();

    public void testExample() {
    	//assertEquals(customer, customerRepository.findByCpfCnpj("35357659869"));
        //assertEquals(supplier, repository.findOne(Specification.sponsorId(customer.getId().getSponsorId())));        
    }
	
}
