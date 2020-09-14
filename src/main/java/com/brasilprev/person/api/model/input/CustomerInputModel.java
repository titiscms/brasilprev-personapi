package com.brasilprev.person.api.model.input;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerInputModel {
		
	@NotBlank
	@ApiModelProperty(example = "Thiago Costa", required = true)
	private String name;
	
	@NotNull
	@CPF
	@ApiModelProperty(example = "80477649009", required = true)
	private String cpf;
	
	@Valid
	@NotNull
	private AddressInputModel address; 
}
