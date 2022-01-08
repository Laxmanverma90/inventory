package com.inventory.exception;

public class ProductNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8010800562416584583L;
	
	private static final String message = "Oops! Product Not Found !!!";
	
	public ProductNotFoundException() {
		super(message);
	}

}
