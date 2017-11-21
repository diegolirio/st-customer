package com.diegolirio.st.domain.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Document(collection="telephones")
public class Telephone {

	@Id
	private String id;
	
	private String contactType, number;
	
	@Setter
	private People people;

	private boolean active = true;
	
}
