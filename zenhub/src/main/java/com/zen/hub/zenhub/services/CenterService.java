package com.zen.hub.zenhub.services;

import java.util.List;

import com.zen.hub.zenhub.mappers.sorting.CenterSorting;
import com.zen.hub.zenhub.mappers.sorting.SortingDirection;
import com.zen.hub.zenhub.model.Center;

public interface CenterService {
	
	Center selectCenter(Integer id);	
	List<Center> getCenterList(CenterSorting sortByTag, SortingDirection sortingDirection);
	List<Center> findCenterWithCenterId(String centerId);
	int getTotalCenterCount(); 
	Center insertCenter(Center center);
}
