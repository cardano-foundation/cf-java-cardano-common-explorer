package org.cardanofoundation.explorer.common.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ByronGenesis {

  private Object avvmDistr;

  private Object blockVersionData;

  private String ftsSeed;

  private Object protocolConsts;

  private Integer startTime;

  private Object bootStakeholders;

  private Object heavyDelegation;

  private Object nonAvvmBalances;

  private Object vssCerts;
}
