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
public enum DRepType {
  PRE_DEFINED("PRE_DEFINED"),
  REGISTERED("REGISTERED");

  String value;

  private static final Map<String, DRepType> dRepTypeMap = new HashMap<>();

  static {
    for (DRepType type : DRepType.values()) {
      dRepTypeMap.put(type.value, type);
    }
  }

  public static DRepType fromValue(String value) {
    return dRepTypeMap.get(value);
  }
}
