package org.cardanofoundation.explorer.common.validation.length;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.apache.logging.log4j.util.Strings;

public class LengthValidator implements ConstraintValidator<LengthValid, String> {
  private int length;

  @Override
  public void initialize(LengthValid constraintAnnotation) {
    this.length = constraintAnnotation.value();
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (this.length == 0) {
      context
          .buildConstraintViolationWithTemplate("length value is not configured")
          .addConstraintViolation();
      return false;
    }
    if (Strings.isNotBlank(value) && value.length() != this.length) {
      context
          .buildConstraintViolationWithTemplate(
              "The expected length of the hash is " + this.length + " characters")
          .addConstraintViolation();
      return false;
    }
    return true;
  }
}
