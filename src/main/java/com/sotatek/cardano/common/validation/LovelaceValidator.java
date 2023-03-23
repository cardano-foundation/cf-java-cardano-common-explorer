package com.sotatek.cardano.common.validation;

import java.math.BigInteger;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LovelaceValidator implements ConstraintValidator<Lovelace, BigInteger> {

  @Override
  public boolean isValid(BigInteger number, ConstraintValidatorContext constraintValidatorContext) {
    return number.compareTo(BigInteger.valueOf(0L)) >= 0
        && number.compareTo(new BigInteger("18446744073709551615")) <= 0;
  }
}
