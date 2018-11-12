package com.zen.hub.zenhub.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zen.hub.zenhub.model.Center;

@Mapper
public interface CenterMapper {	
	Center selectCenter(@Param("id") Integer id);	
}