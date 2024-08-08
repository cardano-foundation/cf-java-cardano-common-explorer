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
public enum DRepStatus {
  ACTIVE("active"),
  INACTIVE("inactive"),
  RETIRED("retired");

  String value;

  private static final Map<String, DRepStatus> dRepStatusMap = new HashMap<>();

  static {
    for (DRepStatus type : DRepStatus.values()) {
      dRepStatusMap.put(type.value, type);
    }
  }

  public static DRepStatus fromValue(String value) {
    return dRepStatusMap.get(value);
  }
}
