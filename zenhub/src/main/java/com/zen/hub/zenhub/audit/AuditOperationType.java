package com.zen.hub.zenhub.audit;

public enum AuditOperationType {
	NOT_AUDITABLE(0, false), SELECT(1, true), INSERT(2, true), UPDATE(3, true), DELETE(4, true);
	
	private Integer type;
	private Boolean auditable;
	
	AuditOperationType(Integer type, Boolean auditable) {
		this.type = type;
		this.auditable = auditable;
	}

	public Integer getType() {
		return type;
	}

	public boolean isAuditable() {
		return auditable;
	}

	public Boolean isAuditablebeforeMethod() {
		return AuditOperationType.UPDATE.equals(this) || AuditOperationType.DELETE.equals(this);
	}
	
}