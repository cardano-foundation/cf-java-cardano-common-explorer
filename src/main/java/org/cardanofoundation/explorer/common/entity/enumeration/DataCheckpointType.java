package org.cardanofoundation.explorer.common.entity.enumeration;

import java.util.HashMap;
import java.util.Map;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public enum DataCheckpointType {
  DREP_INFO("DREP_INFO"),
  GOV_ACTION_DATA("GOV_ACTION_DATA"),
  TOKEN_TX_COUNT("TOKEN_TX_COUNT"),
  ADDRESS_TX_COUNT("ADDRESS_TX_COUNT"),
  STAKE_ADDRESS_TX_COUNT("STAKE_ADDRESS_TX_COUNT");

  String value;

  private static final Map<String, DataCheckpointType> dataCheckpointTypeMap = new HashMap<>();

  static {
    for (DataCheckpointType type : DataCheckpointType.values()) {
      dataCheckpointTypeMap.put(type.value, type);
    }
  }

  public static DataCheckpointType fromValue(String value) {
    return dataCheckpointTypeMap.get(value);
  }
}
