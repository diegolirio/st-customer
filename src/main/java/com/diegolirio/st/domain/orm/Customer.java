package com.diegolirio.st.domain.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="customers")
public class Customer {

	@Id
	private String id;
	private String cpfCnpj;

	public String getId() {
		return id;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}

	
	
}
