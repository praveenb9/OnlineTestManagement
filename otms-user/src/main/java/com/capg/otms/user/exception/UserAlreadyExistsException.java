package com.capg.otms.user.exception;

public class UserAlreadyExistsException extends RuntimeException{

	public UserAlreadyExistsException(String message) {
		super(message);
	}
}
