package com.brasilprev.person.api.model.input;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerInputModel {
		
	@NotBlank
	private String name;
	
	@NotNull
	@CPF
	private String cpf;
	
	@Valid
	@NotNull
	private AddressInputModel address; 
}
