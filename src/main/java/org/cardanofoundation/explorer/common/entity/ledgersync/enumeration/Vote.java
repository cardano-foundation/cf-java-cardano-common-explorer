package org.cardanofoundation.explorer.common.entity.ledgersync.enumeration;

public enum Vote {
  NO(0),
  YES(1),
  ABSTAIN(2),
  NONE(3);

  private final int value;

  private Vote(int value) {
    this.value = value;
  }
}
