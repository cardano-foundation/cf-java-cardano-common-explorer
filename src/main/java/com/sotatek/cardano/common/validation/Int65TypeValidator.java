package com.sotatek.cardano.common.validation;

import com.sotatek.cardano.common.constanst.ValidationConstant;
import java.math.BigInteger;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Validation;

public class Int65TypeValidator implements ConstraintValidator<Int65Type, BigInteger> {

  private static final BigInteger MAX_64_BYTES = ValidationConstant.getMaxInt65();
  private static final BigInteger MIN_64_BYTES = ValidationConstant.getMinInt65();

  /**
   * Checking if input number greater than MAX_64_BYTES or smaller MIN_64_BYTES .
   * if not return true else false
   *
   * @param number                     number
   * @param constraintValidatorContext
   * @return boolean
   */
  @Override
  public boolean isValid(BigInteger number, ConstraintValidatorContext constraintValidatorContext) {
    return number.compareTo(MIN_64_BYTES) >= BigInteger.ONE.intValue()
        && number.compareTo(MAX_64_BYTES) <= BigInteger.ONE.intValue();
  }
}
