/**
 	* 
 	* Project Name : Online Test Management System
 	* 
**/

package com.capg.otms.question.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.capg.otms.question.exception.InvalidQuestionIdException;
import com.capg.otms.question.exception.QuestionAlreadyExistException;
import com.capg.otms.question.exception.QuestionDoesNotExistException;
import com.capg.otms.question.exception.QuestionIdNotNullException;
import com.capg.otms.question.model.ErrorResponse;


/**
	* The ErrorController class controls  the Exceptions Raised.
	*
	* @author   :Praveen Bandi
	* @version  :1.0
	* @since    :2020-09-20 
**/
@RestControllerAdvice
public class ErrorController {
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = {InvalidQuestionIdException.class,QuestionDoesNotExistException.class})
	public ErrorResponse handleNotFound(Exception excepion, HttpServletRequest request)
	{
		return new ErrorResponse(new Date(), excepion.getMessage(), HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND.value(), request.getRequestURI());
		
	}

	@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
	@ExceptionHandler(value = {QuestionIdNotNullException.class,QuestionAlreadyExistException.class})
	public ErrorResponse handleNotNull(Exception excepion, HttpServletRequest request)
	{
		return new ErrorResponse(new Date(), excepion.getMessage(), HttpStatus.NOT_ACCEPTABLE.getReasonPhrase(), HttpStatus.NOT_ACCEPTABLE.value(), request.getRequestURI());
		
	}
	
	
	@ExceptionHandler(value = {HttpStatusCodeException.class})
	public ErrorResponse handleOtherExceptions(HttpStatusCodeException excepion, HttpServletRequest request)
	{
		return new ErrorResponse(new Date(), excepion.getMessage(), excepion.getStatusCode().getReasonPhrase(), excepion.getStatusCode().value(), request.getRequestURI());
		
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ErrorResponse handleMethodArgumentTypeMismatch(
	  MethodArgumentTypeMismatchException exception, HttpServletRequest request) {
		
		return new ErrorResponse(new Date(), exception.getMessage(), HttpStatus.BAD_REQUEST.getReasonPhrase(), HttpStatus.BAD_REQUEST.value(), request.getRequestURI());

	}
}
