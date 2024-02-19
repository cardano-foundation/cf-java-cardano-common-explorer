package org.cardanofoundation.explorer.common;

import static org.cardanofoundation.explorer.common.constants.ValidationConstant.ASSET_MAX_BYTES;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.cardanofoundation.explorer.common.entity.validation.Asset32TypeValidator;

class Asset32TypeValidatorTest {

  Asset32TypeValidator validator = new Asset32TypeValidator();

  @Test
  void isValid() {
    byte[] bytesLength32 = new byte[ASSET_MAX_BYTES];
    Assertions.assertTrue(validator.isValid(bytesLength32, null));
  }

  @Test
  void isNotValidLengthSmaller() {
    byte[] bytesLength32 = new byte[0];
    Assertions.assertEquals(Boolean.FALSE, validator.isValid(bytesLength32, null));
  }

  @Test
  void isNotValidLengthGetter() {
    byte[] bytesLength32 = new byte[59];
    Assertions.assertEquals(Boolean.FALSE, validator.isValid(bytesLength32, null));
  }
}
