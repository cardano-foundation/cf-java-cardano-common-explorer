package org.cardanofoundation.explorer.common.entity.validation;

import static org.cardanofoundation.explorer.common.constants.ValidationConstant.HASH_28;

import java.util.Objects;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class Hash28TypeValidator implements ConstraintValidator<Hash28Type, String> {

  /**
   * Checking if input string length equal to 56 or not . if equal return true else false
   *
   * @param string hash string
   * @param constraintValidatorContext
   * @return boolean
   */
  @Override
  public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {
    return Objects.isNull(string) || string.length() == HASH_28;
  }
}
