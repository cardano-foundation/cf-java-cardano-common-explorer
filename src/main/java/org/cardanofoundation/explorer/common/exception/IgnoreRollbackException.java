package org.cardanofoundation.explorer.common.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IgnoreRollbackException extends RuntimeException {

  private final String errorCode;

  private final String errorMsg;

  public IgnoreRollbackException(ErrorCode err) {
    this.errorCode = err.getServiceErrorCode();
    this.errorMsg = err.getDesc();
  }
}
