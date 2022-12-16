package com.sotatek.cardano.common.enumeration;

import java.util.HashMap;
import java.util.Map;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Getter
public enum CollateralInType {
  USED(0),
  UNUSED(1);

  int value;

  private static final Map<Integer, CollateralInType> mCollateralInType = new HashMap<>();

  static {
    for (CollateralInType type : CollateralInType.values()) {
      mCollateralInType.put(type.value,type);
    }
  }

  public static CollateralInType fromValue(int value) {
    return mCollateralInType.get(value);
  }
}
