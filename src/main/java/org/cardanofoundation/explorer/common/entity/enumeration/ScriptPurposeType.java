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
public enum ScriptPurposeType {
  SPEND("spend"),
  MINT("mint"),
  CERT("cert"),
  REWARD("reward"),
  VOTE("vote"),
  PROPOSE("propose");

  String value;

  private static final Map<String, ScriptPurposeType> rewardTypeMap = new HashMap<>();

  static {
    for (ScriptPurposeType type : ScriptPurposeType.values()) {
      rewardTypeMap.put(type.value, type);
    }
  }

  public static ScriptPurposeType fromValue(String value) {
    return rewardTypeMap.get(value);
  }
}
