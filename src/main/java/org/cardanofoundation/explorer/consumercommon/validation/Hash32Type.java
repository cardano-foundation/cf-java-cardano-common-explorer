package org.cardanofoundation.explorer.consumercommon.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = Hash32TypeValidator.class)
@Documented
public @interface Hash32Type {
  String message() default "The value must be Hash32Type";

  Class<?>[] groups() default { };

  Class<? extends Payload>[] payload() default { };
}

class Hash32TypeValidator implements ConstraintValidator<Hash32Type, String> {

  @Override
  public boolean isValid(String bytes, ConstraintValidatorContext constraintValidatorContext) {
    return bytes.length() == 64;
  }
}