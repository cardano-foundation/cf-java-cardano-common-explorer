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
@Constraint(validatedBy = TxIndexValidator.class)
@Documented
public @interface TxIndex {
  String message() default "The value must be TxIndex";

  Class<?>[] groups() default { };

  Class<? extends Payload>[] payload() default { };
}

