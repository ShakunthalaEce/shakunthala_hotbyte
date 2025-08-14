/*
 * Author: Shakunthala
 * Last Modified:12/8/25
 * Global Excepiton Handler
 * 
 * Responsibility:
 * Handle Exceptions
*/
package com.hexaware.hotbyte.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleResourceNotFound(ResourceNotFoundException ex) {
		return ex.getMessage();
	}
}
