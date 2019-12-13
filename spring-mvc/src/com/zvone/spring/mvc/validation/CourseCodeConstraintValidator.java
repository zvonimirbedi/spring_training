package com.zvone.spring.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	private String[] coursePrefix;

	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();
	}

	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {

		boolean result;
		if (theCode != null) {

			for (int i = 0; i < coursePrefix.length; i++) {
				result = theCode.startsWith(coursePrefix[i]);
				if (result == true) {
					return result;
				}
			}
			result = false;

		} else {
			result = true;
		}
		return result;
	}

}
