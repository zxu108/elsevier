package com.zen.hub.zenhub.audit;

public interface AuditService<T,E> {

	void applyAudit(T entity, AuditOperationType operationType);

	}
