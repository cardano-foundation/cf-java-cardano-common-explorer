package org.cardanofoundation.explorer.common.exception;

public class CborRuntimeException extends RuntimeException {

  public CborRuntimeException(String msg) {
    super(msg);
  }

  public CborRuntimeException(String msg, Exception e) {
    super(msg, e);
  }
}
