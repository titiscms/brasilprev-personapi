package com.brasilprev.person.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brasilprev.person.api.model.input.CustomerInputModel;
import com.brasilprev.person.domain.model.Customer;

@Component
public class CustomerModelDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Customer toDomainObject(CustomerInputModel customerInputModel) {
		return modelMapper.map(customerInputModel, Customer.class);
	}
		
	public void copyToDomainObject(CustomerInputModel customerInputModel, Customer customer) {
		modelMapper.map(customerInputModel, customer);
	}
	
}
