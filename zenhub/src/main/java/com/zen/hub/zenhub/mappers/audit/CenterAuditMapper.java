package com.zen.hub.zenhub.mappers.audit;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zen.hub.zenhub.model.audit.CenterAudit;

@Mapper
public interface CenterAuditMapper {	
//	Center selectCenter(@Param("id") Integer id);	
//	List<Center> getCenterList(@Param("sortByTag") CenterSorting sortByTag, @Param("sortingDirection") SortingDirection sortingDirection);
//	List<Center> findCenterWithCenterId(@Param("centerId") String centerId);
//	int getTotalCenterCount(); 
	int insertAudit(@Param("audit") CenterAudit audit);
}