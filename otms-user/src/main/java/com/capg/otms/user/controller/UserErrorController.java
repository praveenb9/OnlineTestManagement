package com.capg.otms.user.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.capg.otms.user.exception.InvalidInputException;
import com.capg.otms.user.exception.UserAlreadyExistsException;
import com.capg.otms.user.exception.UserNotFoundException;

@ControllerAdvice
@RestController
public class UserErrorController {

	@ExceptionHandler(InvalidInputException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid input")
	public void handleInvalidInputException() {
		
	}
	@ExceptionHandler(UserAlreadyExistsException.class)
	@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE,reason = "User already exists")
	public void UserAlreadyExistsexception() {
		
	}
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "User Not found!")
	public void UserNotFoundException() {
		
	}
	
}
