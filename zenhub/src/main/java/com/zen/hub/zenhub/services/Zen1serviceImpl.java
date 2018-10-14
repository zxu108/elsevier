package com.zen.hub.zenhub.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zen.hub.zenhub.mappers.CustMapper;
import com.zen.hub.zenhub.model.CustomerInfo;
import com.zen.hub.zenhub.model.Zenmodel1;

@Service
public class Zen1serviceImpl implements Zen1service {

	private static final Logger LOGGER = LoggerFactory.getLogger(Zen1serviceImpl.class);
	
	@Autowired
	private CustMapper custMapper;
	
	@Override
	public Zenmodel1 getMode1(Integer i1, String s1) {
		Zenmodel1 ts1 = new Zenmodel1();
		
		LOGGER.debug("input values id: {} and string {}", i1, s1);
		
		ts1.setId1(i1);
		ts1.setSt1(s1);
		
		return ts1;	
	}

	@Override

	public List<CustomerInfo> selectCust(Integer custId) {
		
		List<CustomerInfo> lcust = custMapper.selectCust(custId);
		
		LOGGER.info("search for info for {} with size {}", custId, lcust.size());
		
		return lcust;
	}
}
