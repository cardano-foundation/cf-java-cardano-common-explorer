package org.cardanofoundation.explorer.common;

import java.math.BigInteger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.cardanofoundation.explorer.common.entity.validation.TxIndexValidator;

class TxIndexValidatorTest {

  TxIndexValidator validator = new TxIndexValidator();

  @Test
  void isValid() {
    BigInteger number = BigInteger.ZERO;
    Assertions.assertTrue(validator.isValid(number.shortValue(), null));
    number = BigInteger.valueOf(255);
    Assertions.assertTrue(validator.isValid(number.shortValue(), null));
  }

  @Test
  void isNotValidLengthSmaller() {
    BigInteger number = BigInteger.valueOf(-1);
    Assertions.assertEquals(Boolean.FALSE, validator.isValid(number.shortValue(), null));
  }
}
