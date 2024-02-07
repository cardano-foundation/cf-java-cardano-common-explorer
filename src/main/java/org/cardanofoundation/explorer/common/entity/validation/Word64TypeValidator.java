package org.cardanofoundation.explorer.common.entity.validation;

import java.math.BigInteger;
import java.util.Objects;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.cardanofoundation.explorer.common.constants.ValidationConstant;

public class Word64TypeValidator implements ConstraintValidator<Word64Type, BigInteger> {

  private static final BigInteger MAX_64_BYTES = ValidationConstant.getMaxLoveLace();

  /**
   * Checking if input number is out of range 2^64 or not if not return true else false
   *
   * @param number number
   * @param constraintValidatorContext
   * @return boolean
   */
  @Override
  public boolean isValid(BigInteger number, ConstraintValidatorContext constraintValidatorContext) {
    return Objects.isNull(number)
        || (number.compareTo(BigInteger.ZERO) >= BigInteger.ZERO.intValue()
            && number.compareTo(MAX_64_BYTES) <= BigInteger.ZERO.intValue());
  }
}
