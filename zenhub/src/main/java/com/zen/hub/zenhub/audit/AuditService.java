package com.zen.hub.zenhub.audit;

import java.util.Date;
import java.util.List;

public interface AuditService<T,E> {

	void applyAudit(T entity, AuditOperationType operationType);

	List<E> GetAuditListById(String Id, Date startDateTime, Date endDateTime, String Sorting, String ascDesc, Integer currentPage, Integer pageSize);
	
	Integer getTotalRow(String Id, Date startDateTime, Date endDateTime);
	}
