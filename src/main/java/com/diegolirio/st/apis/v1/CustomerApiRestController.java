package com.diegolirio.st.apis.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegolirio.st.domain.orm.Customer;
import com.diegolirio.st.services.customer.CustomerService;

@RestController
@RequestMapping(CustomerApiRestController.URL)
public class CustomerApiRestController {

	public static final String URL = "/api/v1/customer";
	
	@Autowired
	private CustomerService customerService;

	@GetMapping
	public ResponseEntity<?> findAll() {
		return new ResponseEntity<List<Customer>>(this.customerService.findAll(), HttpStatus.OK);
	}
	
}
