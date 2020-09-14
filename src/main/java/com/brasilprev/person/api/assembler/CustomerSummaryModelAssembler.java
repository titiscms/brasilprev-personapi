package com.brasilprev.person.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brasilprev.person.api.model.CustomerSummaryModel;
import com.brasilprev.person.domain.model.Customer;

@Component
public class CustomerSummaryModelAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public CustomerSummaryModel toModel(Customer customer) {
		return modelMapper.map(customer, CustomerSummaryModel.class);
	}
	
	public List<CustomerSummaryModel> toColletcionModel(List<Customer> customers) {
		return customers.stream()
				.map(customer -> toModel(customer))
				.collect(Collectors.toList());
	}
	
}
