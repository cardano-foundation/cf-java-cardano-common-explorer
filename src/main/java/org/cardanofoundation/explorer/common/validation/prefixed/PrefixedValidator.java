package org.cardanofoundation.explorer.common.validation.prefixed;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.apache.logging.log4j.util.Strings;

public class PrefixedValidator implements ConstraintValidator<PrefixedValid, String> {
  private String prefixed;

  @Override
  public void initialize(PrefixedValid constraintAnnotation) {
    this.prefixed = constraintAnnotation.value();
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (Strings.isBlank(this.prefixed)) {
      context
          .buildConstraintViolationWithTemplate("prefixed value is not configured")
          .addConstraintViolation();
      return false;
    }

    if (!value.startsWith(this.prefixed)) {
      context
          .buildConstraintViolationWithTemplate(
              "Field should have a prefixed value of " + Strings.quote(this.prefixed))
          .addConstraintViolation();
      return false;
    }

    return true;
  }
}
