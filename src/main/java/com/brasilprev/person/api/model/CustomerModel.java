package com.brasilprev.person.api.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerModel {

	private Long id;
	
	private String name;
	
	private String cpf;
	
	private AddressModel address; 
}
