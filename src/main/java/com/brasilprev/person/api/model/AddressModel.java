package com.brasilprev.person.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressModel {

	@ApiModelProperty(example = "09530001")
	private String zipCode;
	
	@ApiModelProperty(example = "Rua Major Carlos Del Prete")
	private String addressLine_1;
	
	@ApiModelProperty(example = "1708")
	private String number;
	
	@ApiModelProperty(example = "apto 118")
	private String addressLine_2;
	
	@ApiModelProperty(example = "Ceramica")
	private String region;
	
	@ApiModelProperty(example = "São Caetano do Sul")
	private String city;
	
	@ApiModelProperty(example = "São Paulo")
	private String province;
}