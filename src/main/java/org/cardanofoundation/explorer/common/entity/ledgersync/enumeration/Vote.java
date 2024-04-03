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
public enum Vote {
  NO("NO"),
  YES("YES"),
  ABSTAIN("ABSTAIN"),
  NONE("NONE"),
  ANY("ANY");

  private final String value;

  private static final Map<String, Vote> voteMap = new HashMap<>();

  static {
    for (Vote vote : Vote.values()) {
      voteMap.put(vote.value, vote);
    }
  }

  public static Vote fromValue(String value) {
    return voteMap.get(value);
  }
}
