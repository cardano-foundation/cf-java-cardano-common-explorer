package org.cardanofoundation.explorer.common.validation.pagination;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = {PageZeroValidator.class})
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PageZeroValid {
  String message() default "The page number must be 0";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
