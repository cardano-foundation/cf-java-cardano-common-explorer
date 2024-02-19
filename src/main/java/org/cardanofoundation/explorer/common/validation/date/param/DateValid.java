package org.cardanofoundation.explorer.common.validation.date.param;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Payload;

import org.cardanofoundation.explorer.common.validation.date.DatePattern;

@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface DateValid {
  String message() default "Invalid date format";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  DatePattern pattern() default DatePattern.YYYY_MM_DD_HH_MM_SS;
}
