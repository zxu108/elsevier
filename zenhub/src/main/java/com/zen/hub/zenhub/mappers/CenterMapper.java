package com.zen.hub.zenhub.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zen.hub.zenhub.mappers.sorting.CenterSorting;
import com.zen.hub.zenhub.mappers.sorting.SortingDirection;
import com.zen.hub.zenhub.model.Center;

@Mapper
public interface CenterMapper {	
	Center selectCenter(@Param("id") Integer id);	
	List<Center> getCenterList(@Param("sortByTag") CenterSorting sortByTag, @Param("sortingDirection") SortingDirection sortingDirection);
	int getTotalCenterCount(); 
	int insertCenter(Center center);
}