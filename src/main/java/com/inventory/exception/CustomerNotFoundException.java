package com.inventory.exception;

public class CustomerNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2765723966517731304L;
	
	private static final String MESSAGE = "Sorry! Customer Not found.";

	public CustomerNotFoundException() {
		super(MESSAGE);
	}
}
