package com.brasilprev.person.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Address {

	@Column(name = "address_zip_code")
	private String zipCode;
	
	@Column(name = "address_address_line_1")
	private String addressLine_1;
	
	@Column(name = "address_number")
	private String number;
	
	@Column(name = "address_address_line_2")
	private String addressLine_2;
	
	@Column(name = "address_region")
	private String region;
	
	@Column(name = "address_city")
	private String city;
	
	@Column(name = "address_province")
	private String province;
	
}
