package com.zen.hub.zenhub.transformer;

import org.springframework.stereotype.Component;

import com.zen.hub.zenhub.dto.CenterDTO;
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
}
