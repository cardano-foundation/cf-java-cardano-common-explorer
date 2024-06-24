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
public enum VoterType {
  CONSTITUTIONAL_COMMITTEE_HOT_KEY_HASH("CONSTITUTIONAL_COMMITTEE_HOT_KEY_HASH"),
  CONSTITUTIONAL_COMMITTEE_HOT_SCRIPT_HASH("CONSTITUTIONAL_COMMITTEE_HOT_SCRIPT_HASH"),
  DREP_KEY_HASH("DREP_KEY_HASH"),
  DREP_SCRIPT_HASH("DREP_SCRIPT_HASH"),
  STAKING_POOL_KEY_HASH("STAKING_POOL_KEY_HASH");

  String value;

  private static final Map<String, VoterType> voterTypeMap = new HashMap<>();

  static {
    for (VoterType type : VoterType.values()) {
      voterTypeMap.put(type.value, type);
    }
  }

  public static VoterType fromValue(String value) {
    return voterTypeMap.get(value);
  }
}
