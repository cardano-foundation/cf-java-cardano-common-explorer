package com.sotatek.cardano.common.validation;

import static com.sotatek.cardano.common.constanst.ValidationConstant.HASH_28;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Hash28TypeValidator implements ConstraintValidator<Hash28Type, String> {


  /**
   * Checking if input string length equal to 56 or not . if equal return true  else false
   *
   * @param string                     hash string
   * @param constraintValidatorContext
   * @return boolean
   */
  @Override
  public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {
    return string.length() == HASH_28;
  }
}
