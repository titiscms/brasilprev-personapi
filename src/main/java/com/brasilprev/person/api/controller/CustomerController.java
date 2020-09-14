package com.brasilprev.person.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.brasilprev.person.api.assembler.CustomerModelAssembler;
import com.brasilprev.person.api.assembler.CustomerModelDisassembler;
import com.brasilprev.person.api.assembler.CustomerSummaryModelAssembler;
import com.brasilprev.person.api.model.CustomerModel;
import com.brasilprev.person.api.model.CustomerSummaryModel;
import com.brasilprev.person.api.model.input.CustomerInputModel;
import com.brasilprev.person.domain.model.Customer;
import com.brasilprev.person.domain.repository.CustomerRepository;
import com.brasilprev.person.domain.service.CustomerRegistrationService;

@RestController
@RequestMapping(path = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerRegistrationService customerRegistrationService;
	
	@Autowired
	private CustomerSummaryModelAssembler customerSummaryModelAssembler;
	
	@Autowired
	private CustomerModelAssembler customerModelAssembler;
	
	@Autowired
	private CustomerModelDisassembler customerModelDisassembler; 
	
	@GetMapping
	public List<CustomerSummaryModel> list() {
		List<Customer> customers = customerRepository.findAll();
		
		return customerSummaryModelAssembler.toColletcionModel(customers);
	}
		
	@GetMapping("/{customerId}")
	public CustomerModel find(@PathVariable Long customerId) {
		Customer customer = customerRegistrationService.findOrFail(customerId);
		
		return customerModelAssembler.toModel(customer);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CustomerModel save(@RequestBody @Valid CustomerInputModel customerInputModel) {
		Customer customer = customerModelDisassembler.toDomainObject(customerInputModel);
		
		return customerModelAssembler.toModel(customerRegistrationService.save(customer));
	}
	
	@PutMapping("/{customerId}")
	public CustomerModel update(@PathVariable Long customerId, @RequestBody @Valid CustomerInputModel customerInputModel) {
		Customer currentCustomer = customerRegistrationService.findOrFail(customerId);
		
		customerModelDisassembler.copyToDomainObject(customerInputModel, currentCustomer);
		
		return customerModelAssembler.toModel(customerRegistrationService.save(currentCustomer));
	}
	
	@DeleteMapping("/{customerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long customerId) {
		customerRegistrationService.delete(customerId);
	}
}
