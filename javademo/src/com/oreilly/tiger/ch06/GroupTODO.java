package com.oreilly.tiger.ch06;

import java.util.Date;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface GroupTODO {

	public enum Severity {
		CRITICAL, IMPORTANT, TRIVIAL, DOCUMENTATION
	};

	Severity severity() default Severity.IMPORTANT;

	String item();

	String assignedTo();

	String dateAssigned();
}