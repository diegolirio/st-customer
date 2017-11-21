package com.diegolirio.st.domain.orm;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
public class People {

	@Setter
	//@Indexed(unique=true)
	private String cpfCnpj;
	
	private String name, email;

	private boolean active;
	
	@JsonIgnore
	private List<Address> addresses;
	
	@JsonIgnore
	private List<Telephone> phones;
	
}
