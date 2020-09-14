package com.brasilprev.person.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Embeddable
public class Address {

	@NotBlank
	@Column(name = "address_zip_code")
	private String zipCode;
	
	@NotBlank
	@Column(name = "address_address_line_1")
	private String addressLine_1;
	
	@NotBlank
	@Column(name = "address_number")
	private String number;
	
	@Column(name = "address_address_line_2")
	private String addressLine_2;
	
	@NotBlank
	@Column(name = "address_region")
	private String region;
	
	@NotBlank
	@Column(name = "address_city")
	private String city;
	
	@NotBlank
	@Column(name = "address_province")
	private String province;
	
}
