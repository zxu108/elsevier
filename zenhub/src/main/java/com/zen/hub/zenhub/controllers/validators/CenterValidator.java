package com.zen.hub.zenhub.controllers.validators;

import org.springframework.stereotype.Component;

import com.zen.hub.zenhub.dto.CenterDTO;
import com.zen.hub.zenhub.dto.CenterEnrollDTO;

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
	
	public void validateEnrollInsert(CenterEnrollDTO centerEnrollDTO) {
		
		if (centerEnrollDTO == null) {
			throw new ValidationException("No Valid Center Enrollment Data");			
		}
		
		if (centerEnrollDTO.getCenterId() == null) {
			throw new ValidationException("Please enter a valid center Id");	
		}
		
		if (centerEnrollDTO.getCenterName() == null) {
			throw new ValidationException("Please enter a valid center Name");	
		}
	}
}
