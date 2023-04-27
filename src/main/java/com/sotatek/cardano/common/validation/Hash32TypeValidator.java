package com.sotatek.cardano.common.validation;

import static com.sotatek.cardano.common.constanst.ValidationConstant.HASH_32;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Hash32TypeValidator implements ConstraintValidator<Hash32Type, String> {

  /**
   * Checking if input string length equal to 64 or not . if equal return true  else false
   *
   * @param string                     hash string
   * @param constraintValidatorContext
   * @return boolean
   */
  @Override
  public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {
    return string.length() == HASH_32;
  }
}
