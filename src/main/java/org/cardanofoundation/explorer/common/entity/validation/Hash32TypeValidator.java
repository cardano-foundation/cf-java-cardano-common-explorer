package org.cardanofoundation.explorer.common.entity.validation;

import static org.cardanofoundation.explorer.common.constants.ValidationConstant.HASH_32;

import java.util.Objects;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class Hash32TypeValidator implements ConstraintValidator<Hash32Type, String> {

  /**
   * Checking if input string length equal to 64 or not . if equal return true else false
   *
   * @param string hash string
   * @param constraintValidatorContext
   * @return boolean
   */
  @Override
  public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {
    return Objects.isNull(string) || string.length() == HASH_32;
  }
}
