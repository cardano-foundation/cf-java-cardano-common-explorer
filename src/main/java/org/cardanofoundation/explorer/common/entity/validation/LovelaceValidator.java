package org.cardanofoundation.explorer.common.entity.validation;

import java.math.BigInteger;
import java.util.Objects;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.cardanofoundation.explorer.common.constants.ValidationConstant;

public class LovelaceValidator implements ConstraintValidator<Lovelace, BigInteger> {

  public static final BigInteger MAX_64_BYTES = ValidationConstant.getMaxLoveLace();

  /**
   * Checking if input lovelace is out of range 2^64 or not
   *
   * @param number lovelace
   * @param constraintValidatorContext
   * @return boolean
   */
  @Override
  public boolean isValid(BigInteger number, ConstraintValidatorContext constraintValidatorContext) {
    return Objects.isNull(number)
        || (number.compareTo(BigInteger.valueOf(BigInteger.ZERO.longValue()))
                >= BigInteger.ZERO.intValue()
            && number.compareTo(MAX_64_BYTES) <= BigInteger.ZERO.intValue());
  }
}
