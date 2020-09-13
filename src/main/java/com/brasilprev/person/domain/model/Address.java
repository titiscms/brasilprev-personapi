package com.brasilprev.person.domain.model;

import lombok.Data;

@Data
public class Address {

	private String zipCode;
	
	private String address;
	
	private String number;
	
	private String additionalAddress;
	
	private String neighborhood;
	
	private String city;
	
	private String state;
	
}
