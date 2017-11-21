package com.diegolirio.st.domain.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="address")
public class Address {

	@Id
	private String id;
	
	private String cep, publicPlace, neighborhood, city;
	
	private int number;
	
	private State state;
	
	@Setter
	private People people;
	
	private boolean active;
	
}
