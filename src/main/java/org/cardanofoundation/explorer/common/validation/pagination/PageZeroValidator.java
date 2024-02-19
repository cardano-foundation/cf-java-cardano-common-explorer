package org.cardanofoundation.explorer.common.validation.pagination;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PageZeroValidator implements ConstraintValidator<PageZeroValid, Pagination> {

  @Override
  public boolean isValid(Pagination pagination, ConstraintValidatorContext context) {
    return pagination.getPage() == null || pagination.getPage() == 0;
  }
}
