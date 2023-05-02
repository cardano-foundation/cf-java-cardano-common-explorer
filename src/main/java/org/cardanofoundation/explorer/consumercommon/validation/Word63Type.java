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
@Constraint(validatedBy = Word63TypeValidator.class)
@Documented
public @interface Word63Type {
  String message() default "The value must be Word63Type";

  Class<?>[] groups() default { };

  Class<? extends Payload>[] payload() default { };
}
class Word63TypeValidator implements ConstraintValidator<Word63Type, Long> {

  @Override
  public boolean isValid(Long aLong, ConstraintValidatorContext constraintValidatorContext) {
    return aLong >= 0;
  }
}
