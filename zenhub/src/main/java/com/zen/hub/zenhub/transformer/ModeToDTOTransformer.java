package com.zen.hub.zenhub.transformer;

import org.springframework.stereotype.Component;

import com.zen.hub.zenhub.dto.CustInfoDTO;
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
}
