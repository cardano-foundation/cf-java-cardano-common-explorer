package org.cardanofoundation.explorer.common.entity.validation;

import java.math.BigInteger;
import java.util.Objects;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.cardanofoundation.explorer.common.constants.ValidationConstant;

public class Int65TypeValidator implements ConstraintValidator<Int65Type, BigInteger> {

  public static final BigInteger MAX_64_BYTES = ValidationConstant.getMaxInt65();
  public static final BigInteger MIN_64_BYTES = ValidationConstant.getMinInt65();

  /**
   * Checking if input number greater than MAX_64_BYTES or smaller MIN_64_BYTES . if not return true
   * else false
   *
   * @param number number
   * @param constraintValidatorContext
   * @return boolean
   */
  @Override
  public boolean isValid(BigInteger number, ConstraintValidatorContext constraintValidatorContext) {
    return Objects.isNull(number)
        || (number.compareTo(MIN_64_BYTES) >= BigInteger.ZERO.intValue()
            && number.compareTo(MAX_64_BYTES) < BigInteger.ZERO.intValue());
  }
}
