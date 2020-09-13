package com.brasilprev.person.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brasilprev.person.domain.model.Customer;
import com.brasilprev.person.domain.repository.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping
	public List<Customer> list() {
		return customerRepository.findAll();
	}
	
	@GetMapping("/{customerId}")
	public Customer findById(@PathVariable Long customerId) {
		Optional<Customer> customer = Optional.ofNullable(customerRepository
				.findById(customerId)
				.orElseThrow(IllegalArgumentException::new));
		
		return customer.get();
	}
	
}
