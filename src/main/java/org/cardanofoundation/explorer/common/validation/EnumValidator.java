package org.cardanofoundation.explorer.common.validation;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EnumValidator implements ConstraintValidator<EnumValid, CharSequence> {

  private List<String> acceptedValues;

  @Override
  public void initialize(EnumValid annotation) {
    acceptedValues =
        Stream.of(annotation.enumClass().getEnumConstants())
            .map(Enum::name)
            .collect(Collectors.toList());
  }

  @Override
  public boolean isValid(
      CharSequence value, ConstraintValidatorContext constraintValidatorContext) {
    if (value == null) {
      return true;
    }
    return acceptedValues.contains(value.toString());
  }
}
