package org.cardanofoundation.explorer.common;

import java.math.BigInteger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.cardanofoundation.explorer.common.entity.validation.Word31TypeValidator;

class Word31TypeValidatorTest {

  Word31TypeValidator validator = new Word31TypeValidator();

  @Test
  void isValid() {
    BigInteger number = BigInteger.ZERO;
    Assertions.assertTrue(validator.isValid(number.intValue(), null));
    number = BigInteger.valueOf(255);
    Assertions.assertTrue(validator.isValid(number.intValue(), null));
  }

  @Test
  void isNotValidLengthSmaller() {
    BigInteger number = BigInteger.valueOf(-1);
    Assertions.assertEquals(Boolean.FALSE, validator.isValid(number.intValue(), null));
  }
}
