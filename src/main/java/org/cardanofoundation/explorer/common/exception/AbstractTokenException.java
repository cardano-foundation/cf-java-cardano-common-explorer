package org.cardanofoundation.explorer.common.exception;

public abstract class AbstractTokenException extends RuntimeException {

  private final CommonErrorCode errorCode;

  protected AbstractTokenException(CommonErrorCode errorCode) {
    this.errorCode = errorCode;
  }

  public CommonErrorCode getErrorCode() {
    return this.errorCode;
  }

  @Override
  public String toString() {
    return "AbstractTokenException{" + "errorCode=" + errorCode + '}';
  }
}
