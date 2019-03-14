package com.zen.hub.zenhub.audit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zen.hub.zenhub.services.audit.CenterAuditService;
import com.zen.hub.zenhub.services.audit.Zen1Auditservice;

@Component
public class AuditServiceFactory {

	@Autowired
	private CenterAuditService centerAuditService;
	
	@Autowired
	private Zen1Auditservice zen1Auditservice;
	
	/** insert/update audit **/
	
	AuditService getService(Object entity) {

		if (entity == null) {
			throw new UnsupportedOperationException();
		}
		
		switch(entity.getClass().getSimpleName()) {
		case ("Center"): 
			return centerAuditService;
		case ("CustomerInfo"):
			return zen1Auditservice;
		default:
			throw new UnsupportedOperationException();
		}
		
	}
	
	/** read audit **/
	public AuditService<?,?> getReadService(String functionName) {
		if (functionName == null) {
			throw new UnsupportedOperationException();
		}
		
		switch(functionName) {
		case ("CenterAudit"): 
			return centerAuditService;
		case ("CustomerInfoAudit"):
			return zen1Auditservice;
		default:
			throw new UnsupportedOperationException();
		}
	}
}
