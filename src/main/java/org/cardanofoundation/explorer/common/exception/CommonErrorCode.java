package org.cardanofoundation.explorer.common.exception;

public enum CommonErrorCode implements ErrorCode {
  UNKNOWN_ERROR("500_INTERNAL_SERVER_ERROR", "Something went wrong!"),
  INVALID_PARAM("400_INVALID_REQUEST_PARAM", "Invalid request param"),
  TOKEN_EXPIRED("401_ACCESS_TOKEN_EXPIRED", "The access token is expired"),
  TOKEN_INVALID_SIGNATURE("401_TOKEN_INVALID_SIGNATURE", "The signature access token is invalid"),
  TOKEN_UNSUPPORTED("401_TOKEN_UNSUPPORTED", "The access token is unsupported"),
  TOKEN_IS_EMPTY("401_TOKEN_IS_EMPTY", "The access token is empty"),
  UNAUTHORIZED_TOKEN("401_UNAUTHORIZED", "The access token is unauthorized"),
  INVALID_TOKEN("401_INVALID_ACCESS_TOKEN", "The access token is invalid");
  private final String code;
  private final String desc;

  private CommonErrorCode(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  @Override
  public String getCode() {
    return this.code;
  }

  @Override
  public String getDesc() {
    return this.desc;
  }

  @Override
  public String getServicePrefix() {
    return "EXPLORER_COMMON_ERROR";
  }
}
