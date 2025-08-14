/*
 * Author: Shakunthala
 * Last Modified:12/8/25
 * Exception Class
 * 
 * Responsibility:
 * Handle Resource not found exception
*/
package com.hexaware.hotbyte.exception;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String message) {
		super(message);

	}
}
