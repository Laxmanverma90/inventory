package com.inventory.exception;

public class ItemNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7163493029566230776L;
	
	private static final String MESSAGE = "Oops! Item Not Found !!!";
	
	public ItemNotFoundException() {
		super(MESSAGE);
	}

}
