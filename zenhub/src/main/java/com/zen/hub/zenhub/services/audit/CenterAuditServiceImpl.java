package com.zen.hub.zenhub.services.audit;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zen.hub.zenhub.audit.AuditOperationType;
import com.zen.hub.zenhub.mappers.CenterMapper;
import com.zen.hub.zenhub.mappers.audit.CenterAuditMapper;
import com.zen.hub.zenhub.model.Center;
import com.zen.hub.zenhub.model.audit.CenterAudit;

@Service
public class CenterAuditServiceImpl implements CenterAuditService<Center, CenterAudit> {

	private static final Logger LOGGER = LoggerFactory.getLogger(CenterAuditServiceImpl.class);

	@Autowired
	private CenterMapper centerMapper;
	
	@Autowired
	private CenterAuditMapper centerAuditMapper;
	
	@Override
	public void applyAudit(Center entity, AuditOperationType operationType) {

    LOGGER.info("Applying audit for Center {} for operation {}", entity.getCenterId(), operationType);
    
    Center previousValue = null;
    
    if (AuditOperationType.UPDATE.equals(operationType) || AuditOperationType.DELETE.equals(operationType)) {
    	previousValue = centerMapper.selectCenter(entity.getId());   	
    }
	
    CenterAudit audit = new CenterAudit.CenterAuditBuilder()
    		.withNewValue(entity)
    		.withOldValue(previousValue)
    		.withrevType(operationType.getType())
    		.build();
    
    centerAuditMapper.insertAudit(audit);
    
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
