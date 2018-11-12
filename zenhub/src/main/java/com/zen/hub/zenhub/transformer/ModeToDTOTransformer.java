package com.zen.hub.zenhub.transformer;

import org.springframework.stereotype.Component;

import com.zen.hub.zenhub.dto.CenterDTO;
import com.zen.hub.zenhub.dto.CustInfoDTO;
import com.zen.hub.zenhub.model.Center;
import com.zen.hub.zenhub.model.CustomerInfo;

@Component
public class ModeToDTOTransformer {

	public CustInfoDTO toCustInfoDTO(CustomerInfo cust) {
		
	CustInfoDTO cd = new CustInfoDTO();
		
	cd.setCustDob(cust.getCustDob());
	cd.setCustId(cust.getCustId());
	cd.setCustName(cust.getCustName());
	cd.setCustProj(cust.getCustProj());
	cd.setCustSex(cust.getCustSex());
	return cd;
}
	
	public CenterDTO toCenterDTO(Center center) {
		CenterDTO centerDTO = new CenterDTO();
		
		centerDTO.setId(center.getId());
		centerDTO.setCenterId(center.getCenterId());
		centerDTO.setCenterPassword(center.getCenterPassword());
		centerDTO.setCenterName(center.getCenterName());
		centerDTO.setCenterDescription(center.getCenterDescription());
		centerDTO.setCenterLogo(center.getCenterLogo());
		centerDTO.setCenterOpendDate(center.getCenterOpendDate());
		centerDTO.setCenterOwnerFirstName(center.getCenterOwnerFirstName());
		centerDTO.setCenterOwnerMidName(center.getCenterOwnerMidName());
		centerDTO.setCenterOwnerLastName(center.getCenterOwnerLastName());
		centerDTO.setCenterAddress1(center.getCenterAddress1());
		centerDTO.setCenterAddress2(center.getCenterAddress2());
		centerDTO.setCenterCity(center.getCenterCity());
		centerDTO.setCenterState(center.getCenterState());
		centerDTO.setCenterZipCode(center.getCenterZipCode());
		centerDTO.setCenterCountry(center.getCenterCountry());
		centerDTO.setCenterOwnerEmail(center.getCenterOwnerEmail());
		centerDTO.setCenterOwnerLandPhone(center.getCenterOwnerLandPhone());
		centerDTO.setCenterOwnerMobilePhone(center.getCenterOwnerMobilePhone());
		centerDTO.setCenterCustomerRating(center.getCenterCustomerRating());
		centerDTO.setCenterLevel(center.getCenterLevel());
		centerDTO.setCenterCloseStartDate(center.getCenterCloseStartDate());
		centerDTO.setCenterCloseEndDate(center.getCenterCloseEndDate());
		centerDTO.setCenterOpenStatus(center.isCenterOpenStatus());
		centerDTO.setCenterModifiedDate(center.getCenterModifiedDate());
		centerDTO.setCenterModifiedBy(center.getCenterModifiedBy());

		return centerDTO;
	}
}
