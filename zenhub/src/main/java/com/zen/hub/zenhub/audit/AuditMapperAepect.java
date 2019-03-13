package com.zen.hub.zenhub.audit;

import java.lang.annotation.Annotation;

import com.google.common.collect.Lists;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AuditMapperAepect {

	@Autowired 
	private AuditServiceFactory auditServiceFactory;
	
	@Around("execution(* com.zen.hub.zenhub.mappers.*.*(..) )")
	public Object beforeUpdateEntity(ProceedingJoinPoint pjp) throws Throwable {
		Signature signature = pjp.getSignature();
		
		Annotation annotation = signature.getDeclaringType().getAnnotation(Auditable.class);
		
		AuditOperationType operationType = getOperationType(signature, annotation);
		
		if(operationType.isAuditable() && operationType.isAuditablebeforeMethod()) {
			applyAudit(pjp, operationType);
	}
		
		Object result = pjp.proceed();
		
		if(operationType.isAuditable() && !operationType.isAuditablebeforeMethod()) {
			applyAudit(pjp, operationType);
	}
		
		return result;
}


private AuditOperationType getOperationType(Signature signature, Annotation annotation) {
	AuditOperationType operationType = AuditOperationType.NOT_AUDITABLE;
	
	if (annotation != null) {
		Auditable audit = (Auditable) annotation;
		
		if (Lists.newArrayList(audit.selectMethods()).contains(signature.getName())) {
			operationType = AuditOperationType.SELECT;
		} else if (Lists.newArrayList(audit.insertMethods()).contains(signature.getName())) {
			operationType = AuditOperationType.INSERT;
		} else if (Lists.newArrayList(audit.updateMethods()).contains(signature.getName())) {
			operationType = AuditOperationType.UPDATE;
		} else if (Lists.newArrayList(audit.deleteMethods()).contains(signature.getName())) {
			operationType = AuditOperationType.DELETE;
		} else {
			operationType = AuditOperationType.NOT_AUDITABLE;
		}
	}
		return operationType;
}

private void applyAudit(ProceedingJoinPoint pjp, AuditOperationType operationType) {
	Object entity = pjp.getArgs()[0];
	AuditService service = auditServiceFactory.getService(entity);
	service.applyAudit(entity, operationType);
}
}