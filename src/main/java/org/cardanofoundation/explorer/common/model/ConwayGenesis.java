package org.cardanofoundation.explorer.common.model;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
public class ConwayGenesis {
  @JsonProperty("poolVotingThresholds")
  private Object poolVotingThresholds;

  @JsonProperty("dRepVotingThresholds")
  private Object dRepVotingThresholds;

  @JsonProperty("committeeMinSize")
  private Integer committeeMinSize;

  @JsonProperty("committeeMaxTermLength")
  private Integer committeeMaxTermLength;

  @JsonProperty("govActionLifetime")
  private Integer govActionLifetime;

  @JsonProperty("govActionDeposit")
  private Long govActionDeposit;

  @JsonProperty("dRepDeposit")
  private Long dRepDeposit;

  @JsonProperty("dRepActivity")
  private Integer dRepActivity;

  @JsonProperty("minFeeRefScriptCostPerByte")
  private Integer minFeeRefScriptCostPerByte;

  @JsonProperty("constitution")
  private Object constitution;

  @JsonProperty("committee")
  private Object committee;
}
