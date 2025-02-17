package org.cardanofoundation.explorer.common;

import static org.cardanofoundation.explorer.common.constants.ValidationConstant.HASH_32;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.cardanofoundation.explorer.common.entity.validation.Hash32TypeValidator;

class Hash32TypeValidatorTest {

  Hash32TypeValidator validator = new Hash32TypeValidator();

  @Test
  void isValid() {
    char[] charLength = new char[HASH_32];
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
