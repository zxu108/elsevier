package com.zen.hub.zenhub.audit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;	

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Auditable {
	String[] selectMethods() default {};
	String[] insertMethods() default {};
	String[] updateMethods() default {};
	String[] deleteMethods() default {};
}
