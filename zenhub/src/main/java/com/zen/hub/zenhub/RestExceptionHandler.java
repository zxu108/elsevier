package com.zen.hub.zenhub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.zen.hub.zenhub.controllers.validators.ValidationException;
import com.zen.hub.zenhub.security.AuthorizationException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	String error = "Malformed JSON request";	
	return buildResponseEntiry(new ApiError(HttpStatus.BAD_REQUEST, error));	
	}

	@ExceptionHandler(AuthorizationException.class)
	protected ResponseEntity<Object> authorizationException(AuthorizationException ex) {
	ApiError apiError = new ApiError(HttpStatus.UNAUTHORIZED, "Access denied: " + ex.getMessage());	
	return buildResponseEntiry(apiError);	
	}
	
	@ExceptionHandler(ValidationException.class)
	protected ResponseEntity<Object> validationException(ValidationException ex) {
	ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage());	
	return buildResponseEntiry(apiError);	
	}
	
	
	private ResponseEntity<Object> buildResponseEntiry(ApiError apiError) {
		LOGGER.debug("exception error: {}", apiError.getMessage());
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
}
