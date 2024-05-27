package org.cardanofoundation.explorer.common.entity.enumeration;

import java.util.HashMap;
import java.util.Map;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Getter
public enum TokenAuthType {
  ACCESS_TOKEN("ACCESS_TOKEN"),
  REFRESH_TOKEN("REFRESH_TOKEN"),
  VERIFY_CODE("VERIFY_CODE"),
  RESET_PASSWORD("RESET_PASSWORD");

  String value;
  private static final Map<String, TokenAuthType> tokenAuthTypeMap = new HashMap<>();

  static {
    for (TokenAuthType type : TokenAuthType.values()) {
      tokenAuthTypeMap.put(type.value, type);
    }
  }

  public static TokenAuthType fromValue(String value) {
    return tokenAuthTypeMap.get(value);
  }
}
