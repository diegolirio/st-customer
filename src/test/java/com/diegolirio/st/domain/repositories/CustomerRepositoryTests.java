package com.diegolirio.st.domain.repositories;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTests {
	
//	@Autowired
//	private CustomerRepository customerRepository;
//	
//	private Customer customer = Customer.builder().build();

    @Test
    public void testExample() {
    	assertEquals("", "");
        //assertEquals(customer, customerRepository.findByCpfCnpj("35357659869"));
        //assertEquals(supplier, repository.findOne(SupplierSpecification.sponsorId(supplier.getSupplierId().getSponsorId())));        
    }
	
}
