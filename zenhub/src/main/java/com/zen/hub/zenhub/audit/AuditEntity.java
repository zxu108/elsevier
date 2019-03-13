package com.zen.hub.zenhub.audit;

import java.util.Date;

public interface AuditEntity {
	Date getDTOlastModificationDate();
	String getDTOLastModificationId();
	String getDTOId();
	String getDTODescription();
	String getDTOOldDescription();
}
