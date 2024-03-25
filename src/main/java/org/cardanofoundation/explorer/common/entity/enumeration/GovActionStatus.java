package org.cardanofoundation.explorer.common.entity.enumeration;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public enum GovActionStatus {
  OPEN_BALLOT("OPEN_BALLOT"),
  RATIFIED("RATIFIED"),
  ENACTED("ENACTED"),
  EXPIRED("EXPIRED");

  String value;
}
