package com.zen.hub.zenhub.services.audit;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zen.hub.zenhub.audit.AuditOperationType;
import com.zen.hub.zenhub.audit.AuditService;
import com.zen.hub.zenhub.model.Center;
import com.zen.hub.zenhub.model.audit.CenterAudit;

@Service
public class Zen1AuditserviceImpl implements Zen1Auditservice<Center, CenterAudit> {

	private static final Logger LOGGER = LoggerFactory.getLogger(Zen1AuditserviceImpl.class);

	@Override
	public void applyAudit(Center entity, AuditOperationType operationType) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();		
	}

	@Override
	public List<CenterAudit> GetAuditListById(String Id, Date startDateTime, Date endDateTime, String Sorting,
			String ascDesc, Integer currentPage, Integer pageSize) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public Integer getTotalRow(String Id, Date startDateTime, Date endDateTime) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
}
