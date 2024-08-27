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
  DREP_INFO("drep_info"),
  GOV_ACTION_DATA("gov_action_data"),
  TOKEN_TX_COUNT("token_tx_count");

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
