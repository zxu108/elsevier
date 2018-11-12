package com.zen.hub.zenhub.services;

import java.util.List;

import com.zen.hub.zenhub.model.CustomerInfo;
import com.zen.hub.zenhub.model.Zenmodel1;

public interface Zen1service {

	Zenmodel1 getMode1(Integer i1, String s1) ;
	
	List<CustomerInfo> selectCust(Integer custId);

}
