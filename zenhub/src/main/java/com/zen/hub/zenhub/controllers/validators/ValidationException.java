package com.zen.hub.zenhub.controllers.validators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidationException extends RuntimeException {
	private static final Logger LOGGER = LoggerFactory.getLogger(ValidationException.class);
		public ValidationException(String message) {
			super(message);
			LOGGER.debug("Exception is: "+ message);
		}
}
