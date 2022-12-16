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
public enum TxOutType {
  TX_OUT_SUCCESS(0),
  TX_OUT_FAIL(1),
  COLLATERAL_USED(2),
  COLLATERAL_UNUSED(3);

  int value;

  private static final Map<Integer, TxOutType> txOutTypeMap = new HashMap<>();

  static {
    for (TxOutType type : TxOutType.values()) {
      txOutTypeMap.put(type.value,type);
    }
  }

  public static TxOutType fromValue(int value) {
    return txOutTypeMap.get(value);
  }
}