package org.cardanofoundation.explorer.common.entity.ledgersync.enumeration;

import java.util.HashMap;
import java.util.Map;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Getter
public enum DRepActionType {
  REG_DREP_CERT("REG_DREP_CERT"), // (1)
  UNREG_DREP_CERT("UNREG_DREP_CERT"), // (2)
  UPDATE_DREP_CERT("UPDATE_DREP_CERT"); // (3)

  String value;
  private static final Map<String, DRepActionType> dRepActionTypeMap = new HashMap<>();

  static {
    for (DRepActionType type : DRepActionType.values()) {
      dRepActionTypeMap.put(type.value, type);
    }
  }

  public static DRepActionType fromValue(String value) {
    return dRepActionTypeMap.get(value);
  }
}
