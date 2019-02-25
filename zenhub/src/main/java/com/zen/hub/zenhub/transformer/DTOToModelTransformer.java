package com.zen.hub.zenhub.transformer;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.zen.hub.zenhub.dto.CenterDTO;
import com.zen.hub.zenhub.dto.CenterEnrollDTO;
import com.zen.hub.zenhub.model.Center;

@Component
public class DTOToModelTransformer {


	public Center toCenter(CenterDTO centerDto) {
		Center center = new Center();
		
		center.setCenterAddress1(centerDto.getCenterAddress1());
		center.setCenterAddress2(centerDto.getCenterAddress2());
		center.setCenterCity(centerDto.getCenterCity());
		center.setCenterCloseEndDate(centerDto.getCenterOpendDate());
		center.setCenterCloseStartDate(centerDto.getCenterCloseStartDate());
		center.setCenterCountry(centerDto.getCenterCountry());
		center.setCenterCustomerRating(centerDto.getCenterCustomerRating());
		center.setCenterDescription(centerDto.getCenterDescription());
		center.setCenterId(centerDto.getCenterId());
		center.setCenterLevel(centerDto.getCenterLevel());
		center.setCenterLogo(centerDto.getCenterLogo());
		center.setCenterModifiedBy(centerDto.getCenterModifiedBy());
		center.setCenterModifiedDate(centerDto.getCenterModifiedDate());
		center.setCenterName(centerDto.getCenterName());
		center.setCenterOpendDate(centerDto.getCenterOpendDate());
		center.setCenterOpenStatus(centerDto.isCenterOpenStatus());
		center.setCenterOwnerEmail(centerDto.getCenterOwnerEmail());
		center.setCenterOwnerFirstName(centerDto.getCenterOwnerFirstName());
		center.setCenterOwnerLandPhone(centerDto.getCenterOwnerLandPhone());
		center.setCenterOwnerLastName(centerDto.getCenterOwnerLastName());
		center.setCenterOwnerMidName(centerDto.getCenterOwnerMidName());
		center.setCenterOwnerMobilePhone(centerDto.getCenterOwnerMobilePhone());
		center.setCenterPassword(centerDto.getCenterPassword());
		center.setCenterState(centerDto.getCenterState());
		center.setCenterZipCode(centerDto.getCenterZipCode());
		center.setId(centerDto.getId());
		
		return center;
	}
	
	
	public Center toCenterEnroll(CenterEnrollDTO centerEnrollDTO) {
		Center center = new Center();
		
		center.setCenterAddress1(centerEnrollDTO.getCenterAddress1());
		center.setCenterAddress2(centerEnrollDTO.getCenterAddress2());
		center.setCenterCity(centerEnrollDTO.getCenterCity());
		center.setCenterCloseEndDate(new Date());	// To be changed
		center.setCenterCloseStartDate(centerEnrollDTO.getCenterCloseStartDate());
		center.setCenterCountry(centerEnrollDTO.getCenterCountry());
		center.setCenterCustomerRating(95);			// To be changed
		center.setCenterDescription(centerEnrollDTO.getCenterDescription());
		center.setCenterId(centerEnrollDTO.getCenterId());
		center.setCenterLevel(5);					// To be changed
//		center.setCenterLogo(centerEnrollDTO.getCenterLogo());
		center.setCenterModifiedBy("Test ID");		// To be changed
		center.setCenterModifiedDate(new Date());	// To be changed
		center.setCenterName(centerEnrollDTO.getCenterName());
		center.setCenterOpendDate(new Date());		// To be changed
		center.setCenterOpenStatus(centerEnrollDTO.isCenterOpenStatus());
		center.setCenterOwnerEmail(centerEnrollDTO.getCenterOwnerEmail());
		center.setCenterOwnerFirstName(centerEnrollDTO.getCenterOwnerFirstName());
		center.setCenterOwnerLandPhone(centerEnrollDTO.getCenterOwnerPhone());
		center.setCenterOwnerLastName(centerEnrollDTO.getCenterOwnerLastName());
		center.setCenterOwnerMidName(centerEnrollDTO.getCenterOwnerMidName());
		center.setCenterOwnerMobilePhone("3027654310");	// To be changed
		center.setCenterPassword(centerEnrollDTO.getCenterPassword());
		center.setCenterState(centerEnrollDTO.getCenterState());
		center.setCenterZipCode(centerEnrollDTO.getCenterZipCode());
		center.setId(1);
		
		return center;
	}
}
