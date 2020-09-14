package com.brasilprev.person.api.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressModel {

	private String zipCode;
	
	private String addressLine_1;
	
	private String number;
	
	private String addressLine_2;
	
	private String region;
	
	private String city;
	
	private String province;
}
