package org.cardanofoundation.explorer.common.validation.pagination;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.springframework.data.domain.Sort;

import io.jsonwebtoken.lang.Strings;

public class PaginationDefaultValidator
    implements ConstraintValidator<PaginationDefault, Pagination> {

  private int size;
  private int page;
  private String[] sort;
  private Sort.Direction direction;

  @Override
  public void initialize(PaginationDefault constraintAnnotation) {
    this.size = constraintAnnotation.size();
    this.page = constraintAnnotation.page();
    this.sort = constraintAnnotation.sort();
    this.direction = constraintAnnotation.direction();
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(Pagination value, ConstraintValidatorContext context) {
    if (Objects.isNull(value.getPage())) {
      value.setPage(this.page);
    }
    if (Objects.isNull(value.getSize())) {
      value.setSize(this.size);
    }
    if (this.sort.length > 0 && this.isEmpty(value.getSort())) {
      value.setSort(getDefault(this.sort, this.direction));
    }
    return true;
  }

  private List<String> getDefault(String[] sort, Sort.Direction direction) {
    return Arrays.stream(sort)
        .map(t -> Strings.arrayToCommaDelimitedString(new String[] {t, direction.name()}))
        .toList();
  }

  private boolean isEmpty(List<String> sort) {
    return Objects.isNull(sort) || sort.size() == 0;
  }
}
