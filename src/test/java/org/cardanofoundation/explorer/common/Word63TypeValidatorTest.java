package org.cardanofoundation.explorer.common;

import java.math.BigInteger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.cardanofoundation.explorer.common.entity.validation.Word63TypeValidator;

class Word63TypeValidatorTest {

  Word63TypeValidator validator = new Word63TypeValidator();

  @Test
  void isValid() {
    BigInteger number = BigInteger.ZERO;
    Assertions.assertTrue(validator.isValid(number.longValue(), null));
    number = BigInteger.valueOf(255);
    Assertions.assertTrue(validator.isValid(number.longValue(), null));
  }

  @Test
  void isNotValidLengthSmaller() {
    BigInteger number = BigInteger.valueOf(-1);
    Assertions.assertEquals(Boolean.FALSE, validator.isValid(number.longValue(), null));
  }
}
