package com.sotatek.cardano.common.validation;

import static com.sotatek.cardano.common.constanst.ValidationConstant.ASSET_MAX_BYTES;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Asset32TypeValidator implements ConstraintValidator<Asset32Type, byte[]> {

  /**
   * Checking if input bytes length equal to 58 or not . if equal return true  else false
   *
   * @param data                       byte array
   * @param constraintValidatorContext
   * @return boolean
   */
  @Override
  public boolean isValid(byte[] data, ConstraintValidatorContext constraintValidatorContext) {
    return data.length == ASSET_MAX_BYTES;
  }
}
