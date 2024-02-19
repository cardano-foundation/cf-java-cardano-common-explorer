package org.cardanofoundation.explorer.common.validation.date.requestbody;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.cardanofoundation.explorer.common.validation.date.DatePattern;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface JsonPattern {
  DatePattern pattern() default DatePattern.YYYY_MM_DD_HH_MM_SS;
}
