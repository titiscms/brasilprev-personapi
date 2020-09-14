package com.brasilprev.person.domain.exception;

public class CPFAlreadyRegisteredException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public CPFAlreadyRegisteredException(String message) {
		super(message);
	}
	
	public CPFAlreadyRegisteredException() {
		this("Customer with this cpf already registered");
	}
	
}
