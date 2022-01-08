package com.inventory.exception;

import java.time.LocalDateTime;

import org.hibernate.exception.JDBCConnectionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	private final static String INVENTORY ="Inventory";
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<Error> handleCustomerNotFoundException(CustomerNotFoundException ex){
		Error error = new Error();
		error.setErrorCode("CISTOMER_NOT_FOUND");
		error.setErrorMessage(ex.getMessage());
		error.setDateTime(LocalDateTime.now());
		error.setSource(INVENTORY);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ItemNotFoundException.class)
	public ResponseEntity<Error> handleItemNotFoundException(ItemNotFoundException ex){
		Error error = new Error();
		error.setErrorCode("ITEM_NOT_FOUND");
		error.setErrorMessage(ex.getMessage());
		error.setDateTime(LocalDateTime.now());
		error.setSource(INVENTORY);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<Error> handleProductNotFoundException(ProductNotFoundException ex){
		Error error = new Error();
		error.setErrorCode("PRODUCT_NOT_FOUND");
		error.setErrorMessage(ex.getMessage());
		error.setDateTime(LocalDateTime.now());
		error.setSource(INVENTORY);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ItemUpdateException.class)
	public ResponseEntity<Error> handleItemUpdateException(ItemUpdateException ex){
		Error error = new Error();
		error.setErrorCode("ITEM_NOT_UPDATE");
		error.setErrorMessage(ex.getMessage());
		error.setDateTime(LocalDateTime.now());
		error.setSource(INVENTORY);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
