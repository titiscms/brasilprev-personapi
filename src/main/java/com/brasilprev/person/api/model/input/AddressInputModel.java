package com.brasilprev.person.api.model.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressInputModel {

	@NotNull
	private String zipCode;
	
	@NotBlank
	private String addressLine_1;
	
	@NotNull
	private String number;
	
	private String addressLine_2;
	
	@NotBlank
	private String region;
	
	@NotBlank
	private String city;
	
	@NotBlank
	private String province;
}
