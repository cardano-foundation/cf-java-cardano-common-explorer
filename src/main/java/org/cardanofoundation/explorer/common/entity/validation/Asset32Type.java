package org.cardanofoundation.explorer.common.entity.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = Asset32TypeValidator.class)
@Documented
public @interface Asset32Type {
  String message() default "The value must be Asset32Type";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
