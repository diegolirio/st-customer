package com.diegolirio.st.apis.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegolirio.st.domain.orm.Customer;
import com.diegolirio.st.services.customer.CustomerService;

import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@Api(value="CustomerApiRestService")
@RequestMapping(CustomerApiRestService.URL)
public class CustomerApiRestService {

	public static final String URL = "/api/v1/customer";
	
	@Autowired
	private CustomerService customerService;

	@GetMapping
	@Cacheable(value="customerFindAll")
	public ResponseEntity<?> findAll() {
		return new ResponseEntity<List<Customer>>(this.customerService.findAll(), HttpStatus.OK);
	}
	
	@CacheEvict(value= {"customerFindAll", "customerCustomCpfCnpj"}, allEntries=true)
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(this.customerService.save(customer), HttpStatus.OK);
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String id) {
		this.customerService.delete(id);
		return new ResponseEntity<Customer>(HttpStatus.OK);
	}		
	
	@GetMapping("/cpfcnpj/{cpfCnpj}")
	@Cacheable(value="customerCustomCpfCnpj")
	public ResponseEntity<?> findByCpfCnpj(@PathVariable("cpfCnpj") String cpfCnpj) {
		System.out.println("findByCpfCnpj("+cpfCnpj+")");
		return new ResponseEntity<Customer>(this.customerService.findByCpfCnpj(cpfCnpj), HttpStatus.OK); 
	}
}
