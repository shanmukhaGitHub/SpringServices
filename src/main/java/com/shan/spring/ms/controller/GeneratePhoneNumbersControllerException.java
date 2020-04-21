package com.shan.spring.ms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.google.gson.Gson;
import com.shan.spring.ms.exception.GeneratePhoneBusinessExpection;
import com.shan.spring.ms.model.ErrorResponse;
@ControllerAdvice
public class GeneratePhoneNumbersControllerException extends ResponseEntityExceptionHandler{
	
	private static final Logger log = LoggerFactory.getLogger(GeneratePhoneNumbersControllerException.class);
	private static final String ERROR_RESPONSE = "ErrorResponse: {}";
	
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
		if(log.isErrorEnabled()) {
			log.error(ERROR_RESPONSE, new Gson().toJson(ex.getMessage()));
		}
		
		return new ResponseEntity<>(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

	
	@ExceptionHandler(GeneratePhoneBusinessExpection.class)
	public final ResponseEntity<Object> handleBusinessExceptionrException(GeneratePhoneBusinessExpection ex, WebRequest request) {
		if(log.isErrorEnabled()) {
			log.error(ERROR_RESPONSE, new Gson().toJson(ex.getMessage()));
		}
		
		return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST,ex.getErrorDesc() ,ex),HttpStatus.BAD_REQUEST);
		
	}

}
