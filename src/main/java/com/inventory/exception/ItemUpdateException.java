package com.inventory.exception;

public class ItemUpdateException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2514726135147241143L;
	
	private static final String MESSAGE = "Unable to update Items.";

	public ItemUpdateException() {
		super(MESSAGE);
	}
}
