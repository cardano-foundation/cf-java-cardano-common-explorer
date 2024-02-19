package org.cardanofoundation.explorer.common.entity.validation;

import java.math.BigInteger;
import java.util.Objects;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class Word63TypeValidator implements ConstraintValidator<Word63Type, Long> {

  /**
   * Checking if input number greater or equal to 0 if not return true else false
   *
   * @param aLong number
   * @param constraintValidatorContext
   * @return boolean
   */
  @Override
  public boolean isValid(Long aLong, ConstraintValidatorContext constraintValidatorContext) {
    return Objects.isNull(aLong) || aLong >= BigInteger.ZERO.longValue();
  }
}
