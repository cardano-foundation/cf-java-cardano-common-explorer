package com.sotatek.cardano.common.validation;

import static com.sotatek.cardano.common.constanst.ValidationConstant.ADDRESS_MAX_BYTES;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Addr29TypeValidator implements ConstraintValidator<Addr29Type, String> {

  @Override
  public boolean isValid(String bytes, ConstraintValidatorContext constraintValidatorContext) {
    return bytes.length() == ADDRESS_MAX_BYTES;
  }
}
