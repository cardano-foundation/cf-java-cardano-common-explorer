package org.cardanofoundation.explorer.common.entity.ledgersync.enumeration;

public enum GovActionType {
  PARAMETER_CHANGE_ACTION,
  HARD_FORK_INITIATION_ACTION,
  TREASURY_WITHDRAWALS_ACTION,
  NO_CONFIDENCE,
  UPDATE_COMMITTEE,
  NEW_CONSTITUTION,
  INFO_ACTION;

  private GovActionType() {}
}
