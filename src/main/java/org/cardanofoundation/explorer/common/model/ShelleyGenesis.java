package org.cardanofoundation.explorer.common.model;

import java.math.BigInteger;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShelleyGenesis {

  private Double activeSlotsCoeff;

  private Integer epochLength;

  private Object genDelegs;

  private Object initialFunds;

  private Integer maxKESEvolutions;

  private BigInteger maxLovelaceSupply;

  private String networkId;

  private Integer networkMagic;

  private Object protocolParams;

  private Integer securityParam;

  private Integer slotLength;

  private Integer slotsPerKESPeriod;

  private Object staking;

  private String systemStart;

  private Integer updateQuorum;
}
