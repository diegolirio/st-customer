package com.diegolirio.st.domain.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Getter
@Document(collection="customers")
public class Customer {

	@Id
	private String id;
	private String cpfCnpj;

}
