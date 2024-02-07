package org.cardanofoundation.explorer.common.entity.validation;

import static org.cardanofoundation.explorer.common.constants.ValidationConstant.ADDRESS_MAX_BYTES;

import java.util.Objects;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class Addr29TypeValidator implements ConstraintValidator<Addr29Type, String> {

  @Override
  public boolean isValid(String bytes, ConstraintValidatorContext constraintValidatorContext) {
    return Objects.isNull(bytes) || bytes.length() == ADDRESS_MAX_BYTES;
  }
}
