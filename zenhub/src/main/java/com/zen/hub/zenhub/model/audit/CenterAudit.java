package com.zen.hub.zenhub.model.audit;

import java.util.Date;

import com.zen.hub.zenhub.audit.AuditEntity;
import com.zen.hub.zenhub.model.Center;

public class CenterAudit extends Center implements AuditEntity {
	private Integer rev;
	private Integer revType;
	private Integer id;
	
	private String centerPasswordOld;
	private String centerNameOld;
	private String centerDescriptionOld;
	private boolean centerOpenStatusOld;		
	
	public static class CenterAuditBuilder {
	private Integer revId;
	private Integer revType;
	private Center oldValue;
	private Center newValue;
	
	public CenterAuditBuilder() {		
	}
	
	public CenterAuditBuilder withrevId(Integer revId) {
		this.revId = revId;
		return this;
	}
	
	public CenterAuditBuilder withrevType(Integer revType) {
		this.revType = revType;
		return this;
	}
	
	public CenterAuditBuilder withNewValue(Center newValue) {
		this.newValue = newValue;
		return this;
	}
	
	public CenterAuditBuilder withOldValue(Center oldValue) {
		this.oldValue = oldValue;
		return this;
	}
	
	public CenterAudit build() {
		CenterAudit audit = new CenterAudit();
		audit.setRev(revId);
		audit.setRevType(revType);
		
		if (newValue != null) {
			audit.setCenterPassword(newValue.getCenterPassword());
			audit.setCenterName(newValue.getCenterName());
			audit.setCenterDescription(newValue.getCenterDescription());
			audit.setCenterOpenStatus(newValue.isCenterOpenStatus());			
		}
		
		if (oldValue != null) {
			audit.setCenterPasswordOld(oldValue.getCenterPassword());
			audit.setCenterNameOld(oldValue.getCenterName());
			audit.setCenterDescriptionOld(oldValue.getCenterDescription());
			audit.setCenterOpenStatusOld(oldValue.isCenterOpenStatus());			
			
		}
		
		return audit;
	}
	}
	
	public Integer getRev() {
		return rev;
	}
	public void setRev(Integer rev) {
		this.rev = rev;
	}
	public Integer getRevType() {
		return revType;
	}
	public void setRevType(Integer revType) {
		this.revType = revType;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCenterPasswordOld() {
		return centerPasswordOld;
	}
	public void setCenterPasswordOld(String centerPasswordOld) {
		this.centerPasswordOld = centerPasswordOld;
	}
	public String getCenterNameOld() {
		return centerNameOld;
	}
	public void setCenterNameOld(String centerNameOld) {
		this.centerNameOld = centerNameOld;
	}
	public String getCenterDescriptionOld() {
		return centerDescriptionOld;
	}
	public void setCenterDescriptionOld(String centerDescriptionOld) {
		this.centerDescriptionOld = centerDescriptionOld;
	}
	public boolean isCenterOpenStatusOld() {
		return centerOpenStatusOld;
	}
	public void setCenterOpenStatusOld(boolean centerOpenStatusOld) {
		this.centerOpenStatusOld = centerOpenStatusOld;
	}

	@Override
	public Date getDTOlastModificationDate() {
	return super.getCenterModifiedDate();
	}
	@Override
	public String getDTOLastModificationId() {
		return super.getCenterOwnerLastName();
	}
	@Override
	public String getDTOId() {
		return this.getId().toString();
	}
	@Override
	public String getDTODescription() {
		String resultStr = "";
		
		if (super.getCenterPassword() != null) {
			resultStr = "\nPassword="+super.getCenterPassword();
		}
		
		if (super.getCenterName() != null) {
			resultStr = "\nName="+super.getCenterName();
		}
		
		if (super.getCenterDescription() != null) {
			resultStr = "\nDescription="+super.getCenterDescription();
		}

			resultStr = "\nOpenStatus="+super.isCenterOpenStatus();

		return resultStr;
	}
	@Override
	public String getDTOOldDescription() {
		String resultStr = "";
		
		if (getCenterPasswordOld() != null) {
			resultStr = "\nPassword="+getCenterPasswordOld();
		}
		
		if (getCenterNameOld() != null) {
			resultStr = "\nName="+getCenterNameOld();
		}
		
		if (getCenterDescriptionOld() != null) {
			resultStr = "\nDescription="+getCenterDescriptionOld();
		}

			resultStr = "\nOpenStatus="+isCenterOpenStatusOld();

		return resultStr;
	}		
	
}
