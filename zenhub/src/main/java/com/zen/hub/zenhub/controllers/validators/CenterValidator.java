package com.zen.hub.zenhub.controllers.validators;

import org.springframework.stereotype.Component;

import com.zen.hub.zenhub.dto.CenterDTO;

@Component
public class CenterValidator {

	public void validateInsert(CenterDTO centerDto) {
		
		if (centerDto == null) {
			throw new ValidationException("No Valid Center Data");			
		}
		
		if (centerDto.getCenterId() == null) {
			throw new ValidationException("Please enter a valid center Id");	
		}
		
		if (centerDto.getCenterName() == null) {
			throw new ValidationException("Please enter a valid center Name");	
		}
		
	}
}
