package com.brasilprev.person.domain.model;

import lombok.Data;

@Data
public class Customer {

	private Long id;
	
	private String name;
	
	private String cpf;
	
	private Address address;
	
}
