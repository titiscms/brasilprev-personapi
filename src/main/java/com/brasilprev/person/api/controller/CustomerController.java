package com.brasilprev.person.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
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
	
	@GetMapping
	public List<Customer> list() {
		return customerRepository.findAll();
	}
		
	@GetMapping("/{customerId}")
	public Customer find(@PathVariable Long customerId) {
		return customerRegistrationService.findOrFail(customerId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Customer save(@RequestBody @Valid Customer customer) {
		return customerRegistrationService.save(customer);
	}
	
	@PutMapping("/{customerId}")
	public Customer update(@PathVariable Long customerId, @RequestBody @Valid Customer customer) {
		Customer currentCustomer = customerRegistrationService.findOrFail(customerId);
		
		BeanUtils.copyProperties(customer, currentCustomer, "id");
		
		Customer updatedCustomer = customerRegistrationService.save(currentCustomer);
		
		return updatedCustomer;
	}
	
	@DeleteMapping("/{customerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long customerId) {
		customerRegistrationService.delete(customerId);
	}
}
