package com.zen.hub.zenhub.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zen.hub.zenhub.mappers.CenterMapper;
import com.zen.hub.zenhub.model.Center;

@Service
public class CenterServiceImpl implements CenterService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CenterServiceImpl.class);
	
	@Autowired
	private CenterMapper centerMapper;
	
	@Override
	public Center selectCenter(Integer id) {
	
		Center ct = centerMapper.selectCenter(id);
		
		LOGGER.info("search center info for {} with size {}", id, ct.toString());
		return ct;
	}
}
