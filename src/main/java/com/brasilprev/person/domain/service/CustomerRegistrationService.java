package com.brasilprev.person.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.brasilprev.person.domain.exception.EntityNotFoundException;
import com.brasilprev.person.domain.model.Customer;
import com.brasilprev.person.domain.repository.CustomerRepository;

@Service
public class CustomerRegistrationService {
	
	private static final String MESSAGE_CUSTOMER_NOT_FOUND = 
			"There is no code %d customer record.";
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Transactional
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}
	
	@Transactional
	public void delete(Long customerId) {
		try {
			customerRepository.deleteById(customerId);
			customerRepository.flush();
			
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException(
					String.format(MESSAGE_CUSTOMER_NOT_FOUND, customerId));
		}
	}
	
	public Customer findOrFail(Long customerId) {
		return customerRepository.findById(customerId)
				.orElseThrow(() -> new EntityNotFoundException(
						String.format(MESSAGE_CUSTOMER_NOT_FOUND, customerId)));
	}
	
}
