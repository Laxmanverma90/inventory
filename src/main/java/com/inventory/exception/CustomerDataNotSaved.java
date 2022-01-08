package com.inventory.exception;

public class CustomerDataNotSaved extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1858723144985513679L;

	private static final String MESSAGE = "Oops! Customer data not saved.";

	public CustomerDataNotSaved() {
		super(MESSAGE);
	}
}
