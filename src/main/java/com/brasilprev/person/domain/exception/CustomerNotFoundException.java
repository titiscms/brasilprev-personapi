package com.brasilprev.person.domain.exception;

public class CustomerNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(String message) {
		super(message);
	}
	
	public CustomerNotFoundException(Long id) {
		this(String.format("There is no code %d customer record.", id));
	}
	
}
