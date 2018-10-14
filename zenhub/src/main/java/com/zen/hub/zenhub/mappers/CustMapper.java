package com.zen.hub.zenhub.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zen.hub.zenhub.model.CustomerInfo;

@Mapper
public interface CustMapper {
	
	List<CustomerInfo> selectCust(@Param("customer_id") Integer customer_id);
	
//	Integer insertCust(CustomerInfo customerInfo);
	
}