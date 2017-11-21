package com.diegolirio.st.apis.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegolirio.st.domain.orm.Address;
import com.diegolirio.st.services.address.AddressService;

@CrossOrigin
@RestController
@RequestMapping(AddressApiRestService.URL)
public class AddressApiRestService {

	public static final String URL = "/api/v1/address";
	
	@Autowired
	private AddressService addressService;

	@GetMapping("/people-cpfcnpj/{peopleCpfCnpj}")
	public ResponseEntity<?> findByPeopleId(@PathVariable("peopleCpfCnpj") String peopleCpfCnpj) {
		return new ResponseEntity<List<Address>>(this.addressService.findByPeopleCpfCnpj(peopleCpfCnpj), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Address address) {
		return new ResponseEntity<Address>(this.addressService.save(address), HttpStatus.OK);
	}
	
}
