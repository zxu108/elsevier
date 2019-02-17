package com.zen.hub.zenhub.services;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zen.hub.zenhub.mappers.CenterMapper;
import com.zen.hub.zenhub.mappers.sorting.CenterSorting;
import com.zen.hub.zenhub.mappers.sorting.SortingDirection;
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

	@Override
	public List<Center> getCenterList(CenterSorting sortByTag, SortingDirection sortingDirection) {
		LOGGER.info("get all center info");
		
		List<Center> centerList = centerMapper.getCenterList(sortByTag, sortingDirection);
		
		LOGGER.info("get {} centers", centerList.size());
		
		return centerList;
	}

	@Override
	public int getTotalCenterCount() {
		int centerCount = centerMapper.getTotalCenterCount();
		
		LOGGER.info("total center count is: {}", centerCount);
		return centerCount;
	}

	@Override
	public Center insertCenter(Center center) {
		LOGGER.info("create new center for {}", center.getCenterId());		
		center.setCenterOpendDate(new Date());
		
		int inserted = centerMapper.insertCenter(center);

		LOGGER.info("center created: {}", inserted);
		
		return center;
	}
}
