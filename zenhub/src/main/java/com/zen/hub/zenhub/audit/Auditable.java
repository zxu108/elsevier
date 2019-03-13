package com.zen.hub.zenhub.audit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;	

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Auditable {
	String[] selectMethods() default {};
	String[] insertMethods() default {};
	String[] updateMethods() default {};
	String[] deleteMethods() default {};
}
