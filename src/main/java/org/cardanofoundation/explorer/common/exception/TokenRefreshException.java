package org.cardanofoundation.explorer.common.exception;

public class TokenRefreshException extends AbstractTokenException {

  public TokenRefreshException(CommonErrorCode businessCode) {
    super(businessCode);
  }
}
