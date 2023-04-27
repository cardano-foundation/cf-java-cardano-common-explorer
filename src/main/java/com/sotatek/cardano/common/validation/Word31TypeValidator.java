package com.sotatek.cardano.common.validation;

import java.math.BigInteger;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Word31TypeValidator implements ConstraintValidator<Word31Type, Integer> {

  /**
   * Checking if input number greater than 0 if not return true else false
   *
   * @param integer                    number
   * @param constraintValidatorContext
   * @return boolean
   */
  @Override
  public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
    return integer >= BigInteger.ONE.intValue();
  }
}
