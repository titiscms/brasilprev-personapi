package com.brasilprev.person.api.model.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressInputModel {

	@NotNull
	@ApiModelProperty(example = "09530001", required = true)
	private String zipCode;
	
	@NotBlank
	@ApiModelProperty(example = "Rua Major Carlos Del Prete", required = true)
	private String addressLine_1;
	
	@NotNull
	@ApiModelProperty(example = "1708", required = true)
	private String number;
	
	@ApiModelProperty(example = "apto 118")
	private String addressLine_2;
	
	@NotBlank
	@ApiModelProperty(example = "Ceramica", required = true)
	private String region;
	
	@NotBlank
	@ApiModelProperty(example = "São Caetano do Sul", required = true)
	private String city;
	
	@NotBlank
	@ApiModelProperty(example = "São Paulo", required = true)
	private String province;
}
