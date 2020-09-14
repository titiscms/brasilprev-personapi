package com.brasilprev.person.domain.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.brasilprev.person.domain.exception.CPFAlreadyRegisteredException;
import com.brasilprev.person.domain.exception.CustomerNotFoundException;
import com.brasilprev.person.domain.model.Customer;
import com.brasilprev.person.domain.repository.CustomerRepository;

@Service
public class CustomerRegistrationService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Transactional
	public Customer save(Customer customer) {
		Optional<Customer> customerSaved = customerRepository.findByCpf(customer.getCpf());
		
		if (customerSaved.isPresent() && customer.getId() == null) {
			throw new CPFAlreadyRegisteredException();
		}
		
		return customerRepository.save(customer);
	}
	
	@Transactional
	public void delete(Long customerId) {
		try {
			customerRepository.deleteById(customerId);
			customerRepository.flush();
			
		} catch (EmptyResultDataAccessException e) {
			throw new CustomerNotFoundException(customerId);
		}
	}
	
	public Customer findOrFail(Long customerId) {
		return customerRepository.findById(customerId)
				.orElseThrow(() -> new CustomerNotFoundException(customerId));
	}
	
}
