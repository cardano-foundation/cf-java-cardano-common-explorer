package com.sotatek.cardano.common.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = Word128TypeValidator.class)
@Documented
public @interface Word128Type {
  String message() default "The value must be Word128Type";

  Class<?>[] groups() default { };

  Class<? extends Payload>[] payload() default { };
}

