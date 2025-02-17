package org.cardanofoundation.explorer.common;

import static org.cardanofoundation.explorer.common.constants.ValidationConstant.HASH_28;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.cardanofoundation.explorer.common.entity.validation.Hash28TypeValidator;

class Hash28TypeValidatorTest {

  Hash28TypeValidator validator = new Hash28TypeValidator();

  @Test
  void isValid() {
    char[] charLength = new char[HASH_28];
    Assertions.assertTrue(validator.isValid(String.valueOf(charLength), null));
  }

  @Test
  void isNotValidLengthSmaller() {
    char[] charLength = new char[0];
    Assertions.assertEquals(Boolean.FALSE, validator.isValid(String.valueOf(charLength), null));
  }

  @Test
  void isNotValidLengthGetter() {
    char[] charLength = new char[59];
    Assertions.assertEquals(Boolean.FALSE, validator.isValid(String.valueOf(charLength), null));
  }
}
