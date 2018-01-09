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

import com.diegolirio.st.domain.orm.Telephone;
import com.diegolirio.st.services.telephone.TelephoneService;

import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@Api(value="TelephoneApi")
@RequestMapping(TelephoneApiRestService.URL)
public class TelephoneApiRestService {

	public static final String URL = "/api/v1/phone";
	
	@Autowired
	private TelephoneService telephoneService;
	
	@GetMapping("/people-cpfcnpj/{cpfCnpj}")
	public ResponseEntity<?> findByPeopleCpfCnpj(@PathVariable("cpfCnpj") String cpfCnpj) {
		return new ResponseEntity<List<Telephone>>(this.telephoneService.findByPeopleCpfCnpj(cpfCnpj), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Telephone telephone) {
		return new ResponseEntity<Telephone>(this.telephoneService.save(telephone), HttpStatus.OK);
	}	

}
