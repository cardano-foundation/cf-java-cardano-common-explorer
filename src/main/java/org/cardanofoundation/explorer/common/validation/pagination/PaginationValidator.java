package org.cardanofoundation.explorer.common.validation.pagination;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import io.jsonwebtoken.lang.Strings;

public class PaginationValidator implements ConstraintValidator<PaginationValid, Pagination> {

  private String[] sort;

  @Override
  public void initialize(PaginationValid constraintAnnotation) {
    this.sort = constraintAnnotation.sort();
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(Pagination value, ConstraintValidatorContext context) {
    if (Objects.isNull(value.getSort())) {
      return true;
    }

    if (this.checkIfInvalidFormatSort(value.getSort())) {
      context.buildConstraintViolationWithTemplate("Sort wrong format").addConstraintViolation();
      return false;
    }
    if (this.checkIfInvalidSortableFields(value.getSort(), this.sort)) {
      context
          .buildConstraintViolationWithTemplate(
              "The list of sort fields: "
                  + this.getListOfInvalidSort(value.getSort(), this.sort)
                  + " could either not found or denied for sort action")
          .addConstraintViolation();
      return false;
    }
    return true;
  }

  private boolean checkIfInvalidFormatSort(final List<String> sort) {
    if (sort.size() == 2) {
      this.reformatIfCommaSeparated(sort);
    }
    return !sort.stream().allMatch(t -> t.matches("^[\\w-\\.]+(?:(,(?:DESC|ASC|desc|asc))|)$"));
  }

  private void reformatIfCommaSeparated(final List<String> sort) {
    if (sort.get(1).matches("^(desc|asc|DESC|ASC)$")) {
      this.clearAndBindingComma(sort);
    }
  }

  private void clearAndBindingComma(final List<String> sort) {
    String t = Strings.collectionToCommaDelimitedString(sort);
    sort.clear();
    sort.add(t);
  }

  private Boolean checkIfInvalidSortableFields(final List<String> sort, String[] sortCondition) {
    return sortCondition.length > 0
        && sort.size() > 0
        && sort.stream()
            .map(this::getFirstOfCommaArray)
            .anyMatch(t -> Arrays.stream(sortCondition).noneMatch(t::equals));
  }

  private String getFirstOfCommaArray(String needToProcess) {
    return Arrays.stream(Strings.commaDelimitedListToStringArray(needToProcess))
        .findFirst()
        .orElse("");
  }

  private List<String> getListOfInvalidSort(final List<String> sort, String[] sortCondition) {
    return sort.stream()
        .map(this::getFirstOfCommaArray)
        .filter(t -> Arrays.stream(sortCondition).noneMatch(t::equals))
        .toList();
  }
}
