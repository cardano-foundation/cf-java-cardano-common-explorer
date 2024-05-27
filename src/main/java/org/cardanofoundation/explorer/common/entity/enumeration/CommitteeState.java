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
public enum CommitteeState {
  NORMAL("NORMAL"),
  NO_CONFIDENCE("NO_CONFIDENCE"),
  ;
  String value;

  private static final Map<String, CommitteeState> committeeStateMap = new HashMap<>();

  static {
    for (CommitteeState type : CommitteeState.values()) {
      committeeStateMap.put(type.value, type);
    }
  }

  public static CommitteeState fromValue(String value) {
    return committeeStateMap.get(value);
  }
}
