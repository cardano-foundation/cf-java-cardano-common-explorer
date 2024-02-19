package org.cardanofoundation.explorer.common.validation.pagination;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import org.springframework.data.domain.Sort;

@Constraint(validatedBy = {PaginationDefaultValidator.class})
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PaginationDefault {
  String message() default "";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  /**
   * The default-size the injected {@link org.springframework.data.domain.Pageable} should get if no
   * corresponding parameter defined in request (default is {@code 10}).
   */
  int size() default 10;

  /**
   * The default page number the injected {@link org.springframework.data.domain.Pageable} should
   * use if no corresponding parameter defined in request (default is {@code 0}).
   */
  int page() default 0;

  /**
   * The properties to sort by default. If unset, no sorting will be applied at all.
   *
   * @return
   */
  String[] sort() default {};

  /**
   * The direction to sort by. Defaults to {@link Sort.Direction#ASC}.
   *
   * @return
   */
  Sort.Direction direction() default Sort.Direction.ASC;
}
