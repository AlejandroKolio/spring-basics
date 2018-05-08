package com.udemy.spring.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author alexander.shakhov on 08.05.2018 12:32
 */
public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

   private String coursePrefix;

   public void initialize(CourseCode courseCode) {
      coursePrefix = courseCode.value();
   }

   public boolean isValid(String code, ConstraintValidatorContext context) {
      boolean result;
      if(code != null) {
         result = code.startsWith(coursePrefix);
      } else {
         result = true;
      }

      return result;
   }
}
