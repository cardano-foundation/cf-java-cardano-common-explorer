package org.cardanofoundation.explorer.common.exception;

public class InvalidAccessTokenException extends AbstractTokenException {

  public InvalidAccessTokenException() {
    super(CommonErrorCode.INVALID_TOKEN);
  }
}
