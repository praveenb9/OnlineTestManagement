package com.capg.otms.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import com.capg.otms.exception.TestAlreadyExists;
import com.capg.otms.exception.TestNotFoundException;




@ControllerAdvice
@RestController

	
public class TestErrorController {
	
	
//	@ExceptionHandler(InvalidInputException.class)
//	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid input")
//	public void handleInvalidInputException() {
//		
//	}
	@ExceptionHandler(TestAlreadyExists.class)
	public String TestAlreadyExists(Exception e) {
		return e.getMessage();
	}
	
	
	@ExceptionHandler(TestNotFoundException.class)
	public String TestNotFoundException(Exception e) {
		return e.getMessage();
		}
}
