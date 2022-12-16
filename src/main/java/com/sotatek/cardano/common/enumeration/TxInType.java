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
public enum TxInType {
  USED(0),
  UNUSED(1);

  int value;

  private static final Map<Integer, TxInType> mTxInType = new HashMap<>();

  static {
    for (TxInType type : TxInType.values()) {
      mTxInType.put(type.value,type);
    }
  }

  public static TxInType fromValue(int value) {
    return mTxInType.get(value);
  }
}
