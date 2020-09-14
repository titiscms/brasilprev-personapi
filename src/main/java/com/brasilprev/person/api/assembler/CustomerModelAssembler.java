package com.brasilprev.person.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brasilprev.person.api.model.CustomerModel;
import com.brasilprev.person.domain.model.Customer;

@Component
public class CustomerModelAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public CustomerModel toModel(Customer customer) {
		return modelMapper.map(customer, CustomerModel.class);
	}
	
	public List<CustomerModel> toColletcionModel(List<Customer> customers) {
		return customers.stream()
				.map(customer -> toModel(customer))
				.collect(Collectors.toList());
	}
	
}
