package org.cardanofoundation.explorer.common.validation.pagination;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Payload;

@Constraint(validatedBy = {PaginationValidator.class})
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PaginationValid {
  String message() default "";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  /**
   * List of sortable fields. If a #sort input param is requesting a field that outside of #sort()
   * then @throws ValidateException
   *
   * @default id
   * @return list of sortable fields
   * @throws ConstraintViolationException if the input param not in #sort()
   */
  String[] sort() default {};
}
