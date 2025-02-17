package org.cardanofoundation.explorer.common;

import static org.cardanofoundation.explorer.common.entity.validation.Int65TypeValidator.MAX_64_BYTES;
import static org.cardanofoundation.explorer.common.entity.validation.Int65TypeValidator.MIN_64_BYTES;

import java.math.BigInteger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.cardanofoundation.explorer.common.entity.validation.Int65TypeValidator;

class Int65TypeValidatorTest {

  Int65TypeValidator validator = new Int65TypeValidator();

  @Test
  void isValid() {
    BigInteger number = BigInteger.ZERO;
    Assertions.assertTrue(validator.isValid(number, null));
    number = MIN_64_BYTES;
    Assertions.assertTrue(validator.isValid(number, null));
  }

  @Test
  void isNotValidLengthSmaller() {
    BigInteger number = BigInteger.valueOf(-1).add(MIN_64_BYTES);
    Assertions.assertEquals(Boolean.FALSE, validator.isValid(number, null));

    number = BigInteger.ONE.add(MAX_64_BYTES);
    Assertions.assertEquals(Boolean.FALSE, validator.isValid(number, null));
  }
}
