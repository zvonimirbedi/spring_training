package com.zvone.spring.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

	public String[] value() default {"LUV","TOPS"};
	public String message() default "Must start with LUV or TOPS!";
	
	

	public Class<?>[] groups() default{};
	public Class<? extends Payload>[] payload() default{};
	
}
