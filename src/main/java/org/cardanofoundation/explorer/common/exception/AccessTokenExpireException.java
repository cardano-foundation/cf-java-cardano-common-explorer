package org.cardanofoundation.explorer.common.exception;

public class AccessTokenExpireException extends AbstractTokenException {

  public AccessTokenExpireException() {
    super(CommonErrorCode.TOKEN_EXPIRED);
  }
}
