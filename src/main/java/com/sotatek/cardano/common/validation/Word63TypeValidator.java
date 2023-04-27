package com.sotatek.cardano.common.validation;

import java.math.BigInteger;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Word63TypeValidator implements ConstraintValidator<Word63Type, Long> {

  /**
   * Checking if input number greater than 0
   * if not return true else false
   * @param aLong                      number
   * @param constraintValidatorContext
   * @return boolean
   */
  @Override
  public boolean isValid(Long aLong, ConstraintValidatorContext constraintValidatorContext) {
    return aLong >= BigInteger.ONE.intValue();
  }
}
